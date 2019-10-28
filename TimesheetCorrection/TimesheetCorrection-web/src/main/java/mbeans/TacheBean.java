package mbeans;


import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Project;
import entities.Tache;
import implservices.ProjectService;
import implservices.TacheService;
import implservices.UserService;

@ManagedBean
public class TacheBean 
{
	private int IdTache;
	private String Nom;
	private Date DateDeb;
	private Date DateFin;
	private Date Date_fin_real;
	private Project Project;
	private int PprojectId;
	private int ProjectId;
	private int UserId;
	private String Etat;
	
	
	
	
	




	@EJB
	TacheService tacheservice ;
	@EJB
	ProjectService projectService;
	@EJB
	UserService userService;
	
	
	public List<Tache> getTachePlans(){
		Date date = new Date();
		return tacheservice.getTachePlan(date);
		
		
	}
	
	public String affDevice(){
		String navigateTo="null";
	    tacheservice.affecterTacheProject(IdTache, ProjectId,UserId);
		return navigateTo;
	}
	
	
	public List<Tache> getAllTaches() {
		List<Tache> tachef = null ;
		List<Tache> tache=tacheservice.getAllTache();
		Date d = new Date();
		for (Tache tache2 : tache) {
			Date dd=tache2.getDateDeb();
			Date df=tache2.getDateFin();
			if(dd.after(d)){
				tache2.setEtat("Not Started");				
				}
			else if(dd.before(d) && d.before(df)){
					 tache2.setEtat("In Progress");					
				}				
			else if(df.before(d)){
					 tache2.setEtat("Finished");					
				}				
		}		
		return tache;
	}
	
	
	

	public String ajouterTache()
	{
         String navigateTo="null";

		
		
		tacheservice.ajouterTache(new Tache( Nom,  DateDeb, DateFin, Date_fin_real));
		

		//navigateTo = "/login?faces-redirect=true";
	// navigateTo = "/pages/welcome?faces-redirect=true";
		return navigateTo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Project getProject() {
		return Project;
	}

	public void setProject(Project project) {
		Project = project;
	}

	public int getProjectId() {
		return ProjectId;
	}

	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}

	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public Date getDateDeb() {
		return DateDeb;
	}
	public void setDateDeb(Date dateDeb) {
		DateDeb = dateDeb;
	}
	public Date getDateFin() {
		return DateFin;
	}
	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}
	public Date getDate_fin_real() {
		return Date_fin_real;
	}
	public void setDate_fin_real(Date date_fin_real) {
		Date_fin_real = date_fin_real;
	}

	public int getIdTache() {
		return IdTache;
	}




	public void setIdTache(int idTache) {
		IdTache = idTache;
	}

	
	public String getEtat() {
		return Etat;
	}

	public void setEtat(String etat) {
		Etat = etat;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getPprojectId() {
		return PprojectId;
	}

	public void setPprojectId(int pprojectId) {
		PprojectId = pprojectId;
	}




}
