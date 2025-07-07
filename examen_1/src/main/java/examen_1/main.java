package examen_1;
import java.io.*;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.LinkedList;
import java.util.List;
public class main {
	public static void main(String[] args) {
		checkInitialFile();
		File file = new File("datos.dat");
		crearArchivoModificado(file, ".", ";");
		PrintStream ps = new PrintStream(System.out);
		PrintStream psErr = new PrintStream(System.err);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int opcion = -1;
		while (opcion != 0) {
			mostrarMenuPrincipal();
			try {
				String input = br.readLine();
				opcion = Integer.parseInt(input);
				switch (opcion) {
				case 1:
					// código de agregar datos nuevos al archivo de texto.
					System.out.println("Seleccionaste agregar datos!");
					break;
				case 2:
					// código de eliminar datos del archivo de texto.
					System.out.println("Seleccionaste eliminar datos!");
					break;
				case 3:
					// código de mostrar datos existentes
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
	public static void checkInitialFile() {
		InputStreamReader isr = new InputStreamReader(System.in);
		PrintStream ps = new PrintStream(System.out);
		BufferedReader br = new BufferedReader(isr);
		File file = new File("datos.dat");
		return;
	}
	public static void crearArchivoModificado(File archivoOriginal, String buscar, String reemplazar) {
		File archTemp = new File("tuti_fruit.dat");
		List<String> textoCompleto = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
				BufferedWriter bw = new BufferedWriter(new FileWriter(archTemp));) {
			String linea = "";
			String EOF = null;
			while ((linea = br.readLine()) != EOF) {
				if (linea.contains(buscar)) {
					linea = linea.replace(buscar, reemplazar);
					String lineas = "";
					while ((lineas = br.readLine()) != EOF) {
						textoCompleto.add(lineas);
					}
				}
				bw.write(linea);
				bw.newLine();
			}
			if (!archivoOriginal.delete())
				throw new IOException("No se pudo borrar el archivo original");
			if (!archTemp.renameTo(archivoOriginal))
				throw new IOException("No puedo renombrar el rchivo temporal.");
		} catch (Exception e) {
			// Logger.getLogger(main.class.getName()).log(Level.WARNING, null, e);
		}
		archivoOriginal.deleteOnExit();
	}
	// file.renameTo(new File("datos.csv"));
}
