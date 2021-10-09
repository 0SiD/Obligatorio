package programa;

import java.util.Arrays;

public class Funciones {
	public static void agregar_usuario(String name) {
		// Se aumenta la longitud del arreglo en 1 y se le agrega el nombre de usuario pasado como argumento.
		
		Main.usuarios = Arrays.copyOf(Main.usuarios, Main.usuarios.length + 1);
		Main.usuarios[Main.usuarios.length-1] = name;	
	}
	
	public static int[] agregar_entero_arreglo(int[] arreglo, int numero) {	
		// Se aumenta la longitud del arreglo en 1 y se le agrega el numero como argumento.
		
		arreglo = Arrays.copyOf(arreglo, arreglo.length + 1);
		arreglo[arreglo.length-1] = numero;
		return arreglo;
	}
	
	public static void remover(String[] arreglo, int numero) { 
		/* Si el elemento que se quiere quitar de el arreglo esta en la mitad del mismo este se reacomoda usando
		   ese for sacando el elemento en cuestión, para que al final se reduzca la longitud del arreglo. */
			
		for(int i = numero+1; i < arreglo.length; i++)
			arreglo[i-1] = arreglo[i];
		
		arreglo = Arrays.copyOf(arreglo, arreglo.length - 1);
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
				} 	
			}
		 
			// Si se comprobaron todos los casos y el usuario no está en el arreglo, se da un mensaje de error.
			
			System.out.print("\nEl usuario y/o el pin ingresado son incorrectos");
			Utilidades.TresPuntos();
				
		}
	}
}
