package pt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.domain.CategoriaPai;
import pt.repository.CategoriaPaiRespository;

import java.util.List;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class CategoriaPaiController {

    @Autowired
    CategoriaPaiRespository categoriaPaiRespository;

    @CrossOrigin
    @GetMapping("/CategoriaPai")
    public List<CategoriaPai> index() {
        System.out.println("catpai .. ");
        return categoriaPaiRespository.findAll();
    }

    @CrossOrigin
    @GetMapping("/CategoriaPai/{id}")
    public CategoriaPai show(@PathVariable String id) {
        int CategoriaPaiId=Integer.parseInt(id);
        return categoriaPaiRespository.findOne(CategoriaPaiId);
    }

    /*@PostMapping("/jogo/search")
    public List<Jogo> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return CategoriaPaiRespository.findByNome();
    }*/

    @PostMapping("/CategoriaPai")
    public CategoriaPai create(@RequestBody Map<String, String> body) {
        String designacao=body.get("designacao");
        //int subCategoriaPai_id = Integer.parseInt(body.get("subCategoriaPai_id"));
        return categoriaPaiRespository.save(new CategoriaPai(designacao));
    }

   /* @PostMapping("/CategoriaPai")
    public CategoriaPai create(@RequestBody Map<String, String> body){
        String designacao = body.get("designacao");
        int subCategoriaPai_id = Integer.parseInt(body.get("subCategoriaPai_id"));
        return CategoriaPaiRespository.save(new CategoriaPai(designacao,subCategoriaPai_id));
    }

*/

    @PutMapping("/CategoriaPai/{id}")
    public CategoriaPai update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int CategoriaPaiId=Integer.parseInt(id);
        // getting CategoriaPai
        CategoriaPai CategoriaPai=categoriaPaiRespository.findOne(CategoriaPaiId);
        CategoriaPai.setDesignacao(body.get("designacao"));
        //   CategoriaPai.setDesignacao(body.get("subCategoriaPai_id"));
        return categoriaPaiRespository.save(CategoriaPai);
    }

    @DeleteMapping("CategoriaPai/{id}")
    public boolean delete(@PathVariable String id) {
        int CategoriaPaiId=Integer.parseInt(id);
        categoriaPaiRespository.delete(CategoriaPaiId);
        return true;
    }
}
