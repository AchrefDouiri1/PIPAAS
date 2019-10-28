package implservices;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.GroupUser;
import entities.Project;
import entities.User;
import interfservices.ProjectServiceRemote;

@Stateless
@LocalBean
public class ProjectService implements ProjectServiceRemote {
	
	@PersistenceContext(unitName= "TimesheetCorrection-ejb")
	EntityManager em;
	
	
public void affecterProjectGroup(int IdProject,int Idgroup) {
		
	    Project project=em.find(Project.class, IdProject);
		GroupUser group = em.find(GroupUser.class, Idgroup);
				
		
		project.setGroupproject(group);
		
	}
	
	
	@Override
	public void ajouterproject(Project Project) {
		// TODO Auto-generated method stub
		em.persist(Project);
	}
	@Override
	public void supprimerproject(int Id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Project.class,Id));
	}
	
	public List<Project> getAllProject(){
		return em.createQuery("from Project").getResultList();
	}
	
	

}
