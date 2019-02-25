package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "T_VEICULO")
@SequenceGenerator(name="veiculo", sequenceName= "SQ_T_VEICULO", allocationSize=1)
public class Motorista {
	
	@Id
	@GeneratedValue(generator="veiculo", strategy=GenerationType.SEQUENCE)
	private Integer codigo;
	@Column(name="ds_placa",length=9, nullable=false)
	private String placa;
	@Column(name="ds_cor",length=20, nullable=false)
	private String cor;
	@Column(name="nr_ano")
	private Integer ano;
	
	
	
	public Motorista(Integer codigo, String placa, String cor, Integer ano) {
		super();
		this.codigo = codigo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}
	public Motorista(String placa, String cor, Integer ano) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}
	public Motorista() {
		super();
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	

}
