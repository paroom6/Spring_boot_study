package com.study.mvc.Service;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarService {
    public String getCarNames();
    public int addCar(String CarName);
}
