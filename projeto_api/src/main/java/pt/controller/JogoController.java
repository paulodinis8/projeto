package pt.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import pt.domain.Jogo;
import pt.repository.CategoriaRespository;
import pt.repository.JogoRespository;

import java.util.List;
import java.util.Map;


@RestController
public class JogoController {

    Gson gson = new Gson();
    
    
    @Autowired
    JogoRespository jogoRespository;
    
    @Autowired
    CategoriaRespository categoriaRespository;
    
    
    
    
    @CrossOrigin
    @GetMapping("/jogoTodos")
    public  List<Jogo> index(){
        return jogoRespository.findAll();
    }
    
    @CrossOrigin
    @GetMapping("/jogo")
    public Page<Jogo> findByPage(@RequestParam("page")int  page, @RequestParam("size") int size ){
    	return jogoRespository.findAllPaginated(new PageRequest(page,size));
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
    public Jogo create(@RequestBody Jogo jogo){
        
        return jogoRespository.save(jogo);
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
