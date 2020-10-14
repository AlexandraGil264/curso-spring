package com.example.game.exceptions;

import com.example.game.exceptions.generic.GameKOException;

public class GameKONotFoundException extends GameKOException {

	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "Game not found";

	public GameKONotFoundException() {
		super(MESSAGE);
	}
	
	public GameKONotFoundException(String detalle) {
		super(detalle);
	}
	
	

}
