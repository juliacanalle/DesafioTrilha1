package io.github.julia;

import java.util.Scanner;

public class MenuPrincipal {

    static Scanner scanner = new Scanner(System.in);

    public void exibirMenuPrincipal() {
        while (true) {
            System.out.println("""
                        ===== MENU PRINCIPAL =====
                        [1] Acessar sistema de Empresas
                        [2] Acessar sistema de Colaboradores
                        [0] Encerrar o sistema
                    """);
            String menuPrincipal = scanner.nextLine();
            if (menuPrincipal.equals("1")) {
                exibirMenuEmpresa();
            } else if (menuPrincipal.equals("2")) {
                exibirMenuColaborador();
            } else if (menuPrincipal.equals("0") || menuPrincipal.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando o sistema...");
                System.exit(0);
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void exibirMenuEmpresa() {
        System.out.println("""
    ===== MENU EMPRESA =====
    [1] Cadastrar empresa
    [2] Listar empresas
    [3] Atualizar nome da empresa
    [4] Remover empresa
    [5] Consultar empresa por CNPJ
    [0] Voltar ao menu principal
""");
        String menuEmpresa = scanner.nextLine();
    }

    public void exibirMenuColaborador() {
        System.out.println("""
    ===== MENU COLABORADOR =====
    [1] Cadastrar colaborador
    [2] Atualizar nome do colaborador
    [3] Atualizar idade do colaborador
    [4] Atualizar departamento do colaborador
    [5] Remover colaborador
    [6] Listar colaboradores por idade
    [7] Listar colaboradores por departamento
    [8] Migrar colaborador entre empresas
    [0] Voltar ao menu principal
""");
        String menuColaborador = scanner.nextLine();
    }






    public static void main(String[] args) {
    }
}