package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
		
		// Se crea una lista y se le añaden los posibles nombres de los usuarios.
		
		List<String> nombres = new ArrayList<String>();
		nombres.addAll(Arrays.asList("juan", "pablo", "ana", "luis", "sofia", "antonella", "rosario", "josé"));
		
		// Se inicializan las variables.
		
		Random aleatorio = new Random();
		int valor_maximo = nombres.size();
		int numero_aleatorio;
		
		// Se itera este pedazo de código por la cantidad de usuarios deseados.
		
		for (int i = 0; i < 5; i++) {
			numero_aleatorio = aleatorio.nextInt(valor_maximo - 0) + 0;
			
			usuarios.add(nombres.get(numero_aleatorio));				// Se elige un nombre de manera aleatoria.
			pines.add(aleatorio.nextInt(9999 - 1111) + 0001);			// Se crea un pin de 4 dígitos aleatorio.
			
			valor_maximo--;
			nombres.remove(numero_aleatorio);
		}
		
		Funciones.inicar_sesion();
		
		// Place holder.
		
		Utilidades.CrearUsuario();
		Utilidades.CambiarPin(pines.get(0));
		
		System.out.println("\nTabla de usuarios:\n");
		
		for (var x: usuarios) 
			System.out.println("\t %s | %s".formatted(x, pines.get(usuarios.indexOf(x))));
		
		
	}	
}
