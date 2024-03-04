package com.study.mvc.controller;

import com.study.mvc.model.HelloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class StudyController {
    //메소드가 서블릿 하나
    //thymeleaf 서피스 프리픽스의 셋팅를 자동으로 해준다.
    //mvc
    @GetMapping("/hello")
    public String helloPage(Model model) {
        HelloModel helloModel = HelloModel.builder()
                .name1("조성민")
                .name2("조성이")
                .name3("조성삼")
                .build();
        model.addAttribute("h", helloModel);
        return "hello";//파일의 경로 - tamplates의 파일을 찾는다
    }

    @GetMapping("/test")
    @ResponseBody
    //rest
    //응답시 html이 아닌 데이터를 응답한다. 페이지를 만들지 않으니 모델을 사용하지 않고 mvc도 아니다 json으로 보낸다.
    public Map<String, Object> testPage() {
        Map<String, Object> test = new HashMap<>();
        test.put("age",32);
        return test;
    }
}
