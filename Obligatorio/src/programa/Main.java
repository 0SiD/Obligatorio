package programa;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	// Variables.
	
	static Scanner sc = new Scanner(System.in);
	static int pin_defecto = 1234;
	static int usuario_actual;

	// Se crea el array de usuarios con el usuario administrador, además de el de las contraseñas.
	
	static String[] usuarios = {"administrador"};
	static int[] pines = {pin_defecto};
	static int[] fondos = {-1};
	
	
	public static void main(String[] args) {
		
		// Se crea otro array y se le añaden los posibles nombres de los usuarios.
		
		String[] nombres = {"juan", "pablo", "ana", "luis", "sofia", "antonella", "rosario", "josé"};
				
		// Se inicializan las variables.
				
		Random aleatorio = new Random();
		int valor_maximo = nombres.length;
		int numero_aleatorio;
				
		// Se itera este pedazo de código por la cantidad de usuarios deseados.
		
		for (int i = 0; i < 5; i++) {
			numero_aleatorio = aleatorio.nextInt(valor_maximo - 0) + 0;		// Se genera un número aleatorio y se guarda en una variable.
					
			Funciones.agregar_usuario(nombres[numero_aleatorio]);								// Se busca el nombre al cual equivalga variable.
			pines = Funciones.agregar_entero_arreglo(pines, aleatorio.nextInt(9999 - 1111) + 1111);		// Se crea un pin aleatorio.
			fondos = Funciones.agregar_entero_arreglo(fondos, 0);
			
			// Estos dos datos anteriores se añaden a sus listas correspondientes con sus respectivas funciones.
			
			/* El siguiente trozo de código se encarga de reducir en 1 el mayor valor posible que puede salir en el numero_aleatorio 
			   ya que un nombre del arreglo fue seleccionado.
			   
			   Además saca este nombre del arreglo y lo reordena para que no quede un espacio vacío. */
			
			valor_maximo--;
			Funciones.remover(nombres, numero_aleatorio);
		}
		
		usuario_actual = Funciones.inicar_sesion();
		Menus.MenuUsuario();
		
		// Place holder.
		
		Funciones.tablas();
		
	}	
}
