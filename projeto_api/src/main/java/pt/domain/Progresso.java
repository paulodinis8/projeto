package pt.domain;

import java.util.*;
import javax.persistence.*;

@Entity
public class Progresso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Jogo jogo;

    @ManyToOne
    private Utilizador utilizador;

    @Column
    private String favorito;

    //N utilizadores avaliao N progressos
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Utilizador> utilizadors = new HashSet<>();

    public Progresso(){}

    public Progresso(Jogo jogo, Utilizador utilizador, String favorito){
        this.setJogo(jogo);
        this.setUtilizador(utilizador);
        this.setFavorito(favorito);
    }

    public Progresso(int id, Jogo jogo, Utilizador utilizador, String favorito){
        this.setId(id);
        this.setJogo(jogo);
        this.setUtilizador(utilizador);
        this.setFavorito(favorito);
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public Jogo getJogo(){
        return jogo;
    }
    public void setJogo(Jogo jogo){
        this.jogo=jogo;
    }

    public Utilizador getUtilizador(){
        return utilizador;
    }
    public void setUtilizador(Utilizador utilizador){
        this.utilizador=utilizador;
    }

    public String getFavorito(){
        return favorito;
    }
    public void setFavorito(String favorito){
        this.favorito=favorito;
    }

    @Override
    public String toString() {
        return "Progresso{"+
                "id="+ id +
                ", Jogo=" + jogo+ '\'' +
                ", Utilizador=" + utilizador+ '\'' +
                ",Favorito=" + favorito+ '\'' +
                "}";
    }
}
