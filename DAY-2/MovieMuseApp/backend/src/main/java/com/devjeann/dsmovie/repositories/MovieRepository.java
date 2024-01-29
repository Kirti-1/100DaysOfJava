package com.devjeann.dsmovie.repositories;

import com.devjeann.dsmovie.entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <Movie,Long> {
    
}
