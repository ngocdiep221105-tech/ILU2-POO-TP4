package produit;
import personnages.Gaulois;
public class Sanglier extends Produit{
	private int poids;
	private Gaulois chausseur;
	
	public Sanglier(int poids, Gaulois chausseur) {
		super("sanglier",Unite.KG);
		this.poids=poids;
		this.chausseur=chausseur;
	}
	
	public int getPoids() {
		return poids;
	}
	
	public Gaulois getChausseur() {
		return chausseur;
	}
	
	@Override
	public String decrireProduit() {
		return "sanglier de "+ poids + " kg chassé par "+chausseur.getNom();
	}
}
