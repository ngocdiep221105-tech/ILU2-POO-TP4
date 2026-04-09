package villagegaulois;

import personnages.Gaulois;
import produit.Produit;

public interface IEtal<P extends Produit> {

	boolean isEtalOccupe();

	Gaulois getVendeur();

	int getQuantite();

}