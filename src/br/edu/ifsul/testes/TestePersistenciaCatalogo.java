/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.testes;

//import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Livraria;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;


/**
 *
 * @author Monteiro
 */
public class TestePersistenciaCatalogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("DAW-2016-2-5n1-ModelPU-E1");
        EntityManager em = emf.createEntityManager();
        Catalogo cat = new Catalogo();
        cat.setNome("Ciencias da Computação");
        cat.setDescricao("Catalogo de diversos livros");
        cat.setLivraria(em.find(Livraria.class, 1));
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}