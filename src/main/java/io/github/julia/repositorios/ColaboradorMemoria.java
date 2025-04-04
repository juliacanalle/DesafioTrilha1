package io.github.julia.repositorios;
import io.github.julia.modelo.Colaborador;
import io.github.julia.modelo.Empresa;

import java.util.List;
import java.util.stream.Collectors;

public class ColaboradorMemoria {

    public void cadastrarColaborador(Empresa empresa, Colaborador colaborador) {
        empresa.getListaDeColaboradores().add(colaborador);
    }

    public Colaborador buscarPorMatricula(Empresa empresa, String matricula) {
        for (Colaborador colaborador : empresa.getListaDeColaboradores()) {
            if (colaborador.getMatricula().equalsIgnoreCase(matricula))
                return colaborador;
        }
        System.out.println("Colaborador não encontrado com essa matrícula,");
        return null;
    }

    public void removeColaborador(Empresa empresa, String matricula) {
        //Reutilizando o metodo acima
        Colaborador colaboradorParaRemover = buscarPorMatricula(empresa, matricula);
        if (colaboradorParaRemover != null) {
            empresa.getListaDeColaboradores().remove(colaboradorParaRemover);
            System.out.println("Colaborador " + colaboradorParaRemover + " removido com sucesso!");
            return;
        } else {
            System.out.println("Colaborador não encontrado com essa matrícula!");
        }
    }
}


