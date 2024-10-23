/*
 * package histoire;
 * 
 * import personnages.Druide; import personnages.Gaulois; import
 * personnages.Romain;
 * 
 * public class Scenario {
 * 
 * public static void main(String[] args) { // Création du druide Panoramix avec
 * une potion de force entre 5 et 10 Druide panoramix = new Druide("Panoramix",
 * 5, 10);
 * 
 * // Création des Gaulois Astérix (force 8) et Obélix (force 25) Gaulois
 * asterix = new Gaulois("Astérix", 8); Gaulois obelix = new Gaulois("Obélix",
 * 25);
 * 
 * // Création du Romain Minus avec une force de 6 Romain minus = new
 * Romain("Minus", 6);
 * 
 * // Le druide prépare une potion
 * panoramix.parler("Je vais aller préparer une petite potion...");
 * panoramix.preparerPotion(); // La potion est préparée avec une force de 6
 * 
 * // Le druide tente de donner la potion à Obélix, mais il refuse
 * panoramix.booster(obelix); // Obélix n'a pas le droit à la potion
 * obelix.parler("Par Bélénos, ce n'est pas juste !");
 * 
 * // Le druide donne la potion à Astérix panoramix.booster(asterix); // Astérix
 * reçoit une potion de force 6 asterix.parler("Bonjour");
 * 
 * // Minus essaie de parler avant de recevoir un coup d'Astérix
 * minus.parler("UN GAU... UN GAUGAU..."); asterix.frapper(minus); // Astérix
 * frappe Minus
 * 
 * // Minus abandonne minus.parler("J'abandonne..."); } }
 */
package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;
import villagegaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.preparerPotion();
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0);
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (milexcus.getForce() > 0);

		Musee musee = new Musee();
		asterix.faireUneDonnation(musee);

	}

}
