
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "idioma")
public class Idioma implements Serializable{    
          
@Id
@SequenceGenerator(name = "seq_idioma",sequenceName = "seq_idioma_id",
allocationSize = 1)
@GeneratedValue(generator = "seq_idioma", strategy = GenerationType.SEQUENCE)    
private Integer Id;
    
   @Length(max = 50, message = "O nome não pode ter mais que{max}caracteres")
   @NotNull(message = "O nome não pode ser nulo")
   @NotBlank(message = "O nome não pode ser em branco")
   @Column(name = "nome", length = 50, nullable = false)
    private String nome;
        
   @Length(max = 20, message = "A sigla não pode ter mais que{max}caracteres")
   @NotNull(message = "A sigla não pode ser nula")
   @NotBlank(message = "A sigla não pode ser em branca")
   @Column(name = "sigla", length = 20, nullable = false)
    private String sigla;

    public Idioma() {
    }

    public Integer getId() {
        return Id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.Id);
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
        final Idioma other = (Idioma) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    
    
}
