package pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.domain.Trofeu;

@Repository
public interface TrofeuRespository extends JpaRepository<Trofeu, Integer> {
}
