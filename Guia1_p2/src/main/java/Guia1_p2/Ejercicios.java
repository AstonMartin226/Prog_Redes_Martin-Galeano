package Guia1_p2;

import java.io.*;
import java.util.*;

public class Ejercicios {

	PrintStream ps = new PrintStream(System.out);

	public static void ejercicio1(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintStream console = System.out;
		String entrada;
		String ultimoNumero = "";

		console.println("Escribe datos (solo números se guardan). Presiona Enter vacío para terminar:");

		while (true) {
			console.print("Ingresa un dato: ");
			entrada = reader.readLine();

			// Si presiona Enter vacío, termina
			if (entrada.trim().isEmpty()) {
				break;
			}

			// Verificar si es número
			try {
				Double.parseDouble(entrada);
				ultimoNumero = entrada;
				console.println("Último número válido: " + ultimoNumero);
			} catch (NumberFormatException e) {
				console.println("No es un número.");
			}
		}

		// Guardar solo el último número válido
		if (!ultimoNumero.isEmpty()) {
			PrintWriter writer = new PrintWriter("numeros.txt");
			writer.println(ultimoNumero);
			writer.close();
			console.println("Último número guardado en archivo: " + ultimoNumero);
		} else {
			console.println("No se ingresaron números válidos.");
		}

		
	}

	public static void ejercicio2(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintStream console = System.out;
		PrintWriter writer = new PrintWriter(new FileWriter("numeros.txt", true));
		String entrada;

		console.println("Escribe datos (escribe 'salir' para terminar):");

		while (true) {
			console.print("Ingresa un dato: ");
			entrada = reader.readLine();

			if (entrada.equals("salir")) {
				break;
			}

			try {
				Double.parseDouble(entrada);
				writer.println(entrada);
				writer.flush();
				console.println("Número guardado: " + entrada);
			} catch (NumberFormatException e) {
				console.println("No es un número, no se guardó.");
			}
		}

		writer.close();
	
		console.println("Programa terminado.");
	}

	public static void ejercicio3(String[] args) throws IOException {

		PrintWriter writer = new PrintWriter("../números.txt");

		for (int i = 0; i <= 1000; i += 2) {
			writer.println(i);
		}

		writer.close();
		System.out.println("Archivo 'números.txt' creado con números pares del 0 al 1000");

	}

	public static void ejercicio4(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("../números.txt"));
		PrintStream console = System.out;
		String linea;

		console.println("Números leídos del archivo:");

		while ((linea = reader.readLine()) != null) {
			console.println(linea);
		}

