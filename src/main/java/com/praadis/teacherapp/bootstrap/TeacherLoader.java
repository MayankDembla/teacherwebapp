package com.praadis.teacherapp.bootstrap;

import com.praadis.teacherapp.domain.Teacher;
import com.praadis.teacherapp.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        if(teacherRepository.count() == 0 ){
              teacherRepository.save(Teacher.builder().teacherName("Mayank")
                .teacherUniqueId("MayankDembla")
                      .email("mayankdembla62@gmail.com")
                      .password("Mayank@123")
                      .passwordConfirm("Mayank@123")
                      .build()) ;
        }

        System.out.println("Loaded Teachers : " + teacherRepository.count()) ;

    }

}
