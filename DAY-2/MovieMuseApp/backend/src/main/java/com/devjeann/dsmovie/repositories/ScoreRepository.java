package com.devjeann.dsmovie.repositories;

import com.devjeann.dsmovie.entities.Score;
import com.devjeann.dsmovie.entities.ScorePK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository <Score,ScorePK> {
    
}
