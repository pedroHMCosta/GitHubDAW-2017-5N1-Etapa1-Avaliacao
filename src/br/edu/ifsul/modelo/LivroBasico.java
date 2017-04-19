 
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "livrobasico") 
@Inheritance(strategy = InheritanceType.JOINED)
public class LivroBasico implements Serializable{

    @ManyToMany
    private List<Autor>livrosdeAutores = new ArrayList<>();
    
@Id
@Length(max = 10, message = "O ISBN não pode ter mais que{max}caracteres")
@NotNull(message = "O ISBN não pode ser nulo")
@NotBlank(message = "O ISBN não pode ser em branco")
@Column(name = "isbn", length = 10, nullable = false)
private String isbn;
 
   @Length(max = 50, message = "O titulo não pode ter mais que{max}caracteres")
   @NotNull(message = "O titulo não pode ser nulo")
   @NotBlank(message = "O titulo não pode ser em branco")
   @Column(name = "titulo", length = 50, nullable = false)
   private String titulo;
  
   @Length(max = 50, message = "O resumo não pode ter mais que{max}caracteres")
   @NotNull(message = "O resumo não pode ser nula")
   @NotBlank(message = "O resumo não pode ser em branca")
   @Column(name = "resumo", length = 50, nullable = false)
   private String resumo;

   @Length(max = 50, message = "A editora não pode ter mais que{max}caracteres")
   @NotNull(message = "A editora não pode ser nula")
   @NotBlank(message = "A editora não pode ser em branco")
   @Column(name = "editora", length = 50, nullable = false)
   private String editora;
     
    @NotNull(message = "A data de publicação não pode ser nula")    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataPublicacao",nullable = false)
    private Calendar dataPublicacao;
   
    public LivroBasico() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.getIsbn());
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
        final LivroBasico other = (LivroBasico) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }


    
}
