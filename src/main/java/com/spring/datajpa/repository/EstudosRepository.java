package com.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.datajpa.model.EstudosModel;

import jakarta.transaction.Transactional;

@Repository
public interface EstudosRepository extends JpaRepository<EstudosModel, Long>{
	
	@Query (value = "select p from EstudosModel p where p.nome like %?1% and p.idade = ?2")
	public List<EstudosModel> listName(String name, int age);
	
	@Query (value = "select p from EstudosModel p where p.nome = :nome")
	public List<EstudosModel> listName(@Param("nome") String nome);
	
	@Modifying
	@Transactional
	@Query (value = "delete from EstudosModel p where p.nome = :nome")
	public void deleteByName(@Param("nome") String nome);
	
	@Modifying
	@Transactional
	@Query (value = "delete from EstudosModel p where p.nome = :nome and p.idade = :idade")
	public void deleteByNameAge(@Param("nome")String nome , 
								@Param("idade") int idade);
	
	@Modifying
	@Transactional
	@Query (value = "update EstudosModel p set p.email = :email where p.id = :id")
	public void updateEmail(@Param("email") String email, 
							@Param("id") Long id);
}
