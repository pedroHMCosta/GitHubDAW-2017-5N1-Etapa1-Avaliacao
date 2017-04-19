/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Livraria;
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
public class TestePersistenciaLivraria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("DAW-2016-2-5n1-ModelPU-E1");
        EntityManager em = emf.createEntityManager();
        Livraria li  = new Livraria();   
        li.setNome("Livraria Saraiva");
        li.setSite("www.livrariasaraiva.com.br");
        em.getTransaction().begin();
        em.persist(li);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
