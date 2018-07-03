package pt.domain;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private CategoriaPai categoriaPai;

    private String designacao;

  /*  @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Categoria subCategoria_id;
*/

    public Categoria(){}

    public Categoria(String designacao) {
        this.setDesignacao(designacao);
    }

    public Categoria(int id, CategoriaPai categoriaPai, String designacao) {
        this.id=id;
        this.categoriaPai=categoriaPai;
        this.designacao=designacao;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getDesignacao(){
        return designacao;
    }
    public void setDesignacao(String designacao){
        this.designacao=designacao;
    }

    public CategoriaPai getCategoriaPai() {
        return categoriaPai;
    }

    public void setCategoriaPai(CategoriaPai categoriaPai) {
        this.categoriaPai=categoriaPai;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", designacao=" + designacao + '\'' +
                //              ", subCategoria_id=" + subCategoria_id + '\'' +
                "}";

    }
}
