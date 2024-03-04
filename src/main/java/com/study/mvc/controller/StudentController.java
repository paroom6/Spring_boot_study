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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class StudentController {
    
    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@RequestBody Student student) throws JsonProcessingException {//데이터를 JSON으로 받을때는 @RequestBody를 붙인다
//        List<Student> studentList = new ArrayList<>();
//        int lastId = 0;
//        if (students != null) {
//            if (!students.isBlank()) {
//                ObjectMapper studentsCookie = new ObjectMapper();
//                studentList = studentsCookie.readValue(students, List.class);
//                lastId = studentList.get(studentList.size() - 1).getStudentId();
//            }
//        }
//        student.setStudentId(lastId + 1);
//        ObjectMapper newStudentList = new ObjectMapper();
//        String newStudents = newStudentList.writeValueAsString(studentList);
        //쿠키 임시데이터를 저장할 개인 저장소
        ResponseCookie responseCookie = ResponseCookie
                .from("test", "test_data")
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(60)
                .build();
        //"큰따옴표가 저장이 안됨 - JSON의 형식의 경우 큰따옴표를 사용하기에 저장이 안됨
        return ResponseEntity
                .created(null)
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(student);
    }


    @GetMapping("/student")
    @ResponseBody
    public ResponseEntity<?> getStudentInfo(StudentReqDTO studentReqDTO) {
        System.out.println(studentReqDTO);

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
