package AlmacenarTablas;

import Modelos.TotalLexmena;
import java.util.ArrayList;

/**
 *
 * @author AVJ
 */
public class TotalLexmenaFuncion {

    private static TotalLexmena inicio;
    private static TotalLexmena ultimo;

    public static void insertar(TotalLexmena dataset) {
        if (inicio == null) {
            inicio = dataset;
            ultimo= dataset;
        } else {
            ultimo.setSiguiente(dataset);
            inicio.setAtras(ultimo);
            ultimo= dataset;
        }
        
    }

    public static void vaciar() {
        if (inicio == null) {
            //System.out.println("Lista vacia");
        } else {
            TotalLexmena aux = ultimo.getAtras();
            if (aux != null) {
                aux.setSiguiente(null);
                System.gc();
                ultimo= aux;
            } else {
                System.gc();
                inicio = null;
                ultimo = null;
            }
        }
    }

    public static ArrayList<TotalLexmena> obtener() {
        ArrayList<TotalLexmena> arrayTotalLexmena = new ArrayList<>();
        TotalLexmena aux = inicio;
        if (inicio != null) {
            while (aux != null) {
                arrayTotalLexmena.add(aux);
                aux = aux.getSiguiente();
            }
        }

        return arrayTotalLexmena;
    }

}
