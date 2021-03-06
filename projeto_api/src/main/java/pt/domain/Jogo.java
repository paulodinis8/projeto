package pt.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String nome;
    @Size(min=1, max=100000, message="type need to have only 1 characters")
    private String link;
    private String descricao;
    @Size(min=1, max=100000, message="type need to have only 1 characters")
    private String foto;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade={
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name="jogo_categoria",
            joinColumns={@JoinColumn(name="jogo_id")},
            inverseJoinColumns={@JoinColumn(name="categoria_id")})
    private Set<Categoria> categorias=new HashSet<>();


    public Jogo() {
    }


    public Jogo(String nome, String link, String descricao, String foto, Set<Categoria> categorias) {
        this.setNome(nome);
        this.setLink(link);
        this.setDescricao(descricao);
        this.setFoto(foto);
        this.setCategoria(categorias);
    }

    public Jogo(int id, String nome, String link, String descricao, String foto, Set<Categoria> categorias) {
        this.setId(id);
        this.setNome(nome);
        this.setLink(link);
        this.setDescricao(descricao);
        this.setFoto(foto);
        this.setCategoria(categorias);
    }

    public Jogo(int id, String nome, String link, String descricao, String foto) {
        this.setId(id);
        this.setNome(nome);
        this.setLink(link);
        this.setDescricao(descricao);
        this.setFoto(foto);
    }


    public Jogo(String nome, String link, String descricao, String foto) {
        this.setNome(nome);
        this.setLink(link);
        this.setDescricao(descricao);
        this.setFoto(foto);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome=nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link=link;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao=descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto=foto;
    }

    public Set<Categoria> getCategoria() {
        return categorias;
    }

    private void setCategoria(Set<Categoria> categorias) {
        this.categorias=categorias;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome =" + nome + '\'' +
                ", link=" + link + '\'' +
                ", descricao=" + descricao + '\'' +
                "}";

    }

}