package exo2;

import java.util.Scanner;			     

/**
 *
 * @author 
 * @version 1.0
 */
public class EkTest {


	/**
	 * Dessin de Ck
	 *
	 */
	public static void main(String[] args) {
		System.out.println(" dessin de C recursifs");
		System.out.println("saisir un entier, pour la  profondeur de recursion?");
		Scanner sc = new Scanner(System.in);
		int profondeur = sc.nextInt();

		EkSol t = new EkSol(profondeur); 
	}

}

