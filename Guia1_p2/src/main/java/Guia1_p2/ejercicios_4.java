package Guia1_p2;

import java.io.*;
import java.util.*;

public class ejercicios_4 {

    // ==================== EJERCICIO 1 ====================
    public static class ListaNumeros {
        private List<Integer> numeros;
        private BufferedReader reader;

        // Constructor
        public ListaNumeros() {
            numeros = new ArrayList<>();
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        // Método para leer valores desde el teclado
        public void leerValores() throws IOException {
            System.out.println("Ingrese números enteros (termina con -99):");

            int numero;
            do {
                System.out.print("Número: ");
                String input = reader.readLine();
                numero = Integer.parseInt(input);

                if (numero != -99) {
                    numeros.add(numero);
                }
            } while (numero != -99);

            System.out.println("✓ Lectura de números terminada.");
        }

        // Método para calcular la suma de todos los valores
        public int calcularSuma() {
            int suma = 0;
            for (Integer numero : numeros) {
                suma += numero;
            }
            return suma;
        }

        // Método para mostrar todos los resultados
        public void mostrarResultados() {
            if (numeros.isEmpty()) {
                System.out.println("No se ingresaron números.");
                return;
            }

            int suma = calcularSuma();
            double promedio = (double) suma / numeros.size();

            // Mostrar todos los números ingresados
            for (Integer numero : numeros) {
                System.out.println(numero);
            }

            // Mostrar promedio y suma
            System.out.println("al calcular el promedio te da " + promedio);
            System.out.println("la suma de los numeros te da " + suma);

            // Mostrar números mayores al promedio
            System.out.print("los numeros mayores al promedio son:\n");
            boolean primero = true;
            for (Integer numero : numeros) {
                if (numero > promedio) {
                    if (!primero) {
                        System.out.print(", ");
                    }
                    System.out.print(numero);
                    primero = false;
                }
            }
            System.out.println(); // Nueva línea al final
        }

        // Método main para ejecutar solo el ejercicio de ListaNumeros
        public static void main(String[] args) {
            ListaNumeros lista = new ListaNumeros();
            try {
                lista.leerValores();
                lista.mostrarResultados();
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar números enteros válidos.");
            }
        }
    }

    // ==================== EJERCICIO 2 ====================
    public static class Colegio {
        // HashMap para almacenar nacionalidad y cantidad de alumnos
        private HashMap<String, Integer> nacionalidades;
        private BufferedReader reader;

        // Constructor
        public Colegio() {
            nacionalidades = new HashMap<>();
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        // Añade la nacionalidad de un nuevo alumno pidiendo datos al usuario
        public void addAlumno() throws IOException {
            System.out.print("Ingrese la nacionalidad del alumno: ");
            String nacionalidad = reader.readLine();

            if (nacionalidades.containsKey(nacionalidad)) {
                // Si ya existe, incrementa el contador
                nacionalidades.put(nacionalidad, nacionalidades.get(nacionalidad) + 1);
            } else {
                // Si no existe, la añade con contador 1
                nacionalidades.put(nacionalidad, 1);
            }
            System.out.println("✓ Alumno de " + nacionalidad + " agregado!");
        }

        // Muestra todas las nacionalidades y el número de alumnos
        public void showAll() {
            if (nacionalidades.isEmpty()) {
                System.out.println("No hay alumnos registrados.");
                return;
            }

            System.out.println("Nacionalidades en el colegio:");
            for (Map.Entry<String, Integer> entry : nacionalidades.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " alumnos");
            }
        }

        // Muestra la nacionalidad específica y el número de alumnos
        public void showNacionalidad() throws IOException {
            System.out.print("Ingrese la nacionalidad a consultar: ");
            String nacionalidad = reader.readLine();

            if (nacionalidades.containsKey(nacionalidad)) {
                System.out.println(nacionalidad + ": " + nacionalidades.get(nacionalidad) + " alumnos");
            } else {
                System.out.println("No hay alumnos de nacionalidad " + nacionalidad);
            }
        }

        // Muestra cuántas nacionalidades diferentes existen
        public void cuantos() {
            System.out.println("Hay " + nacionalidades.size() + " nacionalidades diferentes");
        }

        // Elimina todos los datos
        public void borra() {
            nacionalidades.clear();
            System.out.println("Todos los datos han sido eliminados.");
        }

        // Método principal con menú interactivo
        public void ejecutar() throws IOException {
            int opcion;
            do {
                mostrarMenu();
                String input = reader.readLine();
                opcion = Integer.parseInt(input);

                switch (opcion) {
                case 1:
                    addAlumno();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    showNacionalidad();
                    break;
                case 4:
                    cuantos();
                    break;
                case 5:
                    borra();
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                }
                System.out.println(); // Línea en blanco para separar
            } while (opcion != 6);
        }

