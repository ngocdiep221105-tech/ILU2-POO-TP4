package scenarioTest;


import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;


public class Scenario {

	public static void main(String[] args) {

		class Village implements IVillage{
			private IEtal[] marche = new IEtal[3];
			private int nbEtals = 0;

			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produits, int prix) {
				if (nbEtals >= marche.length) {
					return false;
				}
				if (etal.installerVendeur(vendeur, produits, prix)) {
					marche[nbEtals++] = etal;
					return true;
				}
				return false;
			}

			@Override
			public void acheterProduit(String produit, int quantiteSouhaitee) {
				int quantiteRestante = quantiteSouhaitee;

				for (int i = 0; i < nbEtals && quantiteRestante != 0; i++) {
					int dispo = marche[i].contientProduit(produit, quantiteRestante);

					if (dispo > 0) {
						int prix = marche[i].acheterProduit(dispo);

						String nom = dispo > 1 ? produit + "s" : produit;

						System.out.println("A l'étal n° " + (i + 1)
								+ ", j'achète " + dispo + " " + nom
								+ " et je paye " + prix + " sous.");

						quantiteRestante -= dispo;
					}
				}

				String nom = quantiteSouhaitee > 1 ? produit + "s" : produit;

				System.out.println("Je voulais " + quantiteSouhaitee + " " + nom
						+ ", j'en ai acheté "
						+ (quantiteSouhaitee - quantiteRestante) + ".");
				
			}
			
			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();

				for (int i = 0; i < nbEtals; i++) {
					sb.append(marche[i].etatEtal());
				}

				return sb.toString();
			}
		}

		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(200, obelix);
		Sanglier sanglier2 = new Sanglier(150, obelix);
		Sanglier sanglier3 = new Sanglier(100, asterix);
		Sanglier sanglier4 = new Sanglier(50, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		
		IVillage village = new Village();
		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		village.acheterProduit("sanglier", 3);

		System.out.println(village);
	}

}

