package io.github.julia.servicos;

import io.github.julia.modelo.Colaborador;
import io.github.julia.modelo.Empresa;
import io.github.julia.repositorios.ColaboradorMemoria;
import io.github.julia.repositorios.EmpresaMemoria;

import java.util.List;
import java.util.stream.Collectors;

public class ColaboradorService {

    private ColaboradorMemoria colaboradorMemoria;
    private EmpresaMemoria empresaMemoria;

    public ColaboradorService(ColaboradorMemoria colaboradorMemoria) {
        this.colaboradorMemoria = colaboradorMemoria;
    }

    public ColaboradorService(EmpresaMemoria empresaMemoria) {
        this.empresaMemoria = empresaMemoria;
    }

    public void cadastrarColaborador(Empresa empresa, Colaborador colaborador) {
        colaboradorMemoria.cadastrarColaborador(empresa, colaborador);
    }

    public boolean validarMatriculaDuplicada(Empresa empresa, String matricula) {
        for (Colaborador colaborador : empresa.getListaDeColaboradores()) {
            if (colaborador.getMatricula().equalsIgnoreCase(matricula))
                return true;
        }
        return false;
    }

    public Colaborador localizarColaborador(Empresa empresa, String matricula) {
        Colaborador colaboradorEncontrado = colaboradorMemoria.buscarPorMatricula(empresa, matricula);
        return colaboradorEncontrado;
    }

    public void migrarColaborador(Empresa empresaAtual, Empresa empresaDestino, String matricula) {
        Colaborador colaboradorEncontrado = localizarColaborador(empresaAtual, matricula);
        if (colaboradorEncontrado != null) {
            empresaAtual.getListaDeColaboradores().remove(colaboradorEncontrado);
            System.out.println("Colaborador " + colaboradorEncontrado + " removido com sucesso da empresa " + empresaAtual.getNomeFantasia() + "!");

            empresaDestino.getListaDeColaboradores().add(colaboradorEncontrado);
            System.out.println("Agora o " + colaboradorEncontrado + " faz parte do quadro de funcionários da empresa " + empresaDestino.getNomeFantasia() + "!");
        } else {
            System.out.println("Colaborador não encontrado com essa matrícula!");
        }
    }

    public void atualizarNomeColaborador(Empresa empresa, String matricula, String novoNome) {
        Colaborador colaboradorEncontrado = localizarColaborador(empresa, matricula);
        if (colaboradorEncontrado != null) {
            colaboradorEncontrado.setNome(novoNome);
            System.out.println("Nome atualizado com sucesso: " + novoNome + ".");
        } else {
            System.out.println("Colaborador não encontrado com essa matrícula!");
        }
    }

    public void atualizarIdadeColaborador(Empresa empresa, String matricula, int idade) {
        Colaborador colaboradorEncontrado = localizarColaborador(empresa, matricula);
        if (colaboradorEncontrado != null) {
            colaboradorEncontrado.setIdade(idade);
            System.out.println("Idade atualizada com sucesso: " + idade + " anos.");
        } else {
            System.out.println("Colaborador não encontrado com essa matrícula!");
        }
    }

    public void atualizarDepartamentoColaborador(Empresa empresa, String matricula, String departamento) {
        Colaborador colaboradorEncontrado = localizarColaborador(empresa, matricula);
        if (colaboradorEncontrado != null) {
            colaboradorEncontrado.setDepartamento(departamento);
            System.out.println("Sucesso! Cadastrado atualizado:" + colaboradorEncontrado);
        } else {
            System.out.println("Colaborador não encontrado com essa matrícula!");
        }
    }

    public List<Colaborador> listarColaboradoresPorIdade(Empresa empresa, int idadeMin, int idadeMax) {
        return empresa.getListaDeColaboradores().stream()
                .filter(colaborador -> colaborador.getIdade() >= idadeMin && colaborador.getIdade() <= idadeMax)
                .collect(Collectors.toList());
    }

    public List<Colaborador> listarColaboradoresPorDepartamento(Empresa empresa, String departamento) {
        return empresa.getListaDeColaboradores().stream()
                .filter(colaborador -> colaborador.getDepartamento().equalsIgnoreCase(departamento))
                .collect(Collectors.toList());
    }

    public void removeColaborador(Empresa empresa, String matricula) {
        colaboradorMemoria.removeColaborador(empresa, matricula);
    }

    public void listarTodosColaboradores(Empresa empresa) {
        List<Colaborador> listaDeColaboradoresGeral = empresa.getListaDeColaboradores();
        if (listaDeColaboradoresGeral.isEmpty()) {
            System.out.println("Não há colaboradores cadastrados nessa empresa!");
        } else {
            System.out.println("Colaboradores da empresa " + empresa.getNomeFantasia() + ":");
            for (Colaborador colaborador : listaDeColaboradoresGeral) {
                System.out.println(colaborador);
            }
        }
    }
}

