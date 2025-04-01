public class Colaborador {

    String nome;
    int idade;
    String matricula;
    String departamento;

    public Colaborador(String nome, int idade, String matricula, String departamento) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isMaiorDeIdade() {
        return idade >= 18;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " | Idade: " + idade +
                " (" + (isMaiorDeIdade() ? "Maior de idade" : "Menor de idade") + ")" +
                " | Matrícula: " + matricula +
                " | Departamento: " + departamento;
    }
}
