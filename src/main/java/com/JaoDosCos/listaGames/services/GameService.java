package com.JaoDosCos.listaGames.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JaoDosCos.listaGames.dto.GameMinDTO;
import com.JaoDosCos.listaGames.entities.Game;
import com.JaoDosCos.listaGames.repositories.GameRepositories;

@Component

public class GameService {
		
	@Autowired
	private GameRepositories gameRepository;
	
	public List<GameMinDTO> findAll() {
		List <Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