		reader.close();
		console.println("Fin de la lectura.");

	}

	public static void ejercicio5(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("../números.txt"));
		PrintWriter writer = new PrintWriter("../números_temp.txt");
		String linea;

		// Leer y escribir solo los que NO son múltiplos de 3
		while ((linea = reader.readLine()) != null) {
			int numero = Integer.parseInt(linea);
			if (numero % 3 != 0) {
				writer.println(linea);
			}
		}

		reader.close();
		writer.close();

		// Reemplazar el archivo original
		new File("../números.txt").delete();
		new File("../números_temp.txt").renameTo(new File("../números.txt"));

		System.out.println("Se eliminaron todos los múltiplos de 3 del archivo.");

	}

	public static void ejercicio6(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("../números.txt"));
		PrintWriter writer = new PrintWriter("../../primos.dat");
		String linea;

		while ((linea = reader.readLine()) != null) {
			int numero = Integer.parseInt(linea);
			if (esPrimo(numero)) {
				writer.println(numero);
			}
		}

		reader.close();
		writer.close();
		System.out.println("Números primos guardados en 'primos.dat'");
	}

	static boolean esPrimo(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;

	}

	public static void ejercicio7(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintStream console = System.out;

		// Crear archivo y cargar 10 palabras con ñ
		PrintWriter writer = new PrintWriter("../caracteres.dat");

		console.println("Ingresa 10 palabras que contengan la letra 'ñ':");

		for (int i = 1; i <= 10; i++) {
			console.print("Palabra " + i + ": ");
			String palabra = reader.readLine();
			writer.println(palabra);
		}
		writer.close();

		// Mostrar archivo original
		console.println("\nFichero original:");
		BufferedReader fileReader = new BufferedReader(new FileReader("../caracteres.dat"));
		String linea;
		while ((linea = fileReader.readLine()) != null) {
			console.println(linea);
		}
		fileReader.close();

		// Editar archivo - cambiar ñ por nie-nio
		BufferedReader readerEditado = new BufferedReader(new FileReader("../caracteres.dat"));
		PrintWriter writerEditado = new PrintWriter("../caracteres_temp.dat");

		while ((linea = readerEditado.readLine()) != null) {
			String lineaEditada = linea.replace("ñ", "nie-nio");
			writerEditado.println(lineaEditada);
		}
		readerEditado.close();
		writerEditado.close();

		// Reemplazar archivo original
		new File("../caracteres.dat").delete();
		new File("../caracteres_temp.dat").renameTo(new File("../caracteres.dat"));

		// Mostrar archivo arreglado
		console.println("\nFichero arreglado:");
		BufferedReader fileReaderFinal = new BufferedReader(new FileReader("../caracteres.dat"));
		while ((linea = fileReaderFinal.readLine()) != null) {
			console.println(linea);
		}
		fileReaderFinal.close();

		

	}

	public static void ejercicio8(String[] args) throws IOException {
		PrintStream console = System.out;

		// Crear archivo HTML con lorem
		PrintWriter writer = new PrintWriter("pagina.html");
		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("    <title>Mi Página</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("    <h1>Título Principal</h1>");
		writer.println("    <p>Este es un párrafo normal.</p>");
		writer.println("    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>");
		writer.println("    <p>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>");
		writer.println("    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.</p>");
		writer.println("    <p>Otro párrafo sin lorem.</p>");
		writer.println("    <div>Lorem ipsum es muy común en diseño web.</div>");
		writer.println("    <span>Texto final normal.</span>");
		writer.println("</body>");
		writer.println("</html>");
		writer.close();

		console.println("Archivo HTML creado con lorem.");

		// Leer archivo original y mostrar
		console.println("\nArchivo original:");
		BufferedReader reader = new BufferedReader(new FileReader("pagina.html"));
		String linea;
		while ((linea = reader.readLine()) != null) {
			console.println(linea);
		}
		reader.close();

		// Editar archivo - borrar líneas que contengan "lorem"
		BufferedReader readerEditado = new BufferedReader(new FileReader("pagina.html"));
		PrintWriter writerEditado = new PrintWriter("pagina_temp.html");

		while ((linea = readerEditado.readLine()) != null) {
			if (!linea.toLowerCase().contains("lorem")) {
				writerEditado.println(linea);
			}
		}
		readerEditado.close();
		writerEditado.close();

		// Reemplazar archivo original
		new File("pagina.html").delete();
		new File("pagina_temp.html").renameTo(new File("pagina.html"));

		// Mostrar archivo sin lorem
		console.println("\nArchivo sin lorem:");
		BufferedReader readerFinal = new BufferedReader(new FileReader("pagina.html"));
		while ((linea = readerFinal.readLine()) != null) {
			console.println(linea);
		}
		readerFinal.close();

	}

	private static final String ARCHIVO_CLIMA = "datos_clima.txt";

	public static void ejercicio9(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintStream console = System.out;
		int opcion;

		do {
			mostrarMenu();
			opcion = Integer.parseInt(reader.readLine());

			switch (opcion) {
			case 1:
				cargarDatoClima(reader, console);
				break;
			case 2:
				mostrarTodosLosDatos(console);
				break;
			case 3:
				borrarRegistro(reader, console);
				break;
			case 4:
				console.println("Saliendo del programa...");
				break;
			default:
				console.println("Opción inválida.");
			}
		} while (opcion != 4);

		
	}

	private static void mostrarMenu() {
		System.out.println("\n=== SISTEMA DE DATOS CLIMÁTICOS ===");
		System.out.println("1. Cargar dato de clima");
		System.out.println("2. Mostrar todos los datos");
		System.out.println("3. Borrar registro");
		System.out.println("4. Salir");
		System.out.print("Seleccione una opción: ");
	}

	private static void cargarDatoClima(BufferedReader reader, PrintStream console) throws IOException {
		console.print("Ingrese la fecha (dd/mm/yyyy): ");
		String fecha = reader.readLine();

		console.print("Ingrese la temperatura (°C): ");
		String temperatura = reader.readLine();

		console.print("Ingrese la humedad (%): ");
		String humedad = reader.readLine();

		console.print("Ingrese descripción del clima: ");
		String descripcion = reader.readLine();

		// Guardar en archivo
		PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_CLIMA, true));
		writer.println(fecha + "," + temperatura + "," + humedad + "," + descripcion);
		writer.close();

		console.println("Dato climático guardado correctamente.");
	}

	private static void mostrarTodosLosDatos(PrintStream console) throws IOException {
		console.println("\n=== TODOS LOS DATOS CLIMÁTICOS ===");

		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(ARCHIVO_CLIMA));
			String linea;
			int contador = 1;

			while ((linea = fileReader.readLine()) != null) {
				String[] datos = linea.split(",");
				console.println(contador + ". Fecha: " + datos[0] + " | Temp: " + datos[1] + "°C" + " | Humedad: "
						+ datos[2] + "%" + " | Clima: " + datos[3]);
				contador++;
			}
			fileReader.close();

			if (contador == 1) {
				console.println("No hay datos registrados.");
			}
		} catch (FileNotFoundException e) {
			console.println("No hay datos registrados.");
		}
	}

	private static void borrarRegistro(BufferedReader reader, PrintStream console) throws IOException {
		console.println("\n=== BORRAR REGISTRO ===");

		// Mostrar datos con números
		mostrarTodosLosDatos(console);

		console.print("\nIngrese el número del registro a borrar: ");
		int numRegistro = Integer.parseInt(reader.readLine());

		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(ARCHIVO_CLIMA));
			PrintWriter writer = new PrintWriter("clima_temp.txt");

			String linea;
			int contador = 1;
			boolean encontrado = false;

			while ((linea = fileReader.readLine()) != null) {
				if (contador != numRegistro) {
					writer.println(linea);
				} else {
					encontrado = true;
				}
				contador++;
			}

			fileReader.close();
			writer.close();

			if (encontrado) {
				new File(ARCHIVO_CLIMA).delete();
				new File("clima_temp.txt").renameTo(new File(ARCHIVO_CLIMA));
				console.println("Registro borrado correctamente.");
			} else {
				new File("clima_temp.txt").delete();
				console.println("Número de registro inválido.");
			}

		} catch (FileNotFoundException e) {
			console.println("No hay datos para borrar.");
		}
	}

	private List<Integer> numeros = new ArrayList<>();
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
	
	
	
	
	
	
	
}
