package com.praadis.teacherapp.service;

import com.praadis.teacherapp.domain.Posts;
import com.praadis.teacherapp.domain.Teacher;
import com.praadis.teacherapp.model.PostDto;
import com.praadis.teacherapp.model.TeacherDto;

import java.util.List;
import java.util.UUID;

public interface PostServices {

    // S
    Posts getPostById(UUID PostsId) ;
    List<Posts> getPostsByPostsId(Long PostsId) ;

    // C
    Posts saveNewPosts(PostDto Postsdto) ;

    // U
    void updatePosts(String PostsId, PostDto PostsDto );


    // D
    void deletePosts(String PostsId, PostDto PostsDto) ;

}
