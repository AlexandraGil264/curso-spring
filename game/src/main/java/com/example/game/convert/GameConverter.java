package com.example.game.convert;

import com.example.game.dtos.request.GameRequest;
import com.example.game.entities.Game;

public class GameConverter {

	public static Game dtoToEntity(GameRequest gameDto) {
		Game game = new Game();
		game.setTitle(gameDto.getTitle());
		game.setRelease(gameDto.getRelease());
		return game;
	}
	
	public static GameRequest entityToDto(Game game) {
		GameRequest gameRequest= new GameRequest();
		gameRequest.setTitle(game.getTitle());
		gameRequest.setRelease(game.getRelease());
		return gameRequest;
	}
}
