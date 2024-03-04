package com.study.mvc.controller;

import com.study.mvc.dto.HelloDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * controller명: studentController
 * 메서드명: getStudentInfo()
 * 요청메서드: Get
 * 요청 url: /student
 * 요청 params: name,age, phone, address
 * 응답데이터: JSON(name,age, phone, address)
 */
@RestController//모든 메서드에게 ResponseBody를 부여
public class StudyRestController {

    @GetMapping("/hello/test")
    public String hello(HelloDTO helloDTO) {//requset를 지우고 파라메터명을 변수명으로 지정하면 받을 수 있다. 알아서 parsing 해 준다.
        // DTO를 통해 한번에 값을 받아와서 사용할 수 있다.
        System.out.println(helloDTO);
        return "Hello";
    }
}
