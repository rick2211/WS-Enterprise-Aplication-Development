package br.com.fiap.entity;

import java.io.Serializable;
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

@Entity
@Table(name="T_FARMACIA")
@SequenceGenerator(name="farmacia", sequenceName="SQ_T_FARMACIA",allocationSize=1)
public class Farmacia implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cd_farmacia", nullable=false,length=50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SQ_T_FARMACIA")
	private Integer cdFarmacia;
	
	@Column(name="nm_farmacia")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_abertura")
	private Calendar dataAbertura;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo")
	private TipoFarmacia tipo;
	
	@Column(name="ds_plantao")
	private Boolean plantao;
	
	
	public Farmacia(String nome, Calendar dataAbertura, TipoFarmacia tipo, Boolean plantao) {
		super();
		this.nome = nome;
		this.dataAbertura = dataAbertura;
		this.tipo = tipo;
		this.plantao = plantao;
	}

	public Farmacia(Integer cdFarmacia, String nome, Calendar dataAbertura, TipoFarmacia tipo, Boolean plantao) {
		super();
		this.cdFarmacia = cdFarmacia;
		this.nome = nome;
		this.dataAbertura = dataAbertura;
		this.tipo = tipo;
		this.plantao = plantao;
	}
	
	public Farmacia() {
		super();
	}
	public Integer getCdFarmacia() {
		return cdFarmacia;
	}
	public void setCdFarmacia(Integer cdFarmacia) {
		this.cdFarmacia = cdFarmacia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public TipoFarmacia getTipo() {
		return tipo;
	}
	public void setTipo(TipoFarmacia tipo) {
		this.tipo = tipo;
	}
	public Boolean getPlantao() {
		return plantao;
	}
	public void setPlantao(Boolean plantao) {
		this.plantao = plantao;
	}
	
	
	

}
