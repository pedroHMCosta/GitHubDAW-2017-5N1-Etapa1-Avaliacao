
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.LivroBasico;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;


public class TestePersistenciaAutoresDeLivros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          EntityManagerFactory emf = 
                  Persistence.createEntityManagerFactory("DAW-2016-2-5n1-ModelPU-E1");
        EntityManager em = emf.createEntityManager();
        LivroBasico lb = em.find(LivroBasico.class, "0000000001");
        Autor au = em.find(Autor.class, 1);
            au.getAutoresDeLivros().add(lb);
            em.getTransaction().begin();
            em.persist(au);
            em.getTransaction().commit();
       
        
        em.getTransaction().begin();
        em.persist(lb);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
