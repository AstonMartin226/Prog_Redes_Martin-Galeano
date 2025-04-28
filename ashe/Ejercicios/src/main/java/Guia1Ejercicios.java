
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.io.InputStreamReader;
import java.io.*;


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
		
		//F
        
        /*
        
        try {
            
            System.out.print("Ingrese el precio del artículo: ");
            int precio = Integer.parseInt(reader.readLine());
            
            
            double plan1 = precio - (precio * 0.1);
            
      
            double plan2 = precio + (precio * 0.1);
            double plan2Cont = plan2 / 2;  
            double plan2Cuot = (plan2 - plan2Cont) / 2;  
            
           
            double plan3 = precio + (precio * 0.15);
            double plan3Cont = plan3 * 0.25;  
            double plan3Cuot = (plan3 - plan3Cont) / 5;  
            
           
            double plan4 = precio + (precio * 0.25);
            double plan4Cuot1 = (plan4 * 0.6) / 4;  
            double plan4Cuot2 = (plan4 * 0.4) / 4;  
            
       
            ps.println("A continuación se muestran los precios a pagar en cada plan para este producto:");
            ps.println("Plan 1: $" + plan1 + " (todo al contado)");
            ps.println("Plan 2: $" + plan2 + " ($" + plan2Cont + " al contado y 2 cuotas de $" + plan2Cuot + ")");
            ps.println("Plan 3: $" + plan3 + " ($" + plan3Cont + " al contado y 5 cuotas de $" + plan3Cuot + ")");
            ps.println("Plan 4: $" + plan4 + " (4 cuotas de $" + plan4Cuot1 + " y 4 cuotas de $" + plan4Cuot2 + ")");
            
            reader.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error de entrada/salida: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Debe ingresar un número válido.");
        }
        
        */
        
        
        //g
		
        try {
            ps.print("Ingrese su signo del zodiaco en minusculas: ");
            String signo = reader.readLine().toLowerCase(); // Convertir a minúsculas para evitar problemas con mayúsculas

            switch (signo) {
                case "aries":
                    ps.println("Mes aproximado: Marzo - Abril");
                    break;
                case "tauro":
                    ps.println("Mes aproximado: Abril - Mayo");
                    break;
                case "geminis":  // Aquí solo usamos "geminis", porque ya lo convertimos a minúsculas
                    ps.println("Mes aproximado: Mayo - Junio");
                    break;
                case "cancer":
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
                    ps.println("Signo no reconocido. Asegurate de escribirlo correctamente.");
            }
        } catch (IOException e) {
            ps.println("Hubo un error al leer la entrada.");
        }
        
        
		}
	
}
		
		
		
		
		
		
		
		

		
		
		
		
		
		
	
