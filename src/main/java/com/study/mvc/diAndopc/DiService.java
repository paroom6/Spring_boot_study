package com.study.mvc.diAndopc;

import java.util.List;

public class DiService {

    private  DIRepository diRepository;
    public  DiService(DIRepository diRepository) {
        this.diRepository = diRepository;
    }


    public int getTotal() {
        int total = 0;
        List<Integer> scoreList = diRepository.getSocreList();
        for (Integer score : scoreList) {
            total += score;
        }
        return total;
    }

    public double getAverage() {
        int total = 0;
        List<Integer> scoreList = diRepository.getSocreList();
        for (Integer score : scoreList) {
            total += score;
        }
        double average =  total / scoreList.size();
        return average;
    }
}
