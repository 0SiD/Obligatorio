package program;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<String> users = new ArrayList<>();
	static ArrayList<Integer> pines = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	static int pin_defecto = 1234;
	
	public static void main(String[] args) {
		
		// Variables.
		
		users.add("administrador");
		pines.add(1234);
		
		// Place holder.
		
		Utilidades.AdministradorUsuarios();
		Utilidades.CambiarPin(pines.get(0));
		
		System.out.println("\nTabla de usuarios:\n");
		
		for (var x: users) 
			System.out.println("\t %s | %s".formatted(x, pines.get(users.indexOf(x))));
		
		
	}	
}
