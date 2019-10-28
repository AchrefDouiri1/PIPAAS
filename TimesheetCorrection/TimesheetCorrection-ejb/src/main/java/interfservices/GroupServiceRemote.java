package interfservices;

import java.util.List;

import entities.GroupUser;
import entities.Project;

public interface GroupServiceRemote {
	
	public void ajoutergroup(GroupUser Group);
	public void supprimergroup(int Id);
	public List<GroupUser> getAllGroup();
	public List<Project> getProjectsByUser(int iduser);

}
