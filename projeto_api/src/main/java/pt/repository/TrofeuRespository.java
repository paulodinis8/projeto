package pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pt.domain.Trofeu;

import java.util.List;

@Repository
public interface TrofeuRespository extends JpaRepository<Trofeu, Integer> {

    @Query("select trofeu from Trofeu trofeu where trofeu.registo.progresso.utilizador.id =?1")
    List<Trofeu> findTrofeuByUser(int userId);
}
