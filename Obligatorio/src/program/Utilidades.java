package program;

public class Utilidades {
	
	public static void CrearUsuario() {
			
			// Se inicializa la variable para el nombre del futuro usuario.
			
			String nombre_usuario;	
			
			// Se le pide el nombre del usuario.
			
			System.out.println("Al momento de crear un usuario tome en cuenta los siguentes datos:"
					+ "\n\t- Solo se va a tomar la primera palabra que haya ingresado, por lo cual no se recomienda utilizar espacios."
					+ "\n\t- El nombre de usuario no es key sensitive.\n");
			
			// Eso es simplemente una espera.
			
			try{Thread.sleep(800);}catch(InterruptedException e){;}
			
			System.out.print("Ingrese el nombre de el nuevo usuario: ");
			nombre_usuario = Main.sc.next().toLowerCase();
		
			// Se añade el usuario, con el pin por defecto.
			
			Main.usuarios.add(nombre_usuario);
			Main.pines.add(Main.pin_defecto);
			
		}
	
	public static void CambiarPin(int pin) {
		
		// Se inicializan las varibales para el pin anterior y la verificación del mismo.
		
		int pin_anterior = pin;
		int verificacion = 0;
	
		// Se ejecuta este trozo de código una vez al menos y se reptite mientras el pin no sea igual a la verificación,
		
		do {
						
			System.out.print("Cree un nuevo pin de al menos 4 caracteres para este nuevo usuario: ");
			pin = Main.sc.nextInt();
			
			// IF: Se comprueba si la cantidad de caracteres del pin es menor a 4.
			// ELSE IF: Se comprueba si el pin anterior es igual al nuevo.
			
			if ((pin+"").length() < 4) {
				System.out.print("\nLa cantidad de caracteres del pin es menor a 4");
				TresPuntos();
				continue;
			}else if (pin_anterior == pin) {
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
		
		} while(verificacion != pin || (pin+"").length() < 4 || pin_anterior == pin);
		
		Main.pines.set(Main.usuario_actual, pin);
		
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
