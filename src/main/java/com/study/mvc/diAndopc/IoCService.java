package com.study.mvc.diAndopc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor //상수나 빈값을 불가하게 하면 자동으로 등록한다. - Autowired 대체가능
public class IoCService {
    private final  IoCRepository ioCRepository; //항상 주입되어야하는 요소를 상수로 잡아 코드를 간결하게 한다.

    public String getJson() throws JsonProcessingException {
        Map<String, String>  namaMap = ioCRepository.convertNameMap();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(namaMap);
        return json;
    }

}
