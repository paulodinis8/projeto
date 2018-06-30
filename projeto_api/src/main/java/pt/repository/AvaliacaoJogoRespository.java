package pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.domain.AvaliacaoJogo;

@Repository
public interface AvaliacaoJogoRespository extends JpaRepository<AvaliacaoJogo, Integer> {
    //List<Categoria> findByDesignacao(String designacao);
}