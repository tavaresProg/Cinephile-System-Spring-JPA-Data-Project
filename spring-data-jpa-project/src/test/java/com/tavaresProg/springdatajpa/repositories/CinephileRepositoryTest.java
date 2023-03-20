package com.tavaresProg.springdatajpa.repositories;

import com.tavaresProg.springdatajpa.entities.Account;
import com.tavaresProg.springdatajpa.entities.Cinephile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CinephileRepositoryTest {

    @Autowired
    private CinephileRepository repository;

    @Test
    public void saveCinephile() {

        Account account = Account.builder()
                .email("patrickk9@hotmail.com")
                .username("jason66")
                .password("slasherLover66")
                .build();

        Cinephile cinephile = Cinephile.builder()
                .name("Patrick J Katern")
                .phone("99365214875")
                .account(account)
                .build();

        repository.save(cinephile);

    }

    @Test
    public void printAllStudents() {
        List<Cinephile> cinephiles = repository.findAll();
        if (cinephiles.isEmpty()) {
            System.out.println("Cannot find any cinephiles");
        } else System.out.println("cinephiles = " + cinephiles);
    }

    @Test
    public void printStudentByName() {
        List<Cinephile> cinephiles = repository.findByName("Amanda Louis Paris");
        if (cinephiles.isEmpty()) {
            System.out.println("Cannot find any cinephiles");
        } else System.out.println("cinephiles = " + cinephiles);
    }

    @Test
    public void printFindByFirstNameContaining() {
        List<Cinephile> cinephiles = repository.findByNameContaining("a");
        if (cinephiles.isEmpty()) {
            System.out.println("Cannot find any cinephiles");
        } else System.out.println("cinephiles = " + cinephiles);
    }


    @Test
    public void printCinephileBasedOnUsername() {
        List<Cinephile> cinephiles = repository.findByAccountUsername("kittyLover");
        if (cinephiles.isEmpty()) {
            System.out.println("Cannot find any cinephiles");
        } else System.out.println("cinephiles = " + cinephiles);
    }

    @Test
    public void printFindByNameAndPhone() {
        Cinephile cinephiles = repository.findByNameAndPhone("Amanda Louis Paris", "63854236952");
        System.out.println(cinephiles);
    }

    @Test
    public void updateCinephilePhoneByName() {
        repository.updateCinephilePhoneByName("11963584561", "Hugo Vedda");
    }

    @Test
    public void deleteCinephileByName() {
        repository.deleteByCinephileName("Amanda Loius Paris");
    }


}