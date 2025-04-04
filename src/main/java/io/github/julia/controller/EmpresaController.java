package io.github.julia.controller;

import io.github.julia.infraestrutura.ExportadorArquivoFactory;
import io.github.julia.infraestrutura.ExportadorDeArquivos;
import io.github.julia.modelo.Empresa;
import io.github.julia.servicos.ColaboradorService;
import io.github.julia.servicos.EmpresaService;

import java.util.FormatFlagsConversionMismatchException;
import java.util.Scanner;

public class EmpresaController {

    EmpresaService empresaService;
    ColaboradorService colaboradorService;
    Scanner scanner = new Scanner(System.in);

    public EmpresaController(EmpresaService empresaService, ColaboradorService colaboradorService) {
        this.empresaService = empresaService;
        this.colaboradorService = colaboradorService;
    }


    //Scanner para coletar os dados para cadastro da empresa
    public void exibirFormularioCadastraEmpresa() {
        System.out.println("Informe o nome fantasia da empresa (ou digite 'sair' para encerrar):");
        String nome = scanner.nextLine();
        if (nome.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        System.out.println("Informe o CNPJ (ou digite 'sair' para encerrar):");
        String cnpj = scanner.nextLine();
        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        Empresa novaEmpresa = new Empresa(nome, cnpj);
        empresaService.cadastrarEmpresa(novaEmpresa);
    }

    public void exibirFormularioAtualizaEmpresa() {
        System.out.println("Informe o CNPJ da empresa que deseja atualizar (ou digite 'sair' para encerrar):");
        String cnpj = scanner.nextLine();
        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        System.out.println("Informe o novo nome fantasia da empresa (ou digite 'sair' para encerrar):");
        String nome = scanner.nextLine();
        if (nome.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        empresaService.atualizarEmpresa(cnpj, nome);
    }

    public void exibirPerguntaRemoverEmpresa() {
        System.out.println("Informe o CNPJ da empresa que deseja remover (ou digite 'sair' para encerrar):");
        String cnpj = scanner.nextLine();
        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }
        empresaService.removerEmpresa(cnpj);
    }

    public void exibirPerguntaBuscarPorCnpj() {
        System.out.println("Informe o CNPJ da empresa que deseja remover:");
        String cnpj = scanner.nextLine();
        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }
        Empresa empresa = empresaService.buscarPorCnpj(cnpj);
        if (empresa != null) {
            System.out.println(empresa);
        } else {
            System.out.println("Empresa não encontrada.");
        }
    }

    public void exibirFormularioMigrarColaborador() {
        System.out.println("Informe a matrícula do colaborador que deseja migrar de empresa:");
        String matricula = scanner.nextLine();
        if (matricula.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        System.out.println("Informe o CNPJ da empresa atual (ou digite 'sair' para encerrar):");
        String cnpjAtual = scanner.nextLine();
        if (cnpjAtual.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        System.out.println("Informe o CNPJ da nova empresa do colaborador (ou digite 'sair' para encerrar):");
        String cnpjDestino = scanner.nextLine();
        if (cnpjDestino.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        Empresa empresaAtual = empresaService.buscarPorCnpj(cnpjAtual);
        Empresa empresaDestino = empresaService.buscarPorCnpj(cnpjDestino);

        colaboradorService.migrarColaborador(empresaAtual, empresaDestino, matricula);
    }

    public void exibirFormularioExportacao() {
        System.out.println("Informe o CNPJ da empresa que deseja extrair arquivo (ou digite 'sair' para encerrar):");
        String cnpj = scanner.nextLine();
        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        Empresa empresaEncontrada = empresaService.buscarPorCnpj(cnpj);

        if (empresaEncontrada == null){
            System.out.println("Ops! Empresa não encontrada com esse CNPJ, tente novamente.");
            return;
        }

        System.out.println("Você deseja extrair o arquivo em qual formato (.csv, .txt ou .json)?");
        String formato = scanner.nextLine();

        ExportadorDeArquivos exportador = ExportadorArquivoFactory.getExportador(formato);

        if (exportador == null) {
            System.out.println("Formato inválido! Use: csv, txt ou json.");
            return;
        }

        System.out.println("""
Selecione qual é o sistema operacional do seu computador:
[1] Windows
[2] Mac
[3] Linux
""");
        String sistema = scanner.nextLine();

        String home = System.getProperty("user.home");
        String pastaDownloads = "";

        switch (sistema) {
            case "1" -> pastaDownloads = home + "\\Downloads\\";
            case "2", "3" -> pastaDownloads = home + "/Downloads/";
            default -> {
                System.out.println("Opção inválida. Exportação cancelada.");
                return;
            }
        }
        String caminhoDestino = pastaDownloads + "empresa_" + empresaEncontrada.getCnpj() + "." + formato;

        exportador.exportar(empresaEncontrada, caminhoDestino);
        System.out.println();
        System.out.println("Arquivo gerado com sucesso!");
    }
}
