package br.com.bruno.scrap.config;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import br.com.bruno.scrap.model.Dados;
 
@Component
public class Scrapper {

	Document documento = null;
	
	
	public Dados listarDados() throws IOException {
		documento = Jsoup
		        .connect("https://www.worldometers.info/coronavirus/").get();
		        
		for(Element row: documento.select("#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(11)")) {
			
				String pais = row.select("td:nth-child(2)").text();
				String totalCasos = row.select("td:nth-child(3)").text();
				String novosCasos = row.select("td:nth-child(4)").text();
				String totalMortes = row.select("td:nth-child(5)").text();
				String novasMortes = row.select("td:nth-child(6)").text();
				String totalRecuperados = row.select("td:nth-child(7)").text();
				String casosAtivos = row.select("td:nth-child(9)").text();
				String populacao = row.select("td:nth-child(15)").text();
				String data = documento.select("body > div.container > div:nth-child(2) > div.col-md-8 > div > div:nth-child(5)").text();
				data = data.substring(14, 31);
				data = data.replace(",", "");
				data = data.replace(" ", "/");
				LocalDate datas = LocalDate.parse(data, DateTimeFormatter.ofPattern("MMMM/d/yyyy", Locale.ENGLISH));
			    Dados dados = new Dados(pais, totalCasos, novosCasos, totalMortes, novasMortes, totalRecuperados, casosAtivos, populacao, datas);
			    return dados;
		}
		
		return null;
		
	}


}
