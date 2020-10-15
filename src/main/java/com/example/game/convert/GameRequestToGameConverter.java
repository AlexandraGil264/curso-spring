package com.example.game.convert;

import com.example.game.dtos.request.GameRequest;
import com.example.game.entities.Game;
import com.example.game.entities.Genre;

public class GameRequestToGameConverter implements Convert<GameRequest, Game>{
	
	@Override
	public Game convert(GameRequest gameRequest) {
		Game game = new Game();
		game.setTitle(gameRequest.getTitle());
		game.setDescription(gameRequest.getDescription());
		game.setRelease(gameRequest.getRelease());
		return game;
		
		for(GenreEnum genre : gameRequest.getGenre()) {
			Genre genreEntity = new Genre();
			game.getGenres().add(genreEntity);
		}
		return game;
	}

}
