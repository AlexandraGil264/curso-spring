package com.example.game.exceptions.handler;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.example.game.dtos.GameErrorDto;
import com.example.game.exceptions.generic.GameKOException;
import com.example.game.exceptions.generic.NoContentExecption;
import com.example.game.exceptions.generic.NotFoundExecption;

@ControllerAdvice
public class GameHandlerException extends ResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler({GameKOException.class})
	@ResponseBody
	public GameErrorDto gameKO(HttpServletRequest request, GameKOException exception) {
		return new GameErrorDto("00", exception.getDetalle());
	}
	
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({NotFoundExecption.class})
	@ResponseBody
	public GameErrorDto notFoundRequest(HttpServletRequest request, NotFoundExecption exception) {
		return new GameErrorDto("01", exception.getLocalizedMessage());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler({NoContentExecption.class})
	@ResponseBody
	public GameErrorDto notContentRequest(HttpServletRequest request, NoContentExecption exception) {
		return new GameErrorDto("01", exception.getDetalle());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream().map( e -> e.getDefaultMessage()).collect(Collectors.toList());
		return new ResponseEntity<>(new GameErrorDto("02", errorMessages.toString()),
				HttpStatus.BAD_REQUEST);
	}
}
