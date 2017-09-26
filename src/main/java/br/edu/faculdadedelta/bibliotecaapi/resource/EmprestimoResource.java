package br.edu.faculdadedelta.bibliotecaapi.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.faculdadedelta.bibliotecaapi.model.Emprestimo;
import br.edu.faculdadedelta.bibliotecaapi.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoResource {

	@Autowired
	private EmprestimoService service;
	
	@PostMapping
	public ResponseEntity<Emprestimo>inserir(@RequestBody @Valid Emprestimo emprestimo){
		Emprestimo emprestimoCadastrado = this.service.inserir(emprestimo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emprestimoCadastrado.getId()).toUri();
		return ResponseEntity.created(uri).body(emprestimoCadastrado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Emprestimo>alterar(@RequestBody @Valid Emprestimo emprestimo, @PathVariable("id") Long id){
			emprestimo.setId(id);
			this.service.alterar(emprestimo);
			return ResponseEntity.ok(emprestimo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo>pesquisarPorId(@PathVariable("id") Long id){
		Emprestimo emprestimo = this.service.pesquisaPorId(id);
		return ResponseEntity.ok(emprestimo);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>excluir(@PathVariable("id") Long id){
		this.service.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Emprestimo>>listar(){
		List<Emprestimo>emprestimos = this.service.listar();
		return ResponseEntity.ok(emprestimos);
	}
}
