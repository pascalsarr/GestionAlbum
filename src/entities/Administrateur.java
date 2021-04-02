package entities;
	


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Administrateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	

	@Column(name = "nomadmin")
	private String	nomadmin;
	@Column(name = "password")
	private String	password;
	
	public Administrateur()
	 {
	
	 }

	public Administrateur(String nomadmin,String password)
	{
	
		this.nomadmin =  nomadmin;
		this.password =  password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomadmin() {
		return nomadmin;
	}

	public void setNomadmin(String nomadmin) {
		this.nomadmin = nomadmin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
