package programa;

public class Menus {

	static int entrada, a_retirar, a_cargar;
	
	public static boolean MenuUsuario() {
			
			while (true) {
				System.out.println("[Obligatorio ATM]\n"
								 + "\n 1. Retirar dinero"
								 + "\n 2. Cargar saldo"
								 + "\n 3. Hacer transaccion a otro usuario"
								 + "\n 4. Ver saldo de la cuenta"
								 + "\n 5. Cambiar pin"
								 + "\n 6. Salir");
				
				try{Thread.sleep(200);}catch(InterruptedException e){;}
				System.out.print("\nIngrese una opción: ");
				entrada = Main.sc.nextInt();
				
				System.out.println("");
				
				switch(entrada) {
				case 1:
					
					System.out.println("Actualmente tiene $%s".formatted(Main.fondos[Main.usuario_actual]));
					System.out.print("¿Cuanto dinero desea retirar? ");
					a_retirar = Main.sc.nextInt();
					
					if (a_retirar <= 0) {	
						System.out.println("\nHubo un error al realizar la transacción.");
					}else if (a_retirar % 100 == 0) {	
						Main.fondos[Main.usuario_actual] -= a_retirar;
						System.out.println("\nSe han retirado $%s.\n".formatted(a_retirar)
										 + "Su cuenta a quedado con $%s".formatted(Main.fondos[Main.usuario_actual]));
					}else{
						System.out.println("\nEl numero ingresado no es múltiplo de 100.");
					}
					break;
				
				case 2:
					System.out.print("¿Cuanto dinero desea cargar? ");
					a_cargar = Main.sc.nextInt();
					
					if (a_cargar < 0) {
						System.out.println("No se pudo realizar la operación.");
					}else {
						Main.fondos[Main.usuario_actual] += a_cargar;
						System.out.println("¡Su importe se ha añadido con exito!");
					}
					break;
					
				case 3:
					System.out.print("Ingrese el usuario del destinatario: ");
					String destinatario = Main.sc.next().toLowerCase();
					
					System.out.print("Ahora ingrese el monto que le desea enviar: ");
					int monto = Main.sc.nextInt();
					
					System.out.print("\nEsta seguro de hacer esta transaccion (S/n): ");
					if (Main.sc.next().toLowerCase().equals("s")){
						if (Utilidades.Transaccion(destinatario, Main.fondos[Main.usuario_actual], monto)) {
							System.out.println("\n\n¡Se ha realizado la transaccion con éxito! ");
						}else {
							System.out.println("\nHubo un error al realizar la transacción.");
						}
					}
					break;
					
				case 4:
					System.out.println("Sus fondos actuales son de $%s".formatted(Main.fondos[Main.usuario_actual]));
					break;
				
				case 5:
					Utilidades.CambiarPin();
					break;
					
				case 6:
					System.out.println("¡Vuelva pronto!\n\n");
					return true;
					
				default:
					System.out.println("El número ingresado no coincide con ninguna de las opciones del menú.");
					break;
				}
				
				System.out.println();
				try{Thread.sleep(300);}catch(InterruptedException e){;}
				
			}
		}
	
	public static boolean MenuAdministrador() {
		
		boolean usuario_creado;
		
		while(true) {
			System.out.println("[Obligatorio ATM]\n"
							 + "\n 1. Crear usuario"
							 + "\n 2. Ver la lista de usuarios"
							 + "\n 3. Cambiar pin"
							 + "\n 4. Salir"
							 + "\n 5. Cerrar programa");
			
			try{Thread.sleep(800);}catch(InterruptedException e){;}
			System.out.print("\nIngrese una opción: ");
			entrada = Main.sc.nextInt();
			
			System.out.println("");
			
			switch(entrada) {
			case 1:
				
				// Aviso.
				
				System.out.println("Al momento de crear un usuario tome en cuenta lo siguente:\n"
						+ "\nSolo se va a tomar la primera palabra que haya ingresado, por lo cual no se recomienda utilizar espacios."
						+ "\nEl nombre de usuario no es key sensitive.\n");
				
				// Una espera.
				
				try{Thread.sleep(800);}catch(InterruptedException e){;}
				
				do {
					usuario_creado = Utilidades.CrearUsuario();
					
					if (!usuario_creado) {
						System.out.println("El nombre de usuario ya está registrado.");
						try{Thread.sleep(200);}catch(InterruptedException e){;}
						System.out.println("\nVuelva a intentar.");
						try{Thread.sleep(400);}catch(InterruptedException e){;}
					}
					
				}while(!usuario_creado);
				
				try{Thread.sleep(300);}catch(InterruptedException e){;}
				System.out.println("\n// El usuarios se ha creado satisfactoriamente");
				try{Thread.sleep(100);}catch(InterruptedException e){;}
				
				break;
			
			case 2:
				Utilidades.Tabla_Usuarios();
				break;
				
			case 3:
				Utilidades.CambiarPin();
				break;
				
			case 4:
				System.out.println("¡Vuelva pronto!\n\n");
				return true;
				
			case 5:
					System.out.print("\nCerando el programa");
					Funciones.TresPuntos();
					return false;
				
			default:
				System.out.println("El número ingresado no coincide con ninguna de las opciones del menú.");
				break;
			}
			
			System.out.println();
			try{Thread.sleep(300);}catch(InterruptedException e){;}
			
		}
	}
}