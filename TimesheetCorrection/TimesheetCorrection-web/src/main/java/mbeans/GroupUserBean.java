package mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import entities.GroupUser;
import entities.Project;
import implservices.GroupService;



@ManagedBean
public class GroupUserBean {
	
	private int Id;
	private String Nom;
	private List<Project> project ;
	
	private int iduser;
	
	
	
	
	
	
	
	
	
	public int getIduser() {
		return iduser;
	}


	public void setIduser(int iduser) {
		this.iduser = iduser;
	}


	public List<Project> getProject() {
		return project;
	}


	public void setProject(List<Project> project) {
		this.project = project;
	}
	@EJB
	GroupService groupservice ;
	
	public List<GroupUser> getAllGroups() {
		return groupservice.getAllGroup();
	}
	
	
	public List<Project> getProjectsbyuser(int iduser)
	{	
		 project =groupservice.getProjectsByUser(iduser) ;
		 return project;
	}
	
	
	public String ajouterGroup(){
		String navigateTo="null";
	
		
		groupservice.ajoutergroup(new GroupUser(Nom));

		
		return navigateTo;
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

}
