package io.github.julia.modelo;

public class Colaborador extends Pessoa {

    String matricula;
    int idade;
    String departamento;

    public Colaborador(String nome, String id, int idade) {
        super(nome);
        this.matricula = id;
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isMaiorDeIdade() {
        return idade >= 18;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " | Idade: " + idade +
                " (" + (isMaiorDeIdade() ? "Maior de idade" : "Menor de idade") + ")" +
                " | ID: " + matricula +
                "| Departamento: " + departamento;
    }
}
