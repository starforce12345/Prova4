package Prova.Back.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Prova.Back.Model.Tipo;

@Repository
public interface TipoRepository extends JpaRepository <Tipo, Long> {
}
