package program;

import java.util.ArrayList;

public class Main {
	
	static ArrayList<String> users = new ArrayList<>();
	static ArrayList<Integer> pines = new ArrayList<>();
	
	static int pin_defecto = 1234;
	
	public static void main(String[] args) {
		
		// Variables.
		
		users.add("administrador");
		pines.add(1234);
		
		// Place holder.
		
		Utilidades.AdministradorUsuarios();
		
		System.out.println("\nTabla de usuarios:\n");
		
		for (var x: users) 
			System.out.println("\t %s | %s".formatted(x, pines.get(users.indexOf(x))));
		
	}	
}
