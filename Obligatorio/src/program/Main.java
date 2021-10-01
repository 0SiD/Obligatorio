package program;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	// Variables.
	
	static ArrayList<String> usuarios = new ArrayList<>();
	static ArrayList<Integer> pines = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	static int pin_defecto = 1234;
	
	public static void main(String[] args) {
		
		// Se crea el usuario administrador.
		
		usuarios.add("administrador");
		pines.add(pin_defecto);
		
		Funciones.inicar_sesion();
		
		// Place holder.
		
		Utilidades.CrearUsuario();
		Utilidades.CambiarPin(pines.get(0));
		
		System.out.println("\nTabla de usuarios:\n");
		
		for (var x: usuarios) 
			System.out.println("\t %s | %s".formatted(x, pines.get(usuarios.indexOf(x))));
		
		
	}	
}
