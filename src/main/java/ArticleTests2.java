package main.java;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class ArticleTests2 {

	static EntityManager em = null;
	
    public static void main(String[] args) throws IOException {

    	int id;
        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2-eclipselink");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            
            
//            Query query = em.createQuery("SELECT a FROM Article a JOIN FETCH UserDetails u ON u.userId = a.user.userId");
//            
//          @SuppressWarnings("unchecked")
//			List<Article> userDetailsList = query.getResultList();
            
            TypedQuery<UserDetails> query = em.createNamedQuery("UserDetails.findAll", UserDetails.class);
			List<UserDetails> userDetailsList = query.getResultList();
            
            System.out.println("---------------------------------------------");
            for (int i = 0; i < userDetailsList.size(); i++) {
            	System.out.println("User: " + userDetailsList.get(i).toString());
			}
            
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}