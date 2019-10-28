package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Nom;
	private String Prenom;
	private String Role;
	private String Login;
	private String Mdp;
	@OneToMany(mappedBy="User",cascade=CascadeType.REMOVE)
	private List<Tache> taches;
	
	@ManyToOne
	private GroupUser groupuser;
	
	
	
	
	
	
	public GroupUser getGroupuser() {
		return groupuser;
	}
	public void setGroupuser(GroupUser groupuser) {
		this.groupuser = groupuser;
	}
	public User(String nom, String prenom, String role, String login, String mdp, List<Tache> taches,
			GroupUser groupuser) {
		super();
		Nom = nom;
		Prenom = prenom;
		Role = role;
		Login = login;
		Mdp = mdp;
		this.taches = taches;
		this.groupuser = groupuser;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Tache> getTaches() {
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	private static final long serialVersionUID = 1L;
	
	

	public User(String login, String mdp) {
		super();
		Login = login;
		Mdp = mdp;
	}
	public User(String nom, String prenom, String role, String login, String mdp) {
		super();
		Nom = nom;
		Prenom = prenom;
		Role = role;
		Login = login;
		Mdp = mdp;
	}
	public User() {
		super();
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public String getNom() {
		return this.Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}   
	public String getPrenom() {
		return this.Prenom;
	}

	public void setPrenom(String Prenom) {
		this.Prenom = Prenom;
	}   
	public String getRole() {
		return this.Role;
	}

	public void setRole(String Role) {
		this.Role = Role;
	}   
	public String getLogin() {
		return this.Login;
	}

	public void setLogin(String Login) {
		this.Login = Login;
	}   
	public String getMdp() {
		return this.Mdp;
	}

	public void setMdp(String Mdp) {
		this.Mdp = Mdp;
	}
   
}
