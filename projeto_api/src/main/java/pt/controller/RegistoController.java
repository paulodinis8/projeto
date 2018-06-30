package pt.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistoController {
/*
   @Autowired
    RegistoRespository registoRespository;

    @CrossOrigin
    @GetMapping("/registo")
    public List<Registo> index(){
        return registoRespository.findAll();
    }

    @CrossOrigin
    @GetMapping("/registo/{id}")
    public Registo show(@PathVariable String id){
        int registoId = Integer.parseInt(id);
        return registoRespository.findOne(registoId);
    }

    @PostMapping("/registo")
    public Registo create(@RequestBody Map<String, String> body) {
       // Date data = format.parse(body.get("data"));
        int tempo = Integer.parseInt(body.get("tempo"));
        return registoRespository.save(new Registo(/*data, tempo));
    }

   /* @PostMapping("/registo")
    public registo create(@RequestBody Map<String, String> body){
        String designacao = body.get("designacao");
        int subregisto_id = Integer.parseInt(body.get("subregisto_id"));
        return registoRespository.save(new registo(designacao,subregisto_id));
    }


    @PutMapping("/registo/{id}")
    public Registo update(@PathVariable String id, @RequestBody Map<String, String> body){
        int registoId = Integer.parseInt(id);
        // getting registo
        Registo registo = registoRespository.findOne(registoId);
      //  registo.setData(format.parse(body.get("data")));
        registo.setTempo(Integer.parseInt(body.get("tempo")));
        //   registo.setDesignacao(body.get("subregisto_id"));
        return registoRespository.save(registo);
    }

    @DeleteMapping("registo/{id}")
    public boolean delete(@PathVariable String id){
        int registoId = Integer.parseInt(id);
        registoRespository.delete(registoId);
        return true;
    }

*/
}