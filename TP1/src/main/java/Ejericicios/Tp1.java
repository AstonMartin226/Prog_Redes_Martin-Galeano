package Ejericicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tp1 {
    
    private static int[] vectorMemoria = new int[5];
    private static final String ARCHIVO_DATOS = "datos.txt";
    private static final String ARCHIVO_RESULTADOS = "resultados.txt";
    private static final String ARCHIVO_ERRORES = "error.txt";
    
    public static void main(String[] args) {
        System.out.println("=== INICIO DEL TRABAJO PRÁCTICO ===");
        
        System.out.println("\n1. Ingresando datos...");
        ingresarDatos();
        
        System.out.println("\n2. Procesando datos del vector...");
        procesarDatosVector();
        
        System.out.println("\n3. Procesando datos de ambos orígenes...");
        procesarDatosAmbosOrigenes();
        
        System.out.println("\n=== PROCESO COMPLETADO ===");
        System.out.println("Revisa los archivos generados: resultados.txt y error.txt");
    }
    
    private static void ingresarDatos() {
        int[] datosDelSistema = obtenerDatosDelSistema();
        int[] datosDeArchivo = generarDatosDeConfiguracion();
        
        System.out.println("=== ORIGEN 1: Datos del sistema ===");
        for (int i = 0; i < vectorMemoria.length; i++) {
            vectorMemoria[i] = datosDelSistema[i];
            System.out.println("Vector[" + i + "] = " + vectorMemoria[i]);
        }
        
        System.out.println("\n=== ORIGEN 2: Datos de configuración ===");
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_DATOS))) {
            for (int dato : datosDeArchivo) {
                writer.println(dato);
                System.out.println("Guardado en archivo: " + dato);
            }
        } catch (IOException e) {
            System.err.println("Error al crear archivo: " + e.getMessage());
        }
    }
    
    private static int[] obtenerDatosDelSistema() {
        long tiempoActual = System.currentTimeMillis();
        int dato1 = (int) (tiempoActual % 100);
        
        Runtime runtime = Runtime.getRuntime();
        long memoriaLibre = runtime.freeMemory();
        int dato2 = (int) (memoriaLibre % 50);
        
        String javaVersion = System.getProperty("java.version");
        int dato3 = javaVersion.length() % 10;
        
        int dato4 = 0;  // Primer cero
        int dato5 = 0;  // Segundo cero
        
        return new int[]{dato1, dato2, dato3, dato4, dato5};
    }
    
    private static int[] generarDatosDeConfiguracion() {
        int maxConexiones = 20;
        int timeout = 30;
        int reintentos = 0;      // Primer cero
        int bufferSize = 1024;
        int poolSize = 0;        // Segundo cero
        int puerto = 8080;
        
        return new int[]{maxConexiones, timeout, reintentos, bufferSize, poolSize, puerto};
    }
    
    private static void procesarDatosVector() {
        limpiarArchivos();
        
        System.out.println("División: numero ÷ (siguiente numero - 3)");
        
        for (int i = 0; i < vectorMemoria.length - 1; i++) {
            int numero1 = vectorMemoria[i];
            int numero2 = vectorMemoria[i + 1] - 3;
            
            realizarDivision(numero1, numero2, "Vector-Punto2");
        }
    }
    
    // IMPORTANTE: NO limpiar archivos, debe AGREGAR a los archivos del punto 2
    private static void procesarDatosAmbosOrigenes() {
        System.out.println("División: numero ÷ 3");
        
        for (int numero : vectorMemoria) {
            realizarDivision(numero, 3, "Vector-Punto3");
        }
        
        List<Integer> datosArchivo = leerDatosDelArchivo();
        for (int numero : datosArchivo) {
            realizarDivision(numero, 3, "Archivo-Punto3");
        }
    }
    
    // Usar división entera para que ArithmeticException funcione correctamente
    private static void realizarDivision(Integer numero1, Integer numero2, String origen) {
        try {
            if (numero1 == null || numero2 == null) {
                throw new NullPointerException("Valor nulo detectado");
            }
            
            int resultadoEntero = numero1 / numero2; // Para capturar ArithmeticException
            double resultado = (double) numero1 / numero2;
            
            String linea = numero1 + " / " + numero2 + " = " + resultado;
            guardarEnArchivo(ARCHIVO_RESULTADOS, linea);
            System.out.println("[" + origen + "] " + linea);
            
        } catch (ArithmeticException e) {
            String error = numero1 + " / " + numero2 + " = ERROR: División por cero";
            guardarEnArchivo(ARCHIVO_ERRORES, error);
            System.err.println("[" + origen + "] " + error);
            
        } catch (NullPointerException e) {
            String error = numero1 + " / " + numero2 + " = ERROR: Valor faltante (NullPointerException)";
            guardarEnArchivo(ARCHIVO_ERRORES, error);
            System.err.println("[" + origen + "] " + error);
            
        } catch (Exception e) {
            String error = numero1 + " / " + numero2 + " = ERROR: " + e.getMessage();
            guardarEnArchivo(ARCHIVO_ERRORES, error);
            System.err.println("[" + origen + "] " + error);
        }
    }
    
    private static List<Integer> leerDatosDelArchivo() {
        List<Integer> datos = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_DATOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                try {
                    int numero = Integer.parseInt(linea.trim());
                    datos.add(numero);
                } catch (NumberFormatException e) {
                    datos.add(null);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
        }
        
        return datos;
    }
    
    private static void guardarEnArchivo(String nombreArchivo, String contenido) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo, true))) {
            writer.println(contenido);
        } catch (IOException e) {
            System.err.println("Error al escribir en archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
    
    private static void limpiarArchivos() {
        try {
            new PrintWriter(ARCHIVO_RESULTADOS).close();
            new PrintWriter(ARCHIVO_ERRORES).close();
        } catch (IOException e) {
            System.err.println("Error al limpiar archivos: " + e.getMessage());
        }
    }
}