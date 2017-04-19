
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


public class TestePersistenciaLivroBasico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("DAW-2016-2-5n1-ModelPU-E1");
        EntityManager em = emf.createEntityManager();
        LivroBasico lb = new LivroBasico();
       
        lb.setIsbn("3332342422");
        lb.setTitulo("Silmarillion");
        lb.setResumo("Ficção");
        lb.setEditora("Editora HueBR");
        Calendar c = Calendar.getInstance();
	c.set(2016, Calendar.NOVEMBER, 05);	
        lb.setDataPublicacao(Calendar.getInstance());
        
        em.getTransaction().begin();
        em.persist(lb);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
