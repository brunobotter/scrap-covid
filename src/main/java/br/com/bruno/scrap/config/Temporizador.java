package br.com.bruno.scrap.config;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.bruno.scrap.model.Dados;
import br.com.bruno.scrap.model.Data;
import br.com.bruno.scrap.repository.DataRepository;
import br.com.bruno.scrap.service.DadosService;
import br.com.bruno.scrap.service.DataService;

@Component
public class Temporizador {

	@Autowired
	private Scrapper scrap;
	
	@Autowired
	private DataService dataService;
	
	@Autowired
	private DataRepository paisRepository;
	
	@Autowired
	private DadosService dadoServices;
	
	//hora em milisegundos
	@Scheduled(fixedDelay = 3600000)
	public void populaTabela() throws IOException {
		LocalDate dataVigente = LocalDate.now();
		List<Data> listaData = paisRepository.findByData(dataVigente);
		List<Dados> listaDados = scrap.listarDadosPais();
		if(listaData.isEmpty()) {
			dadoServices.salvar(listaDados);
			Data data = new Data(dataVigente, listaDados);
			dataService.salvar(data);
		}else {
			dadoServices.atualizar(listaData.get(0).getDados(), listaDados);
		}	
	}
}
