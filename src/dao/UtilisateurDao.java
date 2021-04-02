package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Administrateur;
import entities.Utilisateur;

@Stateless
public class UtilisateurDao {
	private static final String	SELECT_ALL_USER	= "SELECT u FROM Utilisateur u";

	@PersistenceContext
	private EntityManager		em;

	public void ajouter(Utilisateur utilisateur)
	{
		em.persist(utilisateur);
	}
	
	public Utilisateur modifier(Utilisateur user) throws DaoException
         {
		   try {
		
          em.merge(user);
          em.flush();
          return user;
		   }catch( Exception e) {
			   System.out.println();
			   return null;
		   }
         }
	public List<Utilisateur> lister()
	{
		return em.createQuery(SELECT_ALL_USER, Utilisateur.class)
				.getResultList();
	}
	
	public  void supprimer(Integer id)
    {
		  Utilisateur utilisateur = em.find(Utilisateur.class,id);
		  em.remove(em.merge(utilisateur));
           

          } 

	public  Utilisateur getUserByLogin(Integer id ) 
 	      { 	
	    	return  em.find(Utilisateur.class,id);
	      }	

    public Utilisateur TrouverUser( String login ) throws DaoException {
 	   
         Utilisateur utilisateur = null;
         
         TypedQuery<Utilisateur> query =  em.createQuery("SELECT u FROM Utilisateur u WHERE u.login=:login ", Utilisateur.class);
         
         query.setParameter("login",login);

         try {
             utilisateur = (Utilisateur) query.getSingleResult();
         } catch ( NoResultException e ) {
            System.out.println("No users"+e);
         } catch ( Exception e ) {
         	  System.out.println("No Exception"+e);
         }
         return utilisateur;
     }
}
