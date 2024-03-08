package com.study.mvc.Service;

import com.study.mvc.Repository.DBStudyRepository;
import com.study.mvc.dto.DBStudyReqDto;
import com.study.mvc.dto.DBStudyInsertRespDTO;
import com.study.mvc.dto.DBStudySelectRespDto;
import com.study.mvc.entity.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DBStudyService {
//  Mapper의 경우 xml에서 component로 잡힌다.
    //데이터베이스 - repository -> entity 사용
    //웹 - 서버 -> dto 사용
    @Autowired
    private DBStudyRepository dbStudyRepository;
    public DBStudyInsertRespDTO createStudy(DBStudyReqDto dbStudyReqDto) {
        Study findStudy = dbStudyRepository.findStudyByName(dbStudyReqDto.getName());
        if(findStudy != null) {
            return DBStudyInsertRespDTO.builder()
                    .successStatus(false)
                    .build();

        }
        Study study = Study.builder()
                .name(dbStudyReqDto.getName())
                .age(dbStudyReqDto.getAge())
                .build();
        int successCount = dbStudyRepository.save(study);
        //useGeneratedKeys="true" keyProperty="id" 이후로 아이디 등록됨
        
        DBStudyInsertRespDTO dbStudyInsertRespDTO = DBStudyInsertRespDTO.builder()
                .id(study.getId())
                .name(study.getName())
                .age(study.getAge())
                .successStatus(successCount > 0)
                .successCount(successCount)
                .build();
        return dbStudyInsertRespDTO;
    }
    public DBStudySelectRespDto findStudyById(int id) {
//        xml의 select문에서 resultType="com.study.mvc.entity.Study"을 통해서 해당 객체로 값을 리턴 할 수 잇다
        Study study = dbStudyRepository.findStudyById(id);
        System.out.println(study);
        DBStudySelectRespDto dbStudySelectRespDto = DBStudySelectRespDto.builder()
                .id(study.getId())
                .name(study.getName())
                .age(study.getAge())
                .build();
        return dbStudySelectRespDto;
    }public Study  findStudyByName(String name) {//결과값이 2개 이상이면 List 사용
        return dbStudyRepository.findStudyByName(name);
    }
    public List<DBStudySelectRespDto> findAll() {
        List<Study> studyList = dbStudyRepository.findAll();
        List<DBStudySelectRespDto> dbStudySelectRespDtoList = new ArrayList<>();
        for (Study study : studyList) {
            dbStudySelectRespDtoList.add(study.toDto());
        }
        return dbStudySelectRespDtoList;
    }
    public List<DBStudySelectRespDto> findAll2() {
        List<Study> studyList = dbStudyRepository.findAll();
        List<DBStudySelectRespDto> dbStudySelectRespDtoList = studyList.stream().map(study -> study.toDto()).collect(Collectors.toList());
        return dbStudySelectRespDtoList;
    }
    public int deleteById(int id) {
        return dbStudyRepository.deleteById(id);
    }
    public int putById(int id, DBStudyReqDto dbStudyReqDto) {
        return dbStudyRepository.putById(dbStudyReqDto.toEntity(id));
    }
    public int PatchById(int id, DBStudyReqDto dbStudyReqDto) {
        return dbStudyRepository.patchById(dbStudyReqDto.toEntity(id));
    }

}
