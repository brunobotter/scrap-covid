package br.com.bruno.scrap.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.scrap.model.Dados;

@Repository
public interface DadosRepository extends JpaRepository<Dados, Long>{

	List<Dados> findByAtualizacao(LocalDate atualizacao);
}
