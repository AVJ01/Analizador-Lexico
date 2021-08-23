package AlmacenarTablas;

import Modelos.Categoria;
import java.util.ArrayList;

/**
 *
 * @author AVJ
 */
public class CategoriaFuncion {

    private static Categoria inicio;
    private static Categoria ultimo;

    public static void insertar(Categoria dataset) {
        if (inicio == null) {
            inicio = dataset;
            ultimo= dataset;
        } else {
            ultimo.setSiguiente(dataset);
            inicio.setAtras(ultimo);
            ultimo= dataset;
        }
    }

    public static  void vaciar() {
        if (inicio == null) {
            //System.out.println("Lista vacia");
        } else {
            Categoria aux = ultimo.getAtras();
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

    public static ArrayList<Categoria> obtener() {
        ArrayList<Categoria> arrayCategoria = new ArrayList<>();
        Categoria aux = inicio;
        if (inicio != null) {
            while (aux != null) {
                arrayCategoria.add(aux);
                aux = aux.getSiguiente();
            }
        }
        return arrayCategoria;
    }

}
