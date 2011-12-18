package exo3;

import java.awt.Graphics;
import mymath.Point;

public class EkSol extends Ek {
	private int nbSegments;
	private double ANGLE;

	public EkSol(int profondeur) {
		this(profondeur, 5);
	}

	public EkSol(int profondeur, int nbSegments) {
		super(profondeur);
		this.nbSegments = nbSegments;
		ANGLE = 2*Math.PI/nbSegments;
	}

	private Point rotate(Point p, double angle) {
		return new Point(p.getX()*Math.cos(angle)-p.getY()*Math.sin(angle),
				p.getX()*Math.sin(angle)+p.getY()*Math.cos(angle));
	}

	public void drawEk(int xorigine, int yorigine, double angle, int taille, int n, Graphics drawingArea) {
		if(n>0) {
			// Vecteur directeur de la droite courante
			Point vD = new Point(1,0);
			Point p = null;
			for	(int i=0; i<nbSegments; i++) {
				// On calcule le vecteur directeur du segment courant
				vD = rotate(vD, ANGLE);
				// On calcule la position du centre de l'étoile suivante (celle attachée au segment courant)
				p = new Point(xorigine+taille*vD.getX(), yorigine+taille*vD.getY());
				// On appelle récursivement sur chacunes des sous-étoiles
				drawEk((int)p.getX(), (int)p.getY(), ANGLE, taille/3, n-1, drawingArea);

				// On l'affiche
				drawingArea.drawLine((int)xorigine, (int)yorigine, (int)p.getX(), (int)p.getY());
			}
		}		
	}
}
