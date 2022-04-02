package evento;

import java.util.Scanner;


public class AppVentaEntrada {
	public final static Scanner scanner = new Scanner(System.in);
	public static Asiento asiento;
	
	public final static int OPCION_MENU_VER_ASIENTOS = 1;
	public final static int OPCION_MENU_COMPRAR_ENTRADA = 2;
	public final static int OPCION_MENU_INFORMACION_EVENTO = 3;
	public final static int OPCION_MENU_SALIR = 4;
	
	
public static void main(String[] args) {
	asiento = new Asiento(10, 10);
	asiento.llenarEvento();
	//asiento.mostrarSala();
	
	int opcionSeleccionada;
	do {
		opcionSeleccionada = menu();
		switch (opcionSeleccionada) {
		case OPCION_MENU_VER_ASIENTOS:
			asiento.mostrarSala();
			break;
		case OPCION_MENU_COMPRAR_ENTRADA:
			comprarEntrada();;
			break;	
		case OPCION_MENU_INFORMACION_EVENTO:
			asiento.estadisticas();
			break;		
		}
	} while (opcionSeleccionada != OPCION_MENU_SALIR);
	System.out.printf("Seleccionó la opción %d", opcionSeleccionada);
}


private static int menu() {
	
	System.out.println("----------------------- \n *MENU VENTAS * \n-----------------------");
	System.out.println("1. VER DISPONIBILIDAD DE ASIENTOS");
	System.out.println("2. COMPRAR ENTRADA A EVENTO");
	System.out.println("3. ESTADISTICAS DEL EVENTO");	
	System.out.println("4. EXIT");
	
	System.out.println("\n-------------------------------- \n *POR FAVOR DIGITE UNA OPCIÓN* \n--------------------------------");
	
			
	try {
		int opcionSeleccionada = scanner.nextInt();
		return opcionSeleccionada;
	} catch (java.util.InputMismatchException ime) {
		System.out.println("\n Solo se permiten números \n");
	}
	return 0;
}

private static void comprarEntrada() {
	
	boolean verificar;
	int comprarFila,comprarColumna;
	do {
		System.out.println("\nIngresa la fila");
		comprarFila = scanner.nextInt();
		System.out.println("\nIngresa la columna");
		comprarColumna = scanner.nextInt();
		verificar = asiento.verificarVoleto(comprarFila, comprarColumna);
	} while (!verificar);
	asiento.comprarEntrada(comprarFila, comprarColumna);
}

}
