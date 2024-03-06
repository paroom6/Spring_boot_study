package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.study.mvc.diAndopc.DIRepository;
import com.study.mvc.diAndopc.DiService;
import com.study.mvc.diAndopc.IoCService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//controller의 경우 이미 컴포넌트를 상속받는다.
//스프링부트 시작시 컴포넌트를 찾아 IoC 컨터이너에 등록 @Autowired로 불러온다.
//Controller, Component, Service, Reposito ry, Configuration-Bean
@RequiredArgsConstructor//상수값 같이 필수로 요구되는 컴포넌트를 불러온다.
public class IoCController {
//    @Autowired(required = false)//존재하면 하도록 가능 //Autowired의 장점:
    private final IoCService ioCService;//new(초기화)를 하지 않은 빈값이다. @Component로 ioc를 사용한다.
    @GetMapping("/ioc")
    public ResponseEntity<?>  iocTest() throws JsonProcessingException {//웹서버는 스레드를 사용 보통 응답 때 예외처리가 된다.
        String json = ioCService.getJson();
        return ResponseEntity.ok(json);
    }
}
