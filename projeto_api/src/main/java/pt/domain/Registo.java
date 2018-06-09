package pt.domain;

import javax.persistence.*;

import java.util.*;

@Entity
public class Registo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date data;

    private int tempo;

    @ManyToOne
    private Progresso progresso;

    public Registo() {
    }

    public Registo(int id, Date data, int tempo, Progresso progresso) {
        this.id = id;
        this.data = data;
        this.tempo = tempo;
        this.progresso = progresso;
    }

    public Registo(Date data, int tempo, Progresso progresso) {
        this.data = data;
        this.tempo = tempo;
        this.progresso = progresso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public Progresso getProgresso() {
        return progresso;
    }

    public void setProgresso(Progresso progresso) {
        this.progresso = progresso;
    }

    @Override
    public String toString() {
        return "Registo{" +
                "id=" + id +
                ", data=" + data +
                ", tempo=" + tempo +
                ", progresso=" + progresso +
                '}';
    }
}
