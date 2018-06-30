package pt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.domain.AvaliacaoJogo;
import pt.repository.AvaliacaoJogoRespository;

import java.util.List;
import java.util.Map;

@RestController
public class AvaliacaoJogoController {

    @Autowired
    AvaliacaoJogoRespository avaliacaoJogoRespository;

    @CrossOrigin
    @GetMapping("/avaliacaoJogo")
    public List<AvaliacaoJogo> index() {
        return avaliacaoJogoRespository.findAll();
    }

    @CrossOrigin
    @GetMapping("/avaliacaoJogo/{id}")
    public AvaliacaoJogo show(@PathVariable String id) {
        int avaliacaoJogoId=Integer.parseInt(id);
        return avaliacaoJogoRespository.findOne(avaliacaoJogoId);
    }

    /*@PostMapping("/jogo/search")
    public List<Jogo> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return jogoRespository.findByNome();
    }*/

    @PostMapping("/avaliacaoJogo")
    public AvaliacaoJogo create(@RequestBody Map<String, String> body) {
        int estrelas=Integer.parseInt(body.get("estrelas"));
        String comentario=body.get("comentario");
        //int subCategoria_id = Integer.parseInt(body.get("subCategoria_id"));
        return avaliacaoJogoRespository.save(new AvaliacaoJogo(estrelas, comentario));
    }


    @PutMapping("/avaliacaoJogo/{id}")
    public AvaliacaoJogo update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int avaliacaoJogoId=Integer.parseInt(id);
        // getting categoria
        AvaliacaoJogo avaliacaoJogo=avaliacaoJogoRespository.findOne(avaliacaoJogoId);
        avaliacaoJogo.setEstrelas(Integer.parseInt(body.get("estrelas")));
        avaliacaoJogo.setComentario("comentario");
        //   categoria.setDesignacao(body.get("subCategoria_id"));
        return avaliacaoJogoRespository.save(avaliacaoJogo);
    }

    @DeleteMapping("avaliacaoJogo/{id}")
    public boolean delete(@PathVariable String id) {
        int avaliacaoJogoId=Integer.parseInt(id);
        avaliacaoJogoRespository.delete(avaliacaoJogoId);
        return true;
    }


}