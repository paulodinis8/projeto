package pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.domain.CategoriaPai;

@Repository
public interface CategoriaPaiRespository extends JpaRepository<CategoriaPai, Integer> {
    //List<Categoria> findByDesignacao(String designacao);
}