package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: GroupUser
 *
 */
@Entity

public class GroupUser implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Nom;
	@OneToMany (mappedBy="groupuser",cascade=CascadeType.REMOVE)
	private List<User> user;
	@OneToMany (mappedBy="groupproject",cascade=CascadeType.REMOVE)
	private List<Project> project;
	
	
	
	
	
	
	

	
	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public GroupUser(String nom, List<User> user) {
		super();
		Nom = nom;
		this.user = user;
	}

	public GroupUser(String nom) {
		super();
		Nom = nom;
	}

	public GroupUser(int id, String nom, List<User> user) {
		super();
		Id = id;
		Nom = nom;
		this.user = user;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	public GroupUser() {
		super();
	}
   
}
