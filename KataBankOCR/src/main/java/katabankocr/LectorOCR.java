package main.java.katabankocr;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class LectorOCR {

    private int TAMANYO_DIGITO = 3;
    private String checksum = "";

    public String leerCodigo(String codigo) {
        List<Digito> listaDigitos = leerDigitos(codigo);
        String codigoLeido = "";

        for (Digito d : listaDigitos) {
            codigoLeido += d.toString();
        }

        this.checksum = esCuentaValida(codigoLeido);

        return codigoLeido+checksum;
    }

    private List<Digito> leerDigitos(String codigo) {

        List<Digito> listaDigitos = new ArrayList<Digito>();

        String[] filas = StringUtils.split(codigo, "\n");

        int inicio = 0;
        Digito digito = null;

        for (int i = 0; i < 9; i++, inicio += 3) {
            digito = new Digito(new String[]{
                        StringUtils.mid(filas[0], inicio, TAMANYO_DIGITO),
                        StringUtils.mid(filas[1], inicio, TAMANYO_DIGITO),
                        StringUtils.mid(filas[2], inicio, TAMANYO_DIGITO),
                        StringUtils.mid(filas[3], inicio, TAMANYO_DIGITO)});
            listaDigitos.add(digito);
        }

        return listaDigitos;
    }

    private String esCuentaValida(String valor) {
        if (StringUtils.contains(valor,"?")){
            return " ILL";
        }
        float totalSum = calcularChecksum(valor, 1);
        
        if (totalSum == 0 || totalSum % 11 != 0)
            return " ERR";

        return "";
    }

    private float calcularChecksum(String valor, int i) {
        float suma = Float.parseFloat(valor.substring(valor.length() - 1)) * i;

        if (valor.length() > 1) {
            suma += calcularChecksum(valor.substring(0, valor.length() - 1), ++i);
        }
        return suma;
    }
}
