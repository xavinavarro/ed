package org.institutoserpis.ed;

import java.util.Scanner;

public class HolaMundo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nombre = scanner.nextLine();
		System.out.printf("Hola %s desde eclipse",nombre);
	}
}