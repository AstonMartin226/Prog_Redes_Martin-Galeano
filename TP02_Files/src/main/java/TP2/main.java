package TP2;

import java.io.*;
import java.util.*;

public class main {
    
    static Scanner scanner = new Scanner(System.in);
    static File archivo = new File("Inventario.dat");
    
    public static void main(String[] args) {
        crearArchivo();
        
        while(true) {
            mostrarMenu();
            String opcion = leerTexto();
            
            switch(opcion) {
                case "1":
                    agregarProducto();
                    break;
                case "2":
                    mostrarInventario();
                    break;
                case "3":
                    eliminarProducto();
                    break;
                case "4":
                    editarProducto();
                    break;
                case "5":
                    System.out.println("\u001B[32mGracias por usar el sistema!\u001B[0m");
                    return;
                default:
                    System.out.println("\u001B[31mOpcion no valida\u001B[0m");
            }
        }
    }
    
    static void mostrarMenu() {
        System.out.println("\u001B[34m\n=== SISTEMA DE INVENTARIO ===\u001B[0m");
        System.out.println("1. Agregar producto");
        System.out.println("2. Mostrar inventario");
        System.out.println("3. Eliminar producto");
        System.out.println("4. Editar producto");
        System.out.println("5. Salir");
        System.out.print("\u001B[36mSelecciona una opcion: \u001B[0m");
    }
    
    static String leerTexto() {
        return scanner.nextLine();
    }
    
    static int identificarNumero(String texto) {
        try {
            Integer.parseInt(texto);
            return 1;
        } catch (NumberFormatException e) {
            try {
                Float.parseFloat(texto);
                return 2;
            } catch (NumberFormatException e2) {
                return 0;
            }
        }
    }
    
    static int textoAEntero(String texto) {
        return Integer.parseInt(texto);
    }
    
    static float textoAFloat(String texto) {
        return Float.parseFloat(texto);
    }
    
