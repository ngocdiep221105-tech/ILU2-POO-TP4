package produit;

enum Unite{G, KG, L, CL, ML, PIECE};
public abstract class Produit {
	protected String nom;
	protected Unite unite;
	
	protected Produit(String nom, Unite unite) {
		this.nom=nom;
		this.unite=unite;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Unite getUnit() {
		return unite;
	}
	
	public abstract String decrireProduit();
}


