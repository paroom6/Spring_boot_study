package com.study.mvc.Service;

import com.study.mvc.Repository.CarRepository;
import com.study.mvc.Util.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class CarServiceImpl implements CarService{
    final String componentName = "a"; // 상수를 대입도 가능하다.
    @Autowired
    @Qualifier(componentName)//컴포넌트 명을 지정해 주입가능하다.
    private CarRepository carRepository;//인터페이스로 만들어진 두개의 객체 중 선택하는 것 - 컴포넌트 명과 필드명을 맞춰준다.
    @Override
    public String getCarNames() {
//        carRepository.getCarNames().stream().collect(Collectors.joining());
        return String.join(", ",carRepository.getCarNames());
    }

    @Override
    public int addCar(String CarName) {
        return 0;
    }
}
