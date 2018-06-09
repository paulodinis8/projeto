package pt.domain;

import javax.persistence.*;

@Entity
public class Trofeu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String descricao;

    private int valor;

    @ManyToOne
    private Pontos pontos;

    @ManyToOne
    private Registo registo;

    public Trofeu() {
    }

    public Trofeu(int id, String descricao, int valor, Pontos pontos, Registo registo) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.pontos = pontos;
        this.registo = registo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Pontos getPontos() {
        return pontos;
    }

    public void setPontos(Pontos pontos) {
        this.pontos = pontos;
    }

    public Registo getRegisto() {
        return registo;
    }

    public void setRegisto(Registo registo) {
        this.registo = registo;
    }

    @Override
    public String toString() {
        return "Trofeu{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", pontos=" + pontos +
                ", registo=" + registo +
                '}';
    }
}
