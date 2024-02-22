package com.s19d1.hibernatemapping.service;

import com.s19d1.hibernatemapping.entity.Movie;

import java.util.List;

public interface MovieService{
    List<Movie> getMovies();
    Movie getMovieById(Long id);
    Movie addMovie(Movie movie);

    Movie deleteMovie(Long id);
}
