package com.praadis.teacherapp.service;

import com.praadis.teacherapp.domain.Teacher;
import com.praadis.teacherapp.mapper.TeacherMapper;
import com.praadis.teacherapp.model.TeacherDto;
import com.praadis.teacherapp.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@RequiredArgsConstructor
@Service
public class TeacherServicesImpl implements  TeacherServices {

    private final TeacherRepository tRepo ;
    private final TeacherMapper teacherMapper;

    @Override
    public Teacher getTeacherById(UUID uuid) {

        return tRepo.findById(uuid).orElse(null) ;

    }

    @Override
    public List<Teacher> getTeacherByTeacherId(String teacherId) {

        var teacher  = new Teacher() ;
        teacher.setTeacherUniqueId(teacherId);

        var matcher  = ExampleMatcher.matching().withMatcher("teacherUniqueId",exact()).withIgnoreNullValues() ;
        var teachr  = Example.of(teacher,matcher) ;

        return (List<Teacher>)tRepo.findAll(teachr);
    }

    @Override
    public Teacher saveNewTeacher(TeacherDto teacherdto) {
        return tRepo.save(teacherMapper.teacherDtotoTeacher(teacherdto));
    }

    @Override
    public void updateteacher(String teacherId, TeacherDto teacherDto) {

    }

    @Override
    public void deleteTeacher(String teacherId, TeacherDto teacherDto) {

    }
}
