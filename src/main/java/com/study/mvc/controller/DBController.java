package com.study.mvc.controller;

import com.study.mvc.Service.DBStudyService;
import com.study.mvc.dto.DBStudyReqDto;
import com.study.mvc.entity.Study;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DBController {
    @Autowired
    private DBStudyService dbStudyService;
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody DBStudyReqDto dbStudyReqDto) {
        System.out.println(dbStudyReqDto);
        return ResponseEntity.ok(dbStudyService.createStudy(dbStudyReqDto));
    }
    @GetMapping("/select/study/{id}")
    public  ResponseEntity<?> selectStudy(@PathVariable int id) {

        return ResponseEntity.ok(dbStudyService.findStudyById(id));
    }
    @GetMapping("/select/study")
    public  ResponseEntity<?> selectStudy(@RequestParam String name) {
        Study study = dbStudyService.findStudyByName(name);
        return study == null ? null : ResponseEntity.ok(study.toDto());
    }
    @GetMapping("/select/all")
    public  ResponseEntity<?> selectStudy() {
        return ResponseEntity.ok(dbStudyService.findAll());
    }
    @GetMapping("/select/all2")
    public  ResponseEntity<?> selectStudy2() {
        return ResponseEntity.ok(dbStudyService.findAll2());
    }
    @DeleteMapping("/delete/study/{id}")
    public ResponseEntity<?> deleteStudy(@PathVariable int id) {

        return ResponseEntity.ok(dbStudyService.deleteById(id));
    }

    @PutMapping("/update/study/{id}")//전체 수정을 의미 들어온 객체로 수정
    public ResponseEntity<?> updateStudy(@PathVariable int id, @RequestBody DBStudyReqDto dbStudyReqDto) {
        return ResponseEntity.ok(dbStudyService.putById(id, dbStudyReqDto));
    }
    @PatchMapping("/update/study/{id}")//부분 수정을 의미 들어온 값만 수정 ifnull 만약 null이라면 , nullif() 안의 값이 같으면 null을 리턴
    public ResponseEntity<?> updatesStudy(@PathVariable int id, @RequestBody DBStudyReqDto dbStudyReqDto) {
        return ResponseEntity.ok(dbStudyService.PatchById(id, dbStudyReqDto));
    }

}
