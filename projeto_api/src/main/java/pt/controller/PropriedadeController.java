package pt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.domain.Propriedade;
import pt.repository.PropriedadeRespository;

import java.util.List;
import java.util.Map;

public class PropriedadeController {

    @Autowired
    PropriedadeRespository propriedadeRespository;

    @CrossOrigin
    @GetMapping("/Propriedade")
    public List<Propriedade> index() {
        return propriedadeRespository.findAll();
    }

    @CrossOrigin
    @GetMapping("/Propriedade/{id}")
    public Propriedade show(@PathVariable String id) {
        int PropriedadeId=Integer.parseInt(id);
        return propriedadeRespository.findOne(PropriedadeId);
    }

    /*@PostMapping("/jogo/search")
    public List<Jogo> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return PropriedadeRespository.findByNome();
    }*/

    @PostMapping("/Propriedade")
    public Propriedade create(@RequestBody Map<String, String> body) {
        String designacao=body.get("designacao");
        //int subPropriedade_id = Integer.parseInt(body.get("subPropriedade_id"));
        return propriedadeRespository.save(new Propriedade(designacao));
    }

   /* @PostMapping("/Propriedade")
    public Propriedade create(@RequestBody Map<String, String> body){
        String designacao = body.get("designacao");
        int subPropriedade_id = Integer.parseInt(body.get("subPropriedade_id"));
        return PropriedadeRespository.save(new Propriedade(designacao,subPropriedade_id));
    }

*/

    @PutMapping("/Propriedade/{id}")
    public Propriedade update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int PropriedadeId=Integer.parseInt(id);
        // getting Propriedade
        Propriedade Propriedade=propriedadeRespository.findOne(PropriedadeId);
        Propriedade.setDesignacao(body.get("designacao"));
        //   Propriedade.setDesignacao(body.get("subPropriedade_id"));
        return propriedadeRespository.save(Propriedade);
    }

    @DeleteMapping("Propriedade/{id}")
    public boolean delete(@PathVariable String id) {
        int PropriedadeId=Integer.parseInt(id);
        propriedadeRespository.delete(PropriedadeId);
        return true;
    }
}
