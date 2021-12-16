package Prova.Back.DTO;

import Prova.Back.Model.Fornecedor;

public class FornecedorDTO {

	private Long id;
	private String nome;
	private String local;
	
	private ProdutoDTO produto;
	
	public FornecedorDTO () {
	}

	public FornecedorDTO(Long id, String nome, String local, ProdutoDTO produto) {
		this.id = id;
		this.nome = nome;
		this.local = local;
		this.produto = produto;
	}
	
	public FornecedorDTO(Fornecedor entity) {
		id = entity.getId();
		nome = entity.getNome();
		local = entity.getLocal();
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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}  		
}
