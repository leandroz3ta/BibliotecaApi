package br.edu.faculdadedelta.bibliotecaapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Campo Rua é de preenchimento obrigatório!")
	private String rua;
	
	@NotBlank(message = "Campo Bairro é de preenchimento obrigatório!")
	private String bairro;
	
	@NotBlank(message = "Campo Quadra é de preenchimento obrigatório!")
	private String quadra;
	
	@NotBlank(message = "Campo Lote é de preenchimento obrigatório!")
	private String lote;
	
	@NotBlank(message = "Campo Número é de preenchimento obrigatório!")
	private String numero;
	
	@NotBlank(message = "Campo Complemento é de preenchimento obrigatório!")
	private String complemento;
	
	@NotBlank(message = "Campo Cidade é de preenchimento obrigatório!")
	private String cidade;
	
	@NotBlank(message = "Campo Estado é de preenchimento obrigatório!")
	private String estado;
	
	@NotBlank(message = "Campo País é de preenchimento obrigatório!")
	private String pais;
}
