package com.praadis.teacherapp.controller;

import com.praadis.teacherapp.domain.Teacher;
import com.praadis.teacherapp.model.TeacherDto;
import com.praadis.teacherapp.service.TeacherServices;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RequiredArgsConstructor
@Validated
@RequestMapping("/teacher/")
@RestController
public class TeacherController {

    private final TeacherServices tService ;

    @GetMapping("/admin/welcome")
    public String welcomeadmin(){
       return "Welcome Admin to Teacher API" ;
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome Student to Teacher API" ;
    }

    // By UUID
    @GetMapping("/uuid/{teacherId}")
    public ResponseEntity<Teacher> getTeacher(@NotNull @PathVariable("teacherId")UUID teacherId) {
       return new ResponseEntity<Teacher>(tService.getTeacherById(teacherId), HttpStatus.OK) ;
    }

    // By User Id
    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacher(@NotNull @PathVariable("teacherId")String teacherId) {
       return new ResponseEntity<Teacher>(tService.getTeacherByTeacherId(teacherId).get(0), HttpStatus.OK) ;
    }

    // Post the Teacher
   @PostMapping  //Post a new Teacher
   public ResponseEntity<?> addTeacher(@Valid @NotNull @RequestBody TeacherDto teacherDto){
       val savedteacher = tService.saveNewTeacher(teacherDto) ;
       val header  = new HttpHeaders() ;
       header.add("Location","http://localhost:8081/teacher/" + savedteacher.getUuid().toString());
       return new ResponseEntity<Object>(header, HttpStatus.CREATED) ;
   }

   // Update Teacher


   // Delete a Teacher


}
