package com.s19d1.hibernatemapping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "actor" , schema = "fsweb")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    private Date birthDate;


        @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
        @JoinTable(name = "movie_actor",schema = "fsweb",
                joinColumns = @JoinColumn(name = "actor_id"),
                inverseJoinColumns = @JoinColumn(name = "movie_id"))
        private List<Movie> movieList;


        public void addMovie(Movie movie){
        if (movieList == null){
            movieList = new ArrayList<>();
        }
        movieList.add(movie);
    }

}
