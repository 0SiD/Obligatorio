package program;

import java.util.Arrays;

public class Funciones {
	public static void agregar_usuario(String name) {
		
		String[] arreglo_copia = Arrays.copyOf(Main.usuarios, Main.usuarios.length + 1);
		arreglo_copia[arreglo_copia.length-1] = name;
		Main.usuarios = arreglo_copia;
		
	}
	
	public static void agregar_pin(int pin) {
		
		int[] arreglo_copia = Arrays.copyOf(Main.pines, Main.pines.length + 1);
		arreglo_copia[arreglo_copia.length-1] = pin;
		Main.pines = arreglo_copia;	
	}
	
	public static int inicar_sesion(){
		
		// Se inicializan las variables para las entradas del usuario.
		
		String usuario_ingresado;
		int pin_ingresado;
		
		while (true){
			
		// El usuario ingresa los datos.
			
		 System.out.print("Ingrese el nombre de usuario: ");
		 usuario_ingresado = Main.sc.next().toLowerCase();
		 
		 System.out.print("Ingrese el pin: ");
		 pin_ingresado = Main.sc.nextInt();
		 
		// Se comprueba si los datos ingresados están en la lista.
		 
		 for (int i = 0; i < Main.usuarios.length; i++) {
			 if (usuario_ingresado.equals(Main.usuarios[i]) && pin_ingresado == Main.pines[i]) {
				 
				 System.out.println("\nHaz iniciado sesión como %s.\n".formatted(usuario_ingresado));
				 return i;
			} // if
				
		 } // for
		 
			 // Si no es así se da un mensaje de error.
			 System.out.print("\nEl usuario y/o el pin ingresado son incorrectos");
			Utilidades.TresPuntos();
				
			
		
		} // while
	
	} // función
}
