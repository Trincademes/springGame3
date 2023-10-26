package com.senai.pedro.PrjGame.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.pedro.PrjGame.Entities.Jogo;
import com.senai.pedro.PrjGame.Repositories.JogoRepository;

@Service
public class JogoService {

	private final JogoRepository jogoRepository;

	@Autowired
	public JogoService(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}

	public Jogo saveJogo(Jogo jogo) {
		return (Jogo) jogoRepository.save(jogo);

	}

	public Jogo getJogoById(Long id) {
		return (Jogo) jogoRepository.findById(id).orElse(null);
	}

	public List<Jogo> getAllJogo() {
		return jogoRepository.findAll();
	}

	public void deletejogo(Long id) {
		jogoRepository.deleteById(id);
	}

	
	
	public Jogo updateJogo(Long id, Jogo novoJogo) {
        Optional<Jogo> jogoOptional = jogoRepository.findById(id);
        if (jogoOptional.isPresent()) {
        	Jogo jogoExistente = jogoOptional.get();
           	jogoExistente.setName(novoJogo.getName());
        	jogoExistente.setPlataform(novoJogo.getPlataform());          
            return jogoRepository.save(jogoExistente); 
        } else {
            return null; 
        }
    }
	
}
