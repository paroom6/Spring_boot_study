package com.study.mvc.Repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//이름을 적어주면 필드명과 컴포넌트 명이 일치할 경우 자동으로 주입된다.
@Repository("a")// component가 포함되어 있다.
public class CarRepositoryImpl implements CarRepository{

    @Override
    public List<String> getCarNames() {
        return List.of("소나타","아반떼");
    }

    @Override
    public int insertCar(String carName) {
        System.out.println("등록된 차량 : " + carName);
        return 1;
    }



}
