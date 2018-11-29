package Dao;

public class Livre {

	private int Id_Livre;
	private String Description;
	private double Prix;
	private int Quentite;

	public int getQuentite() {
		return Quentite;
	}

	public void setQuentite(int quentite) {
		Quentite = quentite;
	}

	public Livre() {
	}

	public int getId_Livre() {
		return Id_Livre;
	}

	public void setId_Livre(int id_Livre) {
		Id_Livre = id_Livre;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getPrix() {
		return Prix;
	}

	public void setPrix(double prix) {
		Prix = prix;
	}
}
