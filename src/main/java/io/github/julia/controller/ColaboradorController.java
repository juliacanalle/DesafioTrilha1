package io.github.julia.controller;

import io.github.julia.modelo.Colaborador;
import io.github.julia.modelo.Empresa;
import io.github.julia.repositorios.ColaboradorMemoria;
import io.github.julia.repositorios.EmpresaMemoria;
import io.github.julia.servicos.ColaboradorService;

import java.util.List;
import java.util.Scanner;

public class ColaboradorController {

    EmpresaMemoria empresaMemoria;
    ColaboradorMemoria colaboradorMemoria;
    ColaboradorService colaboradorService;

    public ColaboradorController(EmpresaMemoria empresaMemoria) {
        this.empresaMemoria = empresaMemoria;
    }

    public ColaboradorController(ColaboradorMemoria colaboradorMemoria) {
        this.colaboradorMemoria = colaboradorMemoria;
    }

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    Scanner scanner = new Scanner(System.in);

    public void exibirColaboradoresPorIdade(Scanner scanner) {
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

    public void exibirColaboradoresPorDepartamento(Scanner scanner) {
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
}


