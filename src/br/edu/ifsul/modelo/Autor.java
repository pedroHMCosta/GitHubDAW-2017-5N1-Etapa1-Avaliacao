
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "autor") 
public class Autor implements Serializable{
    
   @ManyToMany
   @JoinTable(name = "autoresDeLivros",
   joinColumns = @JoinColumn(name="autor",referencedColumnName="id",nullable=false),
   inverseJoinColumns=@JoinColumn(name="livrobasico",referencedColumnName="isbn",nullable = false))  
   private List<LivroBasico>autoresDeLivros = new ArrayList<>();
    
@Id
@SequenceGenerator(name = "seq_autor",sequenceName = "seq_autor_id",
allocationSize = 1)
@GeneratedValue(generator = "seq_autor", strategy = GenerationType.SEQUENCE)    
private Integer Id;
 
   @Length(max = 50, message = "O nome não pode ter mais que{max}caracteres")
   @NotNull(message = "O nome não pode ser nulo")
   @NotBlank(message = "O nome não pode ser em branco")
   @Column(name = "nome", length = 50, nullable = false)
   private String nome;
   
      
   @Length(max = 50, message = "A bibliografia não pode ter mais que{max}caracteres")
   @NotNull(message = "A bibliografia não pode ser nula")
   @NotBlank(message = "A bibliografia não pode ser em branca")
   @Column(name = "bibliografia",  length = 50,columnDefinition = "text")
   private String bibliografia;

    public Autor() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.Id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
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

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }
    
     public List<LivroBasico> getAutoresDeLivros() {
        return autoresDeLivros;
    }

    public void setAutoreslivros(List<LivroBasico> autoresDeLivros) {
        this.autoresDeLivros =  autoresDeLivros;
    }

    
}
