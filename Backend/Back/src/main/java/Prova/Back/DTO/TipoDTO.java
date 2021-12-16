package Prova.Back.DTO;

import Prova.Back.Model.Tipo;

public class TipoDTO {
	
	private Long id;
	private String nome;
	
	private ProdutoDTO produto;
	
	public TipoDTO () {
	}

	public TipoDTO(Long id, String nome, ProdutoDTO produto) {
		this.id = id;
		this.nome = nome;
		this.produto = produto;
	}
	
	public TipoDTO(Tipo entity) {
		id = entity.getId();
		nome = entity.getNome();
		produto = new ProdutoDTO (entity.getProduto());
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

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
}
