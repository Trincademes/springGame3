package com.senai.pedro.PrjGame.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.pedro.PrjGame.Entities.Jogo;
import com.senai.pedro.PrjGame.Service.JogoService;

@RestController
@RequestMapping("/jogos")
public class JogoController {
	@Autowired
	private final JogoService jogoService;

	public JogoController(JogoService jogoService) {
		this.jogoService = jogoService;
	}

	@PostMapping
	public Jogo createjogo(@RequestBody Jogo jogo) {
		return jogoService.saveJogo(jogo);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Jogo> getjogo(@PathVariable Long id) {
		Jogo jogo = jogoService.getJogoById(id);
		if (jogo != null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping("/home")
	public String paginainicial() {
		return "index";

	}
@DeleteMapping("/{id}")
	public void deletejogo(@PathVariable Long id) {
		jogoService.deletejogo(id);
	}
	


@GetMapping
public ResponseEntity<List<Jogo>> getAllJogos(RequestEntity<Void> requestEntity) {
	String method = requestEntity.getMethod().name();
	String contentType = requestEntity.getHeaders().getContentType().toString();
	List<Jogo> jogos = jogoService.getAllJogo();
	return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
			.body(jogos);
}

@PutMapping("/{id}")
public Jogo updateJogo(@PathVariable Long id, @RequestBody Jogo jogo) {
    return jogoService.updateJogo(id, jogo);
}
}
