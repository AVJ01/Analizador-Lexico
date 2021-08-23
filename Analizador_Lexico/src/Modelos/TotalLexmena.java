package Modelos;

/**
 *
 * @author AVJ-01
 */
public class TotalLexmena {

    private String nombre;
    private int cantidad;

    private TotalLexmena siguiente;
    private TotalLexmena atras;

    public TotalLexmena() {
    }

    public TotalLexmena(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.siguiente = null;
        this.atras = null;
    }

    public TotalLexmena getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(TotalLexmena siguiente) {
        this.siguiente = siguiente;
    }

    public TotalLexmena getAtras() {
        return atras;
    }

    public void setAtras(TotalLexmena atras) {
        this.atras = atras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
