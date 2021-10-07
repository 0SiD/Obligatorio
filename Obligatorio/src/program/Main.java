package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	// Variables.
	
	static Scanner sc = new Scanner(System.in);
	
	// Se crea la lista de usuarios con el usuario administrador.

	static String[] usuarios = {"administrador"};
	static int[] pines = {1234};
	
	static int usuario_actual;
	static int pin_defecto = 1234;
	
	public static void main(String[] args) {
		
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
					
					Funciones.agregar_usuario(nombres.get(numero_aleatorio));			// Se elige un nombre de manera aleatoria.
					Funciones.agregar_pin(aleatorio.nextInt(9999 - 1111) + 0001);		// Se crea un pin de 4 dígitos aleatorio.		
					
					valor_maximo--;
					nombres.remove(numero_aleatorio);
				}
		
		usuario_actual = Funciones.inicar_sesion();
		
		// Place holder.
		
		Utilidades.CambiarPin(pines[usuario_actual]);
		
		System.out.println("\nTabla de usuarios:\n");
		
		for (int i = 0; i < usuarios.length; i++)
			System.out.println("\t %s | %s".formatted(usuarios[i], pines[i]));
		
		
	}	
}
