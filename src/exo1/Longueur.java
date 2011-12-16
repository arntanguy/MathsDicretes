package exo1;

public class Longueur {

	private static double calculLong (double base, int nbFois, int puis) {
		if (nbFois == 0) return base * puis;
		return calculLong(base / Math.sqrt(2.0), nbFois - 1, 2*puis);
	}
	
	public static double Long (double base, int nbFois) {
		return calculLong (base, nbFois, 1);
	}
	
}
