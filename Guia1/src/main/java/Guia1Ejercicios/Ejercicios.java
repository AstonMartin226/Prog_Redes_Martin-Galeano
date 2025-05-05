/**
 * 
 */
package Guia1Ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicios {

	public static void main(String[] args) {
		PrintStream ps = new PrintStream(System.out);
		PrintStream psErr = new PrintStream(System.err);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			ejercicio1(ps);
			ejercicio2(ps);
			ejercicio3(ps);
			ejercicio4(ps);
			ejercicio5(ps);
			ejercicio6(ps);
			ejercicio7(ps);
			ejercicio8(ps, psErr, br);
			ejercicio9(ps, psErr, br);
			ejercicio10(ps, psErr, br);
			ejercicio11(ps, psErr, br);
			ejercicio12(ps, psErr, br);
			ejercicio13(ps, psErr, br);
			ejercicio14(ps, psErr, br);
			ejercicio15(ps, psErr, br);
		} catch (IOException | NumberFormatException e) {
			psErr.println("Error: " + e.getMessage());
		}
	}

	public static String leerLinea() {
		PrintStream psErr = new PrintStream(System.err);
		StringBuilder resultado = new StringBuilder();

		try {
			int caracter;
			while ((caracter = System.in.read()) != -1) {
				if (caracter == 10) {
					break;
				} else if (caracter != 13) {
					resultado.append((char) caracter);
				}
			}
		} catch (IOException e) {
			psErr.println("Error: " + e.getMessage());
		}

		return resultado.toString().trim();
	}

	// punto 1

	public static void ejercicio1(PrintStream ps) {
		ps.print("Inserte el valor de una hora de trabajo: ");
		int valorHora = Integer.parseInt(leerLinea());

		ps.print("Inserte la cantidad de horas trabajadas ");
		int cantidadHoras = Integer.parseInt(leerLinea());

		int salario = valorHora * cantidadHoras;
		ps.println("El salario bruto es: " + salario);

	}

	public static void ejercicio2(PrintStream ps) {
		ps.print("Inserte el valor del primer ángulo: ");
		int valorAngulo1 = Integer.parseInt(leerLinea());

		ps.print("Inserte el valor del segundo ángulo: ");
		int valorAngulo2 = Integer.parseInt(leerLinea());

		int valorAngulo3 = 180 - valorAngulo1 - valorAngulo2;
		ps.println("El valor del tercer ángulo es: " + valorAngulo3);

	}

	public static void ejercicio3(PrintStream ps) {
		ps.print("Inserte la superficie del cuadrado en m2: ");
		int superficie = Integer.parseInt(leerLinea());

		double perimetro = 4 * Math.sqrt(superficie);
		ps.println("El valor del perímetro es: " + perimetro + "m");

	}

	public static void ejercicio4(PrintStream ps) {
		ps.print("Inserte la temperatura en grados Fahrenheit: ");
		int fahrenheit = Integer.parseInt(leerLinea());

		double centigrados = (fahrenheit - 32) * 0.55555;
		ps.println("El valor en grados centígrados es: " + centigrados + "°");

	}

	public static void ejercicio5(PrintStream ps) {
		ps.print("Inserte el tiempo en segundos: ");
		int totalSegundos = Integer.parseInt(leerLinea());

		int dias = totalSegundos / 86400;
		int resto = totalSegundos % 86400;

		int horas = resto / 3600;
		resto = resto % 3600;

		int minutos = resto / 60;
		int segundos = resto % 60;

		ps.println("El tiempo equivale a:" + dias + " días, " + horas + " horas, " + minutos + " minutos y " + segundos
				+ "segundos");

	}

	public static void ejercicio6(PrintStream ps) {
		ps.print("Ingrese el precio del artículo: ");
		double precio = Double.parseDouble(leerLinea());

		ps.println("\n=== Plan 1 ===");
		double total1 = precio * 0.90;
		ps.println("Pago al contado con 10% de descuento: $" + total1);

		ps.println("\n=== Plan 2 ===");
		double precioPlan2 = precio * 1.10;
		double contado2 = precioPlan2 * 0.50;
		double cuota2 = (precioPlan2 - contado2) / 2;
		ps.println("50% al contado: $" + contado2);
		ps.println("2 cuotas de: $" + cuota2);

		ps.println("\n=== Plan 3 ===");
		double precioPlan3 = precio * 1.15;
		double contado3 = precioPlan3 * 0.25;
		double cuota3 = (precioPlan3 - contado3) / 5;
		ps.println("25% al contado: $" + contado3);
		ps.println("5 cuotas de : $" + cuota3);

		ps.println("\n=== Plan 4 ===");
		double precioPlan4 = precio * 1.25;
		double primeras4 = (precioPlan4 * 0.60) / 4;
		double ultimas4 = (precioPlan4 * 0.40) / 4;
		ps.println("8 cuotas en total:");
		ps.println("- 4 primeras cuotas de: $" + primeras4);
		ps.println("- 4 últimas cuotas de: $" + ultimas4);

	}

	public static void ejercicio7(PrintStream ps) {

		ps.print("ingrese su signo del zodiaco: ");
		String signo = leerLinea();

		switch (signo) {

		case "aries":
			ps.println("Mes aproximado: Marzo - Abril");
			break;
		case "tauro":
			ps.println("Mes aproximado: Abril - Mayo");
			break;
		case "geminis":
		case "géminis":
			ps.println("Mes aproximado: Mayo - Junio");
			break;
		case "cancer":
		case "cáncer":
			ps.println("Mes aproximado: Junio - Julio");
			break;
		case "leo":
			ps.println("Mes aproximado: Julio - Agosto");
			break;
		case "virgo":
			ps.println("Mes aproximado: Agosto - Septiembre");
			break;
		case "libra":
			ps.println("Mes aproximado: Septiembre - Octubre");
			break;
		case "escorpio":
			ps.println("Mes aproximado: Octubre - Noviembre");
			break;
		case "sagitario":
			ps.println("Mes aproximado: Noviembre - Diciembre");
			break;
		case "capricornio":
			ps.println("Mes aproximado: Diciembre - Enero");
			break;
		case "acuario":
			ps.println("Mes aproximado: Enero - Febrero");
			break;
		case "piscis":
			ps.println("Mes aproximado: Febrero - Marzo");
			break;
		default:
			ps.println("Entrada no reconocida. Asegurate de escribirlo correctamente.");

		}

	}

	// punto 2

	public static void ejercicio8(PrintStream ps, PrintStream psErr, BufferedReader br) throws IOException {
		ps.print("Ingrese el primer apellido: ");
		String apellido1 = br.readLine();
		ps.print("Ingrese el segundo apellido: ");
		String apellido2 = br.readLine();
		ps.print("Ingrese el tercer apellido: ");
		String apellido3 = br.readLine();

		String[] apellidos = { apellido1, apellido2, apellido3 };

		Arrays.sort(apellidos);

		ps.println("Los apellidos en orden alfabético:");
		for (String apellido : apellidos) {
			ps.println(apellido);
		}

	}

	public static void ejercicio9(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException, NumberFormatException {
		ps.print("Ingrese el primer numero: ");
		double num1 = Double.parseDouble(br.readLine());
		ps.print("Ingrese el segundo numero: ");
		double num2 = Double.parseDouble(br.readLine());
		ps.print("Ingrese el tercer numero: ");
		double num3 = Double.parseDouble(br.readLine());
		ps.print("Ingrese el cuarto numero: ");
		double num4 = Double.parseDouble(br.readLine());

		double[] numeros = { num1, num2, num3, num4 };

		Arrays.sort(numeros);

		ps.println("El número más chico es: " + numeros[0]);

	}

	public static void ejercicio10(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException, NumberFormatException {

		ps.print("Ingrese un número entero: ");
		int num = Integer.parseInt(br.readLine());

		if (num % 2 == 0) {
			System.out.println("Es par");
		} else {

			System.out.println("Es impar");
		}
	}

	public static void ejercicio11(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException, NumberFormatException {

		ps.print("Ingrese el primer número entero:");
		int num1 = Integer.parseInt(br.readLine());

		ps.print("Ingrese el segundo número entero:");
		int num2 = Integer.parseInt(br.readLine());

		int[] numeros = { num1, num2 };

		Arrays.sort(numeros);

		if (numeros[1] % numeros[0] == 0) {
			System.out.println("El mayor es divisible por el menor");
		} else {
			System.out.println("El mayor no es divisible por el menor");
		}

	}

	public static void ejercicio12(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException, NumberFormatException {
		ps.print("Ingrese su día de nacimiento (1-32): ");
		int dia = Integer.parseInt(br.readLine());

		ps.print("Ingrese su mes de nacimiento (1-12): ");
		int mes = Integer.parseInt(br.readLine());

		String signo = null;

		if (mes == 1) {
			signo = (dia < 20) ? "Capricornio" : "Acuario";
		} else if (mes == 2) {
			signo = (dia < 19) ? "Acuario" : "Piscis";
		} else if (mes == 3) {
			signo = (dia < 21) ? "Piscis" : "Aries";
		} else if (mes == 4) {
			signo = (dia < 20) ? "Aries" : "Tauro";
		} else if (mes == 5) {
			signo = (dia < 21) ? "Tauro" : "Géminis";
		} else if (mes == 6) {
			signo = (dia < 21) ? "Géminis" : "Cáncer";
		} else if (mes == 7) {
			signo = (dia < 23) ? "Cáncer" : "Leo";
		} else if (mes == 8) {
			signo = (dia < 23) ? "Leo" : "Virgo";
		} else if (mes == 9) {
			signo = (dia < 23) ? "Virgo" : "Libra";
		} else if (mes == 10) {
			signo = (dia < 23) ? "Libra" : "Escorpio";
		} else if (mes == 11) {
			signo = (dia < 22) ? "Escorpio" : "Sagitario";
		} else if (mes == 12) {
			signo = (dia < 22) ? "Sagitario" : "Capricornio";
		}

		if (signo != null) {
			ps.println("Tu signo zodiacal es: " + signo);
		} else {
			ps.println("Fecha inválida.");
		}
	}

	public static void ejercicio13(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException, NumberFormatException {

		ps.print("Ingrese el nombre y apellido de la primer persona: ");
		String nombre1 = br.readLine();
		ps.print("Ingrese el nombre y apellido de la segunda persona: ");
		String nombre2 = br.readLine();

		String[] lista1 = nombre1.split(" ");
		String[] lista2 = nombre2.split(" ");

		if (lista1.length < 2 || lista2.length < 2) {
			ps.println("Por favor, ingresá nombre y apellido para ambas personas.");
		} else {
			if (lista1[1].length() > lista2[1].length()) {
				ps.println(nombre1 + " tiene el apellido más largo");
			} else if (lista2[1].length() > lista1[1].length()) {
				ps.println(nombre2 + " tiene el apellido más largo");
			} else {
				ps.println("Ambos apellidos tienen la misma longitud.");
			}
		}

	}

	public static void ejercicio14(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException, NumberFormatException {

		ps.print("Ingrese un número natural: ");
		int num = Integer.parseInt(br.readLine());

		if (num <= 0) {
			ps.println("Por favor, ingresá un número natural (mayor que 0)");
		} else {
			ps.println("Tabla de multiplicar del " + num + ":");
			for (int i = 1; i <= 10; i++) {
				ps.println(num + " x " + i + " = " + (num * i));
			}
		}

	}

	
	public static void ejercicio15(PrintStream ps, PrintStream psErr, BufferedReader br)
			throws IOException, NumberFormatException {
		
		ps.print("Ingrese un numero natural: ");
		int num = Integer.parseInt(br.readLine());

		boolean esPrimo = true;

		if (num <= 1) {
			esPrimo = false;
		} else {
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					esPrimo = false;
					break;
				}
			}
		}

		if (esPrimo) {
			ps.println("El numero ingresado es primo");
		} else {
			ps.println("El numero ingresado no es primo");
		}
		
	}
	
	
}
