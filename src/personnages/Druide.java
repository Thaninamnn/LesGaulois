package personnages;

import java.util.Random; // Importation de la classe Random

public class Druide {

	private static final int FORCE_MOYENNE = 7;
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	private Random random = new Random();

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void preparerPotion() {
		 // Creation de l'objet Random

		forcePotion = random.nextInt(effetPotionMax-effetPotionMin)+ effetPotionMin;
		/*
		 * modification pour générer une force de potion entre effetPotionMin et
		 * effetPotionMax forcePotion = random.nextInt(effetPotionMax - effetPotionMin +
		 * 1) + effetPotionMin;
		 */

		// Détermination du message à afficher selon la force de la potion
		if (forcePotion > FORCE_MOYENNE) {
			parler("J'ai préparé une super potion de force " + forcePotion + ".");
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion + ".");
		}

	}

	public void booster(Gaulois gaulois) {
		gaulois.boirePotion(forcePotion); // Le Gaulois boit la potion avec la force préparée

	}
	/*
	 * public void booster(Gaulois gaulois) { if (gaulois.getNom().equals("Obélix"))
	 * { // Si le gaulois est Obelix, le druide refuse de lui donner la potion
	 * parler("Non, Obélix !... Tu n’auras pas de potion magique !"); } else { //
	 * Sinon, le gaulois boit la potion gaulois.boirePotion(forcePotion); // Le
	 * Gaulois boit la potion avec la force préparée parler("Je viens de booster " +
	 * gaulois.getNom() + " avec une potion de force " + forcePotion + " !"); } }
	 */

	public static void main(String[] args) {
		// Création du druide Panoramix
		Druide panoramix = new Druide("Panoramix", 5, 10);

		// Tester la méthode preparerPotion plusieurs fois
		for (int i = 0; i < 10; i++) {
			panoramix.preparerPotion(); // Appel de la méthode pour préparer la potion
		}
	}
}
