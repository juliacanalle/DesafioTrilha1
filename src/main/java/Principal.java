import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GerenciaEmpresa gerenciaEmpresa = new GerenciaEmpresa(scanner);

        gerenciaEmpresa.cadastraEmpresa();
        gerenciaEmpresa.consultaEmpresas();
        gerenciaEmpresa.consultaEmpresa();
        gerenciaEmpresa.atualizarEmpresa();
        gerenciaEmpresa.removeEmpresa();
    }
}