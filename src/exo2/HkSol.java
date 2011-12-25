package exo2;

import java.awt.Graphics;

import mymath.Point;

public class HkSol extends Hk {
	public HkSol(int profondeur) {
		super(profondeur);
	}

	public void drawHk(int xc, int yc, int cote, int k,	Graphics drawingArea) {
		if(k>0) {
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
				drawingArea.drawLine(xc1, yc1, xc2, yc2);
				drawingArea.drawLine(xc2, yc2, xc3, yc3);
				drawingArea.drawLine(xc3, yc3, xc4, yc4);
			}
			drawHk(xc1, yc1, demiCote, k-1, drawingArea);
			drawHk(xc2, yc2, demiCote, k-1, drawingArea);
			drawHk(xc3, yc3, demiCote, k-1, drawingArea);
			drawHk(xc4, yc4, demiCote, k-1, drawingArea);

		}
	}
}
