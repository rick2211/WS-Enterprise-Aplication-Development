package br.com.fiap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ITEM_CARRINHO")
@SequenceGenerator(name="item_carrinho", sequenceName="SEQ_T_ITEM_CARRINHO", allocationSize=1)
public class ItemCarrinho {
	@Id
	@Column(name="cd_item_carrinho")
	@GeneratedValue(generator = "item_carrinho", strategy=GenerationType.SEQUENCE)
	private int codigo;
	@Column(name= "qt_quantidade")
	private int quantidade;
	@Column(name= "vl_valor", nullable=false)
	private double valor;
	
	@ManyToOne
	@JoinColumn(name="cd_carrinho")
	private CarrinhoCompras carrinhoCompras;
	
	@ManyToOne
	@JoinColumn(name="cd_produto")
	private Produto produto;

}
