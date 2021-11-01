package programa;

public class Utilidades {
	
	public static boolean CrearUsuario(String nombre) {
		
			for (int i = 0; i < Main.usuarios.length; i++) {
				if(Main.usuarios[i].equals(nombre)) {
					return true;
				}
			}

			// Se añade el usuario, con el pin por defecto.
			
			Funciones.agregar_usuario(nombre);
			Main.pines = Funciones.agregar_entero_arreglo(Main.pines, Main.pin_defecto);
			Main.fondos = Funciones.agregar_entero_arreglo(Main.fondos, 0);
			
			return false;
			
			// Cuando la clase devuelve falso es que el usuario no está en la lista.
			
		}
	
	public static void CambiarPin() {
		
		// Se inicializan las varibales para el pin anterior y la verificación del mismo.
		int pin = Main.pines[Main.usuario_actual];
		int pin_anterior = pin;
		int verificacion = 0;
	
		// Se ejecuta este trozo de código una vez al menos y se reptite mientras el pin no sea igual a la verificación,
		
		do {
						
			System.out.print("Cree un nuevo pin de al menos 4 caracteres: ");
			pin = Main.sc.nextInt();
			
			// IF: Se comprueba si la cantidad de caracteres del pin es menor a 4.
			// ELSE IF: Se comprueba si el pin anterior es igual al nuevo.
			// ELSE IF: Se comprueba si el pin anterior es igual al pin por defecto.
			
			if ((pin+"").length() < 4) {
				System.out.print("La cantidad de caracteres del pin es menor a 4");
				Funciones.TresPuntos();
				continue;
			}else if (pin_anterior == pin) {
				System.out.print("El nuevo pin no puede ser igual al anterior");
				Funciones.TresPuntos();
				continue;
			}else if (pin == Main.pin_defecto) {
				System.out.print("El nuevo pin no puede ser igual al pin por defecto");
				Funciones.TresPuntos();
				continue;
			}
			
			System.out.print("Repita el nuevo pin: ");
			verificacion = Main.sc.nextInt();
			
			// Se comprueba si ambos pines coniciden.
			
			if (verificacion != pin) {	
				System.out.print("\nLos pines ingresados no coinciden");
				Funciones.TresPuntos();
			}
		
		} while(verificacion != pin || (pin+"").length() < 4 || pin_anterior == pin);
		
		Main.pines[Main.usuario_actual]=pin;
		
	}
	public static boolean Transaccion(String usuario, int fondos, int monto) {
		if (monto <= fondos) {
			for (int i = 0; i < Main.usuarios.length; i++) {
				if (Main.usuarios[i].equals(usuario)) {
					Main.fondos[Main.usuario_actual] -= monto;
					Main.fondos[i] += monto;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void Tabla_Usuarios(){

		System.out.println("\nTabla de usuarios:\n");
		for (int i = 1; i < Main.usuarios.length; i++)
			System.out.println("\t %s - $%s".formatted(Main.usuarios[i], Main.fondos[i]));
		
	}
}
