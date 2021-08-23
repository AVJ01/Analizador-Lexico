package AlmacenarTablas;

import Modelos.TablaLexema;
import java.util.ArrayList;

/**
 *
 * @author AVJ
 */
public class TablaLexemaFuncion{

    private static TablaLexema inicio;
    private static TablaLexema ultimo;
    
    public static void insertar(TablaLexema dataset) {
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
            TablaLexema aux = ultimo.getAtras();
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

    public static ArrayList<TablaLexema> obtener() {
        ArrayList<TablaLexema> arrayTablaLexema = new ArrayList<>();
        TablaLexema aux = inicio;
        if (inicio != null) {
            while (aux != null) {
                arrayTablaLexema.add(aux);
                aux = aux.getSiguiente();
            }
        }

        return arrayTablaLexema;
    }

    

}
