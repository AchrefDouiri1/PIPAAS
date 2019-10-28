package mbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.Project;
import entities.Tache;
import entities.User;
import implservices.GroupService;
import implservices.ProjectService;
import implservices.UserService;

@ManagedBean
public class ProjectBean {

	private int Id;
	private String NomProject;
	private Date DateDeb;
	private Date DateFin;
	private String Description;
	private int Idgroup;
	private int Idgroupuser;
	
	
	
	public int getIdgroupuser() {
		return Idgroupuser;
	}

	public void setIdgroupuser(int idgroupuser) {
		Idgroupuser = idgroupuser;
	}
	@EJB
	ProjectService projectservice;
	@EJB
	GroupService groupservice;
	@EJB
	UserService userservice;
	
	
	public String affProjectGroup(){
		String navigateTo="null";
		projectservice.affecterProjectGroup(Id, Idgroup);
		return navigateTo;
	}
	
	public List<User> getAllProjectgroup(int Idgroupuser) {
		return userservice.getUsers(Idgroupuser);
	}
	
	public List<Project> getAllProjects() {
		return projectservice.getAllProject();
	}
	
	public String ajouterproject(){
		String navigateTo="null";
	
		
		projectservice.ajouterproject(new Project(NomProject, DateDeb, DateFin, Description));

		
		return navigateTo;
	}
	
	
	
	public int getIdgroup() {
		return Idgroup;
	}

	public void setIdgroup(int idgroup) {
		Idgroup = idgroup;
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNomProject() {
		return NomProject;
	}
	public void setNomProject(String nomProject) {
		NomProject = nomProject;
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	
	
}
