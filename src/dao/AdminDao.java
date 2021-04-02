package dao;




import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import entities.Administrateur;

        @Stateless
		public class AdminDao {
			
		    
		    @PersistenceContext( unitName="gestion_participant_pu" )
			private  EntityManager		em;

			
		      	        
		          
				       public Administrateur trouver( String nomadmin ) throws DaoException {
				    	   
		                    Administrateur administrateur = null;
		                    
		                    TypedQuery<Administrateur> query =  em.createQuery("SELECT a FROM Administrateur a WHERE a.nomadmin=:nomadmin ", Administrateur.class);
				            
		                    query.setParameter("nomadmin",nomadmin);
				
		                    try {
		                        administrateur = (Administrateur) query.getSingleResult();
		                    } catch ( NoResultException e ) {
		                       System.out.println("No users"+e);
		                    } catch ( Exception e ) {
		                    	  System.out.println("No Exception"+e);
		                    }
		                    return administrateur;
		                }
		              }
                       
		    
		    
		    
		    
		    
        