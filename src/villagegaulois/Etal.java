package villagegaulois;

import personnages.Gaulois;
import produit.IProduit;

public class Etal<P extends IProduit> {
	private Gaulois vendeur;
	private P[] produits;
	private int nbProduit=0;
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
	
	public void installerVendeur(Gaulois vendeur, P[] produit, int prix) {
		this.vendeur=vendeur;
		this.produits=produit;
		this.prix=prix;
		this.quantiteDebutMarche=produits.length;
		this.nbProduit=produits.length;
		this.etalOccupe= true;
	}

}
