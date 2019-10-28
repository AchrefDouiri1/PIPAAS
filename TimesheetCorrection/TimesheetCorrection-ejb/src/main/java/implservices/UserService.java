package implservices;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.GroupUser;
import entities.Tache;
import entities.User;
import interfservices.UserServiceRemote;

@Stateless
@LocalBean
public class UserService implements UserServiceRemote {

	@PersistenceContext(unitName= "TimesheetCorrection-ejb")
	EntityManager em;
	
	public void affecterUserGroup(int Iduser,int Idgroup) {
		
		User user=em.find(User.class, Iduser);
		GroupUser group = em.find(GroupUser.class, Idgroup);
				
		
		
		user.setGroupuser(group);
	}
	
	public List<User> getUsers(int groupuser){
		
		TypedQuery<User>  query= em.createQuery("Select e from User e " + "where e.groupuser=:groupuser", User.class);
		query.setParameter("groupuser", groupuser);
		return query.getResultList();
	}
	
	
	@Override
	public void ajouteruser(User User) {
		// TODO Auto-generated method stub
		em.persist(User);
	}
	@Override
	public void supprimeruser(int Id) {
		// TODO Auto-generated method stub
		em.remove(em.find(User.class,Id));
	}
	
	public List<User> getAllUsers(){
		return em.createQuery("from User").getResultList();
	}
	
	public User getLogin(String Login, String Mdp) {
		TypedQuery<User> query= em.createQuery("Select e from User e " + "where e.Login=:Login and "+"e.Mdp=:Mdp", User.class);
		query.setParameter("Login", Login);
		query.setParameter("Mdp", Mdp);
		User user = null;
		try{
			user = query.getSingleResult();
		}
		catch(NoResultException e){
			Logger.getAnonymousLogger().info("Not found");
		}
		return user;
	}
	
	

	

}
