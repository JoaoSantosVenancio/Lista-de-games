package com.JaoDosCos.listaGames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JaoDosCos.listaGames.entities.GameList;

public interface GameListRepositories extends JpaRepository<GameList, Long>{
	 
}
