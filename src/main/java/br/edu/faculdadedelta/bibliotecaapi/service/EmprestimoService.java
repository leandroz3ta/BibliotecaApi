package br.edu.faculdadedelta.bibliotecaapi.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.faculdadedelta.bibliotecaapi.model.Emprestimo;
import br.edu.faculdadedelta.bibliotecaapi.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	private EmprestimoRepository repository;
	
	public Emprestimo alterar(Emprestimo emprestimo) {
		
		pesquisaPorId(emprestimo.getId());
		
		return this.repository.save(emprestimo);
	}

	public Emprestimo pesquisaPorId(Long id) {
		
		Emprestimo valorPesquisado = this.repository.findOne(id);

		if (valorPesquisado == null) {
			throw new EmptyResultDataAccessException(0);
		}
		
		return valorPesquisado;
	}
	
	public Emprestimo inserir(Emprestimo emprestimo) {
		return this.repository.save(emprestimo);
	}
	
	public void excluir(Long id) {
		this.repository.delete(id);
	}
	
	public List<Emprestimo> listar() {
		return this.repository.findAll();
	}
}
