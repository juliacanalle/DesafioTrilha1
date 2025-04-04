package io.github.julia.repositorios;
import io.github.julia.modelo.Empresa;

import java.util.ArrayList;
import java.util.List;

public class EmpresaMemoria {

    List<Empresa> listaDeEmpresas;

    public EmpresaMemoria() {
        this.listaDeEmpresas = new ArrayList<>();
    }

    public void adicionaEmpresa(Empresa empresa) {
        listaDeEmpresas.add(empresa);
    }

    public List<Empresa> listarEmpresas() {
        return listaDeEmpresas;
    }

    public Empresa buscarPorCnpj(String cnpj) {
        for (Empresa empresa : listaDeEmpresas) {
            if (empresa.getCnpj().equalsIgnoreCase(cnpj))
                return empresa;
        }
        System.out.println("Empresa não localizada com esse CNPJ.");
        return null;
    }

    public void removerEmpresa(String cnpj) {
        Empresa empresaParaRemover = null;
        for (Empresa empresa : listaDeEmpresas) {
            if (empresa.getCnpj().equalsIgnoreCase(cnpj)) {
                empresaParaRemover = empresa;
            }
        }
        if (empresaParaRemover != null) {
            listaDeEmpresas.remove(empresaParaRemover);
            System.out.println(empresaParaRemover + " foi removida do sistema com sucesso!");
            return;
        } else {
            System.out.println("Empresa não localizada com esse CNPJ.");
        }
    }
}






