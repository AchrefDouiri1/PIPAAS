package implservices;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Project;
import entities.Tache;
import entities.User;
import interfservices.TacheServiceRemote;

@Stateless
@LocalBean
public class TacheService implements TacheServiceRemote {
	
	@PersistenceContext(unitName= "TimesheetCorrection-ejb")
	EntityManager em ;


	@Override
	public void ajouterTache(Tache tache) {
		
		em.persist(tache);
	
	}
	
	public void affecterTacheProject(int TacheId, int ProjectId,int Iduser) {
		Tache tache = em.find(Tache.class, TacheId);
		Project project = em.find(Project.class, ProjectId);
		User user=em.find(User.class, Iduser);
				;
		
		tache.setProject(project);
		tache.setUser(user);
	}
	
	
	
	public List<Tache> getTachePlan(Date datedeb){
		
		TypedQuery<Tache>  query= em.createQuery("Select e from Tache e " + "where e.DateDeb<=:datedeb", Tache.class);
		query.setParameter("datedeb", datedeb);
		
		//return em.createQuery("from Tache where DateDeb>="+ datedeb).getResultList();
		return query.getResultList() ;
		
		//return em.createQuery("from Tache where DateDeb>="+ datedeb).getResultList();
		
	}

	public List<Tache> getAllTache(){
		return em.createQuery("from Tache").getResultList();
	}
	
	public List<Tache> getAllTachess(){
		return em.createQuery("from Tache").getResultList();
	}
}
