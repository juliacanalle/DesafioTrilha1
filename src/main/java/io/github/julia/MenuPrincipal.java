package io.github.julia;

import io.github.julia.controller.ColaboradorController;
import io.github.julia.controller.EmpresaController;
import io.github.julia.modelo.Empresa;
import io.github.julia.repositorios.ColaboradorMemoria;
import io.github.julia.repositorios.EmpresaMemoria;
import io.github.julia.servicos.ColaboradorService;
import io.github.julia.servicos.EmpresaService;

import java.util.Scanner;

public class MenuPrincipal {

    private final ColaboradorService colaboradorService;
    private final ColaboradorController colaboradorController;
    private final EmpresaService empresaService;
    private final EmpresaController empresaController;

    public MenuPrincipal(ColaboradorService colaboradorService, ColaboradorController colaboradorController, EmpresaService empresaService, EmpresaController empresaController) {
        this.colaboradorService = colaboradorService;
        this.colaboradorController = colaboradorController;
        this.empresaService = empresaService;
        this.empresaController = empresaController;
    }

    static Scanner scanner = new Scanner(System.in);

    public void exibirMenuPrincipal() {
        while (true) {
            System.out.println("""
                        ===== MENU PRINCIPAL =====
                        [1] Acessar sistema de Empresas
                        [2] Acessar sistema de Colaboradores
                        [0] Encerrar o sistema
                    """);
            String RespostaMenuPrincipal = scanner.nextLine();
            if (RespostaMenuPrincipal.equals("1")) {
                exibirMenuEmpresa();
            } else if (RespostaMenuPrincipal.equals("2")) {
                exibirMenuColaborador();
            } else if (RespostaMenuPrincipal.equals("0") || RespostaMenuPrincipal.equalsIgnoreCase("sair")) {
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
    [6] Migrar colaborador entre empresas
    [7] Exportar dados da empresa (formato .csv, .txt ou .json)
    [0] Voltar ao menu principal
""");
        String respostamenuEmpresa = scanner.nextLine();

        switch (respostamenuEmpresa) {
            case "1": empresaController.exibirFormularioCadastraEmpresa();
                break;
            case "2": empresaService.listarEmpresas();
                break;
            case "3": empresaController.exibirFormularioAtualizaEmpresa();
                break;
            case "4": empresaController.exibirPerguntaRemoverEmpresa();
                break;
            case "5": empresaController.exibirPerguntaBuscarPorCnpj();
                break;
            case "6": empresaController.exibirFormularioMigrarColaborador();
                break;
            case"7": empresaController.exibirFormularioExportacao();
                break;
            case "0": exibirMenuPrincipal();
            default:
                System.out.println("Opção inválida. Por favor, tente novamente!");
        }
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
    [8] Listar todos os colaboradores
    [0] Voltar ao menu principal
""");
        String respostaMenuColaborador = scanner.nextLine();

        switch (respostaMenuColaborador) {
            case "1": colaboradorController.exibirFormularioCadastroColaborador();
                break;
            case "2": colaboradorController.exibirPerguntaAtualizaNomeColaborador();
                break;
            case "3": colaboradorController.exibirPerguntaAtualizaIdadeColaborador();
                break;
            case "4": colaboradorController.exibirPerguntaAtualizaDepartamentoColaborador();
                break;
            case "5": colaboradorController.exibirFormularioRemoveColaborador();
                break;
            case "6": colaboradorController.exibirColaboradoresPorIdade();
                break;
            case "7": colaboradorController.exibirColaboradoresPorDepartamento();
                break;
            case "8": colaboradorController.exibePerguntaListaDeColaboradoresGeral();
            break;
            case "0": exibirMenuPrincipal();
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente!");

        }

    }


    public static void main(String[] args) {

        // Instâncias dos repositórios
        EmpresaMemoria empresaMemoria = new EmpresaMemoria();
        ColaboradorMemoria colaboradorMemoria = new ColaboradorMemoria();

        // Instâncias das services
        EmpresaService empresaService = new EmpresaService(empresaMemoria);
        ColaboradorService colaboradorService = new ColaboradorService(colaboradorMemoria);

        // Instâncias dos controllers
        EmpresaController empresaController = new EmpresaController(empresaService, colaboradorService);
        ColaboradorController colaboradorController = new ColaboradorController(empresaMemoria, colaboradorMemoria, empresaService, colaboradorService);

        // Instância do menu principal
        MenuPrincipal menu = new MenuPrincipal(colaboradorService, colaboradorController, empresaService, empresaController);
        menu.exibirMenuPrincipal(); // Inicia o sistema
    }
    }
