package pt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import pt.domain.Categoria;
import pt.repository.CategoriaRespository;

import java.util.List;
import java.util.Map;

@RestController
public class CategoriaController {

    @Autowired
    CategoriaRespository categoriaRespository;

    @GetMapping("/categoria")
    public  List<Categoria> index(){
        return categoriaRespository.findAll();
    }

    @GetMapping("/categoria/{id}")
    public Categoria show(@PathVariable String id){
        int categoriaId = Integer.parseInt(id);
        return categoriaRespository.findOne(categoriaId);
    }

    /*@PostMapping("/jogo/search")
    public List<Jogo> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return jogoRespository.findByNome();
    }*/

    @PostMapping("/categoria")
    public Categoria create(@RequestBody Map<String, String> body){
        String designacao = body.get("designacao");
        int subCategoria_id = Integer.parseInt(body.get("subCategoria_id"));
        return categoriaRespository.save(new Categoria(designacao, subCategoria_id));
    }


    @PutMapping("/categoria/{id}")
    public Categoria update(@PathVariable String id, @RequestBody Map<String, String> body){
        int categoriaId = Integer.parseInt(id);
        // getting categoria
        Categoria categoria = categoriaRespository.findOne(categoriaId);
        categoria.setDesignacao(body.get("designacao"));
        categoria.setDesignacao(body.get("subCategoria_id"));
        return categoriaRespository.save(categoria);
    }

    @DeleteMapping("categoria/{id}")
    public boolean delete(@PathVariable String id){
        int categoriaId = Integer.parseInt(id);
        categoriaRespository.delete(categoriaId);
        return true;
    }


}
