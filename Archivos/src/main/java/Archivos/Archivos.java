package Archivos;

import java.io.PrintStream;
import java.lang.System.Logger.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Archivos {

	PrintStream ps;
	File file;

	public Archivos() {
		ps = new PrintStream(System.out);

		// "\\user\\gonza\\miArchivito.txt"
		file = new File("miArchivito.txt");
		/*
		 * file.createNewFile(); file.delete(); file.deleteOnExit(); file.exists();
		 * file.getAbsoluteFile(); file.getName(); file.getParent();
		 * file.getTotalSpace(); file.isHidden(); file.isDirectory(); file.isFile();
		 * file.list(); file.listFiles(); file.mkdir(); file.renameTo(new File("file"));
		 */

		this.rutaFiles(file);
		this.crearFileConPrintStreamEasy(file);

	}

	/*
	 * ESTE TEXTO NO TIENE NINGUNA ETIQUETA DE IDENTIFICACION. ESTO NO VA A
	 * AAPARECER :( Tambien se puede agregar referencias a class o methodos o
	 * atributos con la instruccion: {
	 *
	 * @ por ejemplo: {@code <html></html>} o usar {@link String}
	 *
	 * @param f Este metodo recibe un archivo.
	 * 
	 * @see FlujoDeDatos.File.
	 * 
	 * @since v1.0
	 */

	public void rutaFiles(File f) {
	}

	public void crearFileConPrintStreamEasy(File f) {

		FileOutputStream fos = null;
		PrintStream fs = null;
		try {
			fos = new FileOutputStream(f);
			fs = new PrintStream(fos);

			fs.print("Una línea");
			fs.println("Nueva línea");
			fs.write(null);
			fs.append(("HOLAA"));

			fs.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Logger.getLogger(Archivos.class.getName()).log(Level.WARNING,null);
		} finally {
			try {
				if (fs != null)
					fs.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();

			}
		}

	}

	public void crearFileConPrinter(File f) {
	}

	/**
	 *
	 * @param f
	 */
	public void crearFileConBuffer(File f) {
	}

	/**
	 *
	 * @param f
	 */
	public void crearFileConBuffer(File f) {
	}

	/**
	 * Descripcion
	 *
	 * @param f un archivo al leer
	 * @return Todo el texto leido.
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String LeerFileConBuffer(File f) throws FileNotFoundException, IOException {
	}

	public void leerFileCaracterAcaractet(File f) {
	}

}
