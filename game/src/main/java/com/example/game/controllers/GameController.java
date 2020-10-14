package com.example.game.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.game.dtos.request.GameRequest;
import com.example.game.dtos.response.GameResponse;
import com.example.game.services.GameService;

@RestController
public class GameController {
	
	@Autowired
	private GameService gamerService;
	
	@GetMapping("/game")
	public ResponseEntity<Object> getGame(@RequestParam("title") String title, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.OK).body(gamerService.getGame(title));
	}
	
	@PostMapping("/game")
	public ResponseEntity<Object> addGame(@RequestBody @Valid GameRequest gameRequest, HttpServletRequest request){
		GameResponse gameResponse = gamerService.addGame(gameRequest);
		return ResponseEntity.status(HttpStatus.OK).body(gameResponse);
	}
	
}
