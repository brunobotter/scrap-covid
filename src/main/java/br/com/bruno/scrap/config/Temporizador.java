package br.com.bruno.scrap.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.bruno.scrap.model.Dados;
import br.com.bruno.scrap.service.DadosService;

@Component
public class Temporizador {

	@Autowired
	private Scrapper scrap;
	
	@Autowired
	private DadosService service;
	
	@Scheduled(fixedDelay = 100000)
	public void populaTabela() throws IOException {
		Dados dados = scrap.listarDados();
		service.salvar(dados);
	}
}
