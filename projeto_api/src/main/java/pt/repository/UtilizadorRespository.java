package pt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.domain.Utilizador;

@Repository
public interface UtilizadorRespository extends JpaRepository<Utilizador, Integer> {

    // custom query to search to blog post by title or content

    //List<Utilizador> findById(Integer id);
    //  @Query("select utilizador from Utilizador utilizador where utilizador.email=?1")
    //  Utilizador findByEmail(String email);
}