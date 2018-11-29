package Dao;

public class Client {
	private int Id_Client;
	private String Nom;
	private String Prenom;
	private String Email;

	public Client() {
	}

	public int getId_Client() {
		return Id_Client;
	}

	public void setId_Client(int id_Client) {
		Id_Client = id_Client;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
