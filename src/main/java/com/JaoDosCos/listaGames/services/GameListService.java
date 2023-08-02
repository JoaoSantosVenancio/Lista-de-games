package com.JaoDosCos.listaGames.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.JaoDosCos.listaGames.dto.GameListDTO;
import com.JaoDosCos.listaGames.dto.GameMinDTO;
import com.JaoDosCos.listaGames.entities.GameList;
import com.JaoDosCos.listaGames.repositories.GameListRepositories;

@Component

public class GameListService {
		
	@Autowired
	private GameListRepositories gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List <GameList> result = gameListRepository.findAll();
		List<GameListDTO> list = result.stream().map(x -> new GameListDTO(x)).toList();
		return list;
	}
}
