package br.edu.faculdadedelta.bibliotecaapi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Livro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -711289182025183036L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo NOME é de preenchimento obrigatório!")
	private String nome;
	
	private int volume;
	
	@Temporal(TemporalType.DATE)
	private Date dataPublicacao;
	
	@Column(precision=10, scale=2)
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name="id_genero", nullable=false)
	private Genero genero;
	
	@ManyToOne
	@JoinColumn(name="id_autor", nullable=false)
	private Autor autor;
	
	@ManyToOne
	@JoinColumn(name="id_editora", nullable=false)
	private Editora editora;
}
