package com.praadis.teacherapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDto {

    // That null is because they are read only properties to the Client Side
    // And we are gonna null there so When we do bind this object inside of java
    // these are required to be null.

    @Null
    private UUID id ;

    @Null
    private OffsetDateTime createdDate ;

    @Null
    private OffsetDateTime lastmodifiedDate ;

    @NotBlank
    private String teacherName ;

    @NotBlank
    private String teacherUniqueId ;

    @NotBlank
    private String email ;

    @NotBlank
    private String password ;

    @NotBlank
    private String passwordConfirm;

}
