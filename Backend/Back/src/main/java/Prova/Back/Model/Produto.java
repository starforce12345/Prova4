package Prova.Back.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double quantidade;
	private String tipo;
	private String fornecedor;
	private Double precovenda;
	private Double precocompra;

	public Produto () {
	}

	public Produto(Long id, String nome, Double quantidade, String tipo, String fornecedor, Double precovenda,
			Double precocompra) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.fornecedor = fornecedor;
		this.precovenda = precovenda;
		this.precocompra = precocompra;
	}

	public Produto(long l, String string, String string2, String string3, String string4, String string5,
			String string6, Object object) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Double getPrecovenda() {
		return precovenda;
	}

	public void setPrecovenda(Double precovenda) {
		this.precovenda = precovenda;
	}

	public Double getPrecocompra() {
		return precocompra;
	}

	public void setPrecocompra(Double precocompra) {
		this.precocompra = precocompra;
	}
}
