 package fr.unilim.iut.spaceinvaders;


public class Vaisseau {

    int x;
    int y;
    int longueur;
    int hauteur;

    public Vaisseau(int longueur, int hauteur) {
		this.longueur=longueur;
		this.hauteur=hauteur;
		this.x = 0;
		this.y = 0;
	}

    public Vaisseau(int longueur, int hauteur, int x, int y) {
	   this.longueur=longueur;
	   this.hauteur=hauteur;
	   this.x = x;
	   this.y = y;
    }
    public boolean occupeLaPosition(int x, int y) {
    	if (estAbscisseCouverte(x) && estOrdonneeCouverte(y))
			return true;
		
	     return false;
    }

	/**
	 * @param y
	 * @return
	 */
	private boolean estOrdonneeCouverte(int y) {
		return ordonneeLaPlusBasse(y) && ordonneeLaPlusHaute(y);
	}

	/**
	 * @param y
	 * @return
	 */
	public boolean ordonneeLaPlusHaute(int y) {
		return y<=this.y;
	}

	/**
	 * @param y
	 * @return
	 */
	public boolean ordonneeLaPlusBasse(int y) {
		return this.y-this.hauteur+1<=y;
	}

	/**
	 * @param x
	 * @return
	 */
	private boolean estAbscisseCouverte(int x) {
		return (abscisseLaPlusAGauche()<=x) && (x<=abscisseLaPlusADroite());
	}

	/**
	 * @return
	 */
	public int abscisseLaPlusADroite() {
		return this.x+this.longueur-1;
	}
    
    public void seDeplacerVersLaDroite() {
    	 this.x = this.x + 1 ;
 }
    
    public int abscisseLaPlusAGauche() {
        return this.x;
	}
    
    public void seDeplacerVersLaGauche() {
	      this.x = this.x - 1 ;
 }
    
    public void positionner(int x, int y) {
	    this.x = x;
	    this.y = y;
    }

}