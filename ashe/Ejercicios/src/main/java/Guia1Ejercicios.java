
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.io.InputStreamReader;



public class Guia1Ejercicios {

	
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps = new PrintStream(System.out);
        PrintStream psErr = new PrintStream(System.err);
		
		
	// Ejercicios punto 1
		
	//A.
		
		
		/*
		try {
			System.out.print("Ingrese el valor de la hora de trabajo: ");
			double valorHora = Double.parseDouble(reader.readLine());
			
			System.out.print("Ingrese la cantidad de horas trabajadas: ");
			double horasTrabajadas = Double.parseDouble(reader.readLine());
			
			double sueldoBruto = valorHora * horasTrabajadas;
			
			System.out.println("El sueldo bruto es: %" + sueldoBruto);
			
			reader.close();
		} catch (IOException e) {
			System.out.println("Ocurrió un error de entrada/salida: " + e.getMessage());
		}	catch (NumberFormatException e) {
				System.out.println("Debe ingresar un número válido. ");
			}
			
			*/
		
		
		//B.
		
		/*
		try {
			System.out.print("Ingrese el primer ángulo: ");
			double angulo1 = Double.parseDouble(reader.readLine());
			
			System.out.print("Ingrese el segundo ángulo: ");
			double angulo2 = Double.parseDouble(reader.readLine());
			
			
			double angulo3 = 180 - (angulo1 + angulo2);
			
			System.out.println("El valor del tercer ángulo es: " + angulo3 + "°");
			
			reader.close();
		} catch (IOException e) {
			System.out.println("Ocurrió un error de entrada/salida: " + e.getMessage());
		}	catch (NumberFormatException e) {
				System.out.println("Debe ingresar un número válido. ");
			}
			
		*/
		
		
		//C.
		
		/*
		
		try {
			System.out.print("Ingrese la superficie del cuadrado en m2: ");
			double superficie = Double.parseDouble(reader.readLine());
			
			double perimetro = 4 * Math.sqrt(superficie);
			
			System.out.println("El perímetro del cuadrado es el siguiente: " + perimetro + "m");
			
			reader.close();
		} catch (IOException e) {
			System.out.println("Ocurrió un error de entrada/salida: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Debe ingresar un número válido. ");
		}
		
	*/
		
		
		//D.
		
		
		/*
		try {
			System.out.print("Ingrese la temperatura en grados fahrenheit ");
			double fahrenheit = Double.parseDouble(reader.readLine());
			
			double centigrado = (fahrenheit - 32) * 5 / 9;
			
			System.out.println("La temperatura en grados centígrados es " + centigrado + "°");
			
			reader.close();
		} catch (IOException e) {
			System.out.println("Ocurrió un error de entrada/salida: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Debe ingresar un número válido. ");
			
		}
		
		*/
		
		
		//E
		
        
        /*
		   try {
	        	ps.print("Ingrese una cantidad de segundos: ");
	            int segundosIn = Integer.parseInt(reader.readLine());
	            
	            int segundos = 0;
	            int minutos = 0;
	            int horas = 0;
	            int dias = 0;
	            
	            while (segundosIn > 0) {
	            	if (segundos < 60) {
	            		segundos = segundos + 1;
	            	} else {
	            		minutos = minutos + 1;
	            		segundos = 0;
	            	}
	            	
	            	if (minutos == 59) {
	            		horas = horas + 1;
	            		minutos = 0;
	            	}
	            	
	            	if (horas == 24) {
	            		dias = dias + 1;
	            		horas = 0;
	            	}
	            	
	            	segundosIn = segundosIn - 1;
	            }
	            
	            ps.println("Los segundos ingresados equivalen a: " + dias + " dias, " + horas + " horas, " + minutos + " minutos y " + segundos + " segundos");
	        
	        } catch (IOException e) {
	        	psErr.println("Error de entrada: " + e.getMessage());
	        } catch (NumberFormatException e) {
	            psErr.println("Por favor, ingrese solo números válidos.");
	        }
		
		*/
		
		
		
		}
		
		
		
		
		
		
		}
		

		
		
		
		
		
		
	
