package com.praadis.teacherapp.service;

import com.praadis.teacherapp.domain.Teacher;
import com.praadis.teacherapp.model.TeacherDto;

import java.util.List;
import java.util.UUID;

public interface TeacherServices {

    // S
    Teacher getTeacherById(UUID teacherId) ;
    List<Teacher> getTeacherByTeacherId(String teacherId) ;

    // C
    Teacher saveNewTeacher(TeacherDto teacherdto) ;

    // U
    void updateteacher(String teacherId, TeacherDto teacherDto );


    // D
    void deleteTeacher(String teacherId, TeacherDto teacherDto) ;

}
