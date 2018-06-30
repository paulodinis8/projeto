package pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.domain.Propriedade;

@Repository
public interface PropriedadeRespository extends JpaRepository<Propriedade, Integer> {
    //List<Categoria> findByDesignacao(String designacao);
}