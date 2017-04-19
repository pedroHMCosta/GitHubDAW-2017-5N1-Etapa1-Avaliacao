

package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class TestePersisirAutor {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersisirAutor() {
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
    public void TestePersistirAutor(){
        boolean exception = false; // variavel que vai armazenar o resultado do teste
        try {
            Autor au = new Autor();
            au.setNome("Pablo Neruda");
            au.setBibliografia("Bibliografia fictícia");
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