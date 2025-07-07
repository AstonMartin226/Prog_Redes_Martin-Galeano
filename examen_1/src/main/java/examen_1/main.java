package examen_1;
import java.io.*;
public class main {
	public static void main(String[] args) {
		PrintStream ps = new PrintStream(System.out);
		PrintStream psErr = new PrintStream(System.err);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int opcion = -1;
		while (opcion != 0) {
			mostrarMenuPrincipal();
			try {
				String input = br.readLine();
				opcion = Integer.parseInt(input);
				
				switch(opcion) {
				
				case 1:
					
					//código de agregar datos nuevos al archivo de texto.
					
					System.out.println("Seleccionaste agregar datos!");
					
					break;
					
				case 2:
					
					//código de eliminar datos del archivo de texto.
					System.out.println("Seleccionaste eliminar datos!");
					
					break;
				case 3:
					
					//código de mostrar datos existentes
					System.out.println("Seleccionaste ver datos!");
					
					break;
				case 0:
					
					System.out.println("\u001B[32mGracias por usar el sistema!\u001B[0m");
					
					return;
				default:
					System.out.println("\u001B[31mOpcion no valida\u001B[0m");
				
				}
			} catch (IOException | NumberFormatException e) {
				psErr.println("El dato ingresado es incorrecto: " + e.getMessage());
			}
		}
	}
	private static void mostrarMenuPrincipal() {
		System.out.println("\u001B[34m" + "===============================");
		System.out.println(" MENÚ PRINCIPAL");
		System.out.println("===============================" + "\u001B[0m");
		System.out.println("\u001B[33m" + " 1. Agregar datos nuevos al archivo de texto");
		System.out.println(" 2. Eliminar datos del archivo de texto");
		System.out.println(" 3. Mostrar los datos existentes");
		System.out.println(" 0. Salir" + "\u001B[0m");
	}
}
