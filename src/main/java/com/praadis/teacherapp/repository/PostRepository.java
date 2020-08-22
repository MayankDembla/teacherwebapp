package com.praadis.teacherapp.repository;

import com.praadis.teacherapp.domain.Posts;
import com.praadis.teacherapp.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Posts, UUID> {
}
