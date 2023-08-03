package com.JaoDosCos.listaGames.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.JaoDosCos.listaGames.dto.GameListDTO;
import com.JaoDosCos.listaGames.entities.GameList;
import com.JaoDosCos.listaGames.projections.GameMinProjection;
import com.JaoDosCos.listaGames.repositories.GameListRepositories;
import com.JaoDosCos.listaGames.repositories.GameRepositories;

@Component

public class GameListService {
		
	@Autowired
	private GameListRepositories gameListRepository;
	
	@Autowired
	private GameRepositories gameRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List <GameList> result = gameListRepository.findAll();
		List<GameListDTO> list = result.stream().map(x -> new GameListDTO(x)).toList();
		return list;
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i<=max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
