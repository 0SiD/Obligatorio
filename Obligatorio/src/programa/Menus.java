package programa;

public class Menus {

	public static boolean MenuUsuario() {
		int entrada, a_retirar, a_cargar;
		
		do {
			System.out.println("\n[Obligatorio ATM]\n"
							 + "\n 1. Retirar dinero."
							 + "\n 2. Cargar saldo."
							 + "\n 3. Ver saldo de la cuenta"
							 + "\n 4. Cambiar pin."
							 + "\n 5. Salir");
			
			try{Thread.sleep(800);}catch(InterruptedException e){;}
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
				System.out.println("Sus fondos actuales son de $%s".formatted(Main.fondos[Main.usuario_actual]));
				break;
			
			case 4:
				Utilidades.CambiarPin();
				break;
				
			case 5:
				System.out.println("¡Vuelva pronto!");
				return false;
				
			default:
				System.out.println("¿?");
				break;
			}
			
			try{Thread.sleep(300);}catch(InterruptedException e){;}
			
		}while(true);
	}
}