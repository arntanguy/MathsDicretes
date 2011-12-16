package exo1;

import java.awt.Color;
import java.awt.Graphics;

public class CkSol extends Ck {

	public CkSol(int profondeur) {
		super(profondeur);
	}
	
    /** drawCk 
     *  Produit un dessin recursif de Ck
     * Parametres: 
     *    int   x1 :la coordonnee en x de la premiere extremité
     *    int  y1 : la coordonnee en y de la premiere extremité
     *    int   x2 :la coordonnee en x de la deuxièmee extremité
     *    int  y2 : la coordonnee en y de la deuxième extremité
     *    Graphics drawingArea : L'objet graphique dans lequel Ck est dessiné
     *        drawn 
     * Preconditions : x1,x2 sont compris entre 0 et w; y1 et y2 entre 0 et h;
     * Postcondition : Ck est dessiné
     **/ 
    public void drawCk(int x1, int y1, int x2, int y2, int k ,  Graphics drawingArea)  {
    	if(k>0) {
    	// Longeur de la base
    	double lb = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    	// Longeur du côté (2lc^2 = lb^2 par pythagore)
    	double lc = lb/Math.sqrt(2);
    	// hauteur du rectangle
    	double h = (lb/2)*Math.tan(Math.PI/4);
    	double xdirecteur = (y2-y1);
    	double ydirecteur = -(x2-x1);
    	double coeffNormatif = 1/Math.sqrt(xdirecteur*xdirecteur + ydirecteur*ydirecteur);

    	double xmilieu = (x1+x2)/2;
    	double ymilieu = (y1+y2)/2;
    	int xsommet = (int)(xmilieu + h*coeffNormatif * xdirecteur);
    	int ysommet = (int)(ymilieu + h*coeffNormatif * ydirecteur);
    	
        drawingArea.drawLine(x1, y1, xsommet, ysommet);
    	drawingArea.drawLine(xsommet, ysommet, x2, y2);
    	drawCk(xsommet, ysommet, x2, y2, k-1, drawingArea);
    	drawCk(x1, y1, xsommet, ysommet, k-1, drawingArea);

    	System.out.println("x1: "+x1+"\tx2: "+x2+"\txs: "+xsommet+"\n"+
    			"y1: "+y1+"\ty2: "+y2+"\tysomment: "+ysommet+"\n"+
    			"h: "+h);
    	}
    }
    
}
