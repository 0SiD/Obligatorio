package program;

import java.util.Arrays;

public class Utilidades {
	public static void AdministradorUsuarios() {
			
			// Crea el scanner, e inicializa las variables necesarias.
			
			String nombre_usuario;	
			
			
			// Se le pide el nombre del usuario.
			
			System.out.println("Al momento de crear un usuario tome en cuenta los siguentes datos:"
					+ "\n\t- Solo se va a tomar la primera palabra que haya ingresado, por lo cual no se recomienda utilizar espacios."
					+ "\n\t- El nombre de usuario no es key sensitive.\n");
			
			// Eso es simplemente una espera.
			
			try{Thread.sleep(800);}catch(InterruptedException e){;}
			
			System.out.print("Ingrese el nombre de el nuevo usuario: ");
			nombre_usuario = Main.sc.next().toLowerCase();
		
			// Se a�ade el usuario, con el pin por defecto.
			
			Main.users.add(nombre_usuario);
			Main.pines.add(Main.pin_defecto);
			
		}
	
	public static void CambiarPin(int pin) {
		
		// Se inicializan las varibales del scanner con el pin y la verificaci�n del pin.
		
		int lastpin = pin;
		int verificacion = 0;
	
		// Se ejecuta este trozo de c�digo una vez al menos y se reptite mientras el pin no sea igual a la verificaci�n,
		
		do {
						
			System.out.print("Cree un nuevo pin de al menos 4 n�meros para este nuevo usuario: ");
			pin = Main.sc.nextInt();
			
			// Se comprueba si la cantidad de caracteres del pin es menor a 4.
			
			if ((pin+"").length() < 4) {
				System.out.print("\nLa cantidad de caracteres del pin es menor a 4");
				TresPuntos();
				continue;
			}else if (lastpin == pin) {
				System.out.print("\nEl nuevo pin no puede ser igual al anterior");
				TresPuntos();
				continue;
			}
			
			System.out.print("Repita el nuevo pin: ");
			verificacion = Main.sc.nextInt();
			
			// Se comprueba si ambos pines coniciden.
			
			if (verificacion != pin) {	
				System.out.print("\nLos pines ingresados no coinciden");
				TresPuntos();
			}
		
		} while(verificacion != pin || (pin+"").length() < 4 || lastpin == pin);
		
		Main.pines.set(1, pin);
		
	}
	
	public static void TresPuntos() {
		// Se da el efecto de que se queda cargando.
		
		for(int i = 0; i < 3; i++){
			try{Thread.sleep(300);}catch(InterruptedException e){;}
			System.out.print(".");
		}
		System.out.println("\n");
	}
}
