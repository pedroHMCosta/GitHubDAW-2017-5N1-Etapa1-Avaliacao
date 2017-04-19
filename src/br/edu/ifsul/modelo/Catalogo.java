/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Monteiro
 */
@Entity
@Table(name = "catalogo")
public class Catalogo implements Serializable{

    @Id
    @SequenceGenerator(name = "seq_catalogo",sequenceName = "seq_catalogo_id",
    allocationSize = 1)
    @GeneratedValue(generator = "seq_catalogo", strategy = GenerationType.SEQUENCE)
    private Integer Id;
    
    @Length(max = 50, message = "O nome não pode ter mais que{max}caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")  
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Length(max = 50, message = "A descrição não pode ter mais que{max}caracteres")
    @NotNull(message = "A descrição não pode ser nulo")
    @NotBlank(message = "A descrição não pode ser em branco")  
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    
    @NotNull(message = "A livraria não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "livraria", referencedColumnName = "id", nullable = false)
    private Livraria livraria;     
   
    @OneToMany(mappedBy ="catalogo", cascade= CascadeType.ALL,
    orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Livro> ListaDeLivros = new ArrayList<>(); 
//       
//    public void adicionarCatalogo(Livro obj){
//    obj.setCatalogo(this);
//    this.ListaDeLivros.add(obj);
//    }
//    public void removeLivros(int index){
//        this.ListaDeLivros.remove(index);
//    }
      
    public Catalogo() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.Id);
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
        final Catalogo other = (Catalogo) obj;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
//     public List<Livro> getListaDeLivros() {
//        return ListaDeLivros;
//    }
//
//    public void setListaDeLivros(List<Livro> ListaDeLivros) {
//        this.ListaDeLivros = ListaDeLivros;
//    }

    public Livraria getLivraria() {
        return livraria;
    }

    public void setLivraria(Livraria livraria) {
        this.livraria = livraria;
    }
 
}
