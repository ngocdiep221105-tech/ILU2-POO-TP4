package produit;

public interface IProduit {

	String getNom();

	Unite getUnit();

	String decrireProduit();

	int calculerPrix(int prix);

}