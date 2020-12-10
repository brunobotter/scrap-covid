package br.com.bruno.scrap.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import br.com.bruno.scrap.model.Dados;

@Component
public class Scrapper {

	Document documento = null;

	public List<Dados> listarDadosPais() throws IOException {
		documento = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();
		// 5 ate 228
		List<Dados> listaDados = new ArrayList<Dados>();
		for (int i = 9; i <= 228; i++) {
			Elements row = documento
					.select("#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + i + ")");
			
			String pais = row.select("td:nth-child(2)").text();
			String totalCasos = row.select("td:nth-child(3)").text();
			String novosCasos = row.select("td:nth-child(4)").text();
			String totalMortes = row.select("td:nth-child(5)").text();
			String novasMortes = row.select("td:nth-child(6)").text();
			String totalRecuperados = row.select("td:nth-child(7)").text();
			String casosAtivos = row.select("td:nth-child(9)").text();
			String populacao = row.select("td:nth-child(15)").text();
			
			Dados dados =new Dados(pais, totalCasos, novosCasos, totalMortes, novasMortes, totalRecuperados,
					casosAtivos, populacao);
			listaDados.add(dados);
		}
		return listaDados;
	}

}
