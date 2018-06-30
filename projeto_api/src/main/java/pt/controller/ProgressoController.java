package pt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.domain.Progresso;
import pt.repository.ProgressoRespository;

import java.util.List;
import java.util.Map;

@RestController
public class ProgressoController {

    @Autowired
    ProgressoRespository progressoRespository;

    @CrossOrigin
    @GetMapping("/progresso")
    public List<Progresso> index(){
        return progressoRespository.findAll();
    }

    @CrossOrigin
    @GetMapping("/progresso/{id}")
    public Progresso show(@PathVariable String id){
        int progressoId = Integer.parseInt(id);
        return progressoRespository.findOne(progressoId);
    }

    /*@PostMapping("/jogo/search")
    public List<Jogo> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return jogoRespository.findByNome();
    }*/
    @PostMapping("/progresso")
    public Progresso create(@RequestBody Map<String, String> body){
        String favorito = body.get("favorito");
        return progressoRespository.save(new Progresso(favorito));
    }


    @PutMapping("/progresso/{id}")
    public Progresso update(@PathVariable String id, @RequestBody Map<String, String> body){
        int proressoId = Integer.parseInt(id);
        // getting utilizador
        Progresso progresso= progressoRespository.findOne(proressoId);
        progresso.setFavorito(body.get("favorito"));
        return progressoRespository.save(progresso);
    }

    @DeleteMapping("progressp/{id}")
    public boolean delete(@PathVariable String id){
        int progressoId=Integer.parseInt(id);
        progressoRespository.delete(progressoId);
        return true;
    }


}
