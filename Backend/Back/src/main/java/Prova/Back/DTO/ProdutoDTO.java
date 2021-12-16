package Prova.Back.DTO;

import Prova.Back.Model.Produto;

public class ProdutoDTO {

	private Long id;
	private String nome;
	private Double quantidade;
	private String tipo;
	private String fornecedor;
	private Double precovenda;
	private Double precocompra;
	
	public ProdutoDTO () {
	}
	
	public ProdutoDTO(Long id, String nome, Double quantidade, String tipo, String fornecedor, Double precovenda, Double precocompra) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.fornecedor = fornecedor;
		this.precovenda = precovenda;
		this.precocompra = precocompra;
	}
	
	public ProdutoDTO(Produto entity) {
		id = entity.getId();
		nome = entity.getNome();
		quantidade = entity.getQuantidade();
		tipo = entity.getTipo();
		fornecedor = entity.getFornecedor();
		precovenda = entity.getPrecovenda();
		precocompra = entity.getPrecocompra();
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
