package com.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.datajpa.model.EstudosModel;

@Repository
public interface EstudosRepository extends JpaRepository<EstudosModel, Long>{

}
