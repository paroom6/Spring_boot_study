package com.study.mvc.Repository;

import java.util.List;

public interface StudentRepository {
    public List<String> getStudentListAll();
    public String findStudentNameByIndex(int index);
}
