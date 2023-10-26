package com.senai.pedro.PrjGame.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.pedro.PrjGame.Entities.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long>{
	
}
