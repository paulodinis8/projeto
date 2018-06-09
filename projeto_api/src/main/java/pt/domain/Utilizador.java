package pt.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String localidade;
    private String email;
    private int idade;
    private String password;
    private String genero;
    private int totalPontos;


    //Amigos N utilizadores tem N utilizadores
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "amigo",
            joinColumns = { @JoinColumn(name = "utilizador1_id") },
            inverseJoinColumns = { @JoinColumn(name = "utilizador2_id") })
    private Set<Utilizador> utilizadores = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Utilizador> utilizadors = new HashSet<>();

    //N utilizadores tem N grupos
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Grupo> grupos = new HashSet<>();

    //N utilizadores vao avaliar N progressos
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "avaliacaoprogresso",
            joinColumns = { @JoinColumn(name = "utilizador_id") },
            inverseJoinColumns = { @JoinColumn(name = "progresso_id") })
    private Set<Progresso> progressos = new HashSet<>();


    public Utilizador(){}

    public Utilizador(String nome, String localidade, String email, int idade, String password, String genero, int totalPontos){
        this.setNome(nome);
        this.setLocalidade(localidade);
        this.setEmail(email);
        this.setIdade(idade);
        this.setPassword(password);
        this.setGenero(genero);
        this.setTotalPontos(totalPontos);
    }

    public Utilizador(int id, String nome, String localidade, String email, int idade, String password, String genero, int totalPontos){
        this.setId(id);
        this.setNome(nome);
        this.setLocalidade(localidade);
        this.setEmail(email);
        this.setIdade(idade);
        this.setPassword(password);
        this.setGenero(genero);
        this.setTotalPontos(totalPontos);
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }

    public String getLocalidade(){
        return localidade;
    }
    public void setLocalidade(String localidade){
        this.localidade=localidade;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade=idade;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero=genero;
    }

    public int getTotalPontos(){
        return totalPontos;
    }
    public void setTotalPontos(int totalPontos){
        this.totalPontos=totalPontos;
    }

    @Override
    public String toString() {
        return "Utilizador{"+
                "id="+ id +
                ", nome =" + nome + '\'' +
                ", localidade=" + localidade + '\'' +
                ", email=" + email + '\'' +
                ", idade=" + idade + '\'' +
                ", password=" + password + '\'' +
                ", genero=" + genero + '\'' +
                ",totalPontos=" + totalPontos + '\'' +
                "}";
    }
}