package com.example.game.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.example.game.dtos.request.GameRequest;
import com.example.game.entities.Game;
import com.example.game.entities.Genre;
import com.example.game.exceptions.generic.GameKOException;

@Service
public class GameHelper {
	
	@Autowired
	private ConversionService converter;
	
	public Game convertGameRequestToGame(GameRequest gameRequest) {//private Game convertGameRequestToGame(GameRequest gameRequest) {
		Game game = converter.convert(gameRequest, Game.class);
		for(GenreEnum gr : gameRequest.getGenre()) {
			Genre genre = converter.canConvert(gr, Genre.class);
			game.getGenres().add(genre);
		}
		
		List<Genre> genres = gameRequest.getGenre().stream.map(gr -> converter.convert(gr, Genre.class)).collect(Collectors.toList());
		game.getGenres().addAll(genres);
		return game;
	}
	
	/*
	public GameRequest getIfExistGame(Optional<GameRequest> gameDto) {
		if(gameDto.isPresent()) 
			return gameDto.get();
		else
			throw new GameKOException("Juego No encontrado");
	}
	*/
}
