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
        name = "tbl_cinephile",
        uniqueConstraints = @UniqueConstraint(
                name = "phoneId_unique",
                columnNames = "phone"
        )

)

public class Cinephile {

    @Id
    @SequenceGenerator(
            name = "cinephile_sequence",
            sequenceName = "cinephile_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cinephile_sequence"
    )
    private Long cinephileId;
    private String name;
    private String phone;
    @Embedded
    private Account account;
}
