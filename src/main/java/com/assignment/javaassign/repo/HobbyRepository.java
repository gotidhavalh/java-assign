package com.assignment.javaassign.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.assignment.javaassign.model.Hobby;


@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long>{

}
