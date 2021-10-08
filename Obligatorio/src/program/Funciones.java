package program;

import java.util.Arrays;

public class Funciones {
	public static void agregar_usuario(String name) {
		/* Se crea una copia del arreglo, aumentando su longitud en 1 y se le agrega el nombre de usuario pasado como argumento.
		   Al final este arreglo_copia se guarda en el Main.usuarios. */
		
		String[] arreglo_copia = Arrays.copyOf(Main.usuarios, Main.usuarios.length + 1);
		arreglo_copia[arreglo_copia.length-1] = name;
		Main.usuarios = arreglo_copia;
		
	}
	
	public static void agregar_pin(int pin) {	
		/* Se crea una copia del arreglo, aumentando su longitud en 1 y se le agrega el pin ingresado como argumento.
		   Al final este arreglo_copia se guarda en el Main.pines. */
		
		int[] arreglo_copia = Arrays.copyOf(Main.pines, Main.pines.length + 1);
		arreglo_copia[arreglo_copia.length-1] = pin;
		Main.pines = arreglo_copia;	
	}
	
	public static String[] remover(String[] arreglo, int numero) { 
		/* Se crea una copia del arreglo, y si el elemento que se busca esta en la mitad del mismo este se reacomoda usando
		   ese while sacando el elemento en cuestión, para que al final se reduzca la longitud del arreglo y se devuelva
		   para poder setearlo en una variable. */
		
		String[] arreglo_copia = arreglo; 
		
		while(numero+1 < arreglo_copia.length){
			numero++;
            arreglo_copia[numero-1] = arreglo_copia[numero];
		}
		
		return (Arrays.copyOf(arreglo_copia, arreglo_copia.length - 1));
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
