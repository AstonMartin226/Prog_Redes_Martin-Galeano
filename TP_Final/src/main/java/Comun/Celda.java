package Comun;

/**
 * Representa una celda individual del tablero
 */
public class Celda {
    private TipoCelda tipo;
    private boolean disparada;
    private String nombreBarco;
    
    /**
     * Constructor: inicializa una celda vacía con agua
     */
    public Celda() {
        this.tipo = TipoCelda.AGUA;
        this.disparada = false;
        this.nombreBarco = null;
    }
    
    // Getters
    public TipoCelda getTipo() {
        return tipo;
    }
    
    public boolean isDisparada() {
        return disparada;
    }
    
    public String getNombreBarco() {
        return nombreBarco;
    }
    
    // Setters
    public void setTipo(TipoCelda tipo) {
        this.tipo = tipo;
    }
    
    public void setDisparada(boolean disparada) {
        this.disparada = disparada;
    }
    
    public void setNombreBarco(String nombreBarco) {
        this.nombreBarco = nombreBarco;
    }
}