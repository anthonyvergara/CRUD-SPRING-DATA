package com.spring.datajpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.datajpa.model.EstudosModel;
import com.spring.datajpa.repository.EstudosRepository;
import com.spring.datajpa.service.GenericService;

@SpringBootTest
class SpringDatajpaApplicationTests{
	
	@Autowired
	private EstudosRepository estudosRepository;
	
	
	@Test
	void contextLoads() {
		//System.out.println("Iniciou com sucesso!");
		
	}
	
	public void salvar() {
		EstudosModel objeto = new EstudosModel();
		objeto.setLogin("Harry");
		objeto.setSenha("monster");
		objeto.setEmail("harry@gmail.com");
		objeto.setIdade(10);
		estudosRepository.save(objeto);
	}
	
	@Test
	public void consultar() {
		Optional<EstudosModel> estudosModel = estudosRepository.findById(1L);
		
		System.out.println("Login: "+estudosModel.get().getLogin());
		
	}
	
	@Test
	public void update() {
		Optional<EstudosModel> estudosModel = estudosRepository.findById(1L);
		EstudosModel pessoa = estudosModel.get();
		pessoa.setSenha("labiosdemel");
		estudosRepository.save(pessoa);
	}
	
	@Test
	public void delete() {
		Optional<EstudosModel> estudosModel = estudosRepository.findById(152L);
		estudosRepository.delete(estudosModel.get());
		estudosRepository.deleteById(202L);
	}
	
	@Test
	public void listarTodos() {
		List<EstudosModel> estudosModel = estudosRepository.findAll();
		for(EstudosModel list: estudosModel) {
			System.out.println(list.getEmail());
		}
	}

}
