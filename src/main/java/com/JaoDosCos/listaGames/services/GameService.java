package com.JaoDosCos.listaGames.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.JaoDosCos.listaGames.dto.GameDTO;
import com.JaoDosCos.listaGames.dto.GameMinDTO;
import com.JaoDosCos.listaGames.entities.Game;
import com.JaoDosCos.listaGames.projections.GameMinProjection;
import com.JaoDosCos.listaGames.repositories.GameRepositories;

@Component

public class GameService {
		
	@Autowired
	private GameRepositories gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		//exception handling
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		List <GameMinProjection> result = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List <Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
