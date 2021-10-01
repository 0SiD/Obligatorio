package program;

public class Funciones {
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
		 
		 for (String x: Main.usuarios) {
			 if (usuario_ingresado.equals(x) && pin_ingresado == Main.pines.get(Main.usuarios.indexOf(usuario_ingresado))) {
				 
				 System.out.println("\nHaz iniciado sesión como %s.\n".formatted(usuario_ingresado));
				 return Main.usuarios.indexOf(usuario_ingresado);	
				 
			}else{
				
				// Si no es así se da un mensaje de error.
				System.out.print("\nEl usuario y/o el pin ingresado son incorrectos");
				Utilidades.TresPuntos();
				
			} // else.
		 } // for.
		
		} // while.
	
	} // función.
}
