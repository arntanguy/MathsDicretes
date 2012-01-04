package exo2;

import java.awt.Graphics;

import mymath.Point;

public class HkSol extends Hk {
	public HkSol(int profondeur) {
		super(profondeur);
	}

	/**
	 * 
	 * @param xc
	 * @param yc
	 * @param cote
	 * @param orientation
	 * @param k
	 * @param drawingArea
	 */
	public void drawHk(int xc, int yc, int cote, Orientation orientation, int numCarre, int k, Graphics drawingArea) {
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
					switch (numCarre) {
					case 1:
						drawingArea.drawLine(xc4,yc4, xc4+demiCote,yc4);
						break;
					case 2:
						drawingArea.drawLine(xc4,yc4, xc4+demiCote,yc4);
						drawingArea.drawLine(xc1, yc1, xc1, yc1+demiCote);
						break;
					case 3:
						drawingArea.drawLine(xc1, yc1, xc1-demiCote, yc1);
						drawingArea.drawLine(xc4, yc4, xc4, yc4+demiCote);
						break;
					case 4:
						drawingArea.drawLine(xc1, yc1, xc1-demiCote, yc1);
						break;

					}
					break;
				case B:
					drawingArea.drawLine(xc1, yc1, xc2, yc2);
					drawingArea.drawLine(xc1, yc1, xc4, yc4);
					drawingArea.drawLine(xc4, yc4, xc3, yc3);
					switch (numCarre) {
					case 1:
						drawingArea.drawLine(xc2,yc2, xc2,yc2+demiCote);
						drawingArea.drawLine(xc3, yc3, xc3, yc3+demiCote);
						break;
					case 2:
						drawingArea.drawLine(xc3, yc3, xc3+demiCote, yc3);
						break;
					case 3:
						drawingArea.drawLine(xc2, yc2, xc2-demiCote, yc2);
						break;
					case 4:
						drawingArea.drawLine(xc3, yc3, xc3, yc3+demiCote);
						break;

					}
					break;
				case G:
					drawingArea.drawLine(xc1,yc1, xc2,yc2);
					drawingArea.drawLine(xc2,yc2, xc3,yc3);
					drawingArea.drawLine(xc1,yc1, xc4,yc4);
					switch (numCarre) {
					case 1:
						drawingArea.drawLine(xc4, yc4, xc4+demiCote, yc4);
						drawingArea.drawLine(xc3, yc3, xc3, yc3-demiCote);
						break;
					case 2:
						drawingArea.drawLine(xc3, yc3, xc3+demiCote, yc3);
						drawingArea.drawLine(xc4, yc4, xc4, yc4+demiCote);
						break;
					
					case 4:
						drawingArea.drawLine(xc3, yc3, xc3, yc3-demiCote);
						break;

					}
					break;
				case D:
					drawingArea.drawLine(xc4,yc4, xc3,yc3);
					drawingArea.drawLine(xc2,yc2, xc3,yc3);
					drawingArea.drawLine(xc1,yc1, xc4,yc4);
					switch (numCarre) {
					case 1:
						drawingArea.drawLine(xc2, yc2, xc2, yc2-demiCote);
						break;
					case 3:
						drawingArea.drawLine(xc2, yc2, xc2-demiCote, yc2);
						drawingArea.drawLine(xc1, yc1, xc1, yc1+demiCote);
						break;
					case 4:
						drawingArea.drawLine(xc2, yc2, xc2, yc2-demiCote);
						drawingArea.drawLine(xc1, yc1, xc1-demiCote, yc1);
						break;

					}
					break;
				}
			}
			switch (orientation) {
			case H:
				drawHk(xc1, yc1, demiCote, Orientation.D, 1, k-1, drawingArea);
				drawHk(xc2, yc2, demiCote, Orientation.H, 2, k-1, drawingArea);
				drawHk(xc3, yc3, demiCote, Orientation.H, 3, k-1, drawingArea);
				drawHk(xc4, yc4, demiCote, Orientation.G, 4, k-1, drawingArea);
				break;
			case D:
				drawHk(xc1, yc1, demiCote, Orientation.H, 1, k-1, drawingArea);
				drawHk(xc2, yc2, demiCote, Orientation.B, 2, k-1, drawingArea);
				drawHk(xc3, yc3, demiCote, Orientation.D, 3, k-1, drawingArea);
				drawHk(xc4, yc4, demiCote, Orientation.D, 4, k-1, drawingArea);
				break;
			case G:
				drawHk(xc1, yc1, demiCote, Orientation.G, 1, k-1, drawingArea);
				drawHk(xc2, yc2, demiCote, Orientation.G, 2, k-1, drawingArea);
				drawHk(xc3, yc3, demiCote, Orientation.B, 3, k-1, drawingArea);
				drawHk(xc4, yc4, demiCote, Orientation.H, 4, k-1, drawingArea);
				break;
			case B:
				drawHk(xc1, yc1, demiCote, Orientation.B, 1, k-1, drawingArea);
				drawHk(xc2, yc2, demiCote, Orientation.D, 2, k-1, drawingArea);
				drawHk(xc3, yc3, demiCote, Orientation.G, 3, k-1, drawingArea);
				drawHk(xc4, yc4, demiCote, Orientation.B, 4, k-1, drawingArea);
				break;

			}

		}
	}
}
