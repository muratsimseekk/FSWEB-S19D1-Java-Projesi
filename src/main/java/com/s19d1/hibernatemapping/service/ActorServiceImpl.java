package com.s19d1.hibernatemapping.service;

import com.s19d1.hibernatemapping.entity.Actor;
import com.s19d1.hibernatemapping.entity.Movie;
import com.s19d1.hibernatemapping.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{

    private ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> getActorList() {
        return actorRepository.findAll();
    }

    @Override
    public Actor getActorByID(Long id) {
        Optional<Actor> actorOptional = actorRepository.findById(id);
        if (actorOptional.isPresent()){
            return actorOptional.get();
        }
        throw new RuntimeException("Girilen Id ile eslesen Actor bulunamadi.");
    }

    @Override
    public Actor addActor(Actor actor) {
      return actorRepository.save(actor);
    }


    @Override
    public Actor deleteActor(Long id) {
        Optional<Actor> actor = actorRepository.findById(id);
        if (actor.isPresent()){
            actorRepository.delete(actor.get());
            return actor.get();
        }
        throw new RuntimeException("Silme islemi icin girilen ID yok");
    }
}
