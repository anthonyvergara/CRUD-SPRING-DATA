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
		objeto.setNome("Estella");
		objeto.setLogin("estelinha");
		objeto.setSenha("flor");
		objeto.setEmail("estella@gmail.com");
		objeto.setIdade(3);
		EstudosModel objeto2 = new EstudosModel();
		objeto2.setNome("Olivia");
		objeto2.setLogin("vixiolivia");
		objeto2.setSenha("luz");
		objeto2.setEmail("estella@gmail.com");
		objeto2.setIdade(1);
		EstudosModel objeto3 = new EstudosModel();
		objeto3.setNome("Anthony Vergara");
		objeto3.setLogin("anthonyadm");
		objeto3.setSenha("adm");
		objeto3.setEmail("adm@gmail.com");
		objeto3.setIdade(27);
		estudosRepository.save(objeto);
		estudosRepository.save(objeto2);
		estudosRepository.save(objeto3);
	}
	
	@Test
	public void consultar() {
		Optional<EstudosModel> estudosModel = estudosRepository.findById(1L);
		
		System.out.println("Login: "+estudosModel.get().getLogin());
		
	}
	
	@Test
	public void consultarNome() {
		List<EstudosModel> estudosModel = estudosRepository.listName("Anthony");
		for (EstudosModel nomes : estudosModel) {
			System.out.println(nomes.getNome());
		}
	}
	
	
	public void update() {
		Optional<EstudosModel> estudosModel = estudosRepository.findById(1L);
		EstudosModel pessoa = estudosModel.get();
		pessoa.setNome("Jennifer");
		
		Optional<EstudosModel> estudosModel2 = estudosRepository.findById(2L);
		EstudosModel pessoa2 = estudosModel2.get();
		pessoa2.setNome("Anthony");
		estudosRepository.save(pessoa);
		estudosRepository.save(pessoa2);
	}
	
	
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
