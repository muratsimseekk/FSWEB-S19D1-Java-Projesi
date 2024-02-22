package com.s19d1.hibernatemapping.controller;

import com.s19d1.hibernatemapping.entity.Actor;
import com.s19d1.hibernatemapping.entity.Movie;
import com.s19d1.hibernatemapping.service.ActorService;
import com.s19d1.hibernatemapping.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech")
public class ActorController {
    private ActorService actorService;
    private MovieService movieService;


    @Autowired
    public ActorController(ActorService actorService, MovieService movieService) {
        this.actorService = actorService;
        this.movieService = movieService;
    }

    @GetMapping("/actor")
    public List<Actor> findAll(){
        return actorService.getActorList();
    }

    @GetMapping("/actor/{id}")
    public Actor findByID(@PathVariable Long id){
        return actorService.getActorByID(id);
    }

    @PostMapping("/actor")
    public Actor save(@RequestBody Actor actor) {
        List<Movie> movieList = movieService.getMovies();

        for (Movie movie : movieList){
            actor.addMovie(movie);
        }
        actorService.addActor(actor);
        return actor;
    }

    @PutMapping("/actor/{id}")
    public Actor update(@RequestBody Actor actor ,@PathVariable Long id){
        Actor actor1 = actorService.getActorByID(id);
        actor1.setMovieList(actor1.getMovieList());
        actor1.setId(id);
        actorService.addActor(actor);

        return actor;
    }

}
