package ejercicio_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class liebre implements Runnable {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream ps = System.out;
    static PrintStream err = System.err;

    public static int probability(int min, int max) {
        int rango = (max - min) + 1;
        int random = (int) ((rango * Math.random()) + min);
        return random;
    }

    public void run() {
        int casillaActual = 0;
        while (casillaActual < 70) {
            int prob = probability(1, 100);
            if (casillaActual < 0) casillaActual = 0;
            if (prob > 0 && prob <= 14) {
                if (casillaActual > 70) casillaActual = 70;
                casillaActual = casillaActual + 0;
                ps.println("Liebre se queda estatica por un momento. No avanza casillas.");
            } else if (prob > 14 && prob <= 28) {
                casillaActual = casillaActual + 9;
                if (casillaActual > 70) casillaActual = 70;
                ps.println("Liebre acelera y avanza 9 casillas.");
            } else if (prob > 28 && prob <= 35) {
                casillaActual = casillaActual - 12;
                if (casillaActual < 0) casillaActual = 0;
                if (casillaActual > 70) casillaActual = 70;
                ps.println("Liebre choca con un obstaculo y retrocede 12 casillas.");
            } else if (prob > 35 && prob <= 56) {
                casillaActual = casillaActual + 1;
                if (casillaActual > 70) casillaActual = 70;
                ps.println("Liebre mantiene ritmo y avanza 1 casilla.");
            } else if (prob > 56 && prob < 70) {
                if (casillaActual < 0) casillaActual = 0;
                casillaActual = casillaActual - 2;
                if (casillaActual > 70) casillaActual = 70;
                ps.println("Liebre esquiva un obstaculo y retrocede 2 casillas.");
            }
            try {
                Thread.sleep(1000);
                ps.println("Liebre encuentras en la casilla: " + casillaActual);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
