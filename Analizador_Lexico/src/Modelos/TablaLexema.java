package Modelos;

/**
 *
 * @author AVJ-01
 */
public class TablaLexema {

    private String lexema;
    private int clase;
    private int codigo;

    private TablaLexema siguiente;
    private TablaLexema atras;

    public TablaLexema() {
    }

    public TablaLexema(String lexema, int clase, int codigo) {
        this.lexema = lexema;
        this.clase = clase;
        this.codigo = codigo;
        this.siguiente = null;
        this.atras = null;
    }
    
    

    public TablaLexema getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(TablaLexema siguiente) {
        this.siguiente = siguiente;
    }

    public TablaLexema getAtras() {
        return atras;
    }

    public void setAtras(TablaLexema atras) {
        this.atras = atras;
    }

    
    
    
    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}
