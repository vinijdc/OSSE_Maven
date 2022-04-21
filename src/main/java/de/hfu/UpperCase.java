package de.hfu;
import java.util.Scanner;

/**
 * Dieses Programm konvertiert Kleinbuchstaben in Großbuchstaben
 * 
 * @author vinij
 *
 */


public class UpperCase {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){
		    System.out.println("Bitte geben Sie einen Text in Kleinbuchstaben ein:");
		    String text = scanner.nextLine();
		    text = text.toUpperCase();
		    System.out.println(text);
		}
	}
}