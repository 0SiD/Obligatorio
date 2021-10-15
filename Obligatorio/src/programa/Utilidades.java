package programa;

public class Utilidades {
	
	public static boolean CrearUsuario() {
			
			// Se inicializa la variable para el nombre del futuro usuario.
			
			String nombre_usuario;	
			
			// Se le pide el nombre del usuario.
			
			System.out.print("Ingrese el nombre de el nuevo usuario: ");
			
			nombre_usuario = Main.sc.next().toLowerCase();
		
			for (int i = 0; i < Main.usuarios.length; i++) {
				if(Main.usuarios[i].equals(nombre_usuario)) {
					return false;
				}
			}

			// Se a�ade el usuario, con el pin por defecto.
			
			Funciones.agregar_usuario(nombre_usuario);
			Main.pines = Funciones.agregar_entero_arreglo(Main.pines, Main.pin_defecto);
			Main.fondos = Funciones.agregar_entero_arreglo(Main.fondos, 0);
			
			return true;
			
		}
	
	public static void CambiarPin() {
		
		// Se inicializan las varibales para el pin anterior y la verificaci�n del mismo.
		int pin = Main.pines[Main.usuario_actual];
		int pin_anterior = pin;
		int verificacion = 0;
	
		// Se ejecuta este trozo de c�digo una vez al menos y se reptite mientras el pin no sea igual a la verificaci�n,
		
		do {
						
			System.out.print("Cree un nuevo pin de al menos 4 caracteres: ");
			pin = Main.sc.nextInt();
			
			// IF: Se comprueba si la cantidad de caracteres del pin es menor a 4.
			// ELSE IF: Se comprueba si el pin anterior es igual al nuevo.
			
			if ((pin+"").length() < 4) {
				System.out.print("\nLa cantidad de caracteres del pin es menor a 4");
				Funciones.TresPuntos();
				continue;
			}else if (pin_anterior == pin) {
				System.out.print("\nEl nuevo pin no puede ser igual al anterior");
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
