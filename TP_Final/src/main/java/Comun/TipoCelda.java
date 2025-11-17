package Comun;

/**
 * Enum que representa los posibles estados de una celda en el tablero
 */
public enum TipoCelda {
    AGUA,      // Celda sin barco
    BARCO,     // Celda con parte de un barco
    IMPACTO,   // Celda con barco que fue disparada
    FALLO      // Celda de agua que fue disparada
}