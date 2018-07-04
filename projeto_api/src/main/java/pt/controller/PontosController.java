package pt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.domain.Pontos;
import pt.repository.PontosRespository;

import java.util.List;
import java.util.Map;

@RestController
public class PontosController {

    @Autowired
    PontosRespository pontosRespository;

    @CrossOrigin
    @GetMapping("/pontos")
    public List<Pontos> index() {
        return pontosRespository.findAll();
    }

    @CrossOrigin
    @GetMapping("/pontos/{id}")
    public Pontos show(@PathVariable String id) {
        int pontosId=Integer.parseInt(id);
        return pontosRespository.findOne(pontosId);
    }

 /*   @CrossOrigin
    @PostMapping("/trofeu")
    public Registo create(@RequestBody Map<String, String> body) {
        //Date data = (body.get("data"));
        int tempo = Integer.parseInt(body.get("tempo"));
        return registoRespository.save(new Registo(tempo));
    }
*/

    @PutMapping("/pontos/{id}")
    public Pontos update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int pontosId=Integer.parseInt(id);
        // getting registo
        Pontos pontos=pontosRespository.findOne(pontosId);
        //  registo.setData(format.parse(body.get("data")));
        pontos.setPontos(Integer.parseInt(body.get("pontos")));
        pontos.setTipo(body.get("tipo"));
        //   registo.setDesignacao(body.get("subregisto_id"));
        return pontosRespository.save(pontos);
    }

    @DeleteMapping("pontos/{id}")
    public boolean delete(@PathVariable String id) {
        int pontosId=Integer.parseInt(id);
        pontosRespository.delete(pontosId);
        return true;
    }
}
