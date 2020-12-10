package br.com.bruno.scrap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.scrap.model.Dados;
import br.com.bruno.scrap.repository.DadosRepository;

@Service
public class DadosService {

	@Autowired
	private DadosRepository dadosRepository;

	public List<Dados> listarTodos() {
		return dadosRepository.findAll();
	}

	public void salvar(List<Dados> dados) {
		for (Dados dados2 : dados) {
			dadosRepository.save(dados2);
		}
	}

	public void atualizar(List<Dados> listaBD, List<Dados> listaScrap) {
		int contador = 0;
		for (Dados dados : listaBD) {
			dados.setCasosAtivos(listaScrap.get(contador).getCasosAtivos());
			dados.setLista(listaScrap.get(contador).getLista());
			dados.setNovasMortes(listaScrap.get(contador).getNovasMortes());
			dados.setNovosCasos(listaScrap.get(contador).getNovosCasos());
			dados.setPais(listaScrap.get(contador).getPais());
			dados.setPopulacao(listaScrap.get(contador).getPopulacao());
			dados.setTotalCasos(listaScrap.get(contador).getTotalCasos());
			dados.setTotalMortes(listaScrap.get(contador).getTotalMortes());
			dadosRepository.save(dados);
			contador++;
		}
	}

}
