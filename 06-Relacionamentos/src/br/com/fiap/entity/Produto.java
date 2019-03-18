package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PRODUTO")
@SequenceGenerator(name="produto", sequenceName="SEQ_T_PRODUTO", allocationSize=1)
public class Produto {
	@Id
	@Column(name="cd_produto")
	@GeneratedValue(generator = "produto", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Column(name= "nm_produto", nullable= false, length= 50)
	private String nome;
	@Column(name= "vl_valor", nullable = false)
	private double valor;
	
	@OneToMany(mappedBy= " produto")
	private List<ItemCarrinho> itemCarrinho;
	
	@ManyToMany(mappedBy="produtos")
	private List<Fornecedor> fornecedores;

}
