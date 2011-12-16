package exo2;


import java.awt.*;                    // Pour  Graphics, Frame
import java.awt.event.WindowAdapter;  // Pour fermer
import java.awt.event.WindowEvent;    // Pour fermer

/**
 * Ck
 *
 * @author 
 * @version 1.0
 */
public abstract class Ek extends Frame {
	static final int WIDTH = 800;       // taille initiale de la frame 
	static final int HEIGHT = 1200;
	protected int profondeur;


	/**
	 * Creation de Ck.
	 *
	 * @param prof nombre d'itérations
	 */
	public Ek (int prof) {
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
		System.out.println("Call");
		int frameHeight = getSize().height; // taille du frame, cette fois avec lesbvordures
		int frameWidth = getSize().width;   
		int h = frameHeight-50 ;  //   pour que Ck tienne dans 
		int w = frameWidth -50;  //     le frame
		int rootX = frameWidth/2; // recherche du centre
		int rootY = frameHeight/2;   //
		g.setColor(Color.yellow);  // La couleur avec laquelle on va dessiner
		
		drawEk(w/2, h/2, 0, w/4, profondeur, g); 
	}

	public abstract void drawEk(int xorigine, int yorigine, double angle, int taille, int k, Graphics drawingArea);

}


