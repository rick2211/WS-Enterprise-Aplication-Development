package br.com.fiap.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fiap.model.enums.Genero;

@Entity
@Table(name="T_VEICULO")
@SequenceGenerator(name="veiculo", sequenceName="SQ_T_VEICULO", allocationSize=1)
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "veiculo")
	private Long numeroCarteira;
	@Column(name="nm_motorista", length=150, nullable=false)
	private String nome;
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	@Column(name = "fl_carteira")
	private Byte[] file;
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero")
	private Genero  genero;
	
	
	public Veiculo(Long numeroCarteira, String nome, Calendar dataNascimento, Byte[] file, Genero genero) {
		super();
		this.numeroCarteira = numeroCarteira;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.file = file;
		this.genero = genero;
	}
	public Veiculo(String nome, Calendar dataNascimento, Byte[] file, Genero genero) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.file = file;
		this.genero = genero;
	}
	public Veiculo() {
		super();
	}
	public Long getNumeroCarteira() {
		return numeroCarteira;
	}
	public void setNumeroCarteira(Long numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Byte[] getFile() {
		return file;
	}
	public void setFile(Byte[] file) {
		this.file = file;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	

	
}
