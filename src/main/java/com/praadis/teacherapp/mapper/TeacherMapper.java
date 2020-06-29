package com.praadis.teacherapp.mapper;

import com.praadis.teacherapp.domain.Teacher;
import com.praadis.teacherapp.model.TeacherDto;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(uses = {DateMapper.class})
public interface TeacherMapper {

    TeacherDto teachertoTeacherDto(Teacher teacher) ;
    Teacher teacherDtotoTeacher(TeacherDto teacherDto) ;
}
