package com.tavaresProg.springdatajpa.entities;

import com.tavaresProg.springdatajpa.enums.Genre;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(
        exclude = "cinephilesWhoWatched"
)
@Table(
        name = "tbl_movie"
)

public class Movie {

    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    private long movieId;
    private String title;

    @Enumerated(
            EnumType.STRING
    )
    private Genre genre;

    @OneToOne(
            mappedBy = "movie",
            cascade = CascadeType.ALL
    )
    private MovieExtraInfo movieExtraInfo;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false
    )
    @JoinColumn(
            name = "director_id",
            referencedColumnName = "directorId"
    )
    private Director director;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "cinephile_movie_map",
            joinColumns = @JoinColumn(
                    name = "movie_id",
                    referencedColumnName = "movieId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "cinephile_id",
                    referencedColumnName = "cinephileId"
            )
    )
    private List<Cinephile> cinephilesWhoWatched;

    public void addCinephiles(Cinephile cinephile) {
        if (cinephilesWhoWatched == null) cinephilesWhoWatched = new ArrayList<>();
        cinephilesWhoWatched.add(cinephile);
    }

}
