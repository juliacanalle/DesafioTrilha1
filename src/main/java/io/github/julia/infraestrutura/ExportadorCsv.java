package io.github.julia.infraestrutura;

import io.github.julia.modelo.Colaborador;
import io.github.julia.modelo.Empresa;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ExportadorCsv implements ExportadorDeArquivos {
    @Override
    public void exportar(Empresa empresa, String caminhoDestino) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(caminhoDestino), StandardCharsets.UTF_8))) {

            writer.write("Nome Fantasia;CNPJ");
            writer.newLine();

            writer.write(empresa.getNomeFantasia() + ";" + empresa.getCnpj());
            writer.newLine();
            writer.newLine();

            writer.write("Nome;Idade;Matrícula;Departamento");
            writer.newLine();

            List<Colaborador> colaboradores = empresa.getListaDeColaboradores();
            for (Colaborador c : colaboradores) {
                writer.write(c.getNome() + ";" + c.getIdade() + ";" + c.getMatricula() + ";" + c.getDepartamento());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao exportar o arquivo CSV: " + e.getMessage());
        }
    }
}
