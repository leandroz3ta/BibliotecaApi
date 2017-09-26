package br.edu.faculdadedelta.bibliotecaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.faculdadedelta.bibliotecaapi.model.Endereco;
import br.edu.faculdadedelta.bibliotecaapi.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public Endereco alterar(Endereco endereco) {
		
		pesquisarPorId(endereco.getId());
		
		return this.repository.save(endereco);
	}

	public Endereco pesquisarPorId(Long id) {
		
		Endereco valorPesquisado = this.repository.findOne(id);

		if (valorPesquisado == null) {
			throw new EmptyResultDataAccessException(0);
		}
		
		return valorPesquisado;
	}
	
	public Endereco inserir(Endereco endereco) {
		return this.repository.save(endereco);
	}
	
	public void excluir(Long id) {
		this.repository.delete(id);
	}
	
	public List<Endereco> listar() {
		return this.repository.findAll();
	}
}
