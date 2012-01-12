package Lk;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.text.AbstractDocument.BranchElement;


public class LkSol extends Lk{
	
	/**
	 * Constructeur normal
	 * @param prof
	 */
	public LkSol(int prof) {
		super(prof);
	}

	@Override
	public void drawHk(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, chem entree, chem sortie, int k , 
			Graphics drawingArea) {
			
		/*
		 * Calculer les coordonnée du point milieu du carré
		 */
		int mx = (x1+x3)/2;
		int my = (y1+y3)/2;
		
		/*
		 * Calcul du point milieu du coté gauche
		 */
		int mgx = (x1+x4)/2;
		int mgy = (y1+y4)/2;
		
		/*
		 * Calcul du point milieu du coté haut
		 */
		int mhx = (x1+x2)/2;
		int mhy = (y1+y2)/2;
		
		/*
		 * Calcul du point milieu du coté droit
		 */
		int mdx = (x2+x3)/2;
		int mdy = (y2+y3)/2;
		
		/*
		 * Calcul du point milieu du coté droit
		 */
		int mbx = (x3+x4)/2;
		int mby = (y3+y4)/2;
		
		
		/*
		 * Mettre en place le condition d'arret
		 * Lorsque le compteur arrive à 0
		 * Alors on effectue tous les affichages necessaires
		 * 
		 */
		if(k == 0){
			
			/**
			 * Definir la couleur des carrés
			 */
			drawingArea.setColor(Color.white);
			
			drawingArea.drawLine(x1, y1, x2, y2);
			drawingArea.drawLine(x2, y2, x3, y3);
			drawingArea.drawLine(x3, y3, x4, y4);
			drawingArea.drawLine(x4, y4, x1, y1);
			
			/**
			 * Definir la couleur des traits
			 */
			drawingArea.setColor(Color.red);
			
			/*
			 * Celon le type d'entrée
			 */
			switch (entree) {
				case bas:
					switch (sortie) {
						case haut:
							
							drawingArea.drawLine(x1, y1, x4, y4);
							
							break;
						case droite:
							
							drawingArea.drawLine(x1, y1, x4, y4);
							drawingArea.drawLine(x1, y1, x2, y2);
						
						break;
						case gauche:

							drawingArea.drawLine(x1, y1, x2, y2);
							drawingArea.drawLine(x2, y2, x3, y3);
							
							break;
					}
					break;
				case haut:
					switch (sortie) {
						case bas:
							
							drawingArea.drawLine(x2, y2, x3, y3);

							break;
						case milieu:
							
							drawingArea.drawLine(x1, y1, x4, y4);
							drawingArea.drawLine(x2, y2, x3, y3);
						
							break;
						case droite:
							
							drawingArea.drawLine(x1, y1, x4, y4);
							drawingArea.drawLine(x4, y4, x3, y3);
						
						break;
						case gauche:
							
							drawingArea.drawLine(x2, y2, x3, y3);
							drawingArea.drawLine(x3, y3, x4, y4);
						
							break;
					}
					break;
				case milieu:
					switch (sortie) {
						case haut:
							
							drawingArea.drawLine(x1, y1, x4, y4);
							drawingArea.drawLine(x2, y2, x3, y3);
						
							break;
						case droite:
							
							drawingArea.drawLine(x4, y4, x3, y3);
							drawingArea.drawLine(x1, y1, x2, y2);
						
						break;
						case milieu:
							drawingArea.drawLine(x4, y4, x3, y3);
							drawingArea.drawLine(x1, y1, x2, y2);
						
						break;
					}
					break;
				case droite:
					switch (sortie) {
						case bas:
							
							drawingArea.drawLine(x1, y1, x2, y2);
							drawingArea.drawLine(x1, y1, x4, y4);
						
							break;
						case haut:
							
							drawingArea.drawLine(x3, y3, x4, y4);
							drawingArea.drawLine(x1, y1, x4, y4);
						
							break;
						case gauche:
							
							drawingArea.drawLine(x1, y1, x2, y2);
						
							break;
					}
				break;
				case gauche:
					switch (sortie) {
						case bas:
							
							drawingArea.drawLine(x2, y2, x3, y3);
							drawingArea.drawLine(x1, y1, x2, y2);
						
							break;
						case haut:
							
							drawingArea.drawLine(x4, y4, x3, y3);
							drawingArea.drawLine(x3, y3, x2, y2);
						
							break;
						case milieu:
							
							drawingArea.drawLine(x4, y4, x3, y3);
							drawingArea.drawLine(x1, y1, x2, y2);
						
							break;
						case droite:
							
							drawingArea.drawLine(x4, y4, x3, y3);
						
						break;
					}
					break;
			}
			
			return;
		}
		
		/*
		 * Decrementer le compteur pour la prochaine iteration
		 */
		k--;
			
		
		/*
		 * Celon le type d'entrée
		 */
		switch (entree) {
			case bas:
				switch (sortie) {
					case haut:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.droite,chem.haut, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.bas,chem.gauche, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.gauche,chem.haut, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.bas,chem.droite, k, drawingArea);
						
						break;
					case droite:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.bas,chem.droite, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.gauche,chem.bas, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.haut,chem.droite, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.bas,chem.haut, k, drawingArea);
					break;
					case gauche:

						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.droite,chem.gauche, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.bas,chem.gauche, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.gauche,chem.haut, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.bas,chem.droite, k, drawingArea);
						break;
				}
				break;
			case haut:
				switch (sortie) {
					case bas:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.droite,chem.bas, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.haut,chem.gauche, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.gauche,chem.bas, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.haut,chem.droite, k, drawingArea);
						break;
					case milieu:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.droite,chem.bas, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.haut,chem.gauche, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.gauche,chem.milieu, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.haut,chem.droite, k, drawingArea);
						break;
						
					case droite:

						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.droite,chem.bas, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.haut,chem.gauche, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.gauche,chem.droite, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.haut,chem.droite, k, drawingArea);
					break;
					case gauche:

						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.bas,chem.gauche, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.haut,chem.bas, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.haut,chem.gauche, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.droite,chem.haut, k, drawingArea);
						break;
				}
				break;
			case milieu:
				switch (sortie) {
					case haut:
						
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.droite,chem.haut, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.bas,chem.gauche, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.gauche,chem.haut, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.milieu,chem.droite, k, drawingArea);
						break;
					case droite:
						
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.bas,chem.droite, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.gauche,chem.bas, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.haut,chem.droite, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.milieu,chem.haut, k, drawingArea);
					break;
					case milieu:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.bas,chem.droite, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.gauche,chem.bas, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.haut,chem.milieu, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.milieu,chem.haut, k, drawingArea);
					break;
				}
				break;
			case droite:
				switch (sortie) {
					case bas:				
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.droite,chem.bas, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.droite,chem.gauche, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.gauche,chem.bas, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.haut,chem.droite, k, drawingArea);
						break;
					case haut:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.bas,chem.haut, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.droite,chem.bas, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.haut,chem.gauche, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.droite,chem.haut, k, drawingArea);
						break;
					case gauche:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.bas,chem.gauche, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.droite,chem.bas, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.haut,chem.gauche, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.droite,chem.haut, k, drawingArea);
						break;
				}
			break;
			case gauche:
				switch (sortie) {
					case bas:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.bas,chem.droite, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.gauche,chem.bas, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.haut,chem.bas, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.gauche,chem.haut, k, drawingArea);
						break;
					case haut:
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.droite,chem.haut, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.bas,chem.gauche, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.gauche,chem.haut, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.gauche,chem.droite, k, drawingArea);
						
						
						break;
					case milieu:	
						
						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.bas,chem.droite, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.gauche,chem.bas, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.haut,chem.milieu, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.gauche,chem.haut, k, drawingArea);
						
						
						break;
					case droite:

						//HautGauche
						drawHk(x1, y1, mhx, mhy, mx, my, mgx, mgy,chem.bas,chem.droite, k, drawingArea);
						
						//HautDroit
						drawHk(mhx, mhy, x2, y2, mdx, mdy, mx, my,chem.gauche,chem.bas, k, drawingArea);
						
						//Bas droit
						drawHk(mx, my, mdx, mdy, x3, y3, mbx, mby,chem.haut,chem.droite, k, drawingArea);
						
						//Bas gauche
						drawHk(mgx, mgy, mx, my, mbx, mby, x4, y4,chem.gauche,chem.haut, k, drawingArea);
					
					break;
				}
				break;
		}
	}

}
