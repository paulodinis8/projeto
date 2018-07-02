package pt.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import pt.domain.Categoria;
import pt.domain.Jogo;
import pt.repository.CategoriaRespository;
import pt.repository.JogoRespository;

import java.util.ArrayList;
import java.util.Collection;
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
		public Page<Jogo> findByPage(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("filter") List<Integer> filters) {
	
			if (filters != null && !filters.isEmpty()) {
				List<Jogo> allJogos = jogoRespository.findAll();
				List<Jogo> filteredJogos = filterCategoria(allJogos, filters);
				return new PageImpl<Jogo>(filteredJogos, new PageRequest(page, size), filteredJogos.size());
			}
			return jogoRespository.findAllPaginated(new PageRequest(page, size));
    }
	
	public List<Jogo> filterCategoria(List<Jogo> jogos, List<Integer> filters) {
		List<Jogo> jogosReturned = new ArrayList<>();
		for (Jogo j : jogos) {
			if (j.getCategoria() != null &&
							!j.getCategoria().isEmpty()) {
				List<Integer> categoriaID = getCategoriaIDList(j.getCategoria());
				
				if (categoriaID.containsAll(filters)) {
					jogosReturned.add(j);
				}
			}
		}
		
		System.out.println("filteredJogos: " + jogosReturned.size());
		return jogosReturned;
	}
	
	public List<Integer> getCategoriaIDList(Collection<Categoria> categorias) {
		List<Integer> categoriaIDList = new ArrayList<>(categorias.size());
		
		for (Categoria categoria : categorias) {
			categoriaIDList.add(categoria.getId());
		}
		return categoriaIDList;
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
