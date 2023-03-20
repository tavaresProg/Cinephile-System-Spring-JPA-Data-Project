package com.tavaresProg.springdatajpa.repositories;

import com.tavaresProg.springdatajpa.entities.Cinephile;
import com.tavaresProg.springdatajpa.entities.Director;
import com.tavaresProg.springdatajpa.entities.Movie;
import com.tavaresProg.springdatajpa.enums.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository repository;


    @Test
    public void printMovies() {
        List<Movie> movies = repository.findAll();
        if (movies.isEmpty()) {
            System.out.println("Cannot find any movies");
        } else System.out.println("movies = " + movies);
    }

    @Test
    public void saveMovie() {

        Director director = Director.builder()
                .name("Justin Lin")
                .birthdate("10/11/1971")
                .build();

        Movie movie =
                Movie.builder()
                        .title("fast and the furious - tokyo drift")
                        .genre(Genre.ACTION)
                        .director(director)
                        .build();


        repository.save(movie);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);

        Pageable firstPageWithTwoRecords =
                PageRequest.of(1, 2);

        List<Movie> movies =
                repository.findAll(firstPageWithTwoRecords).getContent();

        Long totalElements =
                repository.findAll(firstPageWithTwoRecords)
                        .getTotalElements();

        int totalPages =
                repository.findAll(firstPageWithTwoRecords)
                        .getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("movies = " + movies);
    }

    @Test
    public void findAllSorting() {

        Pageable sortByTitle =
                PageRequest.of(0, 2,
                        Sort.by("title"));

        List<Movie> movies = repository.findAll(sortByTitle).getContent();
        System.out.println("movies = " + movies);

    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0, 10);

        List<Movie> movies =
                repository.findByTitleContaining("K",
                        firstPageTenRecords).getContent();

        System.out.println("movies = " + movies);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Director director =
                Director.builder()
                        .name("M. Night Shyamalan")
                        .birthdate("08/06/1970")
                        .build();

        Movie movie = Movie.builder()
                .title("Glass")
                .genre(Genre.ACTION)
                .director(director)
                .build();

        Cinephile cinephile = Cinephile.builder()
                .name("John Willer Carpenter")
                .phone("87612232159")
                .build();

        movie.addCinephiles(cinephile);

        repository.save(movie);
    }
}