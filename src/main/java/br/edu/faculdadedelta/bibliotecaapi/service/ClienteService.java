package br.edu.faculdadedelta.bibliotecaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.faculdadedelta.bibliotecaapi.model.Cliente;
import br.edu.faculdadedelta.bibliotecaapi.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente alterar(Cliente cliente) {
		
		pesquisarPorId(cliente.getId());
		
		return this.repository.save(cliente);
	}

	public Cliente pesquisarPorId(Long id) {
		
		Cliente valorPesquisado = this.repository.findOne(id);

		if (valorPesquisado == null) {
			throw new EmptyResultDataAccessException(0);
		}
		
		return valorPesquisado;
	}
	
	public Cliente inserir(Cliente cliente) {
		return this.repository.save(cliente);
	}
	
	public void excluir(Long id) {
		this.repository.delete(id);
	}
	
	public List<Cliente> listar() {
		return this.repository.findAll();
	}
}
