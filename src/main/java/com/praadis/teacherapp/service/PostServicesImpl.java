package com.praadis.teacherapp.service;

import com.praadis.teacherapp.domain.Posts;
import com.praadis.teacherapp.domain.Teacher;
import com.praadis.teacherapp.mapper.PostMapper;
import com.praadis.teacherapp.mapper.TeacherMapper;
import com.praadis.teacherapp.model.PostDto;
import com.praadis.teacherapp.model.TeacherDto;
import com.praadis.teacherapp.repository.PostRepository;
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
public class PostServicesImpl implements  PostServices {


    private final PostRepository tRepo ;
    private final com.praadis.teacherapp.mapper.PostMapper PostMapper;

    @Override
    public Posts getPostById(UUID uuid) {

        return tRepo.findById(uuid).orElse(null) ;

    }

    @Override
    public List<Posts> getPostsByPostsId(Long PostId) {

        var Post  = new Posts() ;
        Post.setPostId(PostId);

        var matcher  = ExampleMatcher.matching().withMatcher("PostUniqueId",exact()).withIgnoreNullValues() ;
        var teachr  = Example.of(Post,matcher) ;

        return (List<Posts>)tRepo.findAll(teachr);
    }

    @Override
    public Posts saveNewPosts(PostDto Postdto) {
        return tRepo.save(PostMapper.PostDtotoPost(Postdto));
    }

    @Override
    public void updatePosts(String PostId, PostDto PostDto) {

    }

    @Override
    public void deletePosts(String PostId, PostDto PostDto) {

    }
}
