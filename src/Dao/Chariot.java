package Dao;

public class Chariot {
	private int Id_Client;
	private int Id_Livre;
	private double Montant;
	private int Quentite;

	public Chariot() {

	}

	public int getId_Client() {
		return Id_Client;
	}

	public void setId_Client(int id_Client) {
		Id_Client = id_Client;
	}

	public int getId_Livre() {
		return Id_Livre;
	}

	public void setId_Livre(int id_Livre) {
		Id_Livre = id_Livre;
	}

	public double getMontant() {
		return Montant;
	}

	public void setMontant(double montant) {
		Montant = montant;
	}

	public int getQuentite() {
		return Quentite;
	}

	public void setQuentite(int quentite) {
		Quentite = quentite;
	}

}
