package evento;

import java.util.Arrays;
import java.time.LocalDateTime;

public class Asiento {
	private final int fila;
	private final int columna;
	private String[][]local; 
	private int entrada,entradaVendida;
	private LocalDateTime fechaHoraActual = LocalDateTime.now();
	
	public Asiento(int fila, int columna) {
		super();
		this.fila = fila;
		this.columna = columna;
		this.local = new String [fila+1][columna+1];
		this.entrada = 0;
	}

	public String[][] getLocal() {
		return local;
	}

	public void setLocal(String[][] local) {
		this.local = local;
	}

	public int getEntrada() {
		return entrada;
	}

	public void setEntrada(int entrada) {
		this.entrada = entrada;
	}

	public int getEntradaVendida() {
		return entradaVendida;
	}

	public void setEntradaVendida(int entradaVendida) {
		this.entradaVendida = entradaVendida;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public LocalDateTime getFechaHoraActual() {
		return fechaHoraActual;
	}

	public void setFechaHoraActual(LocalDateTime fechaHoraActual) {
		this.fechaHoraActual = fechaHoraActual;
	}
	
	//se llena el local con L
	//L = asiento libre
	//se pueden solicitar por consola si en un futuro cambia aforo
	public void llenarEvento() {		
		
		for (int i = 0; i < local.length; i++) {
			for (int j = 0; j < local[0].length; j++) {
				if (i==0 &&j ==0) local[i][j] = " ";
				else if (i==0) local[i][j] = String.valueOf(j);
				else if (j==0) local[i][j] = String.valueOf(i);
				else local[i][j] = "L";	
			}
		}
	}

	//muestra en pantalla la distribucion de los asistentes
	// L = asiento libre  V = vendido
	
	public void mostrarSala() {
		System.out.println("\n    Evento:   ");
		System.out.println("**************");
		for (String[] asientos : local) {
			for (int j = 0; j < local[0].length; j++) {
				System.out.print(asientos[j]+" ");
			}			
			System.out.println("\n");
		}
		System.out.println("************** \n");
	}
	
	//validamos que solo se puedan seleccionar entradas que estan dentro de nuestro arreglo bi dimensional
	// devuelve la validacion si se puede comprar la entrada
	public boolean verificarVoleto(int comprarFila, int comprarColumna) {
		boolean verificar = comprarFila > fila || comprarColumna > columna || comprarColumna == 0 || comprarColumna == 0;
		if (verificar) {
			System.out.println("Entrada no existe");
			return false;
		} else if(local[comprarFila][comprarColumna].equals("1")){
			System.out.println("Entrada no disponible");
			return false;
		}
		return true;
	}
	
	//genera la venta 
	//imprime la entrada
	//
	public void comprarEntrada(int comprarFila, int comprarColumna) {
		int precio = 30000;
		entrada += 1;
		entradaVendida += precio;
		local[comprarFila][comprarColumna] = "V";
		System.out.println("\n**************ENTRADA*****************\n");
		System.out.println("Ubicacion : Cancha\n" );
		System.out.printf("Fecha : %1$td-%1$tm-%1$ty %tT%n",fechaHoraActual);
		System.out.println("\nEl valor de la entrada es de : $"+ precio);		
		System.out.println("\n***************************************\n");
		
	}
	
	//generamos resporte
	//entradas vendidas
	//entradas por vender
	//recaudacion
	public void estadisticas() {
		System.out.println("\n Entradas vendidas : "+entrada);
		System.out.println("\n Entradas disponibles : "+ (30-entrada));
		System.out.println("\n Recaudado : "+entradaVendida);
		
	}
	
	@Override
	public String toString() {
		return "Asientos [fila=" + fila + ", columna=" + columna + ", local=" + Arrays.toString(local) + ", entrada="
				+ entrada + ", entradaVendida =" + entradaVendida + "]";
	}

	
	
}
