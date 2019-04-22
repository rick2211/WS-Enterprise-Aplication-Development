package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_USUARIO")
@SequenceGenerator(name="usuario",sequenceName="SEQ_TAB_USUARIO",allocationSize=1)
public class Usuario {

	@Id
	@Column(name="cod_usuario")
	@GeneratedValue(generator="usuario",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nom_usuario")
	private String nome;

	@ManyToMany(mappedBy="usuarios")
	private List<ItemTeste> itens;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ItemTeste> getItens() {
		return itens;
	}

	public void setItens(List<ItemTeste> itens) {
		this.itens = itens;
	}
	
}
