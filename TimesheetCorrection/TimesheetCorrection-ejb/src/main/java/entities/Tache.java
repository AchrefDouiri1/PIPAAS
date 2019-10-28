package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tache
 *
 */
@Entity

public class Tache implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Nom;
	private Date DateDeb;
	private Date DateFin;
	private Date Date_fin_real;
	private String Etat;
	@ManyToOne
	private Project project;
	@ManyToOne
	private User User;
	
	
	public String getEtat() {
		return Etat;
	}
	public void setEtat(String etat) {
		Etat = etat;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}

	private static final long serialVersionUID = 1L;
	
	

	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Tache(String nom, Date dateDeb, Date dateFin, Date date_fin_real) {
		super();
		Nom = nom;
		DateDeb = dateDeb;
		DateFin = dateFin;
		Date_fin_real = date_fin_real;
	}
	public Tache() {
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
	public Date getDateDeb() {
		return this.DateDeb;
	}

	public void setDateDeb(Date DateDeb) {
		this.DateDeb = DateDeb;
	}   
	public Date getDateFin() {
		return this.DateFin;
	}

	public void setDateFin(Date DateFin) {
		this.DateFin = DateFin;
	}   
	public Date getDate_fin_real() {
		return this.Date_fin_real;
	}

	public void setDate_fin_real(Date Date_fin_real) {
		this.Date_fin_real = Date_fin_real;
	}
   
}
