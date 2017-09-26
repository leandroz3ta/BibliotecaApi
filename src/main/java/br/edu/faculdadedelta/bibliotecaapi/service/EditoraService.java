package br.edu.faculdadedelta.bibliotecaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.faculdadedelta.bibliotecaapi.model.Editora;
import br.edu.faculdadedelta.bibliotecaapi.repository.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repository;
	
	public Editora alterar(Editora editora) {
		
		pesquisarPorId(editora.getId());
		
		return this.repository.save(editora);
	}

	public Editora pesquisarPorId(Long id) {
		
		Editora valorPesquisado = this.repository.findOne(id);

		if (valorPesquisado == null) {
			throw new EmptyResultDataAccessException(0);
		}
		
		return valorPesquisado;
	}
	
	public Editora inserir(Editora editora) {
		return this.repository.save(editora);
	}
	
	public void excluir(Long id) {
		this.repository.delete(id);
	}
	
	public List<Editora> listar() {
		return this.repository.findAll();
	}
}
