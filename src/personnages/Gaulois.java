package personnages;

import villagegaulois.Musee;

public class Gaulois {
	private String nom;

	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}

	/*
	 * private String prendreparole() { return "Le gaulois " + nom + " : "; }
	 */
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";

	}

	// Méthode pour frapper un Romain
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(force / 3); // Force divisée par 3 (sans effet de la potion)
//	}

	/*
	 * public void frapper(Romain romain) { int forceCoup = (force / 3) *
	 * effetpotion; System.out.println(nom +
	 * " envoie un grand coup dans la mâchoire de " + romain.getNom() +
	 * " avec une force de " + forceCoup); romain.recevoirCoup(forceCoup); //
	 * Applique le coup }
	 */
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesRecus = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesRecus != null && i < tropheesRecus.length; i++) {
			if (tropheesRecus[i] != null && nbTrophees < trophees.length) {
				this.trophees[nbTrophees] = tropheesRecus[i];
				nbTrophees++;
			}
		}

	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée !");
	}

	public void faireUneDonnation(Musee musee) {
		if (nbTrophees > 0) {

			String annonce = prendreParole() + "« Je donne au musée tous mes trophées :";

			for (int i = 0; i < nbTrophees; i++) {
				annonce += " - " + trophees[i];
				musee.donnerTrophees(this, trophees[i]);
			}

			parler(annonce + " »");

			nbTrophees = 0;
			trophees = new Equipement[100];
		} else {
			parler("Je n'ai aucun trophée à donner.");
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain romain = new Romain("César", 6);

		System.out.println(asterix);
		System.out.println(asterix.nom);
		System.out.println(asterix.prendreParole());
		asterix.parler("je parle");

		// Astérix frappe sans potion
		asterix.frapper(romain);

		// Astérix boit une potion avec une force de 5
		asterix.boirePotion(5);

		// Astérix frappe apres avoir bu la potion
		asterix.frapper(romain);
	}
}
