package Funciones;

import com.jayway.jsonpath.JsonPath;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author AVJ
 */
public class VerificarReglas {

    protected String jsonReglas = FuncionesAyuda.leerJsonReglas();

    public String OoSoN(String CT) throws JSONException {//Operador o simbolo

        JSONArray OperadorArit = new JSONArray(JsonPath.read(jsonReglas, "$.OperadorArit").toString());
        JSONArray OperadorLogico = new JSONArray(JsonPath.read(jsonReglas, "$.OperadorLogico").toString());
        JSONArray SimbolosEspe = new JSONArray(JsonPath.read(jsonReglas, "$.SimbolosEspe").toString());

        String ARRAY = "NULL";

        for (int i = 0; i < OperadorArit.length(); i++) {
            if (OperadorArit.get(i).toString().equals(CT)) {
                ARRAY = "Operador";
                return ARRAY;
            }
        }

        for (int i = 0; i < OperadorLogico.length(); i++) {
            if (OperadorLogico.get(i).toString().equals(CT)) {
                ARRAY = "Operador";
                return ARRAY;
            }
        }

        for (int i = 0; i < SimbolosEspe.length(); i++) {
            if (SimbolosEspe.get(i).toString().equals(CT)) {
                ARRAY = "SimbolosE";
                return ARRAY;
            }
        }
        return ARRAY;
    }

    public boolean isNum(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public boolean isReserv(String CT) throws JSONException {//Verifica si es una palabra reservada
        JSONArray PalabraReservada = new JSONArray(JsonPath.read(jsonReglas, "$.PalabraReservada").toString());

        for (int i = 0; i < PalabraReservada.length(); i++) {
            if (PalabraReservada.get(i).toString().equals(CT)) {
                return true;
            }
        }
        return false;
    }

}
