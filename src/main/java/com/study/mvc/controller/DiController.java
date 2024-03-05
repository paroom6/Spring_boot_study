package com.study.mvc.controller;


import com.study.mvc.diAndopc.DIRepository;
import com.study.mvc.diAndopc.DiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DiController {
    /**
     * DI(Dependency Injection)의존성 주입
     * 필기보다 시도해서 익숙해 지기
     * 가르쳐준것을 그대로 받아들이기
     */
    @GetMapping("/di")
    public ResponseEntity<?> diRest() {
        DIRepository diRepository = new DIRepository();
        DiService diService = new DiService(diRepository);
        Map<String,Object> responeseData =
                Map.of(
                        "total",diService.getTotal(),
                        "average",diService.getAverage()
                );
        return ResponseEntity.ok(responeseData);//ok의 경우 body 생략가능
    }
}
