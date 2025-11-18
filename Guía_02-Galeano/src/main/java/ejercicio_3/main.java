package ejercicio3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import javax.swing.JOptionPane;

public class main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream ps = System.out;
    static PrintStream err = System.err;

    public static void main(String[] args) {
        try {
            Thread jojo = new Thread(new Liebre());
            Thread gyro = new Thread(new Tortuga());
            ps.println("¡Comienza la carrera Steel Ball Run!");
            Thread.sleep(2000);
            jojo.start();
            gyro.start();
            while (true) {
                if (jojo.isAlive() && !gyro.isAlive()) {
                    var output = "El ganador es Tortuga.";
                    JOptionPane.showMessageDialog(null, output);
                    break;
                } else if (!jojo.isAlive() && gyro.isAlive()) {
                    var output = "El ganador es Liebre.";
                    JOptionPane.showMessageDialog(null, output);
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
