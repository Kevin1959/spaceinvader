package fr.unilim.iut.spaceinvaders;

public abstract class Sprite {

	public Sprite(Position origine, Dimension dimension, int vitesse) {
		super();
		this.origine = origine;
		this.dimension = dimension;
		this.vitesse = vitesse;
	}

	protected Position origine;
	protected Dimension dimension;
	protected int vitesse;

	public Sprite() {
		super();
	}

	public boolean occupeLaPosition(int x, int y) {
	    return estAbscisseCouverte(x) && estOrdonneeCouverte(y);
	}

	private boolean estOrdonneeCouverte(int y) {
	   return (ordonneeLaPlusBasse() <= y) && (y <= ordonneeLaPlusHaute());
	}

	private boolean estAbscisseCouverte(int x) {
	   return (abscisseLaPlusAGauche() <= x) && (x <= abscisseLaPlusADroite());
	}

	public int ordonneeLaPlusBasse() {
	    return this.origine.ordonnee() - this.dimension.hauteur() + 1;
	}

	public int ordonneeLaPlusHaute() {
		   return this.origine.ordonnee();
	   }

	public int abscisseLaPlusADroite() {
		   return this.origine.abscisse() + this.dimension.longueur() - 1;
	   }

	public int abscisseLaPlusAGauche() {
		   return this.origine.abscisse();
	   }

	public void seDeplacerVersLaDroite() {
		   this.origine.changerAbscisse(this.origine.abscisse() + vitesse);
	   }

	public void seDeplacerVersLaGauche() {
		   this.origine.changerAbscisse(this.origine.abscisse() - vitesse);
	   }

	public void positionner(int x, int y) {
		   this.origine.changerAbscisse(x);
		   this.origine.changerOrdonnee(y);
	   }

	public int hauteur() {
		return this.dimension.hauteur();
	}

	public int longueur() {
		return this.dimension.longueur();
	}

	public Missile tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {
		
		int abscisseMilieuVaisseau = this.abscisseLaPlusAGauche() + (this.longueur() / 2);
		int abscisseOrigineMissile = abscisseMilieuVaisseau - (dimensionMissile.longueur() / 2);

		int ordonneeeOrigineMissile = this.ordonneeLaPlusBasse() - 1;
		Position positionOrigineMissile = new Position(abscisseOrigineMissile, ordonneeeOrigineMissile);

		return new Missile(dimensionMissile, positionOrigineMissile, vitesseMissile);
	}

}