package mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import entities.Tache;
import entities.User;
import implservices.GroupService;
import implservices.UserService;

@ManagedBean

public class UserBean {

	private int Id;
	private String Nom;
	private String Prenom;
	private String Role;
	private String Login;
	private String Mdp;
	private User user;
	private  boolean loggedIn;
	private int Idgroup;
	
	
	
	@EJB
	UserService userservice; 
	@EJB
	GroupService groupservice; 
	
	
	public String affUserGroup(){
		String navigateTo="null";
	    userservice.affecterUserGroup(Id, Idgroup);;
		return navigateTo;
	}
	
	public List<User> getAllUsers() {
		return userservice.getAllUsers();
	}
	
	
	
	public String doLogin(){
		String navigateTo="null";
		//User=userservice.getLogin(Login, Mdp);
		user=userservice.getLogin(Login, Mdp);
		//User = userService.getEmployeeByMatriculeAndPassword(login, password);
	    if (user !=null){
	    	loggedIn=true;
		/*if (user.getEmployeeType()==EmployeeType.ADMIN){
			navigateTo="/espaceadmin?faces-redirect=true";
		}*/
		/*if (employee.getEmployeeType()==EmployeeType.EMP){
			navigateTo="/espacemployee?faces-redirect=true";
		}*/
	    	navigateTo="inscription?faces-redirect=true";
	    }
		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));
		}
	return navigateTo;
	}
	
	public String ajouteruser(){
		String navigateTo="null";
	
		
		userservice.ajouteruser(new User( Nom, Prenom, "Admin", Login, Mdp));

		
		return navigateTo;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
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
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getMdp() {
		return Mdp;
	}
	public void setMdp(String mdp) {
		Mdp = mdp;
	}
	
	
}