        private void mostrarMenu() {
            System.out.println("=== SISTEMA DE GESTIÓN DE ALUMNOS ===");
            System.out.println("1. Añadir alumno");
            System.out.println("2. Mostrar todas las nacionalidades");
            System.out.println("3. Consultar nacionalidad específica");
            System.out.println("4. Mostrar cantidad de nacionalidades");
            System.out.println("5. Borrar todos los datos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
        }

        // Método main para ejecutar solo el ejercicio de Colegio
        public static void main(String[] args) {
            Colegio colegio = new Colegio();
            try {
                colegio.ejecutar();
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            }
        }
    }

    // ==================== EJERCICIO 3 ====================
    public static class ListaDias {
        private ArrayList<String> listDias;

        // Constructor
        public ListaDias() {
            listDias = new ArrayList<>();
            inicializarDias();
        }

        // Inicializar la lista con los días de la semana
        private void inicializarDias() {
            listDias.add("Lunes");
            listDias.add("Martes");
            listDias.add("Miércoles");
            listDias.add("Jueves");
            listDias.add("Viernes");
            listDias.add("Sábado");
            listDias.add("Domingo");
        }

        public void ejecutarEjercicio() {
            System.out.println("=== EJERCICIO DE LISTA DE DÍAS ===\n");

            // 1. Mostrar lista inicial
            System.out.println("1. Lista inicial de días:");
            mostrarLista(listDias);

            // 2. Insertar "Juernes" en posición 4
            listDias.add(4, "Juernes");
            System.out.println("\n2. Después de insertar 'Juernes' en posición 4:");
            mostrarLista(listDias);

            // 3. Crear copia de la lista
            ArrayList<String> listaDos = new ArrayList<>(listDias);
            System.out.println("\n3. Se creó listaDos (copia de la lista original)");

            // 4. Añadir contenido de listaDos a listDias
            listDias.addAll(listaDos);
            System.out.println("\n4. Después de añadir listaDos a listDias:");
            mostrarLista(listDias);

            // 5. Mostrar posiciones 3 y 4
            System.out.println("\n5. Contenido de posiciones 3 y 4:");
            System.out.println("Posición 3: " + listDias.get(3));
            System.out.println("Posición 4: " + listDias.get(4));

            // 6. Mostrar primer y último elemento
            System.out.println("\n6. Primer y último elemento:");
            System.out.println("Primer elemento: " + listDias.get(0));
            System.out.println("Último elemento: " + listDias.get(listDias.size() - 1));

            // 7. Eliminar "Juernes"
            System.out.println("\n7. Eliminando 'Juernes':");
            boolean eliminado = listDias.remove("Juernes");
            if (eliminado) {
                System.out.println("✓ Se eliminó 'Juernes' de la lista");
            } else {
                System.out.println("✗ No se encontró 'Juernes' para eliminar");
            }
            mostrarLista(listDias);

            // 8. Mostrar con Iterator
            System.out.println("\n8. Mostrando elementos con Iterator:");
            Iterator<String> iterator = listDias.iterator();
            int contador = 1;
            while (iterator.hasNext()) {
                System.out.println(contador + ". " + iterator.next());
                contador++;
            }

            // 9. Buscar "Lunes" (case insensitive)
            System.out.println("\n9. Buscando 'Lunes' (case insensitive):");
            boolean encontrado = false;
            for (String dia : listDias) {
                if (dia.equalsIgnoreCase("lunes")) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                System.out.println("✓ Se encontró 'Lunes' en la lista");
            } else {
                System.out.println("✗ No se encontró 'Lunes' en la lista");
            }

            // 10. Ordenar y mostrar
            Collections.sort(listDias);
            System.out.println("\n10. Lista ordenada alfabéticamente:");
            mostrarLista(listDias);
        }

        private void mostrarLista(ArrayList<String> lista) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(i + ": " + lista.get(i));
            }
        }

        // Método main para ejecutar solo este ejercicio
        public static void main(String[] args) {
            ListaDias ejercicio = new ListaDias();
            ejercicio.ejecutarEjercicio();
        }
    }

    // ==================== EJERCICIO 4 ====================
    public static class ConjuntoJugadores {
        private HashSet<String> jugadores;

        // Constructor
        public ConjuntoJugadores() {
            jugadores = new HashSet<>();
            inicializarJugadores();
        }

        // Inicializar el conjunto con jugadores del FC Barcelona
        private void inicializarJugadores() {
            jugadores.add("Jordi Alba");
            jugadores.add("Pique");
            jugadores.add("Busquets");
            jugadores.add("Iniesta");
            jugadores.add("Messi");
        }

