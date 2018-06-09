package pt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.domain.Utilizador;

import java.util.List;

@Repository
public interface UtilizadorRespository extends JpaRepository<Utilizador, Integer> {

    // custom query to search to blog post by title or content

    //List<Utilizador> findById(Integer id);
    List<Utilizador> findByNome(String nome);
}