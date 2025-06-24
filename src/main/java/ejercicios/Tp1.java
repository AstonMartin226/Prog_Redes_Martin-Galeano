package ejercicios;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tp1 {
    
    public static void main(String[] args) {
        System.out.println("=== TRABAJO PRÁCTICO - MANEJO DE DATOS ===\n");
        
        // Variables principales
        int[] datosEnMemoria = new int[5];
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream output = System.out;
        
        // EJERCICIO 1: Cargar datos en memoria volátil y no volátil
        output.println(">>> EJERCICIO 1: Cargando datos desde múltiples orígenes <<<");
        cargarDatosVolatiles(datosEnMemoria, consoleReader, output);
        crearArchivoNoVolatil(output);
        
        // EJERCICIO 2: Procesar divisiones y manejar errores
        output.println("\n>>> EJERCICIO 2: Procesando divisiones y manejando excepciones <<<");
        procesarOperacionesMatematicas(datosEnMemoria, output);
        
        output.println("\n=== FINALIZACIÓN EXITOSA DEL PROGRAMA ===");
        output.println("Archivos generados: resultados.txt y error.txt");
    }
    
    /**
     * Carga datos en el vector desde diferentes fuentes
     */
    private static void cargarDatosVolatiles(int[] memoria, BufferedReader reader, PrintStream ps) {
        // Fuente 1: Dato basado en tiempo del sistema
        long timestamp = System.currentTimeMillis();
        memoria[0] = (int)(timestamp % 89); // Evitar patrones obvios
        
        // Fuente 2: Valor fijo predeterminado
        memoria[1] = 147;
        
        // Fuente 3: Entrada interactiva del usuario
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                ps.print("Por favor, introduce cualquier número entero: ");
                memoria[2] = Integer.parseInt(reader.readLine());
                entradaValida = true;
            } catch (IOException e) {
                ps.println("Error de I/O. Reintentando...");
            } catch (NumberFormatException e) {
                ps.println("Entrada inválida. Debe ser un número entero.");
            }
        }
        
        // Fuente 4: Forzar ingreso de cero (primer cero requerido)
        boolean ceroIngresado = false;
        while (!ceroIngresado) {
            try {
                ps.print("IMPORTANTE: Debes ingresar el número 0 exactamente: ");
                int valorIngresado = Integer.parseInt(reader.readLine());
                
                if (valorIngresado == 0) {
                    memoria[3] = valorIngresado;
                    ceroIngresado = true;
                } else {
                    ps.println("ERROR: Solo se acepta el valor 0. Intenta otra vez.");
                }
            } catch (IOException e) {
                ps.println("Problema de entrada. Reintentando...");
            } catch (NumberFormatException e) {
                ps.println("Debes ingresar un número válido (0).");
            }
        }
        
        // Fuente 5: Lectura desde archivo externo
        memoria[4] = obtenerDatoDesdeArchivo(ps);
        
        // Mostrar contenido del vector
        ps.println("\n--- CONTENIDO DEL VECTOR EN MEMORIA VOLÁTIL ---");
        for (int i = 0; i < memoria.length; i++) {
            ps.println("Posición " + i + ": " + memoria[i]);
        }
    }
    
    /**
     * Lee un dato desde un archivo de entrada
     */
    private static int obtenerDatoDesdeArchivo(PrintStream ps) {
        BufferedReader archivoReader = null;
        try {
            archivoReader = new BufferedReader(new FileReader("entrada.txt"));
            String contenido = archivoReader.readLine();
            return Integer.parseInt(contenido.trim());
        } catch (IOException e) {
            ps.println("Advertencia: No se pudo acceder a 'entrada.txt': " + e.getMessage());
            return 0; // Segundo cero requerido como fallback
        } catch (NumberFormatException e) {
            ps.println("Advertencia: Contenido inválido en 'entrada.txt'");
            return 0; // Segundo cero requerido como fallback
        } finally {
            if (archivoReader != null) {
                try {
                    archivoReader.close();
                } catch (IOException e) {
                    Logger.getLogger(Tp1.class.getName()).log(Level.WARNING, null, e);
                }
            }
        }
    }
    
    /**
     * Genera archivo con datos para memoria no volátil
     */
    private static void crearArchivoNoVolatil(PrintStream ps) {
        File archivoDestino = new File("datosNoVolatiles.txt");
        FileWriter escritorArchivo = null;
        BufferedWriter buffer = null;
        
        // Datos que incluyen los ceros requeridos
        int[] informacionPersistente = {
            obtenerDatoAleatorio(),
            78,
            0,    // Primer cero para memoria no volátil
            156,
            0,    // Segundo cero para memoria no volátil
            234
        };
        
        try {
            escritorArchivo = new FileWriter(archivoDestino, false);
            buffer = new BufferedWriter(escritorArchivo);
            
            buffer.write("--- DATOS ALMACENADOS EN MEMORIA NO-VOLÁTIL ---");
            buffer.newLine();
            
            for (int valor : informacionPersistente) {
                buffer.write(String.valueOf(valor));
                buffer.newLine();
            }
            
            buffer.newLine();
            buffer.write("Generado automáticamente por el sistema de procesamiento");
            
            ps.println("\n--- DATOS GUARDADOS EN ARCHIVO (MEMORIA NO-VOLÁTIL) ---");
            for (int i = 0; i < informacionPersistente.length; i++) {
                ps.println("Línea " + (i+1) + ": " + informacionPersistente[i]);
            }
            
            ps.println("✓ Archivo '" + archivoDestino.getName() + "' creado correctamente");
            
        } catch (IOException e) {
            Logger.getLogger(Tp1.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (buffer != null) buffer.close();
                if (escritorArchivo != null) escritorArchivo.close();
            } catch (IOException e) {
                Logger.getLogger(Tp1.class.getName()).log(Level.WARNING, null, e);
            }
        }
    }
    
    /**
     * Genera un dato pseudo-aleatorio basado en propiedades del sistema
     */
    private static int obtenerDatoAleatorio() {
        Runtime sistemaRuntime = Runtime.getRuntime();
        long memoriaDisponible = sistemaRuntime.freeMemory();
        return (int)(memoriaDisponible % 127);
    }
    
    /**
     * Procesa las operaciones matemáticas según especificación del TP
     */
    private static void procesarOperacionesMatematicas(int[] vector, PrintStream ps) {
        // Archivos de salida
        File archivoExitosos = new File("resultados.txt");
        File archivoErrores = new File("error.txt");
        
        BufferedWriter writerResultados = null;
        BufferedWriter writerErrores = null;
        
        try {
            // Inicializar escritores
            writerResultados = new BufferedWriter(new FileWriter(archivoExitosos));
            writerErrores = new BufferedWriter(new FileWriter(archivoErrores));
            
            ps.println("Ejecutando operación: numero ÷ (numero_siguiente - 3)");
            
            // Procesar cada elemento del vector
            for (int indice = 0; indice < vector.length; indice++) {
                int numeroActual = vector[indice];
                
                try {
                    // Verificar existencia del siguiente número
                    if (indice + 1 >= vector.length) {
                        throw new ArrayIndexOutOfBoundsException("No existe elemento siguiente en el vector");
                    }
                    
                    int numeroSiguiente = vector[indice + 1];
                    int divisorCalculado = numeroSiguiente - 3;
                    
                    // Verificar división por cero
                    if (divisorCalculado == 0) {
                        throw new ArithmeticException("El divisor resultante es cero");
                    }
                    
                    // Realizar cálculo
                    double resultadoOperacion = (double) numeroActual / divisorCalculado;
                    
                    // Guardar resultado exitoso
                    String lineaResultado = numeroActual + " / " + divisorCalculado + " = " + resultadoOperacion;
                    writerResultados.write(lineaResultado);
                    writerResultados.newLine();
                    
                    ps.println("✓ " + lineaResultado);
                    
                } catch (ArithmeticException excepcionAritmetica) {
                    int divisorProblematico = vector[indice + 1] - 3;
                    String mensajeError = numeroActual + " / " + divisorProblematico + " = ArithmeticException: " + excepcionAritmetica.getMessage();
                    
                    writerErrores.write(mensajeError);
                    writerErrores.newLine();
                    
                    ps.println("✗ " + mensajeError);
                    
                } catch (ArrayIndexOutOfBoundsException excepcionIndice) {
                    String mensajeError = numeroActual + " / n/a = ArrayIndexOutOfBoundsException: " + excepcionIndice.getMessage();
                    
                    writerErrores.write(mensajeError);
                    writerErrores.newLine();
                    
                    ps.println("✗ " + mensajeError);
                }
            }
            
            ps.println("\n✓ Procesamiento matemático completado exitosamente");
            
        } catch (IOException excepcionIO) {
            Logger.getLogger(Tp1.class.getName()).log(Level.SEVERE, null, excepcionIO);
        } finally {
            // Cerrar recursos de forma segura
            try {
                if (writerResultados != null) writerResultados.close();
                if (writerErrores != null) writerErrores.close();
            } catch (IOException e) {
                Logger.getLogger(Tp1.class.getName()).log(Level.WARNING, null, e);
            }
        }
    }
}