package com.study.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Data
@Builder

public class StudentRespDTO {
    private String name;
    private int age;
    private String phone;
    private String address;
}
