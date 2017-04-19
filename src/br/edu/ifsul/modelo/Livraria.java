package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Monteiro
 */
@Entity
@Table(name = "livraria")
public class Livraria implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_livraria",sequenceName = "seq_livraria_id",
    allocationSize = 1)
    @GeneratedValue(generator = "seq_livraria", strategy = GenerationType.SEQUENCE)
    private Integer Id;
    
    @Length(max = 50, message = "O nome não pode ter mais que{max}caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco") 
    private String nome;
    
    @Length(max = 50, message = "O nome do site não pode ter mais que{max}caracteres")
    @NotNull(message = "Este campo não pode ser nulo")
    @NotBlank(message = "Este campo não pode ser em branco") 
    private String site;

    @OneToMany(mappedBy ="livraria", cascade= CascadeType.ALL, 
    orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Catalogo> catalogos = new ArrayList<>();
      
  public void adicionarCatalogo(Catalogo obj){
    obj.setLivraria(this);
    this.getCatalogo().add(obj);
    }
    public void removeCatalogo(int index){
        this.getCatalogo().remove(index);
    }

    public List<Catalogo> getCatalogo() {
        return catalogos;
    }

    public void setCatalogo(List<Catalogo> catalogo) {
        this.catalogos = catalogo;
    }
    
    public Livraria() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.Id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livraria other = (Livraria) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
    
}
