package exo2;

import java.awt.Graphics;

public class EkSol extends Ek {
	public EkSol(int profondeur) {
		super(profondeur);
	}
	
	private double rotateX(double x, double y, double angle) {
		return x*Math.cos(angle)-y*Math.sin(angle);
	}
	
	private double rotateY(double x, double y, double angle) {
		return x*Math.sin(angle)+y*Math.cos(angle);
	}

	public void drawEk(int xorigine, int yorigine, double angleInitial, int taille, int k, Graphics drawingArea) {
		
		double xDirecteur = rotateX(xorigine, yorigine, angleInitial);
		double yDirecteur = rotateY(xorigine, yorigine, angleInitial);
		double norme = Math.sqrt(xDirecteur*xDirecteur + yDirecteur*yDirecteur);
		
		xDirecteur = xDirecteur/norme;
		yDirecteur = yDirecteur/norme;
		
		
			
		//drawingArea.drawLine(xorigine, yorigine, xorigine+, arg3)
	}		
}