        public void ejecutarEjercicio() {
            System.out.println("=== EJERCICIO DE CONJUNTO DE JUGADORES ===\n");

            // 1. Mostrar conjunto inicial con iteración
            System.out.println("1. Jugadores del FC Barcelona:");
            for (String jugador : jugadores) {
                System.out.println("- " + jugador);
            }

            // 2. Consultar si existe "Neymar JR"
            System.out.println("\n2. ¿Existe 'Neymar JR' en el conjunto?");
            if (jugadores.contains("Neymar JR")) {
                System.out.println("✓ Sí, Neymar JR está en el conjunto");
            } else {
                System.out.println("✗ No, Neymar JR NO está en el conjunto");
            }

            // 3. Crear segundo conjunto jugadores2
            HashSet<String> jugadores2 = new HashSet<>();
            jugadores2.add("Pique");
            jugadores2.add("Busquets");
            
            System.out.println("\n3. Segundo conjunto jugadores2 creado:");
            for (String jugador : jugadores2) {
                System.out.println("- " + jugador);
            }

            // 4. Consultar si todos los elementos de jugadores2 están en jugadores
            System.out.println("\n4. ¿Están todos los jugadores de jugadores2 en jugadores?");
            if (jugadores.containsAll(jugadores2)) {
                System.out.println("✓ Sí, todos los jugadores de jugadores2 están en jugadores");
            } else {
                System.out.println("✗ No, algunos jugadores de jugadores2 NO están en jugadores");
            }

            // 5. Unión de conjuntos
            System.out.println("\n5. Realizando unión de conjuntos...");
            System.out.println("Tamaño antes de la unión: " + jugadores.size());
            jugadores.addAll(jugadores2);
            System.out.println("Tamaño después de la unión: " + jugadores.size());
            System.out.println("(No cambió porque ya contenía esos elementos)");

            // 6. Demostrar que no permite duplicados
            System.out.println("\n6. Intentando agregar 'Pique' nuevamente...");
            boolean agregado = jugadores.add("Pique");
            if (agregado) {
                System.out.println("✓ Se agregó Pique");
            } else {
                System.out.println("✗ NO se pudo agregar Pique - ya existe en el conjunto");
            }
            
            System.out.println("Tamaño final del conjunto: " + jugadores.size());

            // 7. Mostrar conjunto final
            System.out.println("\n7. Conjunto final de jugadores:");
            for (String jugador : jugadores) {
                System.out.println("- " + jugador);
            }

            // 8. Demostrar con Iterator
            System.out.println("\n8. Mostrando con Iterator:");
            Iterator<String> iterator = jugadores.iterator();
            int contador = 1;
            while (iterator.hasNext()) {
                System.out.println(contador + ". " + iterator.next());
                contador++;
            }
        }

        // Método main para ejecutar solo este ejercicio
        public static void main(String[] args) {
            ConjuntoJugadores ejercicio = new ConjuntoJugadores();
            ejercicio.ejecutarEjercicio();
        }
    }

    // ==================== EJERCICIO 5 ====================
    public static class BolasDoColores {
        private Random random;
        private BufferedReader reader;

        // Constructor
        public BolasDoColores() {
            random = new Random();
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public void ejecutarEjercicio() throws IOException {
            System.out.println("=== GENERADOR DE BOLAS DE DOS COLORES ===\n");
            
            System.out.println("Reglas del juego:");
            System.out.println("- 6 números de bolas rojas (1-33, sin repetir)");
            System.out.println("- 1 número de bola azul (1-16)");
            System.out.println();

            // Menú simple
            String opcion;
            do {
                System.out.println("¿Desea generar una combinación? (s/n): ");
                opcion = reader.readLine().toLowerCase();
                
                if (opcion.equals("s") || opcion.equals("si")) {
                    generarCombinacion();
                    System.out.println();
                }
            } while (opcion.equals("s") || opcion.equals("si"));
            
            System.out.println("¡Gracias por jugar!");
        }

        private void generarCombinacion() {
            // Generar 6 bolas rojas únicas (1-33)
            HashSet<Integer> bolasRojas = new HashSet<>();
            
            // Usar while hasta tener 6 números únicos
            while (bolasRojas.size() < 6) {
                int numeroRojo = random.nextInt(33) + 1; // 1-33
                bolasRojas.add(numeroRojo);
            }
            
            // Generar 1 bola azul (1-16)
            int bolaAzul = random.nextInt(16) + 1; // 1-16
            
            // Convertir HashSet a ArrayList para poder ordenar
            ArrayList<Integer> rojasOrdenadas = new ArrayList<>(bolasRojas);
            Collections.sort(rojasOrdenadas);
            
            // Mostrar resultado
            System.out.println("🔴 COMBINACIÓN GENERADA 🔴");
            System.out.println("═══════════════════════════");
            
            System.out.print("Bolas Rojas: ");
            for (int i = 0; i < rojasOrdenadas.size(); i++) {
                System.out.print("🔴" + rojasOrdenadas.get(i));
                if (i < rojasOrdenadas.size() - 1) {
                    System.out.print(" - ");
                }
            }
            System.out.println();
            
            System.out.println("Bola Azul:   🔵" + bolaAzul);
            System.out.println("═══════════════════════════");
        }

        // Método para generar múltiples combinaciones automáticamente
        public void generarVariasCombinaciones(int cantidad) {
            System.out.println("=== GENERANDO " + cantidad + " COMBINACIONES ===\n");
            
            for (int i = 1; i <= cantidad; i++) {
                System.out.println("Combinación #" + i + ":");
                generarCombinacion();
                System.out.println();
            }
        }

        // Método main para ejecutar solo este ejercicio
        public static void main(String[] args) {
            BolasDoColores ejercicio = new BolasDoColores();
            try {
                ejercicio.ejecutarEjercicio();
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            }
        }
    }
}