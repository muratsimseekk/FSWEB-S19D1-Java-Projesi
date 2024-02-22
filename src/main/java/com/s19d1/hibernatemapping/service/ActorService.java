package com.s19d1.hibernatemapping.service;

import com.s19d1.hibernatemapping.entity.Actor;

import java.util.List;

public interface ActorService {

    List<Actor> getActorList();
    Actor getActorByID(Long id);
    Actor addActor(Actor actor);

    Actor deleteActor(Long id);
}
