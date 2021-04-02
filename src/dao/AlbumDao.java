package dao;





import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import entities.Album;
import entities.Utilisateur;


@Stateless
public class AlbumDao {
	private static final String	SELECT_ALL_ALBUM	= "SELECT a FROM Album a";
	@PersistenceContext
	private EntityManager		em;

	
	public void ajouter(Album album)
	{
		em.persist(album);
	}
	
	public List<Album> lister()
	{
		return em.createQuery(SELECT_ALL_ALBUM, Album.class)
				.getResultList();
	}
	public  void supprimer(Integer id)
         {
		  Album album = em.find(Album.class,id);
		  em.remove(em.merge(album));
      
          } 
	public Album modifier(Album album) throws DaoException
    {
	   try {
	
     em.merge(album);
     em.flush();
     return album;
	   }catch( Exception e) {
		   System.out.println();
		   return null;
	   }
    }
	
	public  Album	getAlbumByid(Integer id ) 
        { 	
  	    return  em.find(Album.class,id);
         }	
}
	