package entities;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;

	@Column(name= "titre")
	private String titre;
	@Column(name= "path")
	private String path;
	@Column(name= "description")
	private String description;
	@Temporal(TemporalType.DATE)
	@Column(name = "datecreation")
	private Date	datecreation;
	
	
	
	public Album()
	{
		
	}

	public Album(String titre, String description,Date datecreation,String path)
	{
		this.titre = titre;
		this.description = description;
		this.datecreation = new Date(System.currentTimeMillis());
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	
	
	

}