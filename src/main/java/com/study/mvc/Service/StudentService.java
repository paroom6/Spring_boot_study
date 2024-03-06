package com.study.mvc.Service;

import com.study.mvc.entity.Students;

import java.util.List;

public interface StudentService {
    public List<?> getStudentList();
    public Object getStudent(int index);
}
