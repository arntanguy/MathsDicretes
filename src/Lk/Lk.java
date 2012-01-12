package Lk;



import java.awt.*;                    // Pour  Graphics, Frame
import java.awt.event.WindowAdapter;  // Pour fermer
import java.awt.event.WindowEvent;    // Pour fermer

/**
 * Ck
 *
 * @author 
 * @version 1.0
 */
public abstract class Lk extends Frame {
  static final int WIDTH = 800;       // taille initiale de la frame 
  static final int HEIGHT = 800;
  protected int profondeur;

 

    /**
     * Creation de Ck.
     *
     * @param prof nombre d'itérations
     */
    public Lk (int prof) {
    	this.setSize(WIDTH, HEIGHT);
   	this.setVisible(true);
    	this.setBackground (Color.black);
	this.profondeur=prof;
   	addWindowListener(new WindowHandler());  // pour fermer
   	setTitle("Exo1");
 }


  private class WindowHandler extends WindowAdapter {
    public void windowClosing(WindowEvent e) {System.exit(0);}
  }

   public void paint(Graphics g)
   {
    int frameHeight = getSize().height; // taille du frame, cette fois avec lesbvordures
    int frameWidth = getSize().width;   
    
    int h = frameHeight-50 ;  //   pour que Ck tienne dans 
    int w = frameWidth -50;  //     le frame
    
    int rootX = frameWidth/2; // recherche du centre
    int rootY = frameHeight/2;   //
    
    g.setColor(Color.yellow);  // La couleur avec laquelle on va dessiner
  
    drawHk(w/4, h/4, (3*w)/4, h/4, 3*w/4, 3*h/4, w/4,3*h/4, chem.milieu, chem.milieu,profondeur, g);
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
    public abstract void drawHk(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, chem entree, chem sortie, int k ,
				 Graphics drawingArea) ;
}
      
  

  

