package main.java;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ArticleTests {

	static EntityManager em = null;
	
    public static void main(String[] args) throws IOException {

    	int id;
        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2-eclipselink");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            
            UserDetails ud = new UserDetails();
            ud.setName("name pb");
            ud.setPassword("password");
            
            //em.persist(ud);
            
            Article art = new Article("Nazwa 1", "Tresc 1", 100);
            art.setUser(ud);
            
            createArticle(art);
            
//            System.out.println("Wyciagnieto: " + getArticle(art.getId()).toString());
//            id = art.getId();
            
//            em.close();
//            em = emf.createEntityManager();
//            em.getTransaction().begin();
//            
//            removeArticle(id);
            
            System.out.println("Article: " + ud.getArticles());
            
            
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
    
    public static Article createArticle(Article art) {
    	
    	em.persist(art);
    	em.getTransaction().commit();
    	
    	return art;
    }
    
    public static Article getArticle(int articleID) {
    	return em.find(Article.class, articleID);
    }

    public static void removeArticle(int articleID) {
    	Article art = getArticle(articleID);
    	em.remove(art);
    	em.getTransaction().commit();
    }
}