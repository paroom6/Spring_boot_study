package com.study.mvc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class StudentReqDTO {
    private String name;
    private int age;
    private String phone;
    private String address;

    public StudentRespDTO toRespDTO() {
        return StudentRespDTO.builder()
                .name(name)
                .age(age)
                .phone(phone)
                .address(address)
                .build();
    }
}
