package com.study.mvc.Service;

import com.study.mvc.Repository.StudentRepository;
import com.study.mvc.entity.Students;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    final StudentRepository studentRepository;

    @Override
    public List<?> getStudentList() {
        List<Map<String,String>> studentMapList = new ArrayList<>();
        List<String> studentList = studentRepository.getStudentListAll();
        List<Students> studentsList = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            studentMapList.add(Map.of("name",studentList.get(i)));
            studentsList.add(new Students(studentList.get(i)));
        }
        return studentsList;
//        return studentMapList;
    }

    @Override
    public Object getStudent(int index) {
        return new Students(studentRepository.findStudentNameByIndex(index));
//        return Map.of("name",studentRepository.findStudentNameByIndex(index));
    }


}
