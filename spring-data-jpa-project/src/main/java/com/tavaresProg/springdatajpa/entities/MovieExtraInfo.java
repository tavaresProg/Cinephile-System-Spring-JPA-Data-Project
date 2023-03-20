package com.tavaresProg.springdatajpa.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "movie")
@Table(
        name = "tbl_movie_extra_info",
        uniqueConstraints = @UniqueConstraint(
                name = "movie",
                columnNames = "movie_id"
        )
)
public class MovieExtraInfo {

    @Id
    @SequenceGenerator(
            name = "movie_extra_info_sequence",
            sequenceName = "movie_extra_info_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_extra_info_sequence"
    )
    private Long movieExtraInfoId;
    private Integer year;
    private String classification;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "movie_id",
            referencedColumnName = "movieId"
    )
    private Movie movie;
}
