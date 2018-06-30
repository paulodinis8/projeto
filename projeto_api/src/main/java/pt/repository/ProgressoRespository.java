package pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.domain.Progresso;

@Repository
public interface ProgressoRespository extends JpaRepository<Progresso, Integer> {
}
