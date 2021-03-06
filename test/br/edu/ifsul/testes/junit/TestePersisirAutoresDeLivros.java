package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.LivroBasico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersisirAutoresDeLivros {
     
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersisirAutoresDeLivros() {
    }    
    @Before
    public void setUp() {        
         emf = Persistence.createEntityManagerFactory("DAW-2016-2-5n1-ModelPU-E1");
         em = emf.createEntityManager();
    }    
    @After
    public void tearDown() {
        em.close();        
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false; 
        try {
         
          LivroBasico lb = em.find(LivroBasico.class, "0000000002");
        Autor au = em.find(Autor.class, 2);
            au.getAutoresDeLivros().add(lb);
           em.getTransaction().begin();
            em.persist(au);
            em.getTransaction().commit();
        
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        // comparo o resultado esperado(falso) com o que ocorreu
        Assert.assertEquals(false, exception);
        
    }
    
}