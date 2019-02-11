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
@Table(name="TB_PASTEL")
@SequenceGenerator(name="pastel", sequenceName="SQ_TB_PASTEL", allocationSize=1)
public class Pastel {

	@Id
	@GeneratedValue(generator="pastel", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Column(name="ds_sabor", nullable = false, length= 50)
	private String sabor;
	@Column(name="vl_pastel", nullable = false)
	private float preco;
	@Column(name="is_especial")
	private boolean especial;
	@Column(name="ds_massa")
	@Enumerated(EnumType.STRING)
	private Massa massa;
	@CreationTimestamp
	private Calendar dataCadastro;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataPedido;
	@Transient
	private int numeroComanda;
	@Lob
	private byte[] foto;
}
