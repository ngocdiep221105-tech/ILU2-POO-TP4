package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public class Etal<P extends IProduit> implements IEtal {
	private Gaulois vendeur;
	private P[] produits;
	private int nbProduit = 0;
	private int quantiteDebutMarche;
	private int quantite;
	private boolean etalOccupe = false;
	private int prix;

	public P[] getProduits() {
		return produits;
	}

	public boolean isEtalOccupe() {
		return etalOccupe;
	}

	public Gaulois getVendeur() {
		return vendeur;
	}

	public int getQuantite() {
		return quantite;
	}

	public int getQuantiteDebutMarche() {
		return quantiteDebutMarche;
	}

	public int getPrix() {
		return prix;
	}

	public int getNbProduit() {
		return nbProduit;
	}

	public boolean installerVendeur(Gaulois vendeur, P[] produit, int prix) {
		if (etalOccupe) {
			return false;
		}
		this.vendeur = vendeur;
		this.produits = produit;
		this.prix = prix;
		this.quantiteDebutMarche = produits.length;
		this.nbProduit = produits.length;
		this.etalOccupe = true;
		return true;
	}

	@Override
	public int contientProduit(String produit, int quantiteSouhaitee) {
		int quantiteAVendre = 0;
		if (nbProduit != 0 && this.produits[0].getNom().equals(produit)) {
			if (nbProduit >= quantiteSouhaitee) {
				quantiteAVendre = quantiteSouhaitee;
			} else {
				quantiteAVendre = nbProduit;
			}
		}
		return quantiteAVendre;
	}

	@Override
	public int acheterProduit(int quantiteSouhaitee) {
		int prixPaye = 0;
		for (int i = nbProduit - 1; i > nbProduit - quantiteSouhaitee - 1 || i > 1; i--) {
			prixPaye += produits[i].calculerPrix(prix);
			// question 3.d
		}
		if (nbProduit >= quantiteSouhaitee) {
			nbProduit -= quantiteSouhaitee;
		} else {
			nbProduit = 0;
		}
		return prixPaye;
	}

	@Override
	public String etatEtal() {
		StringBuilder chaine = new StringBuilder("Le vendeur ");
		chaine.append(vendeur.getNom());
		if (nbProduit > 0) {
			chaine.append(" vend ");
			chaine.append(nbProduit);
			chaine.append(" ");
			chaine.append(produits[0].getNom());
			if (nbProduit > 1) {
				chaine.append("s");
			}
			chaine.append(" : ");
			for (int i = 0; i < nbProduit; i++) {
				chaine.append("\n- un ");
				chaine.append(produits[i].decrireProduit());
				
			}
			chaine.append("\nChaque produit est vendu au prix de ");
			chaine.append(prix);
			chaine.append(" sous.");
			chaine.append("\n");
		} else {
			chaine.append(" n'a plus rien à vendre.");
		}
		chaine.append("\n");
		return chaine.toString();
	}

}
