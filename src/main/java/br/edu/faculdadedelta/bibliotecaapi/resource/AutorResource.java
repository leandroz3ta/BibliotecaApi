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

import br.edu.faculdadedelta.bibliotecaapi.model.Autor;
import br.edu.faculdadedelta.bibliotecaapi.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorResource {

	@Autowired
	private AutorService service;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Autor>inserir(@RequestBody @Valid Autor autor){
		Autor autorCadastrado = this.service.inserir(autor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autorCadastrado.getId()).toUri();
		return ResponseEntity.created(uri).body(autorCadastrado);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Autor>alterar(@RequestBody @Valid Autor autor, @PathVariable("id") Long id){
			autor.setId(id);
			this.service.alterar(autor);
			return ResponseEntity.ok(autor);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Autor>pesquisarPorId(@PathVariable("id") Long id){
		Autor autor = this.service.pesquisarPorId(id);
		return ResponseEntity.ok(autor);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>excluir(@PathVariable("id") Long id){
		this.service.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Autor>>listar(){
		List<Autor>autores = this.service.listar();
		return ResponseEntity.ok(autores);
	}
}
