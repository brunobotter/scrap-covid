package br.com.bruno.scrap.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@JsonPropertyOrder({"id","pais","populacao","totalCasos","novosCasos","totalMortes",
	"novasMortes","totalRecuperados","casosAtivos"})
@Table(name = "dados")
public class Dados implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	String pais,totalCasos,novosCasos,totalMortes,novasMortes,
	 totalRecuperados,casosAtivos,populacao; 

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate atualizacao;


	public Dados() {
		
	}
	
	public Dados( String pais, String totalCasos, String novosCasos, String totalMortes, String novasMortes,
			String totalRecuperados, String casosAtivos, String populacao,
			LocalDate atualizacao) {
		
		this.pais = pais;
		this.totalCasos = totalCasos;
		this.novosCasos = novosCasos;
		this.totalMortes = totalMortes;
		this.novasMortes = novasMortes;
		this.totalRecuperados = totalRecuperados;
		this.casosAtivos = casosAtivos;
		this.populacao = populacao;
		this.atualizacao = atualizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTotalCasos() {
		return totalCasos;
	}

	public void setTotalCasos(String totalCasos) {
		this.totalCasos = totalCasos;
	}

	public String getNovosCasos() {
		return novosCasos;
	}

	public void setNovosCasos(String novosCasos) {
		this.novosCasos = novosCasos;
	}

	public String getTotalMortes() {
		return totalMortes;
	}

	public void setTotalMortes(String totalMortes) {
		this.totalMortes = totalMortes;
	}

	public String getNovasMortes() {
		return novasMortes;
	}

	public void setNovasMortes(String novasMortes) {
		this.novasMortes = novasMortes;
	}

	public String getTotalRecuperados() {
		return totalRecuperados;
	}

	public void setTotalRecuperados(String totalRecuperados) {
		this.totalRecuperados = totalRecuperados;
	}



	public String getCasosAtivos() {
		return casosAtivos;
	}

	public void setCasosAtivos(String casosAtivos) {
		this.casosAtivos = casosAtivos;
	}

	public String getPopulacao() {
		return populacao;
	}

	public void setPopulacao(String populacao) {
		this.populacao = populacao;
	}

	public LocalDate getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(LocalDate atualizacao) {
		this.atualizacao = atualizacao;
	}
	
	

	
}
