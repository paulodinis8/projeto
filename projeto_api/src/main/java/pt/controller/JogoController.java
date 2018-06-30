package pt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.domain.Jogo;
import pt.repository.JogoRespository;

import java.util.List;
import java.util.Map;

@RestController
public class JogoController {

    @Autowired
    JogoRespository jogoRespository;

    @CrossOrigin
    @GetMapping("/jogo")
    public  List<Jogo> index(){
        return jogoRespository.findAll();
    }

    @CrossOrigin
    @GetMapping("/jogo/{id}")
    public Jogo show(@PathVariable String id){
        int jogoId = Integer.parseInt(id);
        return jogoRespository.findOne(jogoId);
    }

    /*@PostMapping("/jogo/search")
    public List<Jogo> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return jogoRespository.findByNome();
    }*/

    @PostMapping("/jogo")
    public Jogo create(@RequestBody Map<String, String> body){
        String nome = body.get("nome");
        String link = body.get("link");
        String descricao = body.get("descricao");
        String foto=body.get("foto");
        return jogoRespository.save(new Jogo(nome, link, descricao, foto));
    }


    @PutMapping("/jogo/{id}")
    public Jogo update(@PathVariable String id, @RequestBody Map<String, String> body){
        int jogoId = Integer.parseInt(id);
        // getting utilizador
        Jogo jogo = jogoRespository.findOne(jogoId);
        jogo.setNome(body.get("nome"));
        jogo.setLink(body.get("link"));
        jogo.setDescricao(body.get("descricao"));
        jogo.setFoto(body.get("foto"));
        return jogoRespository.save(jogo);
    }

    @DeleteMapping("jogo/{id}")
    public boolean delete(@PathVariable String id){
        int jogoId = Integer.parseInt(id);
        jogoRespository.delete(jogoId);
        return true;
    }


}
