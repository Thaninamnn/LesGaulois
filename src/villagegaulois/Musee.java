package villagegaulois;

import personnages.Gaulois;
import personnages.Equipement;

public class Musee {
	private Trophee[] trophees;
	private int nbTrophees;

	public Musee() {
		this.trophees = new Trophee[200];
		this.nbTrophees = 0;
	}

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		if (nbTrophees < trophees.length) {
			trophees[nbTrophees] = new Trophee(gaulois, equipement);
			nbTrophees++;
		} else {
			System.out.println("Le musée est plein, impossible d'ajouter plus de trophées.");
		}
	}

}
