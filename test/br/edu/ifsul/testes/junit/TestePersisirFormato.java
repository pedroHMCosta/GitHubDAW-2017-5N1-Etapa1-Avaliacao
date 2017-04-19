

package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Formato;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersisirFormato {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersisirFormato() {
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
    public void TestePersistirFormato(){
        boolean exception = false; // variavel que vai armazenar o resultado do teste
         try {
            Formato fo = new Formato();
            fo.setNome("A4");
                   
            em.getTransaction().begin();
            em.persist(fo);
            em.getTransaction().commit();
        
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        // comparo o resultado esperado(falso) com o que ocorreu
        Assert.assertEquals(false, exception);
        
    }
    
}