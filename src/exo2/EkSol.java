package exo2;

import java.awt.Graphics;
import mymath.Point;

public class EkSol extends Ek {
	private static double ANGLE = 72*Math.PI/180;

	public EkSol(int profondeur) {
		super(profondeur);
	}

	private Point rotate(Point p, double angle) {
		return new Point(p.getX()*Math.cos(angle)-p.getY()*Math.sin(angle),
				p.getX()*Math.sin(angle)+p.getY()*Math.cos(angle));
	}

	private Point rotate(double x, double y, double angle) {
		return new Point(x*Math.cos(angle)-y*Math.sin(angle),
				x*Math.sin(angle)+y*Math.cos(angle));
	}

	public void drawEk(int xorigine, int yorigine, double angleInitial, int taille, int k, Graphics drawingArea) {
		if(k>0) {
			//System.out.println("Angle initial "+angleInitial);

			// Vecteur directeur de la droite courante
			Point vD = rotate(1, 0, angleInitial);

			//System.out.println("Vecteur directeur :"+vD);

			// Premier point de l'étoile
			double x1 = xorigine + taille*vD.getX();
			double y1 = yorigine + taille*vD.getY();
			Point p1 = new Point(x1,y1);
			//System.out.println("Position 1 "+p1.toString());

			drawEk((int)x1, (int)y1, ANGLE, taille/3, k-1, drawingArea);

			vD = rotate(vD, ANGLE);
			Point p2 = new Point(xorigine+taille*vD.getX(), yorigine+taille*vD.getY());
			//System.out.println("Position 2 "+p2.toString());
			drawEk((int)p2.getX(), (int)p2.getY(), ANGLE, taille/3, k-1, drawingArea);
			
			vD = rotate(vD, ANGLE);
			Point p3 = new Point(xorigine+taille*vD.getX(), yorigine+taille*vD.getY());
			//System.out.println("Position 3 "+p3.toString());
			drawEk((int)p3.getX(), (int)p3.getY(), ANGLE, taille/3, k-1, drawingArea);
			
			vD = rotate(vD, ANGLE);
			Point p4 = new Point(xorigine+taille*vD.getX(), yorigine+taille*vD.getY());
			//System.out.println("Position 3 "+p3.toString());
			drawEk((int)p4.getX(), (int)p4.getY(), ANGLE, taille/3, k-1, drawingArea);
			
			vD = rotate(vD, ANGLE);
			Point p5 = new Point(xorigine+taille*vD.getX(), yorigine+taille*vD.getY());
			//System.out.println("Position 3 "+p3.toString());
			drawEk((int)p5.getX(), (int)p5.getY(), ANGLE, taille/3, k-1, drawingArea);
			

			drawingArea.drawLine((int)xorigine, (int)yorigine, (int)p1.getX(), (int)p1.getY());
			drawingArea.drawLine((int)xorigine, (int)yorigine, (int)p2.getX(), (int)p2.getY());
			drawingArea.drawLine((int)xorigine, (int)yorigine, (int)p3.getX(), (int)p3.getY());
			drawingArea.drawLine((int)xorigine, (int)yorigine, (int)p4.getX(), (int)p4.getY());
			drawingArea.drawLine((int)xorigine, (int)yorigine, (int)p5.getX(), (int)p5.getY());


		}		
	}
}
