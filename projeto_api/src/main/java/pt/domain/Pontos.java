package pt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pontos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int pontos;

    private String tipo;

    public Pontos() {
    }

    public Pontos(int id, int pontos, String tipo) {
        this.id = id;
        this.pontos = pontos;
        this.tipo = tipo;
    }

    public Pontos(int pontos, String tipo) {
        this.pontos = pontos;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pontos{" +
                "id=" + id +
                ", pontos=" + pontos +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
