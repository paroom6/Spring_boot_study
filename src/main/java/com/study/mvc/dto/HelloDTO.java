package com.study.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//모든 값이 필수가 된다.
@NoArgsConstructor//getter setter를 가지고 값은 넣는다

public class HelloDTO {
    private String name;
    private int age;
}
