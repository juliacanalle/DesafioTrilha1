import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciaEmpresa {

    private List<Empresa> listaDeEmpresas;
    private Scanner scanner;

    public GerenciaEmpresa(Scanner scanner) {
        this.scanner = scanner;
        this.listaDeEmpresas = new ArrayList<>();
    }

    public List<Empresa> getListaDeEmpresas() {
        return listaDeEmpresas;
    }

    //metodo para cadastrar empresa
    public void cadastraEmpresa() {
        while (true) {
            System.out.println("Informe o nome da empresa para iniciar o cadastro (ou digite 'sair' para cancelar):");
            String nomeFantasia = scanner.nextLine();
            if (nomeFantasia.equalsIgnoreCase("sair")) {
                System.out.println("Cadastro cancelado.");
                break;
            }

            System.out.println("Informe o CNPJ:");
            String cnpj = scanner.nextLine();
            if (cnpj.equalsIgnoreCase("sair")) {
                System.out.println("Cadastro cancelado.");
                break;
            }

            Empresa empresa = new Empresa(nomeFantasia, cnpj);
            listaDeEmpresas.add(empresa);
            System.out.println("Cadastro realizado com sucesso!");
        }
    }

    public void consultaEmpresas() {
        System.out.println("Empresas cadastradas:");
        for (int i = 0; i < listaDeEmpresas.size(); i++) {
            System.out.println((i + 1) + ". " + listaDeEmpresas.get(i)); // usa o toString()
        }
    }

    public void consultaEmpresa() {
        while (true) {
            System.out.println("Informe o CNPJ da empresa que deseja consultar (ou digite 'sair' para cancelar):");
            String cnpj = scanner.nextLine();
            if (cnpj.equalsIgnoreCase("Sair")) {
                break;
            }
            Empresa resultado = getListaDeEmpresas().stream()
                    .filter(empresa -> empresa.getCnpj().equalsIgnoreCase(cnpj))
                    .findFirst()
                    .orElse(null);

            if (resultado != null) {
                System.out.println("Empresa encontrada:");
                System.out.println(resultado);
            } else {
                System.out.println("Nenhuma empresa encontrada com esse CNPJ.");
            }
        }
    }

    public void atualizarEmpresa() {
        System.out.println("Informe o CNPJ da empresa que deseja atualizar (ou digite 'sair' para cancelar):");
        String cnpj = scanner.nextLine();

        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Operação cancelada.");
            return;
        }

        List<Empresa> listaDeEmpresas = getListaDeEmpresas();
        Empresa empresaEncontrada = null;

        for (Empresa e : listaDeEmpresas) {
            if (e.getCnpj().equalsIgnoreCase(cnpj)) {
                empresaEncontrada = e;
                break;
            }
        }

        if (empresaEncontrada != null) {
            System.out.println("Empresa encontrada:");
            System.out.println(empresaEncontrada);

            System.out.println("Qual informação deseja atualizar? (Nome, CNPJ ou digite 'sair' para cancelar)");
            String campo = scanner.nextLine();

            if (campo.equalsIgnoreCase("sair")) {
                System.out.println("Operação cancelada.");
                return;
            }

            switch (campo.toLowerCase()) {
                case "nome":
                    System.out.println("Informe o novo nome:");
                    empresaEncontrada.setNomeFantasia(scanner.nextLine());
                    break;
                case "CNPJ":
                    System.out.println("Informe o novo CNPJ:");
                    empresaEncontrada.setCnpj(scanner.nextLine());
                    break;
                default:
                    System.out.println("Campo inválido. Nenhuma informação foi atualizada.");
                    return;
            }

            System.out.println("Informação atualizada com sucesso!");
            System.out.println("Cadastro atualizado:");
            System.out.println(empresaEncontrada);

        } else {
            System.out.println("Nenhuma empresa encontrada com esse CNPJ.");
        }
    }

    public void removeEmpresa() {
        System.out.println("Informe o CNPJ da empresa que deseja remover (ou digite 'sair' para cancelar):");
        String cnpj = scanner.nextLine();

        if (cnpj.equalsIgnoreCase("sair")) {
            System.out.println("Operação cancelada.");
            return;
        }

        List<Empresa> listaDeEmpresas = getListaDeEmpresas();
        Empresa empresaEncontrada = null;

        for (Empresa e : listaDeEmpresas) {
            if (e.getCnpj().equalsIgnoreCase(cnpj)) {
                empresaEncontrada = e;
                break;
            }
        }

        if (empresaEncontrada != null) {
            System.out.println("Empresa encontrada:");
            System.out.println(empresaEncontrada);
            System.out.println("Deseja realmente remover essa empresa? (sim/não)");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("sim")) {
                listaDeEmpresas.remove(empresaEncontrada);
                System.out.println("Empresa removida com sucesso com sucesso.\n");
            } else {
                System.out.println("Remoção cancelada.\n");
                return;
            }

            // Mostra lista atualizada
            System.out.println("Lista atualizada de empresas:");
            if (listaDeEmpresas.isEmpty()) {
                System.out.println("Nenhum colaborador cadastrado nesta empresa.");
            } else {
                for (Empresa e : listaDeEmpresas) {
                    System.out.println(e);
                }
            }

        } else {
            System.out.println("Nenhum colaborador encontrado com essa matrícula.");
        }
    }

    public void migraColaborador() {

    }
}








