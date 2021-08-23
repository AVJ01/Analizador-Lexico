package Funciones;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import AlmacenarTablas.*;
import Modelos.*;
import org.json.JSONException;

/**
 *
 * @author AVJ-01
 */
public class Analizador {

    private final String[] Nombre = {"Palabra_Reservada", "Identificadores", "Operadores", "Constantes_Numericas",
        "Cadenas", "Simbolos_Especiales"};//Para el nombre de las tablas en el diseño    
    private final VerificarReglas verificarReglas = new VerificarReglas();
    private TotalLexmena CEX;
    private TablaLexema TL;
    private Categoria CTG;

    public void analizador(JTextArea TACode) {
        int CTPR = 1, CTIDE = 1, CTOPE = 1, CTCN = 1, CTCD = 1, CTSE = 1;//Palabra Reservada, Identificador, Operador, numero, cadena, simbolo especial
        String cadena;
        String[] Array;

        try {
            cadena = FuncionesAyuda.ERCOMYESP(TACode);            
            llenarCategoria();
            for (int i = 0; i < cadena.length(); i++) {
                Array = FuncionAnalizar(cadena, i);
                switch (Array[0]) {
                    case "Palabra_Reservada":
                        TL = new TablaLexema();
                        TL.setLexema(Array[1]);
                        TL.setClase(100);
                        TL.setCodigo(100 + CTPR);
                        TablaLexemaFuncion.insertar(TL);
                        CTPR += 1;
                        i = Integer.parseInt(Array[2]);
                        break;
                    case "Identificador":
                        TL = new TablaLexema();
                        TL.setLexema(Array[1]);
                        TL.setClase(200);
                        TL.setCodigo(200 + CTIDE);
                        TablaLexemaFuncion.insertar(TL);
                        CTIDE += 1;
                        i = Integer.parseInt(Array[2]);
                        break;
                    case "Operador":
                        TL = new TablaLexema();
                        TL.setLexema(Array[1]);
                        TL.setClase(300);
                        TL.setCodigo(300 + CTOPE);
                        TablaLexemaFuncion.insertar(TL);
                        i = Integer.parseInt(Array[2]);
                        CTOPE += 1;
                        break;
                    case "Constante_Numerica":
                        TL = new TablaLexema();
                        TL.setLexema(Array[1]);
                        TL.setClase(400);
                        TL.setCodigo(400 + CTCN);
                        TablaLexemaFuncion.insertar(TL);
                        CTCN += 1;
                        i = Integer.parseInt(Array[2]);
                        break;
                    case "Cadenas":
                        TL = new TablaLexema();
                        TL.setLexema(Array[1]);
                        TL.setClase(500);
                        TL.setCodigo(500 + CTCD);
                        TablaLexemaFuncion.insertar(TL);
                        CTCD += 1;
                        i = Integer.parseInt(Array[2]);
                        break;
                    case "SimbolosE":
                        TL = new TablaLexema();
                        TL.setLexema(Array[1]);
                        TL.setClase(600);
                        TL.setCodigo(600 + CTSE);
                        TablaLexemaFuncion.insertar(TL);
                        i = Integer.parseInt(Array[2]);
                        CTSE += 1;
                        break;
                }
            }
            int[] Clase = {CTPR - 1, CTIDE - 1, CTOPE - 1, CTCN - 1, CTCD - 1, CTSE - 1};
            for (int i = 0; i < Nombre.length; i++) {
                CEX = new TotalLexmena();
                CEX.setNombre(Nombre[i]);
                CEX.setCantidad(Clase[i]);
                TotalLexmenaFuncion.insertar(CEX);
            }

        } catch (NumberFormatException | JSONException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }

    private void llenarCategoria() {
        int[] Clase = {100, 200, 300, 400, 500, 600};
        for (int i = 0; i < Nombre.length; i++) {
            CTG = new Categoria();
            CTG.setNombre(Nombre[i]);
            CTG.setClase(Clase[i]);
            CategoriaFuncion.insertar(CTG);
        }
    }

    private String[] FuncionAnalizar(String cadena, int p) throws JSONException{
        String CDTem, CDTem_2, CADE = "", tem_2, TEM;
        String[] array = {"", "", ""}, array_2;
        for (int i = p; i < cadena.length(); i++) {
            CDTem = String.valueOf(cadena.charAt(i));
            switch (verificarReglas.OoSoN(CDTem)) {
                case "Operador":
                    if (i == (cadena.length() - 1)) {
                        TEM = CDTem;
                    } else {
                        if (i == (cadena.length() - 1)) {
                            CDTem_2 = "NULO";
                        } else {
                            CDTem_2 = String.valueOf(cadena.charAt(i + 1));
                        }
                        tem_2 = verificarReglas.OoSoN(CDTem_2);
                        if (tem_2.equals("Operador")) {
                            if (verificarReglas.OoSoN(CDTem + CDTem_2).equals("Operador")) {
                                TEM = CDTem + CDTem_2;
                                i += 1;
                            } else {
                                TEM = CDTem;
                            }
                        } else {
                            TEM = CDTem;
                        }
                    }
                    array[0] = "Operador";
                    array[1] = TEM;
                    array[2] = String.valueOf(i);
                    i = cadena.length() - 1;
                    break;
                case "SimbolosE":
                    array[0] = "SimbolosE";
                    array[1] = CDTem;
                    array[2] = String.valueOf(i);
                    i = cadena.length() - 1;
                    break;
                case "NULL":
                    if (cadena.charAt(i) == '"') {
                        array_2 = FuncionesAyuda.ECTRACadena(cadena, i);
                        array[0] = "Cadenas";
                        array[1] = array_2[0];
                        array[2] = array_2[1];
                        i = cadena.length();
                    } else {
                        CADE = CADE + CDTem;
                        if (i == (cadena.length() - 1)) {
                            CDTem_2 = "NULO";
                        } else {
                            CDTem_2 = verificarReglas.OoSoN(String.valueOf(cadena.charAt(i + 1)));
                        }
                        if (verificarReglas.isReserv(CADE)) {
                            array[0] = "Palabra_Reservada";
                            if (CADE.equals("do")) {
                                TEM = CADE + cadena.charAt(i + 1) + cadena.charAt(i + 2) + cadena.charAt(i + 3) + cadena.charAt(i + 4);
                                if (verificarReglas.isReserv(TEM)) {
                                    array[1] = TEM;
                                    array[2] = String.valueOf(i + 4);
                                } else {
                                    array[1] = CADE;
                                    array[2] = String.valueOf(i);
                                }
                            } else {
                                array[1] = CADE;
                                array[2] = String.valueOf(i);
                            }
                            i = cadena.length() - 1;
                            CADE = "";
                        } else if ((CDTem_2.equals("Operador")) || (CDTem_2.equals("SimbolosE")) || (CDTem_2.equals("NULO"))) {
                            if (verificarReglas.isNum(CADE)) {
                                array[0] = "Constante_Numerica";
                                array[1] = CADE;
                                array[2] = String.valueOf(i);
                                i = cadena.length() - 1;
                                CADE = "";
                            } else {
                                array[0] = "Identificador";
                                array[1] = CADE;
                                array[2] = String.valueOf(i);
                                i = cadena.length() - 1;
                                CADE = "";
                            }
                        } else {
                            //array_2 = FuncionAnalizar(cadena,i+1);                                
                        }
                    }//Temina else del if para las cadenas                        
                    break;
            }//FINAL DEL SWITCH                               
        }//FINAL DEL FOR RECORER EL CODE
        return array;
    }

}
