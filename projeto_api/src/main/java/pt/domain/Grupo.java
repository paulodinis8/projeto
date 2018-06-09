package pt.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String Nome;

    @ManyToOne
    Utilizador admin;

    //N utilizadores tem N grupos
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "grupo_utilizador",
            joinColumns = { @JoinColumn(name = "grupo_id") },
            inverseJoinColumns = { @JoinColumn(name = "utilizador_id") })
    private Set<Utilizador> utilizadores = new HashSet<>();

    public Grupo() {
    }

    public Grupo(int id, String nome, Utilizador admin) {
        this.id = id;
        Nome = nome;
        this.admin = admin;
    }

    public Grupo(String nome, Utilizador admin) {
        Nome = nome;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Utilizador getAdmin() {
        return admin;
    }

    public void setAdmin(Utilizador admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                ", admin=" + admin +
                '}';
    }
}
