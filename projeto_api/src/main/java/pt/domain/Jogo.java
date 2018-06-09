package pt.domain;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.*;

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

    public Jogo(String nome, String link, String descricao){
        this.setNome(nome);
        this.setLink(link);
        this.setDescricao(descricao);
    }

    public Jogo(int id, String nome, String link, String descricao){
        this.setId(id);
        this.setNome(nome);
        this.setLink(link);
        this.setDescricao(descricao);
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