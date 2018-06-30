package pt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pt.domain.Jogo;

@Repository
public interface JogoRespository extends JpaRepository<Jogo, Integer>{
    //List<Jogo> findByNome(String nome);

	@Query("Select j from Jogo j")
	Page<Jogo> findAllPaginated(Pageable pageable);
}