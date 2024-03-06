package com.study.mvc.Repository;

import com.study.mvc.entity.Students;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    private List<String> studentList = List.of("전주환", "서창현", "예홍렬");
    @Override
    public List<String> getStudentListAll() {
        return studentList;
    }

    @Override
    public String findStudentNameByIndex(int index) {
        String student = null;
        if(index < studentList.size()) {
            student = studentList.get(index);
        }
        return student;
    }
}
