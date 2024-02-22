package com.s19d1.hibernatemapping.service;

import com.s19d1.hibernatemapping.entity.Actor;
import com.s19d1.hibernatemapping.entity.Movie;
import com.s19d1.hibernatemapping.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private MovieRepository movieRepository;
    private ActorService actorService;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, ActorService actorService) {
        this.movieRepository = movieRepository;
        this.actorService = actorService;
    }

    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> optional = movieRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }
        throw new RuntimeException("Girilen id li movie bulunmuyor");
    }
    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie deleteMovie(Long id) {
         movieRepository.delete(getMovieById(id));
         return getMovieById(id);
    }
}
