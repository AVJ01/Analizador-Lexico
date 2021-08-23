package Funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JTextArea;

/**
 * @author AVJ
 */
public class FuncionesAyuda {

    public static String[] ECTRACadena(String cadena, int PT) {
        String[] array = {"", ""};
        String CADE = "";
        int TEM = 0;
        for (int i = PT; i < cadena.length(); i++) {
            CADE = CADE + String.valueOf(cadena.charAt(i));
            if (cadena.charAt(i) == '"') {
                TEM += 1;
            }
            if (TEM == 2) {
                array[0] = CADE;
                array[1] = String.valueOf(i);
                break;
            }
        }
        return array;
    }

    public static String ERCOMYESP(JTextArea TACode) {//Elimina los comentarios, espacios, tabuladores y saltos de linea, remplasa los define
        String CADE = "";
        String TEM, TEM_Buscar = "", TEM_Rempl = "";
        int B = 0;
        String[] lineas = TACode.getText().split("\n");
        for (String linea : lineas) {
            TEM = linea;
            if (TEM.length() != 0) {
                if (TEM.charAt(0) == '#') {
                    if (TEM.contains("#define")) {
                        TEM = TEM.replace("#define ", "");
                        for (int i = 0; i < TEM.length(); i++) {
                            if (String.valueOf(TEM.charAt(i)).equals(" ")) {
                                B = i;
                                break;
                            }
                        }
                        TEM_Buscar = TEM.substring(0, B);
                        TEM_Rempl = TEM.substring(B + 1, TEM.length());
                    }
                } else {
                    TEM = TEM.replaceAll("\\s", "");
                    for (int j = 0; j < TEM.length(); j++) {
                        if ((String.valueOf(TEM.charAt(j)).equals("/")) && (String.valueOf(TEM.charAt(j + 1)).equals("/"))) {
                            TEM = TEM.replace(TEM.substring(j, TEM.length()), "");
                            break;
                        }
                    }
                    CADE += TEM;
                }
            }
        }
        CADE = CADE.replace(TEM_Buscar, TEM_Rempl);
        return CADE;
    }

    /**
     * leer datos de archivo.
     *
     * @return
     */
    public static String leerJsonReglas() {
        String pactFile = "src\\analizador_lexico\\Reglas.json";
        StringBuilder strbuffer = new StringBuilder();
        File myFile = new File(pactFile);
        if (!myFile.exists()) {
            System.err.println("No puedo encontrar: " + pactFile);
        }
        try {
            FileInputStream fis = new FileInputStream(pactFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
            try (BufferedReader in = new BufferedReader(inputStreamReader)) {
                String str;
                while ((str = in.readLine()) != null) {
                    strbuffer.append(str);
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return strbuffer.toString();

    }
}
