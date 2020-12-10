package br.com.bruno.scrap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.scrap.model.Dados;

@Repository
public interface DadosRepository extends JpaRepository<Dados, Long>{

}
