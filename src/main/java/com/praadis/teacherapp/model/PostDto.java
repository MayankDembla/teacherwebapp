package com.praadis.teacherapp.model;

import com.praadis.teacherapp.domain.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {

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
    private String photoUrl ;

    @NotBlank
    private String postId ;

    @NotBlank
    private Integer active;

    @NotBlank
    private Teacher teacher ;


}
