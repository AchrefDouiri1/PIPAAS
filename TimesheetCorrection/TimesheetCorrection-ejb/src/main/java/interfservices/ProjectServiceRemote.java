package interfservices;

import java.util.List;

import entities.Project;
import entities.User;

public interface ProjectServiceRemote {

	
	public void ajouterproject(Project Project);
	public void supprimerproject(int Id);
	public List<Project> getAllProject();
	public void affecterProjectGroup(int IdProject,int Idgroup);
}
