package Hk;
import java.awt.Color;
import java.awt.Graphics;


public class HkSol extends Hk{

	public static int compteur = 0;
	
	/**
	 * Constructeur normal
	 * @param prof
	 */
	public HkSol(int prof) {
		super(prof);
	}

	@Override
	public void drawHk(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, chem entree, chem sortie, int k , 
			Graphics drawingArea) {
			
		/*
		 * Calculer les coordonn�e du point milieu du carr�
		 */
		int mx = (x1+x3)/2;
		int my = (y1+y3)/2;
		
		/*
		 * Calcul du point milieu du cot� gauche
		 */
		int mgx = (x1+x4)/2;
		int mgy = (y1+y4)/2;
		
		/*
		 * Calcul du point milieu du cot� haut
		 */
		int mhx = (x1+x2)/2;
		int mhy = (y1+y2)/2;
		
		/*
		 * Calcul du point milieu du cot� droit
		 */
		int mdx = (x2+x3)/2;
		int mdy = (y2+y3)/2;
		
		/*
		 * Calcul du point milieu du cot� droit
		 */
		int mbx = (x3+x4)/2;
		int mby = (y3+y4)/2;
		
		
		/*
		 * Mettre en place le condition d'arret
		 * Lorsque le compteur arrive � 0
		 * 
		 */
		if(k == 0){
			/**
			 * Definir la couleur des traits
			 */
			drawingArea.setColor(Color.red);
			
			/*
			 * Celon le type d'entr�e
			 */
			switch (entree) {
				case bas:
					switch (sortie) {
						case haut:
							
							drawingArea.drawLine(mbx, mby, mx, my);
							drawingArea.drawLine(mx, my, mhx, mhy);
						
							
							break;
						case droite:
							
							drawingArea.drawLine(mbx, mby, mx, my);
							drawingArea.drawLine(mx, my, mdx, mdy);
						
						break;
						case gauche:
							
							drawingArea.drawLine(mbx, mby, mx, my);
							drawingArea.drawLine(mx, my, mgx, mgy);
						
							break;
					}
					break;
				case haut:
					switch (sortie) {
						case bas:
							
							drawingArea.drawLine(mhx, mhy, mx, my);
							drawingArea.drawLine(mx, my, mbx, mby);
						
							break;
						case milieu:
							
							drawingArea.drawLine(mhx, mhy, mx, my);
							drawingArea.drawLine(mx, my, mx, my);
						
							break;
						case droite:
							
							drawingArea.drawLine(mhx, mhy, mx, my);
							drawingArea.drawLine(mx, my, mdx, mdy);
						
						break;
						case gauche:
							
							drawingArea.drawLine(mhx, mhy, mx, my);
							drawingArea.drawLine(mx, my, mgx, mgy);
						
							break;
					}
					break;
				case milieu:
					switch (sortie) {
						case haut:
							
							drawingArea.drawLine(mx, my, mx, my);
							drawingArea.drawLine(mx, my, mhx, mhy);
						
							break;
						case droite:
							
							drawingArea.drawLine(mx, my, mx, my);
							drawingArea.drawLine(mx, my, mdx, mdy);
						
						break;
					}
					break;
				case droite:
					switch (sortie) {
						case bas:
							
							drawingArea.drawLine(mdx, mdy, mx, my);
							drawingArea.drawLine(mx, my, mbx, mby);
						
							break;
						case haut:
							
							drawingArea.drawLine(mdx, mdy, mx, my);
							drawingArea.drawLine(mx, my, mhx, mhy);
						
							break;
						case gauche:
							
							drawingArea.drawLine(mdx, mdy, mx, my);
							drawingArea.drawLine(mx, my, mgx, mgy);
						
							break;
					}
				break;
				case gauche:
					switch (sortie) {
						case bas:
							
							drawingArea.drawLine(mgx, mgy, mx, my);
							drawingArea.drawLine(mx, my, mbx, mby);
						
							break;
						case haut:
							
							drawingArea.drawLine(mgx, mgy, mx, my);
							drawingArea.drawLine(mx, my, mhx, mhy);
						
							break;
						case milieu:
							
							drawingArea.drawLine(mgx, mgy, mx, my);
							drawingArea.drawLine(mx, my, mx, my);
						
							break;
						case droite:
							
							drawingArea.drawLine(mgx, mgy, mx, my);
							drawingArea.drawLine(mx, my, mdx, mdy);
						
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
		 * Celon le type d'entr�e
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
