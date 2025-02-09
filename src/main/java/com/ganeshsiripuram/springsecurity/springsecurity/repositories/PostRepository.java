package com.ganeshsiripuram.springsecurity.springsecurity.repositories;


import com.ganeshsiripuram.springsecurity.springsecurity.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
