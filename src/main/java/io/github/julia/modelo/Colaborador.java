package io.github.julia.modelo;

public class Colaborador extends Pessoa {

    String matricula;
    int idade;
    String departamento;

    public Colaborador(String nome, String matricula, int idade, String departamento) {
        super(nome);
        this.matricula = matricula;
        this.idade = idade;
        this.departamento = departamento;
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
                " | Matrícula: " + matricula +
                "| Departamento: " + departamento;
    }
}
