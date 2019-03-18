package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_FORNECEDOR")
@SequenceGenerator(name="fornecedor", sequenceName="SEQ_T_FORNECEDOR", allocationSize=1)
public class Fornecedor {
	@Id
	@Column(name="cd_fornecedor")
	@GeneratedValue(generator = "fornecedor", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Column(name= "nm_fornecedor", nullable= false, length= 50)
	private String nome;
	@Column(name= "nr_cnpj", nullable= false, length= 14)
	private String cnpj;
	
	@JoinColumn(name="fornecedores")
	@ManyToMany()
	private List<Produto> produtos;

}
