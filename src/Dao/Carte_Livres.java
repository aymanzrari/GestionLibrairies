package Dao;

import java.util.ArrayList;

public class Carte_Livres {

	public int id;
	public ArrayList<Livre> Livres;

	public Carte_Livres() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Livre> getLivres() {
		return Livres;
	}

	public void setLivres(ArrayList<Livre> livres) {
		Livres = livres;
	}

	public double CalculerMontantTotale() {
		double s = 0;
		for (int i = 0; i < getLivres().size(); i++) {
			s = s + getLivres().get(i).getPrix() * getLivres().get(i).getQuentite();
		}
		return s;
	}
}
