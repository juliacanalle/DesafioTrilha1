package io.github.julia.controller;

import io.github.julia.modelo.Colaborador;
import io.github.julia.modelo.Empresa;
import io.github.julia.repositorios.ColaboradorMemoria;
import io.github.julia.repositorios.EmpresaMemoria;
import io.github.julia.servicos.ColaboradorService;
import io.github.julia.servicos.EmpresaService;

import java.util.List;
import java.util.Scanner;

public class ColaboradorController {

    EmpresaMemoria empresaMemoria;
    ColaboradorMemoria colaboradorMemoria;
    EmpresaService empresaService;
    ColaboradorService colaboradorService;

    public ColaboradorController(EmpresaMemoria empresaMemoria, ColaboradorMemoria colaboradorMemoria, EmpresaService empresaService, ColaboradorService colaboradorService) {
        this.empresaMemoria = empresaMemoria;
        this.colaboradorMemoria = colaboradorMemoria;
        this.empresaService = empresaService;
        this.colaboradorService = colaboradorService;
    }

    Scanner scanner = new Scanner(System.in);

    public void exibirFormularioCadastroColaborador() {
        System.out.println("Informe o CNPJ da empresa onde o colaborador será cadastrado (ou digite 'sair' para encerrar):");
        String cnpj = scanner.nextLine();
        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }
        Empresa empresa = empresaService.buscarPorCnpj(cnpj);

        if (empresa == null) {
            System.out.println("Empresa não encontrada com esse CNPJ.");
            return;
        }

