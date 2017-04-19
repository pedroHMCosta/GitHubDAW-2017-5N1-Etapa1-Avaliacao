
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livro;
import br.edu.ifsul.modelo.LivroBasico;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;


public class TestePersistenciaLivro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        
        EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("DAW-2016-2-5n1-ModelPU-E1");
        EntityManager em = emf.createEntityManager();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/KK/dd");
        Livro livro = new Livro();
        livro.setIsbn("0000000008");
        livro.setTitulo("Olavo - Como não ser um idiota");
        livro.setResumo("Um passo a passo do Olavo");
        livro.setEditora("Editora Brasil");
        livro.setDataPublicacao(Calendar.getInstance());      
        livro.setCodigoBarras("00000000055");
        livro.setNumeroPaginas(500);
        livro.setAtivo(Boolean.TRUE);
       	livro.setDataCadastro(Calendar.getInstance()); 
        livro.setValor(134.77);
        Catalogo cat = em.find(Catalogo.class,1);
        Formato form = em.find(Formato.class, 1);
        Idioma idio = em.find(Idioma.class, 1);
        livro.setCatalogo(cat);
        livro.setFormato(form);
        livro.setIdioma(idio);
        em.getTransaction().begin();
        em.persist(livro);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
