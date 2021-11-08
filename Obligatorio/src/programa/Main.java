package programa;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	// Variables.
	
	static Scanner sc = new Scanner(System.in);
	static int pin_defecto = 1234;
	static int usuario_actual;

	// Se crea el array de usuarios, fondos y pines, con el usuario administrador, adem�s de su pin y sus fondos.
	
	static String[] usuarios = {"administrador"};
	static int[] pines = {pin_defecto};
	static int[] fondos = {-1};
	
	
	public static void main(String[] args) {
		
		// Se crea otro array y se le a�aden los posibles nombres para los usuarios por defecto.
		
		String[] nombres = {"juan", "pablo", "ana", "luis", "sofia", "antonella", "rosario", "jose"};
				
		// Se inicializan las variables.
				
		Random aleatorio = new Random();
		int valor_maximo = nombres.length;
		int numero_aleatorio;
				
		// Se itera este pedazo de c�digo por la cantidad de usuarios deseados.
		
		for (int i = 0; i < 5; i++) {
			numero_aleatorio = aleatorio.nextInt(valor_maximo - 0) + 0;		// Se genera un n�mero aleatorio y se guarda en una variable.
					
			Funciones.agregar_usuario(nombres[numero_aleatorio]);										// Se busca el nombre al cual equivalga variable.
			pines = Funciones.agregar_entero_arreglo(pines, pin_defecto);								// con el pin por defecto.
			fondos = Funciones.agregar_entero_arreglo(fondos, 0);
			
			// Estos tres datos anteriores se a�aden a sus listas correspondientes con sus respectivas funciones.
			
			
			/* El siguiente trozo de c�digo se encarga de reducir en 1 el valor de posibles usuarios que puede salir en el numero_aleatorio 
			   ya que un nombre del arreglo fue seleccionado.
			   
			   Adem�s saca este nombre del arreglo (con la funci�n remover). */
			
			valor_maximo--;
			Funciones.remover(nombres, numero_aleatorio);
		}
		
		// Esto ya es el bucle que se encarga de la ejeuci�n del programa.
		
		boolean en_ejecucion = true; // Se usa como bandera la variable "en_ejecucion" que tiene valor verdadero y cuando quiera salir se cambia el valor a falso.
		
		do {
			usuario_actual = Funciones.inicar_sesion(); // Esta funci�n se encarga de que el usuario inicie sesi�n y declara el la variable el n�mero de usuario.
			
			// El siguente fragmento de c�digo se encarga de que el usuario cambie su pin.
			System.out.println("Usted est� usando el pin por defecto por favor cree uno nuevo.");
			while(Main.pines[Main.usuario_actual] == 1234) {
				UtilidadesUsuario.CambiarPin();
			}
			System.out.println();
			
			// Este if gestiona que men� le corresponde al usuario acutal.
			
			if (usuario_actual == 0) {
				en_ejecucion = Menus.MenuAdministrador();
			}else {
				Menus.MenuUsuario();			
			}
		}while(en_ejecucion);	
	}	
}
