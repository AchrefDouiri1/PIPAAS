package interfservices;

import java.util.Date;
import java.util.List;

import entities.Tache;

public interface TacheServiceRemote {
	
  public void ajouterTache(Tache tache);
  public void affecterTacheProject(int TacheId, int ProjectId,int Iduser);
  public List<Tache> getAllTache();
  public List<Tache> getTachePlan(Date datedeb);


}
