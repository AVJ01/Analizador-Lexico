package Funciones;

import AlmacenarTablas.*;
import Modelos.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AVJ
 */
public class FuncionesMain {

    private ArrayList<TotalLexmena> arrayTotalLexmena = new ArrayList<>();
    private ArrayList<TablaLexema> arrayTablaLexema = new ArrayList<>();
    private ArrayList<Categoria> arrayCategoria = new ArrayList<>();

    public void limpiar() {
        CategoriaFuncion.vaciar();        
        TablaLexemaFuncion.vaciar();        
        TotalLexmenaFuncion.vaciar();
    }

    public void llenarTBFrame(JTable TCTG, JTable TTlexema, JTable TFinal) {//llena las tabla en el Frame
        //Tabla total de categorias
        String[] titulo = {"Nombre", "Cantidad"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulo);
        TCTG.getModel();
        TCTG.setModel(modelo);
        
        arrayCategoria = CategoriaFuncion.obtener();
        for (int i = 0; i < arrayCategoria.size(); i++) {
            Object[] ob = new Object[2];
            ob[0] = arrayCategoria.get(i).getNombre();
            ob[1] = arrayCategoria.get(i).getClase();
            modelo.addRow(ob);
        }
        //Tabla de Tokens
        String[] titulos = {"Lexema", "Clase", "Codigo"};
        DefaultTableModel modelo_2 = new DefaultTableModel(null, titulos);
        TFinal.getModel();
        TFinal.setModel(modelo_2);

        arrayTablaLexema = TablaLexemaFuncion.obtener();

        for (int i = 0; i < arrayTablaLexema.size(); i++) {
            Object[] ob = new Object[3];
            ob[0] = arrayTablaLexema.get(i).getLexema();
            ob[1] = arrayTablaLexema.get(i).getClase();
            ob[2] = arrayTablaLexema.get(i).getCodigo();
            modelo_2.addRow(ob);
        }
        //Tabla total de lexemas
        String[] titulo_3 = {"Nombre", "Cantidad"};
        DefaultTableModel modelo_3 = new DefaultTableModel(null, titulo_3);
        TTlexema.getModel();
        TTlexema.setModel(modelo_3);

        arrayTotalLexmena = TotalLexmenaFuncion.obtener();
        for (int i = 0; i < arrayTotalLexmena.size(); i++) {
            Object[] ob = new Object[2];
            ob[0] = arrayTotalLexmena.get(i).getNombre();
            ob[1] = arrayTotalLexmena.get(i).getCantidad();
            modelo_3.addRow(ob);
        }

    }
}
