package com.example.game.helper;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.game.dtos.request.GameRequest;
import com.example.game.exceptions.generic.GameKOException;

@Service
public class GameHelper {

	public GameRequest getIfExistGame(Optional<GameRequest> gameDto) {
		if(gameDto.isPresent()) 
			return gameDto.get();
		else
			throw new GameKOException("Juego No encontrado");
	}
}
