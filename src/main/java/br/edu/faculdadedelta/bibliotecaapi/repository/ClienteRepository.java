package br.edu.faculdadedelta.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.faculdadedelta.bibliotecaapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
