package pt.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private boolean favorito;

    //N utilizadores avaliao N progressos
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Utilizador> utilizadors = new HashSet<>();

    public Progresso(){}

    public Progresso(Boolean favorito) {
        this.favorito=favorito;
    }

    public Progresso(Jogo jogo, Utilizador utilizador, boolean favorito) {
        this.setJogo(jogo);
        this.setUtilizador(utilizador);
        this.setFavorito(favorito);
    }

    public Progresso(int id, Jogo jogo, Utilizador utilizador, boolean favorito) {
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

    public boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
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
