package com.example.game.exceptions.generic;

public class NotFoundExecption extends RuntimeException{
	
	
	
	private static final long serialVersionUID = 1L;
	private final String detalle;
	
	public NotFoundExecption(String detalle) {
		this.detalle = detalle;
	}

	public String getDetalle() {
		return detalle;
	}

}
