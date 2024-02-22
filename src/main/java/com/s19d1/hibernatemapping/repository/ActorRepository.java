package com.s19d1.hibernatemapping.repository;

import com.s19d1.hibernatemapping.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor , Long> {
}
