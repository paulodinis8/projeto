package pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.domain.*;

@Repository
public interface CategoriaRespository extends JpaRepository<Categoria, Integer> {
	//List<Categoria> findByNome(String nome);
}