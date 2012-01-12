package exo2.Hk;
import java.awt.Color;
import java.awt.Graphics;
import shared.Path;

public class HkSol extends Hk{
	
	/**
	 * Constructeur normal
	 * @param prof
	 */
	public HkSol(int prof) {
		super(prof);
	}

	@Override
	public void drawHk(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, Path entree, Path sortie, int k , 
			Graphics drawingArea) {
			
		// Coordonnées du milieu du carré
		int mx = (x1+x3)/2;
		int my = (y1+y3)/2;
		// Coordonnées du point milieu du côté gauche
		int mgx = (x1+x4)/2;
		int mgy = (y1+y4)/2;
		// Coordonnées du point milieu du côté 
		int mdx = (x2+x3)/2;
		int mdy = (y2+y3)/2;
		// Coordonnées du point milieu du haut
		int mhx = (x1+x2)/2;
		int mhy = (y1+y2)/2;
		// Coordonnées du point milieu du bas
		int mbx = (x3+x4)/2;
		int mby = (y3+y4)/2;
		
		
		// On affiche seulement le dernier niveau de récursion,
		// afin d'éviter d'avoir une supperposition de l'affichage de tous les niveaux
		if(k == 0){
			drawingArea.setColor(Color.red);
			
			switch (entree) {
				case DOWN:
					switch (sortie) {
						case TOP:
							drawingArea.drawLine(mbx, mby, mx, my);
							drawingArea.drawLine(mx, my, mhx, mhy);
							break;
						
						case RIGHT:
							drawingArea.drawLine(mbx, mby, mx, my);
							drawingArea.drawLine(mx, my, mdx, mdy);
						break;

						case LEFT:
							drawingArea.drawLine(mbx, mby, mx, my);
							drawingArea.drawLine(mx, my, mgx, mgy);
							break;
					}
					break;
				case TOP:
					switch (sortie) {
						case DOWN:
							drawingArea.drawLine(mhx, mhy, mx, my);
							drawingArea.drawLine(mx, my, mbx, mby);
							break;

						case MIDDLE:
							drawingArea.drawLine(mhx, mhy, mx, my);
							drawingArea.drawLine(mx, my, mx, my);
							break;

						case RIGHT:
							drawingArea.drawLine(mhx, mhy, mx, my);
							drawingArea.drawLine(mx, my, mdx, mdy);
                            break;

						case LEFT:
							drawingArea.drawLine(mhx, mhy, mx, my);
							drawingArea.drawLine(mx, my, mgx, mgy);
							break;
					}
					break;
				case MIDDLE:
					switch (sortie) {
						case TOP:
							drawingArea.drawLine(mx, my, mx, my);
							drawingArea.drawLine(mx, my, mhx, mhy);
							break;

						case RIGHT:
							drawingArea.drawLine(mx, my, mx, my);
							drawingArea.drawLine(mx, my, mdx, mdy);
						break;
					}
					break;
				case RIGHT:
					switch (sortie) {
						case DOWN:
							drawingArea.drawLine(mdx, mdy, mx, my);
							drawingArea.drawLine(mx, my, mbx, mby);
							break;
						case TOP:
							drawingArea.drawLine(mdx, mdy, mx, my);
							drawingArea.drawLine(mx, my, mhx, mhy);
							break;
						case LEFT:
							drawingArea.drawLine(mdx, mdy, mx, my);
							drawingArea.drawLine(mx, my, mgx, mgy);
							break;
					}
				break;
				case LEFT:
					switch (sortie) {
						case DOWN:
							drawingArea.drawLine(mgx, mgy, mx, my);
							drawingArea.drawLine(mx, my, mbx, mby);
							break;

						case TOP:
							drawingArea.drawLine(mgx, mgy, mx, my);
							drawingArea.drawLine(mx, my, mhx, mhy);
							break;

						case MIDDLE:
							drawingArea.drawLine(mgx, mgy, mx, my);
							drawingArea.drawLine(mx, my, mx, my);
							break;

						case RIGHT:
							drawingArea.drawLine(mgx, mgy, mx, my);
							drawingArea.drawLine(mx, my, mdx, mdy);
						break;
					}
					break;
			}
			return;
		}
			
		
		/*
		 * Celon le type d'entr�e
		 */
		switch (entree) {
			case DOWN:
				switch (sortie) {
					case TOP:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.RIGHT,Path.TOP, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.DOWN,Path.LEFT, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.LEFT,Path.TOP, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.DOWN,Path.RIGHT, k-1, drawingArea);
						
						break;
					case RIGHT:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.DOWN,Path.RIGHT, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.LEFT,Path.DOWN, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.TOP,Path.RIGHT, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.DOWN,Path.TOP, k-1, drawingArea);
					break;
					case LEFT:

						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.RIGHT,Path.LEFT, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.DOWN,Path.LEFT, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.LEFT,Path.TOP, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.DOWN,Path.RIGHT, k-1, drawingArea);
						break;
				}
				break;
			case TOP:
				switch (sortie) {
					case DOWN:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.RIGHT,Path.DOWN, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.TOP,Path.LEFT, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.LEFT,Path.DOWN, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.TOP,Path.RIGHT, k-1, drawingArea);
						break;
					case MIDDLE:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.RIGHT,Path.DOWN, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.TOP,Path.LEFT, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.LEFT,Path.MIDDLE, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.TOP,Path.RIGHT, k-1, drawingArea);
						break;
						
					case RIGHT:

						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.RIGHT,Path.DOWN, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.TOP,Path.LEFT, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.LEFT,Path.RIGHT, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.TOP,Path.RIGHT, k-1, drawingArea);
					break;
					case LEFT:

						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.DOWN,Path.LEFT, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.TOP,Path.DOWN, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.TOP,Path.LEFT, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.RIGHT,Path.TOP, k-1, drawingArea);
						break;
				}
				break;
			case MIDDLE:
				switch (sortie) {
					case TOP:
						
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.RIGHT,Path.TOP, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.DOWN,Path.LEFT, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.LEFT,Path.TOP, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.MIDDLE,Path.RIGHT, k-1, drawingArea);
						break;
					case RIGHT:
						
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.DOWN,Path.RIGHT, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.LEFT,Path.DOWN, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.TOP,Path.RIGHT, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.MIDDLE,Path.TOP, k-1, drawingArea);
					break;
					case MIDDLE:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.DOWN,Path.RIGHT, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.LEFT,Path.DOWN, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.TOP,Path.MIDDLE, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.MIDDLE,Path.TOP, k-1, drawingArea);
					break;
				}
				break;
			case RIGHT:
				switch (sortie) {
					case DOWN:				
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.RIGHT,Path.DOWN, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.RIGHT,Path.LEFT, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.LEFT,Path.DOWN, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.TOP,Path.RIGHT, k-1, drawingArea);
						break;
					case TOP:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.DOWN,Path.TOP, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.RIGHT,Path.DOWN, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.TOP,Path.LEFT, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.RIGHT,Path.TOP, k-1, drawingArea);
						break;
					case LEFT:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.DOWN,Path.LEFT, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.RIGHT,Path.DOWN, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.TOP,Path.LEFT, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.RIGHT,Path.TOP, k-1, drawingArea);
						break;
				}
			break;
			case LEFT:
				switch (sortie) {
					case DOWN:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.DOWN,Path.RIGHT, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.LEFT,Path.DOWN, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.TOP,Path.DOWN, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.LEFT,Path.TOP, k-1, drawingArea);
						break;
					case TOP:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.RIGHT,Path.TOP, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.DOWN,Path.LEFT, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.LEFT,Path.TOP, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.LEFT,Path.RIGHT, k-1, drawingArea);
						
						
						break;
					case MIDDLE:	
						
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.DOWN,Path.RIGHT, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.LEFT,Path.DOWN, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.TOP,Path.MIDDLE, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.LEFT,Path.TOP, k-1, drawingArea);
						
						
						break;
					case RIGHT:

						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,Path.DOWN,Path.RIGHT, k-1, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,Path.LEFT,Path.DOWN, k-1, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,Path.TOP,Path.RIGHT, k-1, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,Path.LEFT,Path.TOP, k-1, drawingArea);
					
					break;
				}
				break;
		}
	}

}
