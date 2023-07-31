package com.JaoDosCos.listaGames.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.JaoDosCos.listaGames.entities.Game;
import com.JaoDosCos.listaGames.repositories.GameRepositories;

@Component

public class GameService {
		
	@Autowired
	private GameRepositories gameRepository;
	
	public List<Game> findAll() {
		List <Game> result = gameRepository.findAll();
		return result;
	}
}
