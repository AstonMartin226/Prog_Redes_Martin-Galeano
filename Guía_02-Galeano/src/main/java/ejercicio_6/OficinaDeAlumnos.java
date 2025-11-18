package ejercicio_6;

import java.util.ArrayList;
import java.util.List;

public class OficinaDeAlumnos implements Runnable {

    public static List<Alumnos> listaAlumnos = new ArrayList<>();

    @Override
    public void run() {
        listaAlumnos.add(new Alumnos("Sebastión", "de León"));
        listaAlumnos.add(new Alumnos("Santiago", "Favereau"));
        listaAlumnos.add(new Alumnos("Benjamin", "Castro Madrid"));
        listaAlumnos.add(new Alumnos("Juan", "Luna"));

        System.out.println("OficinaDeAlumnos: se cargaron " + listaAlumnos.size() + " alumnos.\n");
    }
}