package pt.domain;

import javax.persistence.*;

@Entity
public class AvaliacaoJogo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Jogo jogo;

    @ManyToOne
    private Utilizador utilizador;

    @Column
    private int estrelas;

    @Column
    private String comentario;

    public AvaliacaoJogo() {
    }

    public AvaliacaoJogo(int estrelas, String comentario) {
        this.setEstrelas(estrelas);
        this.setComentario(comentario);
    }

    public AvaliacaoJogo(Utilizador utilizador, Jogo jogo, int estrelas, String comentario) {
        this.utilizador=utilizador;
        this.jogo=jogo;
        this.setEstrelas(estrelas);
        this.setComentario(comentario);
    }

    public AvaliacaoJogo(int id, Utilizador utilizador, Jogo jogo, int estrelas, String comentario) {
        this.setId(id);
        this.utilizador=utilizador;
        this.jogo=jogo;
        this.setEstrelas(estrelas);
        this.setComentario(comentario);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador=utilizador;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo=jogo;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(int estrelas) {
        this.estrelas=estrelas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario=comentario;
    }

    @Override
    public String toString() {
        return "AvaliacaoJogo{" +
                "id=" + id +
                ", utilizador=" + utilizador + '\'' +
                ", jogo=" + jogo + '\'' +
                ", estrelas=" + estrelas + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}