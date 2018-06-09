package pt.domain;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private byte[] fotos;

    @ManyToOne
    private Jogo jogo;

    public Imagem() {
    }

    public Imagem(int id, byte[] fotos, Jogo jogo) {
        this.id = id;
        this.fotos = fotos;
        this.jogo = jogo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getFotos() {
        return fotos;
    }

    public void setFotos(byte[] fotos) {
        this.fotos = fotos;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Imagem(byte[] fotos, Jogo jogo) {
        this.fotos = fotos;
        this.jogo = jogo;
    }

    @Override
    public String toString() {
        return "Imagem{" +
                "id=" + id +
                ", fotos=" + Arrays.toString(fotos) +
                ", jogo=" + jogo +
                '}';
    }
}
