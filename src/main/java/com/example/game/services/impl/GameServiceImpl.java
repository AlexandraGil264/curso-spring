package com.example.game.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.example.game.convert.GameConverter;
import com.example.game.dtos.request.GameRequest;
import com.example.game.dtos.response.GameResponse;
import com.example.game.entities.Game;
import com.example.game.exceptions.GameKONotFoundException;
import com.example.game.helper.GameHelper;
import com.example.game.repository.GameRepository;
import com.example.game.services.GameService;

@Service
public class GameServiceImpl implements GameService{
	
	@Autowired
	private GameHelper gameHelper;
	
	@Autowired
	private GameRepository gameRepo;
	
	List<GameRequest> gamesDtos = new ArrayList<>();

	@Autowired
	private ConversionService converter;
	
	//Para guardar el juego en la BBDD
	/*
	@Override
	public GameResponse addGame(GameRequest gameDto) {
		gamesDtos.add(gameDto);
		
		Game game = new Game();
		game.setTitle(gameDto.getTitle());
		game.setDate(gameDto.getRelease());
		gameRepo.save();
		return new GameResponse();
	}
	*/
	
	@Override
	public GameResponse addGame(GameRequest gameRequest) {//public GameResponse addGame(GameRequest gameDto) {
		//Game game = GameConverter.dtoToEntity(gameDto);
		Game game = gameHelper.convertGameRequestToGame(gameRequest);
		gameRepo.save(game);
		return new GameResponse();
	}
	
	@Override
	public GameResponse getGame(String title) {
		Optional<Game> game = gameRepo.findByTitle(title);
		if(game.isPresent())
			return converter.convert(game.get(), GameResponse.class);
		else
			throw new GameKONotFoundException();
	}
	
	/*
	@Override
	public GameRequest getGame(String title) {
		Optional<Game> game = gameRepo.findById(1L); //Optional<Game> game = gameRepo.findByTitle(title);
		GameRequest gameRequest = GameConverter.entityToDto(game.get());
		return gameRequest;
	}
	*/

	
}
