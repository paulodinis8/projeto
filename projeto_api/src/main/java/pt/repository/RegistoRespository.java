package pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.domain.Registo;

@Repository
public interface RegistoRespository extends JpaRepository<Registo, Integer> {
}
