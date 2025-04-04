package io.github.julia.infraestrutura;

import io.github.julia.modelo.Colaborador;
import io.github.julia.modelo.Empresa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportadorJson implements ExportadorDeArquivos{
    @Override
    public void exportar(Empresa empresa, String caminhoDestino) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoDestino))) {
            writer.write("{");
            writer.write("\"nomeFantasia\":\"" + empresa.getNomeFantasia() + "\",");
            writer.write("\"cnpj\":\"" + empresa.getCnpj() + "\",");
            writer.write("\"colaboradores\":[");

            List<Colaborador> colaboradores = empresa.getListaDeColaboradores();
            for (int i = 0; i < colaboradores.size(); i++) {
                Colaborador c = colaboradores.get(i);
                writer.write("{");
                writer.write("\"nome\":\"" + c.getNome() + "\",");
                writer.write("\"matricula\":\"" + c.getMatricula() + "\",");
                writer.write("\"idade\":" + c.getIdade() + ",");
                writer.write("\"departamento\":\"" + c.getDepartamento() + "\"");
                writer.write("}");
                if (i < colaboradores.size() - 1) {
                    writer.write(",");
                }
            }

            writer.write("]");
            writer.write("}");
        } catch (IOException e) {
            System.out.println("Erro ao exportar o arquivo JSON: " + e.getMessage());
        }
    }
}
