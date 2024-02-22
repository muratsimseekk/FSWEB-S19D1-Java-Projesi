package com.s19d1.hibernatemapping.repository;

import com.s19d1.hibernatemapping.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie , Long> {
}
