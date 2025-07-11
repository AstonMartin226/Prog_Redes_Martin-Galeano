package Guia1_p2;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcion;

        System.out.println("BIENVENIDO AL SISTEMA DE EJERCICIOS");
        
        do {
            try {
                mostrarMenu();
                String input = reader.readLine();
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    // ========== EJERCICIOS DE LA CLASE "Ejercicios" ==========
                    case 1:
                        System.out.println("\nEJECUTANDO EJERCICIO 1 - Guardar ultimo numero valido");
                        Ejercicios.ejercicio1(args);
                        break;
                        
                    case 2:
                        System.out.println("\nEJECUTANDO EJERCICIO 2 - Guardar numeros validos");
                        Ejercicios.ejercicio2(args);
                        break;
                        
                    case 3:
                        System.out.println("\nEJECUTANDO EJERCICIO 3 - Numeros pares 0-1000");
                        Ejercicios.ejercicio3(args);
                        break;
                        
                    case 4:
                        System.out.println("\nEJECUTANDO EJERCICIO 4 - Leer archivo numeros");
                        Ejercicios.ejercicio4(args);
                        break;
                        
                    case 5:
                        System.out.println("\nEJECUTANDO EJERCICIO 5 - Eliminar multiplos de 3");
                        Ejercicios.ejercicio5(args);
                        break;
                        
                    case 6:
                        System.out.println("\nEJECUTANDO EJERCICIO 6 - Numeros primos");
                        Ejercicios.ejercicio6(args);
                        break;
                        
                    case 7:
                        System.out.println("\nEJECUTANDO EJERCICIO 7 - Palabras con ñ");
                        Ejercicios.ejercicio7(args);
                        break;
                        
                    case 8:
                        System.out.println("\nEJECUTANDO EJERCICIO 8 - Archivo HTML sin lorem");
                        Ejercicios.ejercicio8(args);
                        break;
                        
                    case 9:
                        System.out.println("\nEJECUTANDO EJERCICIO 9 - Sistema de datos climaticos");
                        Ejercicios.ejercicio9(args);
                        break;

                    // ========== EJERCICIOS DE LA CLASE "ejercicios_4" ==========
                    case 10:
                        System.out.println("\nEJECUTANDO EJERCICIO 10 - Lista de Numeros");
                        ejercicios_4.ListaNumeros lista = new ejercicios_4.ListaNumeros();
                        lista.leerValores();
                        lista.mostrarResultados();
                        break;
                        
                    case 11:
                        System.out.println("\nEJECUTANDO EJERCICIO 11 - Gestion de Alumnos");
                        ejercicios_4.Colegio colegio = new ejercicios_4.Colegio();
                        colegio.ejecutar();
                        break;
                        
                    case 12:
                        System.out.println("\nEJECUTANDO EJERCICIO 12 - Lista de Dias");
                        ejercicios_4.ListaDias listaDias = new ejercicios_4.ListaDias();
                        listaDias.ejecutarEjercicio();
                        break;
                        
                    case 13:
                        System.out.println("\nEJECUTANDO EJERCICIO 13 - Conjunto de Jugadores");
                        ejercicios_4.ConjuntoJugadores conjuntoJugadores = new ejercicios_4.ConjuntoJugadores();
                        conjuntoJugadores.ejecutarEjercicio();
                        break;
                        
                    case 14:
                        System.out.println("\nEJECUTANDO EJERCICIO 14 - Bolas de Dos Colores");
                        ejercicios_4.BolasDoColores bolasDoColores = new ejercicios_4.BolasDoColores();
                        bolasDoColores.ejecutarEjercicio();
                        break;

                    case 0:
                        System.out.println("\nGracias por usar el sistema! Hasta luego!");
                        break;

                    default:
                        System.out.println("\nOpcion invalida. Por favor, seleccione una opcion valida.");
                        break;
                }

                // Pausa antes de volver al menú (excepto si es salir)
                if (opcion != 0) {
                    System.out.println("\n" + "=".repeat(50));
                    System.out.println("Ejercicio completado. Presione Enter para volver al menu...");
                    reader.readLine();
                    System.out.println();
                }

            } catch (IOException e) {
                System.out.println("\nError de entrada/salida: " + e.getMessage());
                opcion = -1; // Para que no salga del bucle
            } catch (NumberFormatException e) {
                System.out.println("\nError: Debe ingresar un numero valido.");
                opcion = -1; // Para que no salga del bucle
            }

        } while (opcion != 0);

        // Cerrar el reader al final
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar el reader: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println("============================================================");
        System.out.println("                    MENU PRINCIPAL                     ");
        System.out.println("============================================================");
        System.out.println("EJERCICIOS DE ARCHIVOS:");
        System.out.println("  1.  Guardar ultimo numero valido");
        System.out.println("  2.  Guardar todos los numeros validos");
        System.out.println("  3.  Crear archivo con numeros pares (0-1000)");
        System.out.println("  4.  Leer y mostrar archivo de numeros");
        System.out.println("  5.  Eliminar multiplos de 3 del archivo");
        System.out.println("  6.  Extraer numeros primos a archivo");
        System.out.println("  7.  Reemplazar 'ñ' por 'nie-nio' en palabras");
        System.out.println("  8.  Eliminar lineas con 'lorem' de HTML");
        System.out.println("  9.  Sistema completo de datos climaticos");
        System.out.println();
        System.out.println("EJERCICIOS DE COLECCIONES:");
        System.out.println("  10. Lista de numeros con estadisticas");
        System.out.println("  11. Gestion de nacionalidades de alumnos");
        System.out.println("  12. Operaciones con lista de dias");
        System.out.println("  13. Conjunto de jugadores de futbol");
        System.out.println("  14. Generador de bolas de loteria");
        System.out.println();
        System.out.println("  0.  SALIR");
        System.out.println("============================================================");
        System.out.print("Seleccione una opcion: ");
    }
}