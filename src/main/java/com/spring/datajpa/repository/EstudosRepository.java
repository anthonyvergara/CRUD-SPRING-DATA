package com.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.datajpa.model.EstudosModel;

@Repository
public interface EstudosRepository extends JpaRepository<EstudosModel, Long>{
	
	@Query (value = "select p from EstudosModel p where p.nome like %?1%")
	public List<EstudosModel> listName(String name);

}
