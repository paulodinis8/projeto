package pt.domain;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String designacao;

  /*  @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Categoria subCategoria_id;
*/

    public Categoria(){}

    public Categoria(String designacao) {
        this.setDesignacao(designacao);
    }

    /*  public Categoria(String designacao, Categoria subCategoria_id){
          this.setDesignacao(designacao);
          this.setSubCategoria_id(subCategoria_id);
      }

      public Categoria(int id, String designacao, Categoria subCategoria_id){
          this.setId(id);
          this.setDesignacao(designacao);
          this.setSubCategoria_id(subCategoria_id);
      }
  */
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

    /*    public Categoria getSubCategoria_id(){
            return subCategoria_id;
        }
        public void setSubCategoria_id(Categoria subCategoria_id){
            this.subCategoria_id=subCategoria_id;
        }
    */
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", designacao=" + designacao + '\'' +
                //              ", subCategoria_id=" + subCategoria_id + '\'' +
                "}";

    }
}
