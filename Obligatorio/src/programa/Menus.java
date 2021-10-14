package programa;

public class Menus {

	static int entrada, a_retirar, a_cargar;
	
	public static boolean MenuUsuario() {
			
			do {
				System.out.println("[Obligatorio ATM]\n"
								 + "\n 1. Retirar dinero"
								 + "\n 2. Cargar saldo"
								 + "\n 3. Ver saldo de la cuenta"
								 + "\n 4. Cambiar pin"
								 + "\n 5. Salir");
				
				try{Thread.sleep(200);}catch(InterruptedException e){;}
				System.out.print("\nIngrese una opci�n: ");
				entrada = Main.sc.nextInt();
				
				System.out.println("");
				
				switch(entrada) {
				case 1:
					
					System.out.println("Actualmente tiene $%s".formatted(Main.fondos[Main.usuario_actual]));
					System.out.print("�Cuanto dinero desea retirar? ");
					a_retirar = Main.sc.nextInt();
					
					if (a_retirar <= 0) {	
						System.out.println("\nHubo un error al realizar la transacci�n.");
					}else if (a_retirar % 100 == 0) {	
						Main.fondos[Main.usuario_actual] -= a_retirar;
						System.out.println("\nSe han retirado $%s.\n".formatted(a_retirar)
										 + "Su cuenta a quedado con $%s".formatted(Main.fondos[Main.usuario_actual]));
					}else{
						System.out.println("\nEl numero ingresado no es m�ltiplo de 100.");
					}
					break;
				
				case 2:
					System.out.print("�Cuanto dinero desea cargar? ");
					a_cargar = Main.sc.nextInt();
					
					if (a_cargar < 0) {
						System.out.println("No se pudo realizar la operaci�n.");
					}else {
						Main.fondos[Main.usuario_actual] += a_cargar;
						System.out.println("�Su importe se ha a�adido con exito!");
					}
					break;
					
				case 3:
					System.out.println("Sus fondos actuales son de $%s".formatted(Main.fondos[Main.usuario_actual]));
					break;
				
				case 4:
					Utilidades.CambiarPin();
					break;
					
				case 5:
					System.out.println("�Vuelva pronto!\n\n");
					return false;
					
				default:
					System.out.println("El n�mero ingresado no coincide con ninguna de las opciones del men�.");
					break;
				}
				
				System.out.println();
				try{Thread.sleep(300);}catch(InterruptedException e){;}
				
			}while(true);
		}
	
	public static boolean MenuAdministrador() {
		
		do {
			System.out.println("[Obligatorio ATM]\n"
							 + "\n 1. Crear usuario"
							 + "\n 2. Ver la lista de usuarios"
							 + "\n 3. Cambiar pin"
							 + "\n 4. Salir");
			
			try{Thread.sleep(800);}catch(InterruptedException e){;}
			System.out.print("\nIngrese una opci�n: ");
			entrada = Main.sc.nextInt();
			
			System.out.println("");
			
			switch(entrada) {
			case 1:
				Utilidades.CrearUsuario();
				break;
			
			case 2:
				Utilidades.Tabla_Usuarios();
				break;
				
			case 3:
				Utilidades.CambiarPin();
				break;
				
			case 4:
				System.out.println("�Vuelva pronto!\n\n");
				return false;
				
			default:
				System.out.println("El n�mero ingresado no coincide con ninguna de las opciones del men�.");
				break;
			}
			
			System.out.println();
			try{Thread.sleep(300);}catch(InterruptedException e){;}
			
		}while(true);
	}
}