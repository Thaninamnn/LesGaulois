package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;
	private static final String MESSAGE_SOLDAT = "Le soldat ";

	// Méthode pour vérifier si l'invariant est respecté
	private boolean invariantEstRespecte() {
		return force > 0;
	}

	public Romain(String nom, int force) {
		if (force <= 0) {
			throw new IllegalArgumentException("La force doit être positive."); // Précondition
		}
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;

		// Vérifier l'invariant après la création
		if (!invariantEstRespecte()) {
			throw new IllegalStateException("Invariant non respecté : la force doit être positive après la création.");
		}
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public int getForce() {
		return force;

	}
	/*
	 * public void recevoirCoup(int forceCoup) { // Vérifier la précondition assert
	 * forceCoup > 0 : "La force du coup doit être positive.";
	 * 
	 * int forceInitiale = force;
	 * 
	 * force -= forceCoup;
	 * 
	 * if (force > 0) { parler("Aïe"); } else { parler("J'abandonne..."); }
	 * 
	 * // Vérifier la postcondition : la force doit avoir diminué assert force <
	 * forceInitiale :
	 * "Postcondition non respectée : la force doit avoir diminué après le coup.";
	 * 
	 * // Vérifier l'invariant après la modification assert invariantEstRespecte() :
	 * "Invariant non respecté : la force doit être positive après avoir reçu un coup."
	 * ; }
	 */

	public int calculResistanceEquipement(int forceCoup) {

		String texte;

		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;

		int resistanceEquipement = 0;

		if (nbEquipement != 0) {

			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";

			for (int i = 0; i < nbEquipement; i++) {

				if (equipements[i] != null) {

					if (equipements[i].equals(Equipement.BOUCLIER)) {

						resistanceEquipement += 8;

					} else {

						System.out.println("Equipement casque");

						resistanceEquipement += 5;

					}

				}

			}

			texte += resistanceEquipement + "!";

		}

		parler(texte);

		forceCoup -= resistanceEquipement;

		return forceCoup;

	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
			}
			nbEquipementEjecte++;
			equipements[i] = null;
		}
		return equipementEjecte;
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;

		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}

		return equipementEjecte;
	}

	public void sEquiper(Equipement equipement) {
		// Vérifier la précondition
		if (equipement == null) {
			throw new IllegalArgumentException("L'équipement ne doit pas être null.");
		}

		switch (nbEquipement) {
		case 2:
			parler(MESSAGE_SOLDAT + nom + " est déjà bien protégé !");
			break;

		case 1:
			if (equipements[0] == equipement) {
				parler(MESSAGE_SOLDAT + nom + " possède déjà un " + equipement.toString() + " !");
			} else {
				equipements[nbEquipement] = equipement; // Ajouter l'équipement
				nbEquipement++;
				parler(MESSAGE_SOLDAT + nom + " s'équipe avec un " + equipement.toString() + ".");
			}
			break;

		case 0:
			equipements[nbEquipement] = equipement;
			nbEquipement++;
			parler(MESSAGE_SOLDAT + nom + " s'équipe avec un " + equipement.toString() + ".");
			break;

		default:
			System.out.println(MESSAGE_SOLDAT + getNom() + " est bien protégé.");
			break;
		}
	}

	@Override
	public String toString() {
		return "Romain [nom=" + nom + ", force=" + force + "]";
	}

	public static void main(String[] args) {
		Romain romain = new Romain("Rome", 8);
		System.out.println(romain);
		System.out.println(romain.getNom());
		System.out.println(romain.prendreParole());
		romain.parler("Je parle");

		romain.recevoirCoup(3);
		System.out.println("Force après coup: " + romain.force);

		Romain minus = new Romain("Minus", 6);
		Equipement equipement1 = Equipement.CASQUE;
		Equipement equipement2 = Equipement.BOUCLIER;

		// Teste de la méthode sEquiper
		minus.sEquiper(equipement1);
		minus.sEquiper(equipement1);
		minus.sEquiper(equipement2);
		minus.sEquiper(equipement1);

		System.out.println("Équipement de " + romain.getNom() + " : " + equipement1);
		System.out.println("Équipement de " + minus.getNom() + " : " + equipement2);
	}

}
