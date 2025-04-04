package io.github.julia.infraestrutura;
import io.github.julia.infraestrutura.ExportadorCsv;
import io.github.julia.infraestrutura.ExportadorTxt;
import io.github.julia.infraestrutura.ExportadorJson;


public class ExportadorArquivoFactory {

    public static ExportadorDeArquivos getExportador(String formato) {
        if(formato.equalsIgnoreCase("csv")) {
            return new ExportadorCsv();
        } else if (formato.equalsIgnoreCase("txt")) {
            return new ExportadorTxt();
        } else if (formato.equalsIgnoreCase("json")) {
            return new ExportadorJson();
        } else {
            return null;
        }
    }
}
