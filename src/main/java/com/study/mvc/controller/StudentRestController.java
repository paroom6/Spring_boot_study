package com.study.mvc.controller;

import com.study.mvc.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * StudentRestController
 * get요청:/students 응답: ok [{"nane": "전주환"}, {"nane": "서창현"}, {"nane": "예홍렬"}]
 * get요청:ㅣstudent/0 응답: ok {"nane": "전주환"}
 * StudentService(interface) + Impl(class)
 * -getStudentList()
 * -getStudent(int index)
 * StudentRepository(interface) + Impl(class)
 * -getStudentListAll()
 *  -["전주환", "서창현", "예홍렬"]
 * -findStudentNameByIndex(int index)
 */
@Controller
@RequiredArgsConstructor
public class StudentRestController {//Dto나 entity의 경우 private로 설정한 경우 getter와 setter를 무조건 만들어야지 InvalidDefinitionException가 발생하지 않는다.
    final StudentService studentService;
    @GetMapping("/ex/students")
    public ResponseEntity<?> getStudentInfo() {
        return ResponseEntity.ok().body(studentService.getStudentList());
    }
    @GetMapping("/ex/student/{index}")
    public ResponseEntity<?> getStudent(@PathVariable("index") int idx) {//주소에서 값을 가져올 때 사용
        return studentService.getStudent(idx) == null ? ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지않는 ID입니다.")) : ResponseEntity.ok().body(studentService.getStudent(idx));
    }

}
