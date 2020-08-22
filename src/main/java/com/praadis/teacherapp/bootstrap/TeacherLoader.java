package com.praadis.teacherapp.bootstrap;

import com.praadis.teacherapp.domain.Posts;
import com.praadis.teacherapp.domain.Teacher;
import com.praadis.teacherapp.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class TeacherLoader implements CommandLineRunner {

    private final TeacherRepository teacherRepository ;

    public TeacherLoader(TeacherRepository teacherRepository){
            this.teacherRepository = teacherRepository ;
    }


    @Override
    public void run(String... args) throws Exception {
        loadTeacherObjects();
    }

    private void loadTeacherObjects(){

        Teacher teacher = Teacher.builder().teacherName("Mayank")
                .teacherUniqueId("MayankDembla")
                .email("mayankdembla62@gmail.com")
                .password("Mayank@123")
                .passwordConfirm("Mayank@123")
                .build() ;

        Posts post = new Posts() ;
        post.setActive(1);
        post.setPhotoUrl("Test");
        post.setTeacher(teacher);
        post.setPost("TestPost");

        Set<Posts> posts = new HashSet<>() ;
        posts.add(post) ;

        teacher.setPost(posts);

        if(teacherRepository.count() == 0 ){
              teacherRepository.save(teacher) ;
        }

        System.out.println("Loaded Teachers : " + teacherRepository.count()) ;

    }

}
