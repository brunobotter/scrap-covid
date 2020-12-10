package br.com.bruno.scrap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.scrap.model.Data;
import br.com.bruno.scrap.repository.DataRepository;

@Service
public class DataService {

	@Autowired
	private DataRepository dataRepository;
	
	public List<Data> findAll(){
		return dataRepository.findAll();
	}

	public Data salvar(Data pais) {
			return dataRepository.save(pais);
		}

	public void atualizar(Data dataBD, Long id) {
		Data dataSalvar = dataRepository.findById(id).orElseThrow();
		dataSalvar.setDados(dataBD.getDados());
		dataRepository.save(dataSalvar);
	}
		
	}

