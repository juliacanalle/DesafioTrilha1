package io.github.julia.infraestrutura;

import io.github.julia.modelo.Colaborador;
import io.github.julia.modelo.Empresa;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ExportadorTxt implements ExportadorDeArquivos {
    @Override
    public void exportar(Empresa empresa, String caminhoDestino) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(caminhoDestino), StandardCharsets.UTF_8))) {

            writer.write("EMPRESA");
            writer.newLine();
            writer.write("Nome: " + empresa.getNomeFantasia() + " | CNPJ: " + empresa.getCnpj());
            writer.newLine();
            writer.newLine();

            writer.write("COLABORADORES:");
            writer.newLine();

            for (Colaborador c : empresa.getListaDeColaboradores()) {
                writer.write("- Nome: " + c.getNome() + " | Matrícula: " + c.getMatricula() +
                        " | Idade: " + c.getIdade() + " | Departamento: " + c.getDepartamento());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao exportar o arquivo TXT: " + e.getMessage());
        }
    }
}
