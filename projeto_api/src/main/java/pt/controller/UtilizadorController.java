package pt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.domain.Utilizador;
import pt.repository.UtilizadorRespository;

import java.util.List;
import java.util.Map;

@RestController
public class UtilizadorController {

    @Autowired
    UtilizadorRespository utilizadorRespository;

    @CrossOrigin
    @GetMapping("/utilizador")
    public  List<Utilizador> index(){
        return utilizadorRespository.findAll();
    }

    @CrossOrigin
    @GetMapping("/utilizador/{id}")
    public Utilizador show(@PathVariable String id){
        int utilizadorId = Integer.parseInt(id);
        return utilizadorRespository.findOne(utilizadorId);
    }

    /*@PostMapping("/utilizador/search")
    public List<Utilizador> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return utilizadorRespository.findByNome();
    }*/

    @CrossOrigin
    @PostMapping("/utilizador")
    public Utilizador create(@RequestBody Map<String, String> body){
        System.out.println("entrei");
        String nome = body.get("nome");
        String localidade = body.get("localidade");
        String email = body.get("email");
        int idade = Integer.parseInt(body.get("idade"));
        String password=body.get("password");
        String genero= body.get("genero");
        int totalPontos=Integer.parseInt(body.get("totalPontos"));
        String foto=body.get("foto");
        return utilizadorRespository.save(new Utilizador(nome, localidade, email, idade, password, genero, totalPontos, foto));

    }

    @PutMapping("/utilizador/{id}")
    public Utilizador update(@PathVariable String id, @RequestBody Map<String, String> body){
        int utilizadorId = Integer.parseInt(id);
        // getting utilizador
        Utilizador utilizador = utilizadorRespository.findOne(utilizadorId);
        utilizador.setNome(body.get("nome"));
        utilizador.setLocalidade(body.get("localidade"));
        utilizador.setEmail(body.get("email"));
        utilizador.setIdade(Integer.parseInt(body.get("idade")));
        utilizador.setPassword(body.get("password"));
        utilizador.setGenero(body.get("genero"));
        utilizador.setTotalPontos(Integer.parseInt(body.get("totalPontos")));
        utilizador.setFoto("foto");
        return utilizadorRespository.save(utilizador);
    }

    @DeleteMapping("utilizador/{id}")
    public boolean delete(@PathVariable String id){
        int utilizadorId = Integer.parseInt(id);
        utilizadorRespository.delete(utilizadorId);
        return true;
    }
}