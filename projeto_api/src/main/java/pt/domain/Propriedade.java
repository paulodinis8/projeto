package pt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Propriedade {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String designacao;

    public Propriedade(String designacao) {
    }

    public Propriedade(int id, String designacao) {
        this.id=id;
        this.designacao=designacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao=designacao;
    }

    @Override
    public String toString() {
        return "Propriedade{" +
                "id=" + id +
                ", designacao='" + designacao + '\'' +
                '}';
    }
}
