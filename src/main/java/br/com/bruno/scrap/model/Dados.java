package br.com.bruno.scrap.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@JsonPropertyOrder({ "id", "pais", "populacao", "totalCasos", "novosCasos", "totalMortes", "novasMortes",
		"totalRecuperados", "casosAtivos" })
@Table(name = "dados")
public class Dados implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	String pais, totalCasos, novosCasos, totalMortes, novasMortes, totalRecuperados, casosAtivos, populacao;

	@JsonIgnore
	@ManyToOne
	private Data lista;

	public Dados() {

	}

	public Dados(String pais, String totalCasos, String novosCasos, String totalMortes, String novasMortes,
			String totalRecuperados, String casosAtivos, String populacao) {
		super();
		this.pais = pais;
		this.totalCasos = totalCasos;
		this.novosCasos = novosCasos;
		this.totalMortes = totalMortes;
		this.novasMortes = novasMortes;
		this.totalRecuperados = totalRecuperados;
		this.casosAtivos = casosAtivos;
		this.populacao = populacao;

	}

	public Data getLista() {
		return lista;
	}

	public void setLista(Data lista) {
		this.lista = lista;
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

}
