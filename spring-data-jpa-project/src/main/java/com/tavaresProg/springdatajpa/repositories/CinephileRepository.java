package com.tavaresProg.springdatajpa.repositories;

import com.tavaresProg.springdatajpa.entities.Cinephile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CinephileRepository extends JpaRepository<Cinephile, Long> {


    List<Cinephile> findByName(String name);

    List<Cinephile> findByNameContaining(String name);

    List<Cinephile> findByAccountUsername(String accountUsername);

    Cinephile findByNameAndPhone(String name, String phone);

    //JPQL
    @Query("select c from Cinephile c where c.phone = ?1")
    Cinephile getCinephileByPhone(String phone);

    @Query("select c.name from Cinephile c where c.phone = ?1")
    String getCinephileNameByPhone(String phone);

    //Native Query
    @Query(
            value = "select * from tbl_cinephile c where c.phone = ?1",
            nativeQuery = true
    )
    Cinephile getCinephileByPhoneNative(String phone);

    //Native Query Named Param
    @Query(
            value = "select * from tbl_cinephile c where c.phone = :phone",
            nativeQuery = true
    )
    Cinephile getCinephileByPhoneNativeNamedParam(
            @Param("phone") String phone
    );

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_cinephile set phone = ?1 where name = ?2",
            nativeQuery = true
    )
    int updateCinephilePhoneByName(String phone, String name);

    @Modifying
    @Transactional
    @Query(
            value = "delete from tbl_cinephile c where name = ?",
            nativeQuery = true
    )
    int deleteByCinephileName(String name);

}

