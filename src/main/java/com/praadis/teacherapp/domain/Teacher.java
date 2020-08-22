package com.praadis.teacherapp.domain;


import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "teacher")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "uuid")
public class Teacher {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID uuid;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createDate;

    @UpdateTimestamp
    @Column(updatable = false)
    private Timestamp lastupdatedDate;

    private String teacherName;

    @Column(unique = true)
    private String teacherUniqueId;

    @Column(unique = true)
    private String email;

    private String password;

    @Transient
    @JsonIgnore
    private String passwordConfirm;

    //    @JsonBackReference
//    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", targetEntity = Posts.class, fetch = FetchType.EAGER)
    private Set<Posts> post = new HashSet<>();


}
