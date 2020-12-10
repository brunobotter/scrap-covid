package br.com.bruno.scrap.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.scrap.model.Data;
import br.com.bruno.scrap.service.DataService;


@RestController
@RequestMapping("/api")
public class ScrapController {

	@Autowired
	private DataService dataService;
	
	@GetMapping
	public ResponseEntity<List<Data>> listar() throws IOException{
		List<Data> dados = dataService.findAll();
		return ResponseEntity.ok(dados);
	}
	

}
