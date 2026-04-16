package produit;

enum Unite{G, KG, L, CL, ML, PIECE};
public abstract class Produit implements IProduit {
	protected String nom;
	protected Unite unite;
	
	protected Produit(String nom, Unite unite) {
		this.nom=nom;
		this.unite=unite;
	}
	
	@Override
	public String getNom() {
		return nom;
	}
	
	@Override
	public Unite getUnit() {
		return unite;
	}
	
	@Override
	public abstract String decrireProduit();
}


