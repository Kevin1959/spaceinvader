    package fr.unilim.iut.spaceinvaders;
  
    public class SpaceInvaders {

	    private static final char MARQUE_VIDE = '.';
		private static final char MARQUE_VAISSEAU = 'V';
		private static final char MARQUE_FIN_LIGNE = '\n';
		int longueur;
	    int hauteur;
	    Vaisseau vaisseau;

	    public SpaceInvaders(int longueur, int hauteur) {
		   this.longueur = longueur;
		   this.hauteur = hauteur;
	   }
	    
	    public void positionnerUnNouveauVaisseau(int x, int y) {
	        Vaisseau vaisseau = new Vaisseau (x,y);
		}
	    
		private boolean aUnVaisseauQuiOccupeLaPosition(int y, int x) {
			return aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
		}
		
	    private char recupererMarqueDeLaPosition(int x, int y) {
	        char marque;
	        if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
	           marque=MARQUE_VAISSEAU;
	        else
	           marque=MARQUE_VIDE;
	        return marque;
		}
	    
		private boolean aUnVaisseau() {
			return vaisseau!=null;
		}
		
	    @Override
		public String toString() {
			return recupererEspaceJeuDansChaineASCII();
		}

		private String recupererEspaceJeuDansChaineASCII() {
			StringBuilder espaceDeJeu = new StringBuilder();
			for (int y = 0; y < hauteur; y++) {
				for (int x = 0; x < longueur; x++) {
					espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
				}
				espaceDeJeu.append('\n');
			}
			return espaceDeJeu.toString();
		}
   }
    
    
    
