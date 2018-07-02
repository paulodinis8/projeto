package pt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pt.domain.Jogo;

import java.util.List;

@Repository
public interface JogoRespository extends JpaRepository<Jogo, Integer>{
    //List<Jogo> findByNome(String nome);
	
	
	@Query("Select j from Jogo j")
	Page<Jogo> findAllPaginated(Pageable pageable);
	
	@Query("Select j from Jogo j inner join j.categorias jc on jc.id in ?1 ")
	Page<Jogo> findAllPaginatedFiltered(List<Integer> filters, Pageable pageable);

	
}