    static void crearArchivo() {
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("\u001B[31mError creando archivo\u001B[0m");
        }
    }
    
    static void agregarProducto() {
        System.out.println("\u001B[33m\n--- AGREGAR PRODUCTO ---\u001B[0m");
        
        System.out.print("Nombre del producto: ");
        String nombre = leerTexto();
        
        String precioCompra = "";
        while(true) {
            System.out.print("Precio de compra: ");
            precioCompra = leerTexto();
            if(identificarNumero(precioCompra) != 0) {
                break;
            }
            System.out.println("\u001B[31mIngresa un numero valido\u001B[0m");
        }
        
        String precioVenta = "";
        while(true) {
            System.out.print("Precio de venta: ");
            precioVenta = leerTexto();
            if(identificarNumero(precioVenta) != 0) {
                break;
            }
            System.out.println("\u001B[31mIngresa un numero valido\u001B[0m");
        }
        
        String stock = "";
        while(true) {
            System.out.print("Stock: ");
            stock = leerTexto();
            if(identificarNumero(stock) == 1) {
                break;
            }
            System.out.println("\u001B[31mEl stock debe ser un numero entero\u001B[0m");
        }
        
        guardarProducto(nombre, precioCompra, precioVenta, stock);
        System.out.println("\u001B[32mProducto agregado!\u001B[0m");
    }
    
    static void guardarProducto(String nombre, String precioCompra, String precioVenta, String stock) {
        try {
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            String linea = nombre + ";" + precioCompra + ";" + precioVenta + ";" + stock;
            bw.write(linea);
            bw.newLine();
            
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("\u001B[31mError guardando producto\u001B[0m");
        }
    }
    
    static ArrayList<String> leerArchivo() {
        ArrayList<String> productos = new ArrayList<String>();
        
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
            while((linea = br.readLine()) != null) {
                productos.add(linea);
            }
            
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("\u001B[31mError leyendo archivo\u001B[0m");
        }
        
        return productos;
    }
    
    static void mostrarInventario() {
        ArrayList<String> productos = leerArchivo();
        
        if(productos.size() == 0) {
            System.out.println("\u001B[33mNo hay productos en el inventario\u001B[0m");
            return;
        }
        
        System.out.println("\u001B[33m\n--- INVENTARIO ---\u001B[0m");
        System.out.println("ID\tNOMBRE\t\t\tP.COMPRA\tP.VENTA\t\tSTOCK");
        System.out.println("------------------------------------------------------------------");
        
        for(int i = 0; i < productos.size(); i++) {
            String[] datos = productos.get(i).split(";");
            System.out.printf("%d\t%-20s\t$%-10s\t$%-10s\t%s\n", 
                            (i+1), datos[0], datos[1], datos[2], datos[3]);
        }
    }
    
    static void eliminarProducto() {
        ArrayList<String> productos = leerArchivo();
        
        if(productos.size() == 0) {
            System.out.println("\u001B[33mNo hay productos para eliminar\u001B[0m");
            return;
        }
        
        mostrarInventario();
        
        System.out.print("\nIngresa el ID del producto a eliminar: ");
        String idTexto = leerTexto();
        
        if(identificarNumero(idTexto) == 1) {
            int id = textoAEntero(idTexto);
            
            if(id >= 1 && id <= productos.size()) {
                productos.remove(id - 1);
                reescribirArchivo(productos);
                System.out.println("\u001B[32mProducto eliminado!\u001B[0m");
            } else {
                System.out.println("\u001B[31mID no valido\u001B[0m");
            }
        } else {
            System.out.println("\u001B[31mIngresa un numero valido\u001B[0m");
        }
    }
    
    static void editarProducto() {
        ArrayList<String> productos = leerArchivo();
        
        if(productos.size() == 0) {
            System.out.println("\u001B[33mNo hay productos para editar\u001B[0m");
            return;
        }
        
        mostrarInventario();
        
        System.out.print("\nIngresa el ID del producto a editar: ");
        String idTexto = leerTexto();
        
        if(identificarNumero(idTexto) == 1) {
            int id = textoAEntero(idTexto);
            
            if(id >= 1 && id <= productos.size()) {
                String[] datosActuales = productos.get(id - 1).split(";");
                
                System.out.println("\u001B[33m\nEditando producto: " + datosActuales[0] + "\u001B[0m");
                
                System.out.print("Nuevo nombre (actual: " + datosActuales[0] + "): ");
                String nuevoNombre = leerTexto();
                if(nuevoNombre.equals("")) {
                    nuevoNombre = datosActuales[0];
                }
                
                String nuevoPrecioCompra = datosActuales[1];
                while(true) {
                    System.out.print("Nuevo precio compra (actual: " + datosActuales[1] + "): ");
                    String entrada = leerTexto();
                    if(entrada.equals("")) {
                        break;
                    }
                    if(identificarNumero(entrada) != 0) {
                        nuevoPrecioCompra = entrada;
                        break;
                    }
                    System.out.println("\u001B[31mIngresa un numero valido\u001B[0m");
                }
                
                String nuevoPrecioVenta = datosActuales[2];
                while(true) {
                    System.out.print("Nuevo precio venta (actual: " + datosActuales[2] + "): ");
                    String entrada = leerTexto();
                    if(entrada.equals("")) {
                        break;
                    }
                    if(identificarNumero(entrada) != 0) {
                        nuevoPrecioVenta = entrada;
                        break;
                    }
                    System.out.println("\u001B[31mIngresa un numero valido\u001B[0m");
                }
                
                String nuevoStock = datosActuales[3];
                while(true) {
                    System.out.print("Nuevo stock (actual: " + datosActuales[3] + "): ");
                    String entrada = leerTexto();
                    if(entrada.equals("")) {
                        break;
                    }
                    if(identificarNumero(entrada) == 1) {
                        nuevoStock = entrada;
                        break;
                    }
                    System.out.println("\u001B[31mEl stock debe ser un numero entero\u001B[0m");
                }
                
                String productoEditado = nuevoNombre + ";" + nuevoPrecioCompra + ";" + nuevoPrecioVenta + ";" + nuevoStock;
                productos.set(id - 1, productoEditado);
                reescribirArchivo(productos);
                
                System.out.println("\u001B[32mProducto editado!\u001B[0m");
            } else {
                System.out.println("\u001B[31mID no valido\u001B[0m");
            }
        } else {
            System.out.println("\u001B[31mIngresa un numero valido\u001B[0m");
        }
    }
    
    static void reescribirArchivo(ArrayList<String> productos) {
        try {
            FileWriter fw = new FileWriter(archivo, false);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(String producto : productos) {
                bw.write(producto);
                bw.newLine();
            }
            
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("\u001B[31mError actualizando archivo\u001B[0m");
        }
    }
}