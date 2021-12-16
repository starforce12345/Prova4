package Prova.Back.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Prova.Back.Model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository <Estoque, Long> {

}
