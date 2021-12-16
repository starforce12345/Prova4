package Prova.Back.Unitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import Prova.Back.Model.Produto;
import Prova.Back.Repository.ProdutoRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProdutoTest {

	@Autowired
	private ProdutoRepository ProdutoRepository;
	
	@Test
	public void SearchProduct () {
		Produto Produto1 = new Produto
		(1L, "Goosebumps", "20", "Suspense", "Cascavel", "20", "90", null);
		Produto Produto2 = new Produto
		(2L, "MazeRunner", "20", "Ficao_cientifica", "Brasilia", "20", "90", null);
		List<Produto> Produtos = new ArrayList<>();
		Produtos.add(Produto1);
		Produtos.add(Produto2);
	}
	
	@Test
	public void CreateProduct () {
		Produto Produto = new Produto
		(1L, "Goosebumps", "20", "Suspense", "Cascavel", "20", "90", null);
		ProdutoRepository.save(Produto);
		assertNotNull(Produto);
	}
	
	@Test
	public void DeleteProduct () {
		Produto Produto = new Produto
		(1L, "Goosebumps", "20", "Suspense", "Cascavel", "20", "90", null);
		ProdutoRepository.save(Produto);
		Long id = Produto.getId();
		boolean presente1 = ProdutoRepository
		.findById(id).isPresent();
		ProdutoRepository.deleteById(id);
		boolean presente2 = ProdutoRepository
		.findById(id).isPresent();
		assertTrue(presente1);
		assertFalse(presente2);
	}
	
	@Test
	public void UpdateProduct () {
		String nome = "Goosebumps";
		Produto Produto = new Produto
		(1L, "Goosebumps", "20", "Suspense", "Cascavel", "20", "90", null);
		ProdutoRepository.save(Produto);
		Produto user = ProdutoRepository
		.findById(1L).get();
		user.setNome(nome);
		Produto use = ProdutoRepository
		.save(user);
		assertEquals(use.getNome(),nome);
	}
}
