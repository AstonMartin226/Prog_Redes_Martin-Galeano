package cliente;

//TU-CODIGO-UNICO: 4E0CEC3F Code: BAD0

import java.io.*;
import java.net.Socket;


public class MainCliente {

	public static void main(String[] args) {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Ingresa IP: ");
			String ip = input. readLine();
			
			System.out.print("Ingresa el puerto: ");
			int port = Integer.parseInt(input.readLine());
			
			Socket socket = new Socket(ip, port);
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintWriter ps = new PrintWriter(socket.getOutputStream(), true);
			
			System.out.println("Se ha conectado. Escriba algún comando. ");
			
			Thread listener = new Thread(() ->  {
				try {
					String linea;
					while ((linea = br.readLine()) != null) {
						System.out.println(linea);
					}
				} catch (Exception e) {
					System.out.println("Se ha cerrado la conexión.");
				}
			});
			listener.start();
			
			while (true) {
				String msg = input.readLine();
				if (msg == null) break;
				
				ps.println(msg);
				
				if (msg.equals("/logout")) break;
				
			}
			
			socket.close();
			
			
		} catch(Exception E) {
			System.out.println("Error conectando al servidor.");
		}
	}
}
