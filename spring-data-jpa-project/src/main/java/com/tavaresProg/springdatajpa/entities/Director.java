package com.tavaresProg.springdatajpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_director"
)
public class Director {

    @Id
    @SequenceGenerator(
            name = "director_sequence",
            sequenceName = "director_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "director_sequence"
    )
    private Long directorId;
    private String name;
    private String birthdate;
}
