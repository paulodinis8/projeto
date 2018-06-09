package pt.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class AvaliacaoJogo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Utilizador utilizador;

    @ManyToOne
    private Jogo jogo ;

    @Column
    private int estrelas;

    @Column
    private String comentario;

    public  AvaliacaoJogo(){
    };

    public AvaliacaoJogo(Utilizador utilizador, Jogo jogo, int estrelas, String favorito){
        this.utilizador = utilizador;
        this.jogo = jogo;
        this.setEstrelas(estrelas);
        this.setComentario(comentario);
    }

    public AvaliacaoJogo(int id, Utilizador utilizador, Jogo jogo, int estrelas, String favorito){
        this.setId(id);
        this.utilizador=utilizador;
        this.jogo = jogo;
        this.setEstrelas(estrelas);
        this.setComentario(comentario);
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public void setEstrelas(int estrelas) {
        this.estrelas = estrelas;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public String getComentario() {
        return comentario;
    }

    @Override
    public String toString() {
        return "AvaliacaoJogo{" +
                "id=" + id +
                ", utilizador=" + utilizador +'\'' +
                ", jogo=" + jogo +'\'' +
                ", estrelas=" + estrelas +'\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
