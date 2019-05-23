package fr.unilim.iut.spaceinvaders;

public class Missile extends Sprite {
	
	private Position origine;
	private Dimension dimensionMissile;
	private int vitesseMissile;

	public Missile(Dimension dimensionMissile, Position origine, int vitesseMissile) {
		super(origine,dimensionMissile,vitesseMissile);
	}

	
	
}
