package exo2;

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

	private Point rotate(double x, double y, double angle) {
		return new Point(x*Math.cos(angle)-y*Math.sin(angle),
				x*Math.sin(angle)+y*Math.cos(angle));
	}

	public void drawEk(int xorigine, int yorigine, double angle, int taille, int n, Graphics drawingArea) {
		if(n>0) {
			// Vecteur directeur de la droite courante
			Point vD = rotate(1, 0, angle);

			//System.out.println("Vecteur directeur :"+vD);

			Point p = null;
			for	(int i=0; i<nbSegments; i++) {
				vD = rotate(vD, ANGLE);
				p = new Point(xorigine+taille*vD.getX(), yorigine+taille*vD.getY());
				//System.out.println("Position 2 "+p2.toString());
				drawEk((int)p.getX(), (int)p.getY(), ANGLE, taille/3, n-1, drawingArea);
				drawingArea.drawLine((int)xorigine, (int)yorigine, (int)p.getX(), (int)p.getY());
			}
		}		
	}
}
