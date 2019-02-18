package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TB_PASTEL") // não é obrigatório, altera o nome da tabela
// name: nome no java (generator), sequenceName: nome no banco,
// allocationSize: passo (de um em um)
@SequenceGenerator(name = "pastel", sequenceName = "SQ_TB_PASTEL", allocationSize = 1)
public class Pastel {

	@Id
	@GeneratedValue(generator = "pastel", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "ds_sabor", nullable = false, length = 50)
	private String sabor;

	@Column(name = "vl_pastel", nullable = false)
	private float preco;

	@Column(name = "is_especial")
	private boolean especial;

	@Column(name="ds_massa")
	@Enumerated(EnumType.STRING) //grava a constante no banco e não a ordem
	private Massa massa;
	
	@CreationTimestamp //gera a data de cadastro automáticamente
	@Column(updatable=false,name="dt_cadastro") //não será atualizado
	private Calendar dataCadastro;
	
	@Temporal(TemporalType.TIMESTAMP) //data e as horas
	private Calendar dataPedido;

	@Transient //não será uma coluna na tabela no banco de dados
	private int numeroComanda;

	@Lob //campo para arquivos
	private byte[] foto;
	
	public Pastel() {
		super();
	}

	public Pastel(int codigo, String sabor, float preco, boolean especial, Massa massa, Calendar dataPedido,
			byte[] foto) {
		super();
		this.codigo = codigo;
		this.sabor = sabor;
		this.preco = preco;
		this.especial = especial;
		this.massa = massa;
		this.dataPedido = dataPedido;
		this.foto = foto;
	}

	public Pastel(String sabor, float preco, boolean especial, Massa massa, Calendar dataPedido, byte[] foto) {
		super();
		this.sabor = sabor;
		this.preco = preco;
		this.especial = especial;
		this.massa = massa;
		this.dataPedido = dataPedido;
		this.foto = foto;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isEspecial() {
		return especial;
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}

	public Massa getMassa() {
		return massa;
	}

	public void setMassa(Massa massa) {
		this.massa = massa;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public int getNumeroComanda() {
		return numeroComanda;
	}

	public void setNumeroComanda(int numeroComanda) {
		this.numeroComanda = numeroComanda;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
}








