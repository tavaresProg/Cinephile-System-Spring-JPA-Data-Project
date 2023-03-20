package com.tavaresProg.springdatajpa.repositories;

import com.tavaresProg.springdatajpa.entities.Director;
import com.tavaresProg.springdatajpa.entities.Movie;
import com.tavaresProg.springdatajpa.entities.MovieExtraInfo;
import com.tavaresProg.springdatajpa.enums.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieExtraInfoRepositoryTest {

    @Autowired
    private MovieExtraInfoRepository repository;


    @Test
    public void saveExtraInfo() {

        Director director = Director.builder()
                .name("Todd Phillips")
                .birthdate("12/20/1970")
                .build();

        Movie movie =
                Movie.builder()
                        .title("The hangover")
                        .genre(Genre.COMEDY)
                        .director(director)
                        .build();

        MovieExtraInfo extraInfo =
                MovieExtraInfo.builder()
                        .year(2009)
                        .classification("R")
                        .movie(movie)
                        .build();

        repository.save(extraInfo);
    }

    @Test
    public void printAllCourseMaterials() {
        List<MovieExtraInfo> movieExtraInfos =
                repository.findAll();
       if(movieExtraInfos.isEmpty()){
           System.out.println("Cannot find movieExtraInfos");
       } else System.out.println("movieExtraInfos = " + movieExtraInfos);
    }

}