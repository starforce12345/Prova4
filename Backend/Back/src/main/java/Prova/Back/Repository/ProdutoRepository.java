package Prova.Back.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Prova.Back.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long>{
}
