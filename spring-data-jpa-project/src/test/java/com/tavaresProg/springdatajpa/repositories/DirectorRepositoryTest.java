package com.tavaresProg.springdatajpa.repositories;

import com.tavaresProg.springdatajpa.entities.Director;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DirectorRepositoryTest {

    @Autowired
    private DirectorRepository repository;

    @Test
    public void saveDirector() {

        Director director = Director.builder()
                .name("James Cameron")
                .birthdate("08/16/1954")
                .build();

        repository.save(director);
    }
}