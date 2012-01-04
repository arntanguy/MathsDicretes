package exo2;

import java.awt.Graphics;

import mymath.Point;

public class HkSol extends Hk {
	public HkSol(int profondeur) {
		super(profondeur);
	}

	public void drawHk(int xc, int yc, int cote, Orientation orientation, int k, Graphics drawingArea) {
		if(k>0) {
			// Calcul de la position du centre des sous carrés
			int demiCote = cote/2;
			int xc1 = xc - demiCote;
			int yc1 = yc + demiCote;
			int xc2 = xc - demiCote;
			int yc2 = yc - demiCote;
			int xc3 = xc + demiCote;
			int yc3 = yc - demiCote;
			int xc4 = xc + demiCote;
			int yc4 = yc + demiCote;
			
			if(k==1) {
				switch(orientation) {
				case H:
					System.out.println("haut");
					drawingArea.drawLine(xc1,yc1, xc2,yc2);
					drawingArea.drawLine(xc2,yc2, xc3,yc3);
					drawingArea.drawLine(xc3,yc3, xc4,yc4);
					break;
				case B:
					drawingArea.drawLine(xc1, yc1, xc2, yc2);
					drawingArea.drawLine(xc1, yc1, xc4, yc4);
					drawingArea.drawLine(xc4, yc4, xc3, yc3);
					break;
				case G:
					drawingArea.drawLine(xc1,yc1, xc2,yc2);
					drawingArea.drawLine(xc2,yc2, xc3,yc3);
					drawingArea.drawLine(xc1,yc1, xc4,yc4);
					break;
				case D:
					drawingArea.drawLine(xc4,yc4, xc3,yc3);
					drawingArea.drawLine(xc2,yc2, xc3,yc3);
					drawingArea.drawLine(xc1,yc1, xc4,yc4);
					break;
				}
			}
			switch (orientation) {
			case H:
				drawHk(xc1, yc1, demiCote, Orientation.D, k-1, drawingArea);
				drawHk(xc2, yc2, demiCote, Orientation.H, k-1, drawingArea);
				drawHk(xc3, yc3, demiCote, Orientation.H, k-1, drawingArea);
				drawHk(xc4, yc4, demiCote, Orientation.G, k-1, drawingArea);
				break;
			case D:
				drawHk(xc1, yc1, demiCote, Orientation.H, k-1, drawingArea);
				drawHk(xc2, yc2, demiCote, Orientation.B, k-1, drawingArea);
				drawHk(xc3, yc3, demiCote, Orientation.D, k-1, drawingArea);
				drawHk(xc4, yc4, demiCote, Orientation.D, k-1, drawingArea);
				break;
			case G:
				drawHk(xc1, yc1, demiCote, Orientation.G, k-1, drawingArea);
				drawHk(xc2, yc2, demiCote, Orientation.G, k-1, drawingArea);
				drawHk(xc3, yc3, demiCote, Orientation.B, k-1, drawingArea);
				drawHk(xc4, yc4, demiCote, Orientation.H, k-1, drawingArea);
				break;
			case B:
				drawHk(xc1, yc1, demiCote, Orientation.B, k-1, drawingArea);
				drawHk(xc2, yc2, demiCote, Orientation.D, k-1, drawingArea);
				drawHk(xc3, yc3, demiCote, Orientation.G, k-1, drawingArea);
				drawHk(xc4, yc4, demiCote, Orientation.B, k-1, drawingArea);
				break;

			}

		}
	}
}
