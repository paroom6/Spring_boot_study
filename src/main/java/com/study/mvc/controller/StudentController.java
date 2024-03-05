package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.dto.StudentReqDTO;
import com.study.mvc.dto.StudentRespDTO;
import com.study.mvc.entity.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class StudentController {

    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@CookieValue(required = false) String students, @RequestBody Student student) throws JsonProcessingException, UnsupportedEncodingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Student> studentList = new ArrayList<>();
        int lastId = 0;
        System.out.println(students);

        if(students != null) {
            if(!students.isBlank()) {
                for(Object object : objectMapper.readValue(students, List.class)) {//오브젝트 형태로 담긴 리스트의 객체 하나씩 꺼낸서
                    Map<String, Object> studentMap = (Map<String, Object>) object;//map으로 형 변환 하고
                    studentList.add(objectMapper.convertValue(studentMap, Student.class));//student 객체로 형변환 하여 리스트에 넣는다.
                }
                lastId = studentList.get(studentList.size() - 1).getStudentId();
            }
        }

        student.setStudentId(lastId + 1);
        studentList.add(student);

        String studentListJson = objectMapper.writeValueAsString(studentList);//객체를 JSON으로

        System.out.println(studentListJson);
        ResponseCookie responseCookie = ResponseCookie
                .from("students", URLEncoder.encode(studentListJson, "UTF-8"))//쿠키 키값과 매개변수의 변수명 일치
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(60)
                .build();

        // (")문자 저장x

        return ResponseEntity
                .created(null)
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(student);
    }



    @GetMapping("/student")
    @ResponseBody
    public ResponseEntity<?> getStudentInfo(StudentReqDTO studentReqDTO) {
        System.out.println(studentReqDTO);
        StringBuilder stringBuilder = new StringBuilder();

        return ResponseEntity.ok().body(studentReqDTO.toRespDTO());

    }
    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable("studentId") int id) {//주소에서 값을 가져올 때 사용
        List<Student> studentList = List.of(
                new Student(1 ,"조성민"),
                new Student(2 ,"조성이"),
                new Student(3 ,"조성삼"),
                new Student(4 ,"조성사")
        );
//        Student foundStudent = null;
//        for(Student student : studentList) {
//            if(student.getStudentId() == id) {
//                foundStudent = student;
//                break;
//            }
//        }
//        if(foundStudent == null) {
//            return  ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지않는 ID입니다."));
//        }
        Optional<Student> OptionalStudent = studentList.stream().filter(student -> student.getStudentId() == id).findFirst();
        return OptionalStudent.isEmpty() ? ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지않는 ID입니다.")) : ResponseEntity.ok().body(OptionalStudent.get()) ;
    }

}
