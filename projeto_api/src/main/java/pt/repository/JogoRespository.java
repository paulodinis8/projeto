package pt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.domain.Jogo;

import java.util.List;

@Repository
public interface JogoRespository extends JpaRepository<Jogo, Integer>{
    List<Jogo> findByNome(String nome);
}