package com.example.game.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "GENRES")
@Data
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="GENRE")
	@Enumerated(EnumType.STRING)
	private GenreEnum genreName;
	
	@ManyToMany(mappedBy = "genres")
	private List<Game> games;
}
