
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Monteiro
 */
@Entity
@Table(name = "livro")
public class Livro extends LivroBasico implements Serializable {

    public Livro() {
    }

    @Length(max = 12, message = "O codigo de barras não pode ter mais que{max}caracteres")
    @NotNull(message = "O codigo barras não pode ser nulo")
    @NotBlank(message = "O codigo barras não pode ser em branco")
    @Column(name = "codigoBarras", nullable = false, length = 12)
    private String codigoBarras;

    @NotNull(message = "O número de paginas não pode ser nulo")
    @Column(name = "numeroPaginas", nullable = false)
    private Integer numeroPaginas;

    @Column(name = "ativo", nullable = false, length = 1)
    private Boolean ativo;

    @NotNull(message = "A data não pode ser nula")    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datacadastro",nullable = false)
    private Calendar dataCadastro;
    
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", columnDefinition = "numeric(12,2)")
    private Double valor;
    
    @ManyToOne
    @JoinColumn(name = "catalogo", referencedColumnName = "id", nullable = false)
    private Catalogo catalogo; 
    
    @ManyToOne
    @JoinColumn(name = "formato", referencedColumnName = "id", nullable = false)
    private Formato formato;  
    
    @ManyToOne
    @JoinColumn(name = "idioma", referencedColumnName = "id", nullable = false)
    private Idioma idioma;
   
    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

   
}
