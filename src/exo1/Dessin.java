//Fichier Dessin.java
//
package exo1;

import java.awt.*;                    //Pour Graphics et Frame
import java.awt.event.WindowAdapter;  //Pour pouvoir fermer
import java.awt.event.WindowEvent;    //Pour fermer

public class Dessin  extends Frame {
  static final int WIDTH = 1000;       // Taille initiale de la Frame
  static final int HEIGHT = 1200;
 

  public static void main(String args[]) {
    Dessin t = new Dessin();
    t.setSize(WIDTH, HEIGHT);
    t.setVisible(true);
    t.setBackground (Color.white); // Le fond est blanc
  }

  public Dessin () {
  
    addWindowListener(new WindowHandler());  // pour pouvoir fermer
    setTitle("Exemple de dessin temporis�");
 }

  private class WindowHandler extends WindowAdapter {
    public void windowClosing(WindowEvent e) {System.exit(0);}
  }

   public void paint(Graphics g)
   {
    int frameHeight = getSize().height; // dimension du frame avec les bords
    int frameWidth = getSize().width; 
    int h = frameHeight-200 ;  //  On va travailler dans un rectangle de hauteur h
    int w = frameWidth -50;  //    et de largeur w 

   

		monDessin(w,h,g);// dessin de l'arbre
	
	    }
   
/**  monDessin
* dessine un dessin centre en (w,h) de largeur w/2 et de hauteur h/2. 
* Attention le point (0,0) est en haut et a gauche et non en bas � droite comme dans les syst�mes de coordonn�es habituels

**/ 
public static void dessinTemporise(int w, int h, Graphics drawingArea) throws InterruptedException{

	drawingArea.setColor (Color.red);// je dessine en rouge la ligne du haut
	Thread.sleep(500); //temporisation de 500 ms pour voir l'ordre dans lequel les segments sont dessin�s
	drawingArea.drawLine (w/4,h/4,(3*w)/4,h/4);
	drawingArea.setColor (Color.green);// je dessine en vert la ligne du bas
	Thread.sleep(500); //temporisation pour voir l'ordre dans lequel les segments sont dessin�s
	drawingArea.drawLine (w/4,(3*h)/4,(3*w)/4,(3*h)/4);
	drawingArea.setColor (Color.blue);// je dessine en bleu la ligne de gauche
	Thread.sleep(500); //temporisation pour voir l'ordre dans lequel les segments sont dessin�s
	drawingArea.drawLine (w/4,h/4,w/4,(3*h)/4);
	drawingArea.setColor (Color.black);// je dessine en cyan la ligne de droite
	Thread.sleep(500); //temporisation pour voir l'ordre dans lequel les segments sont dessin�s
	drawingArea.drawLine ((3*w)/4,h/4,(3*w)/4,(3*h)/4);
	Thread.sleep(500);
	drawingArea.drawString(" dessin termin�", w/2,h/2);
	

                             
		
		 

}

public static void monDessin(int w, int h, Graphics drawingArea ) {

	try {dessinTemporise(w,h,drawingArea);}
	catch (InterruptedException e) {return; }
		 

}

      
  
 

}

