package com.tavaresProg.springdatajpa.repositories;

import com.tavaresProg.springdatajpa.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
}
