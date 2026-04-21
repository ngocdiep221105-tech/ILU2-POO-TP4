package produit;
import personnages.Gaulois;
public class Sanglier extends Produit{
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chausseur) {
		super("sanglier",Unite.KG);
		this.poids=poids;
		this.chasseur=chausseur;
	}
	
	public int getPoids() {
		return poids;
	}
	
	public Gaulois getChausseur() {
		return chasseur;
	}
	
	@Override
	public String decrireProduit() {
		return "sanglier de "+ poids + " kg chassé par "+chasseur.getNom();
	}
	
	@Override
	public int calculerPrix(int prix) {
		return poids*prix;
	}
}
