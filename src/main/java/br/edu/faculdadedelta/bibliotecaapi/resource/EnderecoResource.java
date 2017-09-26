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


import br.edu.faculdadedelta.bibliotecaapi.model.Endereco;
import br.edu.faculdadedelta.bibliotecaapi.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService service;
	
	@PostMapping
	public ResponseEntity<Endereco>inserir(@RequestBody @Valid Endereco endereco){
		Endereco enderecoCadastrado = this.service.inserir(endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(enderecoCadastrado.getId()).toUri();
		return ResponseEntity.created(uri).body(enderecoCadastrado);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Endereco>alterar(@RequestBody @Valid Endereco endereco, @PathVariable("id") Long id){
			endereco.setId(id);
			this.service.alterar(endereco);
			return ResponseEntity.ok(endereco);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco>pesquisarPorId(@PathVariable("id") Long id){
		Endereco endereco = this.service.pesquisarPorId(id);
		return ResponseEntity.ok(endereco);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>excluir(@PathVariable("id") Long id){
		this.service.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Endereco>>listar(){
		List<Endereco>enderecos = this.service.listar();
		return ResponseEntity.ok(enderecos);
	}
}
