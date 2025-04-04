package io.github.julia.infraestrutura;

import io.github.julia.modelo.Empresa;

public interface ExportadorDeArquivos {
    void exportar(Empresa empresa, String caminhoDestino);
}
