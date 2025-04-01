import java.util.List;
import java.util.Scanner;

public class GerenciaColaborador {

    //Gambiarra pra usar o Scanner em todos os métodos
    private Scanner scanner;

    public GerenciaColaborador(Scanner scanner) {
        this.scanner = scanner;
    }

    //Metodo para cadastro de colaborador;
    public void cadastrarColaborador(Empresa empresa) {
        while (true) {
            System.out.println("Informe o nome do colaborador para iniciar o cadastro (ou digite 'sair' para cancelar):");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("Sair")) {
                break;
            }

            System.out.println("Informe a idade do colaborador:");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Informe o número de matrícula do colaborador:");
            String matricula = scanner.nextLine();

            System.out.println("Informe o departamento que o colaborador irá atuar:");
            String departamento = scanner.nextLine();

            Colaborador colaborador = new Colaborador(nome, idade, matricula, departamento);

            empresa.listaDeColaboradores.add(colaborador);

            System.out.println("Cadastro realizado com sucesso!");

        }
    }

    //Metodo para atualizar o cadastro do colaborador

    public void atualizarColaborador(Empresa empresa) {
        System.out.println("Informe a matrícula do colaborador que deseja atualizar (ou digite 'sair' para cancelar):");
        String matricula = scanner.nextLine();

        if (matricula.equalsIgnoreCase("sair")) {
            System.out.println("Operação cancelada.");
            return;
        }

        List<Colaborador> colaboradores = empresa.getListaDeColaboradores();
        Colaborador colaboradorEncontrado = null;

        for (Colaborador c : colaboradores) {
            if (c.getMatricula().equalsIgnoreCase(matricula)) {
                colaboradorEncontrado = c;
                break;
            }
        }

        if (colaboradorEncontrado != null) {
            System.out.println("Colaborador encontrado:");
            System.out.println(colaboradorEncontrado);

            System.out.println("Qual informação deseja atualizar? (nome, idade, matricula, departamento ou digite 'sair' para cancelar)");
            String campo = scanner.nextLine();

            if (campo.equalsIgnoreCase("sair")) {
                System.out.println("Operação cancelada.");
                return;
            }

            switch (campo.toLowerCase()) {
                case "nome":
                    System.out.println("Informe o novo nome:");
                    colaboradorEncontrado.setNome(scanner.nextLine());
                    break;
                case "idade":
                    System.out.println("Informe a nova idade:");
                    colaboradorEncontrado.setIdade(Integer.parseInt(scanner.nextLine()));
                    break;
                case "matricula":
                    System.out.println("Informe a nova matrícula:");
                    colaboradorEncontrado.setMatricula(scanner.nextLine());
                    break;
                case "departamento":
                    System.out.println("Informe o novo departamento:");
                    colaboradorEncontrado.setDepartamento(scanner.nextLine());
                    break;
                default:
                    System.out.println("Campo inválido. Nenhuma informação foi atualizada.");
                    return;
            }

            System.out.println("Informação atualizada com sucesso!");
            System.out.println("Cadastro atualizado:");
            System.out.println(colaboradorEncontrado);

        } else {
            System.out.println("Nenhum colaborador encontrado com essa matrícula.");
        }
    }

    //Metodo para consultar o colaborador

public void consultaColaborador(Empresa empresa) {
    while (true) {
        System.out.println("Informe a matrícula do colaborador que deseja consultar (ou digite 'sair' para cancelar):");
        String matricula = scanner.nextLine();
        if (matricula.equalsIgnoreCase("Sair")) {
            break;
        }
        Colaborador resultado = empresa.getListaDeColaboradores().stream()
                .filter(colaborador -> colaborador.getMatricula().equalsIgnoreCase(matricula))
                .findFirst()
                .orElse(null);

        if (resultado != null) {
            System.out.println("Colaborador encontrado:");
            System.out.println(resultado);
        } else {
            System.out.println("Nenhum colaborador encontrado com essa matrícula.");
        }
    }
}
//metodo para remover colaborador
public void removeColaborador(Empresa empresa) {
        System.out.println("Informe a matrícula do colaborador que deseja remover (ou digite 'sair' para cancelar):");
        String matricula = scanner.nextLine();

        if (matricula.equalsIgnoreCase("sair")) {
            System.out.println("Operação cancelada.");
            return;
        }

        List<Colaborador> colaboradores = empresa.getListaDeColaboradores();
        Colaborador colaboradorEncontrado = null;

        for (Colaborador c : colaboradores) {
            if (c.getMatricula().equalsIgnoreCase(matricula)) {
                colaboradorEncontrado = c;
                break;
            }
        }

        if (colaboradorEncontrado != null) {
            System.out.println("Colaborador encontrado:");
            System.out.println(colaboradorEncontrado);
            System.out.println("Deseja realmente remover esse colaborador? (sim/não)");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("sim")) {
                colaboradores.remove(colaboradorEncontrado);
                System.out.println("Colaborador removido com sucesso.\n");
            } else {
                System.out.println("Remoção cancelada.\n");
                return;
            }

            // Mostra lista atualizada
            System.out.println("Lista atualizada de colaboradores:");
            if (colaboradores.isEmpty()) {
                System.out.println("Nenhum colaborador cadastrado nesta empresa.");
            } else {
                for (Colaborador c : colaboradores) {
                    System.out.println(c);
                }
            }

        } else {
            System.out.println("Nenhum colaborador encontrado com essa matrícula.");
        }
    }









    public static void main(String[] args) {


    }
}


