package br.com.bruno.scrap.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.scrap.model.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Long>{

	List<Data> findByData(LocalDate data);
}
