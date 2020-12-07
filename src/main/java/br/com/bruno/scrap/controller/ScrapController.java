package br.com.bruno.scrap.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.scrap.model.Dados;
import br.com.bruno.scrap.service.DadosService;


@RestController
@RequestMapping("/api")
public class ScrapController {

	@Autowired
	private DadosService dadosService;
	
	@GetMapping
	public ResponseEntity<List<Dados>> listar() throws IOException{
		List<Dados> dados = dadosService.listarTodos();
		return ResponseEntity.ok(dados);
	}
	

}
