package personnages;

public class Village {

	private String nom;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;
	private Chef chef;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < nbVillageoisMaximum) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		} else {
			System.out.println("Le village est plein, impossible d'ajouter " + gaulois.getNom());
		}
	}

	public Gaulois trouverHabitant(int index) {
		if (index >= 0 && index < nbVillageois) {
			return villageois[index];
		}
		return null;
	}

	public void afficherVillageois() {

		if (chef != null) {
			System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		} else {
			System.out.println("Le village n'a pas de chef.");
		}

		for (int i = 0; i < nbVillageois; i++) {
			Gaulois villageois = this.villageois[i];
			if (villageois != null) {
				System.out.println("- " + villageois.getNom());
			}
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);

		// Ajout du chef
		Chef chef = new Chef("Abraracourcix", 6, village);
		village.setChef(chef);

		// Ajout de villageois
		Gaulois gaulois1 = new Gaulois("Astérix", 8);
		village.ajouterHabitant(gaulois1);

		Gaulois gaulois2 = new Gaulois("Obélix", 25);
		village.ajouterHabitant(gaulois2);

		// Afficher les villageois pour vérifier l'ajout d'Obélix
		village.afficherVillageois();

		// Tester l'accès à un villageois
		Gaulois gaulois = village.trouverHabitant(1);
		System.out.println(gaulois != null ? gaulois.getNom() : "Pas de villageois à cette position.");

		// Exemple de tentative d'accès à un index hors limites
		Gaulois gauloisInvalide = village.trouverHabitant(30); // Hors limites
		if (gauloisInvalide == null) {
			System.out.println("Aucun villageois trouvé à l'index 30.");
		}
	}

}
