package program;

import java.util.Scanner;

public class Utilidades {
	public static void AdministradorUsuarios() {
			
			// Crea el scanner, e inicializa las variables necesarias.
			
			Scanner sc = new Scanner(System.in);
			String nombre_usuario;	
			
			
			// Se le pide el nombre del usuario.
			
			System.out.println("Al momento de crear un usuario tome en cuenta los siguentes datos:"
					+ "\n\t- Solo se va a tomar la primera palabra que haya ingresado, por lo cual no se recomienda utilizar espacios."
					+ "\n\t- El nombre de usuario no es key sensitive.\n");
			
			// Eso es simplemente una espera.
			
			try{Thread.sleep(800);}catch(InterruptedException e){;}
			
			System.out.print("Ingrese el nombre de el nuevo usuario: ");
			nombre_usuario = sc.next().toLowerCase();
		
			// Se añade el usuario, con el pin por defecto.
			
			Main.users.add(nombre_usuario);
			Main.pines.add(Main.pin_defecto);
			
			sc.close();
		}
	
	public static void CambiarPin() {
		
		// Se inicializan las varibales del scanner con el pin y la verificación del pin.
		
		Scanner sc = new Scanner(System.in);
		int pin, verificacion;
		
		// Se ejecuta este trozo de código una vez al menos y se reptite mientras el pin no sea igual a la verificación,
		
		do {
			
			System.out.print("Cree un nuevo pin para este nuevo usuario: ");
			pin = sc.nextInt();
			
			System.out.print("Repita el nuevo pin: ");
			verificacion = sc.nextInt();
			
			if (verificacion != pin) {	
				System.out.print("\nLos pines ingresados no coinciden");
				
				// Se da el efecto de que se queda cargando.
				
				for(int i = 0; i < 3; i++){
					try{Thread.sleep(400);}catch(InterruptedException e){;}
					System.out.print(".");
				}
				System.out.println("\n");
			}
		
		} while(verificacion != pin);
		
		sc.close();
	}
}
