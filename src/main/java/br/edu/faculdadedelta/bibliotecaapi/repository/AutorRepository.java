package br.edu.faculdadedelta.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.faculdadedelta.bibliotecaapi.model.Autor;

public interface AutorRepository  extends JpaRepository<Autor, Long>{

}
