package mymath;

public class Point {
	private double xPos;
	private double yPos;

	public Point() {
		xPos = 0;
		yPos = 0;
	}

	public Point(double x, double y) {
		xPos = x;
		yPos = y;
	}
	public double getX() {
		return xPos;
	}
	public double getY() {
		return yPos;
	}
	public void setPos(double x, double y) {   
		xPos = x;
		yPos = y;
	}
	public void setX(double x) {
		xPos = x;
	}
	public void setY(double y) {
		yPos = y;
	}
	public void deplacer(double x, double y) {
		xPos += x;
		yPos += y;
	}

	public String toString() {
		return "X: "+xPos+"\tY: "+yPos;
	}
}
