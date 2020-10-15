package com.example.game.dtos.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.example.game.enums.GenderEnum;

import lombok.Data;

@Data
public class GameRequest {
	
	@NotBlank(message = "Title can't be null or empty.")
	private String title;
	
	private String description;
	
	private List<GenderEnum> genre = new ArrayList<>();
	
	private Date release;
	

}
