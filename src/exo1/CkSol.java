package exo1;

import java.awt.Color;
import java.awt.Graphics;

public class CkSol extends Ck {

	public CkSol(int profondeur) {
		super(profondeur);
	    setBackground (Color.white); // Le fond est blanc

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
    	
    }
}
