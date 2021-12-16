package Prova.Back.DTO;

import Prova.Back.Model.Estoque;

public class EstoqueDTO {
	
	private Long id;
	private int quantidade;
	private ProdutoDTO produto;
	
	public EstoqueDTO (){
	}

	public EstoqueDTO(Long id, int quantidade, ProdutoDTO produto) {
		this.id = id;
		this.quantidade = quantidade;
		this.produto = produto;
	}
	
	public EstoqueDTO(Estoque entity) {
		id = entity.getId();
		quantidade = entity.getQuantidade();
		produto = new ProdutoDTO(entity.getProduto());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setNome(int quantidade) {
		this.quantidade = quantidade;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
}
