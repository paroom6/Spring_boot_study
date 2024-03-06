package com.study.mvc.diAndopc;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class IoCRepository {
    private List<String> nameList = List.of("조성민","조성이","조성삼");
    public Map<String,String> convertNameMap() {
        Map<String,String> nameMap = new HashMap<>();
        for (int i = 0; i < nameList.size(); i++) {
            nameMap.put("name" + (i + 1), nameList.get(i));
        }
        return nameMap;
    }
}
