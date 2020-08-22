package com.praadis.teacherapp.mapper;

import com.praadis.teacherapp.domain.Posts;
import com.praadis.teacherapp.domain.Teacher;
import com.praadis.teacherapp.model.PostDto;
import com.praadis.teacherapp.model.TeacherDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface PostMapper {

    PostDto PosttoPostDto(Posts Post) ;
    Posts PostDtotoPost(PostDto teacherDto) ;
}
