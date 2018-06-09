package pt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.domain.Jogo;
import pt.domain.Progresso;

import java.util.List;
import java.util.Map;

@RestController
public class ProgressoController {
/*
    @Autowired
    ProgressoRespository progressoRespository;

    @GetMapping("/progresso")
    public List<Progresso> index(){
        return progressoRespository.findAll();
    }

    @GetMapping("/progresso/{id}")
    public Progresso show(@PathVariable String id){
        int progressoId = Integer.parseInt(id);
        return progressoId.findOne(progressoId);
    }
*/
    /*@PostMapping("/jogo/search")
    public List<Jogo> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return jogoRespository.findByNome();
    }*/
/*
    @PostMapping("/progresso")
    public Progresso create(@RequestBody Map<String, String> body){
        String jogo = body.get("jogo");
        String utilizador = body.get("utilizador");
        String favorito = body.get("favorito");
        return progressoRespository.save(new Jogo(jogo, utilizador, favorito));
    }


    @PutMapping("/progresso/{id}")
    public Progresso update(@PathVariable String id, @RequestBody Map<String, String> body){
        int proressoId = Integer.parseInt(id);
        // getting utilizador
        Progresso progresso= progressoRespository.findOne(proressoId);
        jogo.setNome(body.get("nome"));
        jogo.setLink(body.get("link"));
        jogo.setDescricao(body.get("descricao"));
        return jogoRespository.save(jogo);
    }

    @DeleteMapping("jogo/{id}")
    public boolean delete(@PathVariable String id){
        int jogoId = Integer.parseInt(id);
        jogoRespository.delete(jogoId);
        return true;
    }
*/

}
