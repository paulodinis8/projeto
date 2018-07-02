package pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pt.domain.Progresso;

import java.util.List;

@Repository
public interface ProgressoRespository extends JpaRepository<Progresso, Integer> {

    @Query("select progresso from Progresso progresso where progresso.utilizador.id =?1")
    List<Progresso> findProgressoByUser(int userId);
}