        System.out.println("Informe o nome do colaborador (ou digite 'sair' para encerrar):");
        String nome = scanner.nextLine();
        if (nome.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        System.out.println("Informe a matrícula (ou digite 'sair' para encerrar):");
        String matricula = scanner.nextLine();
        if (matricula.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        System.out.println("Informe a idade do colaborador (ou digite 'sair' para encerrar):");
        String idadeDigitada = scanner.nextLine();
        if (idadeDigitada.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }
        int idade = Integer.parseInt(idadeDigitada);

        System.out.println("Informe o departamento onde o colaborador irá atuar (ou digite 'sair' para encerrar):");
        String departamento = scanner.nextLine();
        if (nome.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        Colaborador novoColaborador = new Colaborador(nome, matricula, idade, departamento);
        colaboradorService.cadastrarColaborador(empresa, novoColaborador);

        System.out.println("""
    Colaborador cadastrado com sucesso!
    -----------------------------
    Empresa: %s
    %s
    -----------------------------
    """.formatted(empresa.getNomeFantasia(), novoColaborador));

    }

    public void exibirPerguntaAtualizaNomeColaborador() {
        System.out.println("Informe o CNPJ da empresa onde o colaborador atua (ou digite 'sair' para encerrar):");
        String cnpj = scanner.nextLine();
        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }
        Empresa empresa = empresaService.buscarPorCnpj(cnpj);

        if (empresa == null) {
            System.out.println("Empresa não encontrada com esse CNPJ.");
            return;
        }

        System.out.println("Informe a matrícula do colaborador (ou digite 'sair' para encerrar):");
        String matricula = scanner.nextLine();
        if (matricula.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        Colaborador colaborador = colaboradorService.localizarColaborador(empresa, matricula);

        System.out.println("Informe o novo nome para que o cadastro seja atualizado (ou digite 'sair' para encerrar):");
        String novoNome = scanner.nextLine();
        if (novoNome.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        colaboradorService.atualizarNomeColaborador(empresa, matricula, novoNome);
    }

    public void exibirPerguntaAtualizaIdadeColaborador() {
        System.out.println("Informe o CNPJ da empresa onde o colaborador atua (ou digite 'sair' para encerrar):");
        String cnpj = scanner.nextLine();
        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }
        Empresa empresa = empresaService.buscarPorCnpj(cnpj);

        if (empresa == null) {
            System.out.println("Empresa não encontrada com esse CNPJ.");
            return;
        }

        System.out.println("Informe a matrícula do colaborador (ou digite 'sair' para encerrar):");
        String matricula = scanner.nextLine();
        if (matricula.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        Colaborador colaborador = colaboradorService.localizarColaborador(empresa, matricula);

        System.out.println("Informe a idade atualizada (ou digite 'sair' para encerrar):");
        String idadeDigitada = scanner.nextLine();
        if (idadeDigitada.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }
        int idade = Integer.parseInt(idadeDigitada);

        colaboradorService.atualizarIdadeColaborador(empresa, matricula, idade);
    }

    public void exibirPerguntaAtualizaDepartamentoColaborador() {
        System.out.println("Informe o CNPJ da empresa onde o colaborador atua (ou digite 'sair' para encerrar):");
        String cnpj = scanner.nextLine();
        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }
        Empresa empresa = empresaService.buscarPorCnpj(cnpj);

        if (empresa == null) {
            System.out.println("Empresa não encontrada com esse CNPJ.");
            return;
        }

        System.out.println("Informe a matrícula do colaborador (ou digite 'sair' para encerrar):");
        String matricula = scanner.nextLine();
        if (matricula.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        Colaborador colaborador = colaboradorService.localizarColaborador(empresa, matricula);

        System.out.println("Informe o novo departamento para que o cadastro seja atualizado (ou digite 'sair' para encerrar):");
        String departamento = scanner.nextLine();
        if (departamento.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        colaboradorService.atualizarDepartamentoColaborador(empresa, matricula, departamento);
    }

    public void exibirFormularioRemoveColaborador() {
        System.out.println("Informe o CNPJ da empresa onde o colaborador atua (ou digite 'sair' para encerrar):");
        String cnpj = scanner.nextLine();
        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }
        Empresa empresa = empresaService.buscarPorCnpj(cnpj);

        if (empresa == null) {
            System.out.println("Empresa não encontrada com esse CNPJ.");
            return;
        }

        System.out.println("Informe a matrícula do colaborador (ou digite 'sair' para encerrar):");
        String matricula = scanner.nextLine();
        if (matricula.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        Colaborador colaborador = colaboradorService.localizarColaborador(empresa, matricula);

        System.out.println("Tem certeza que deseja remover o colaborador " + colaborador.getNome() + "? (s/n)");
        String confirmacao = scanner.nextLine();
        if (confirmacao.equalsIgnoreCase("n")) {
            System.out.println("Operação cancelada.");
            return;
        }

        colaboradorService.removeColaborador(empresa, matricula);
    }

    public void exibirColaboradoresPorIdade() {
        System.out.println("Informe o CNPJ (ou digite 'sair' para encerrar):");
        String cnpj = scanner.nextLine();
        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        Empresa empresaEncontrada = empresaMemoria.buscarPorCnpj(cnpj);
        if (empresaEncontrada != null) {
            System.out.println("Informe a idade mínima:");
            int idadeMin = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Informe a idade máxima:");
            int idadeMax = scanner.nextInt();
            scanner.nextLine();

            List<Colaborador> resultado = colaboradorService.listarColaboradoresPorIdade(empresaEncontrada, idadeMin, idadeMax);

            if (resultado.isEmpty()) {
                System.out.println("Nenhum colaborador cadastrado está dentro dessa faixa etária.");
            } else {
                System.out.println("Colaboradores encontrados: ");
                resultado.forEach(System.out::println);
            }
        } else {
            System.out.println("Empresa não localizada com esse CNPJ.");
        }
    }

    public void exibirColaboradoresPorDepartamento() {
        System.out.println("Informe o CNPJ (ou digite 'sair' para encerrar):");
        String cnpj = scanner.nextLine();
        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }

        Empresa empresaEncontrada = empresaMemoria.buscarPorCnpj(cnpj);
        if (empresaEncontrada != null) {
            System.out.println("Informe o departamento: ");
            String departamento = scanner.nextLine();

            List<Colaborador> resultado = colaboradorService.listarColaboradoresPorDepartamento(empresaEncontrada, departamento);

            if (resultado.isEmpty()) {
                System.out.println("Não há nenhum colaborador cadastrado nesse departamento.");
            } else {
                System.out.println("Colaboradores encontrados:");
                resultado.forEach(System.out::println);
            }
        } else {
            System.out.println("Empresa não localizada com esse CNPJ.");
        }
    }

    public void exibePerguntaListaDeColaboradoresGeral()  {
        System.out.println("Informe o CNPJ (ou digite 'sair' para encerrar):");
        String cnpj = scanner.nextLine();

        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Encerrando o sistema...");
            System.exit(0);
        }
        Empresa empresa = empresaService.buscarPorCnpj(cnpj);

        if (empresa == null) {
            System.out.println("Empresa não encontrada com esse CNPJ.");
            return;
        }

        colaboradorService.listarTodosColaboradores(empresa);
    }
}


