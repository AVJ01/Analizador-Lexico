package Modelos;

/**
 *
 * @author AVJ-01
 */
public class Categoria {
    private String nombre;
    private int clase;
    
    private Categoria siguiente;
    private Categoria atras;

    public Categoria() {
    }

    public Categoria(String nombre, int clase) {
        this.nombre = nombre;
        this.clase = clase;
        this.siguiente = null;
        this.atras = null;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

    public Categoria getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Categoria siguiente) {
        this.siguiente = siguiente;
    }

    public Categoria getAtras() {
        return atras;
    }

    public void setAtras(Categoria atras) {
        this.atras = atras;
    }
    
    
}
