package pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.domain.Pontos;

@Repository
public interface PontosRespository extends JpaRepository<Pontos, Integer> {
}
