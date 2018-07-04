package pt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.domain.Trofeu;
import pt.repository.TrofeuRespository;

import java.util.List;
import java.util.Map;

@RestController
public class TrofeuController {

    @Autowired
    TrofeuRespository trofeuRespository;

    @CrossOrigin
    @GetMapping("/trofeu")
    public List<Trofeu> index() {
        return trofeuRespository.findAll();
    }

    @CrossOrigin
    @GetMapping("/trofeu/{id}")
    public Trofeu show(@PathVariable int trofeuId) {
        return trofeuRespository.findOne(trofeuId);
    }

    @CrossOrigin
    @GetMapping("/trofeu/utilizador/{userId}")
    public List<Trofeu> showTrofeuByUser(@PathVariable int userId) {
        return trofeuRespository.findTrofeuByUser(userId);
    }

 /*   @CrossOrigin
    @PostMapping("/trofeu")
    public Registo create(@RequestBody Map<String, String> body) {
        //Date data = (body.get("data"));
        int tempo = Integer.parseInt(body.get("tempo"));
        return registoRespository.save(new Registo(tempo));
    }
*/

    @PutMapping("/trofeu/{id}")
    public Trofeu update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int trofeuId=Integer.parseInt(id);
        // getting registo
        Trofeu trofeu=trofeuRespository.findOne(trofeuId);
        //  registo.setData(format.parse(body.get("data")));
        trofeu.setDescricao(body.get("descricao"));
        trofeu.setValor(Integer.parseInt(body.get("valor")));
        //   registo.setDesignacao(body.get("subregisto_id"));
        return trofeuRespository.save(trofeu);
    }

    @DeleteMapping("trofeu/{id}")
    public boolean delete(@PathVariable String id) {
        int trofeuId=Integer.parseInt(id);
        trofeuRespository.delete(trofeuId);
        return true;
    }
}
