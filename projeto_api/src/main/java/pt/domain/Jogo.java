package pt.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String link;
    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "jogo_categoria",
            joinColumns = { @JoinColumn(name = "jogo_id") },
            inverseJoinColumns = { @JoinColumn(name = "categoria_id") })
    private Set<Categoria> categorias = new HashSet<>();


    public Jogo(){}

    public Jogo(String nome, String link, String descricao, Set<Categoria> categorias){
        this.setNome(nome);
        this.setLink(link);
        this.setDescricao(descricao);
        this.setCategoria(categorias);
    }

    public Jogo(int id, String nome, String link, String descricao, Set<Categoria> categorias){
        this.setId(id);
        this.setNome(nome);
        this.setLink(link);
        this.setDescricao(descricao);
        this.setCategoria(categorias);
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }

    public String getLink(){
        return link;
    }
    public void setLink(String link){
        this.link=link;
    }

    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao=descricao;
    }

    public Set<Categoria> getCategoria() {return categorias; }
    private void setCategoria(Set<Categoria> categorias) { this.categorias=categorias; }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome =" + nome + '\'' +
                ", localidade=" + link + '\'' +
                ", email=" + descricao + '\'' +
                "}";

    }

}