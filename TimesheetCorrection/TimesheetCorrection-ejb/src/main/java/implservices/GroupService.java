package implservices;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.GroupUser;
import entities.Project;
import entities.Tache;
import entities.User;
import interfservices.GroupServiceRemote;

@Stateless
@LocalBean
public class GroupService implements GroupServiceRemote {
	
	@PersistenceContext(unitName= "TimesheetCorrection-ejb")
	EntityManager em;
	
	@Override
	public void ajoutergroup(GroupUser Group) {
		// TODO Auto-generated method stub
		em.persist(Group);
	}
	@Override
	public void supprimergroup(int Id) {
		// TODO Auto-generated method stub
		em.remove(em.find(GroupUser.class,Id));
	}
	
	public List<GroupUser> getAllGroup(){
		return em.createQuery("from GroupUser g order by g.Nom").getResultList();
	}
	
	public List<Project> getProjectsByUser(int iduser) 
	{
		//TypedQuery<Tache>  query= em.createQuery("Select e from GroupUser e " + "where e.<=:datedeb", Tache.class);

		//em.createQuery("from GroupUser g order by g.Nom").getResultList();
		User user = em.find(User.class, iduser);
		int group=user.getGroupuser().getId();
		//TypedQuery<Tache>  query= em.createQuery("Select e from Project e " + "where e.<=:datedeb", Tache.class);
		GroupUser groupeuser=em.find(GroupUser.class, group);
		
		Project proj=groupeuser.getProject().get(0);
		
		
		List<Project> p = null;
		p.add(proj);
		
		return p ;
	}

}
