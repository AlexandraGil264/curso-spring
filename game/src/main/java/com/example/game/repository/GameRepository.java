package com.example.game.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.game.entities.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
	
	
}
