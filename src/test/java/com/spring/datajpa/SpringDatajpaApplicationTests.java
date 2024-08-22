package com.spring.datajpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.datajpa.model.EstudosModel;
import com.spring.datajpa.model.Telefone;
import com.spring.datajpa.repository.EstudosRepository;
import com.spring.datajpa.repository.TelefoneRepository;
import com.spring.datajpa.service.GenericService;

@SpringBootTest
class SpringDatajpaApplicationTests{
	
	@Autowired
	private EstudosRepository estudosRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	
	@Test
	void contextLoads() {
		//System.out.println("Iniciou com sucesso!");
		
	}
	
	@Test
	public void salvar() {
		EstudosModel objeto = new EstudosModel();
		objeto.setNome("Rock");
		objeto.setLogin("AAVe");
		objeto.setSenha("Sams");
		objeto.setEmail("samns@gmail.com");
		objeto.setIdade(3);
		estudosRepository.save(objeto);
	}
	
	@Test
	public void deletarName() {
		estudosRepository.deleteByNameAge("Alpha Beta", 27);
	}
	
	@Test
	public void consultar() {
		Optional<EstudosModel> estudosModel = estudosRepository.findById(1L);
		
		for(Telefone telefones : estudosModel.get().getTelefone() ) {
			System.out.println(telefones.getTipo());
			System.out.println(telefones.getNumero());
			System.out.println(telefones.getEstudosModel().getNome());
			System.out.println(estudosModel.get().getLogin());
		}
		
	}
	
	@Test
	public void consultarNome() {
		List<EstudosModel> estudosModel = estudosRepository.listName("Anthony",27);
		for (EstudosModel nomes : estudosModel) {
			System.out.println(nomes.getNome());
		}
		
		List<EstudosModel> estudos = estudosRepository.listName("Jennifer");
		for(EstudosModel pessoa : estudos) {
			System.out.println("Nome: "+pessoa.getNome());
		}
	}
	
	@Test
	public void insertTelephone() {
		
		Optional<EstudosModel> estudosModel = estudosRepository.findById(2L);
		
		Telefone telefone = new Telefone();
		
		telefone.setTipo("Mobile");
		telefone.setNumero(62995256017L);
		telefone.setEstudosModel(estudosModel.get());
		
		telefoneRepository.save(telefone);
		
		
	}
	
	@Test
	public void atualizarEmail() {
		estudosRepository.updateEmail("olivia@gmail.com", 303L);
	}
	
	@Test
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
