package com.study.mvc.entity;

import com.study.mvc.dto.DBStudySelectRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
//빌더만 한다면 값에 관계없이 순서만 맞춰서 넣는다
public class Study {
    private int id;
    private String name;
    private int age;
    private LocalDateTime createDate;
    public DBStudySelectRespDto toDto() {
        return DBStudySelectRespDto.builder()
                .id(id)
                .name(name)
                .age(age)
                .build();
    }
}
