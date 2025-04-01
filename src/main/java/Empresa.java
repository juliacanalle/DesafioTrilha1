import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa {

    String nomeFantasia;
    String cnpj;
    List<Colaborador> listaDeColaboradores;

    public Empresa(String nomeFantasia, String cnpj) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.listaDeColaboradores = new ArrayList<>();
    }

    public List<Colaborador> getListaDeColaboradores() {
        return listaDeColaboradores;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setListaDeColaboradores(List<Colaborador> listaDeColaboradores) {
        this.listaDeColaboradores = listaDeColaboradores;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return "Empresa: " + nomeFantasia + " | " + "CNPJ: " + cnpj;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //Testes de métodos
        Empresa empresa1 = new Empresa("Mc Donalds", "123456789");
        GerenciaColaborador gerente = new GerenciaColaborador(scanner);
        gerente.cadastrarColaborador(empresa1);
        gerente.consultaColaborador(empresa1);
        gerente.atualizarColaborador(empresa1);
        gerente.removeColaborador(empresa1);

    }

}

