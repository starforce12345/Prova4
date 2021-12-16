package Prova.Back.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Prova.Back.Model.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository <Fornecedor, Long> {

}
