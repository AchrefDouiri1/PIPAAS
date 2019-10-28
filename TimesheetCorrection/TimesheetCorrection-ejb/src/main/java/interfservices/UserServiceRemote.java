package interfservices;

import java.util.List;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserServiceRemote {
	public void ajouteruser(User User);
	public void supprimeruser(int Id);
	public User getLogin(String Login, String Mdp);
	public void affecterUserGroup(int Iduser,int Id);
	public List<User> getUsers(int Id);

}
