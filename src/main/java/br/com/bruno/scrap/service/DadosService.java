package br.com.bruno.scrap.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.scrap.config.Scrapper;
import br.com.bruno.scrap.model.Dados;
import br.com.bruno.scrap.repository.DadosRepository;

@Service
public class DadosService {

	@Autowired
	private DadosRepository dadosRepository;
	
	@Autowired
	private Scrapper scrapper;
	
	public List<Dados> listarTodos(){
		return dadosRepository.findAll();
	}
	
	
	public Dados salvar(Dados dados) throws IOException {
		LocalDate data = LocalDate.now();
		List<Dados> lista = dadosRepository.findByAtualizacao(data);
		if(lista.isEmpty()) {
			Dados dadosBD = scrapper.listarDados();
			
			dados.setCasosAtivos(dadosBD.getCasosAtivos());
			dados.setNovasMortes(dadosBD.getNovasMortes());
			dados.setNovosCasos(dadosBD.getNovosCasos());
			dados.setPais(dadosBD.getPais());
			dados.setPopulacao(dadosBD.getPopulacao());
			dados.setTotalCasos(dadosBD.getTotalCasos());
			dados.setTotalMortes(dadosBD.getTotalMortes());
			dados.setTotalRecuperados(dadosBD.getTotalRecuperados());
			return dadosRepository.save(dadosBD);
		}else {		
			Dados dadosBD = scrapper.listarDados();
			lista.get(0).setId(lista.get(0).getId());
			lista.get(0).setCasosAtivos(dadosBD.getCasosAtivos());
			lista.get(0).setNovasMortes(dadosBD.getNovasMortes());
			lista.get(0).setNovosCasos(dadosBD.getNovosCasos());
			lista.get(0).setPopulacao(dadosBD.getPopulacao());
			lista.get(0).setTotalCasos(dadosBD.getTotalCasos());
			lista.get(0).setTotalMortes(dadosBD.getTotalMortes());
			lista.get(0).setTotalRecuperados(dadosBD.getTotalRecuperados());
			return dadosRepository.save(lista.get(0));
		}
		
	}
	
	
}
