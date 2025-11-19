package server;

//código único del profe Galeano: "TU-CODIGO-UNICO: 7399A25E Code: 2EADED"
//Código único del profe Maldonado: "TU-CODIGO-UNICO: DA002AEC Code: 2EADED"

import java.io.*;
import java.net.*;
import java.util.*;


public class MainServer {

	private static final String Saludo = "Bienvenido al Servidor";
	private static List<ManejadorCliente> clientes = Collections.synchronizedList(new ArrayList<>());
	
	public static void main (String[] args) {
		
		try {
			
			ServerSocket server = new ServerSocket(5000);
			System.out.println("Servidor iniciado. Esperando clientes...");
			
			while(true) {
				Socket socket = server.accept();
				ManejadorCliente handler = new ManejadorCliente(socket);
				clientes.add(handler);
				handler.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static class ManejadorCliente extends Thread {
		
		Socket socket;
		BufferedReader in;
		PrintWriter out;
		
		public ManejadorCliente(Socket s) throws Exception {
			this.socket = s;
			this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			this.out = new PrintWriter(s.getOutputStream(), true);
		}
		
		@Override
		public void run() {
			try {
				
				out.println(Saludo);
				out.flush();
				
				while (true) {
					String msg = in.readLine();
					
					if (msg.equals("/hi")){
						out.println(Saludo);
					} else if (msg.equals("/logout")) {
						out.println("Desconectado");
						cerrarConexion();
						break;
					}else if (msg.startsWith("/")) {
						out.println("COMANDO DESCONOCIDO");
					}else {
						enviarPublico(msg);
					}
					
					
				}
				
			}catch (Exception e) {
				cerrarConexion();
			}
		}
		private void enviarPublico(String mensaje) {
			synchronized(clientes) {
				for (ManejadorCliente cli : clientes) {
					try {
						cli.out.println(mensaje);;
						
					}catch (Exception ignored) {}
				}
			}
		}
		
		private void cerrarConexion() {
			try {
				clientes.remove(this);
				socket.close();
			} catch(Exception ignored) {}
			
		}
	}
}
