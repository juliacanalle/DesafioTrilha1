package io.github.julia.servicos;

import io.github.julia.modelo.Empresa;
import io.github.julia.repositorios.EmpresaMemoria;

import java.util.List;

public class EmpresaService {

    private EmpresaMemoria empresaMemoria;

    public EmpresaService(EmpresaMemoria empresaMemoria) {
        this.empresaMemoria = empresaMemoria;
    }

    public boolean validaCnpjDuplicado(String cnpj) {
        Empresa empresaEncontrada = empresaMemoria.buscarPorCnpj(cnpj);
      if(empresaEncontrada != null) {
          return true;
      } else {
          return false;
      }
    }

    public void cadastrarEmpresa(Empresa empresa) {
        if(!validaCnpjDuplicado(empresa.getCnpj())) {
            empresaMemoria.adicionaEmpresa(empresa);
            System.out.println(empresa + " cadastrada com sucesso!");
        } else {
            System.out.println("Essa empresa já está cadastrada no sistema!");
        }
    }

    public void atualizarEmpresa(String cnpj, String novoNome) {
        Empresa empresaEncontrada = empresaMemoria.buscarPorCnpj(cnpj);
        if(empresaEncontrada != null) {
            empresaEncontrada.setNome(novoNome);
            System.out.println("Alteração realizada com sucesso! Atualmente o nome consta como: " + novoNome);
        } else {
            System.out.println("Empresa não localizada com esse CNPJ.");
        }
    }

    public void removerEmpresa(String cnpj) {
        empresaMemoria.removerEmpresa(cnpj);
    }

    public Empresa buscarPorCnpj(String cnpj) {
        return empresaMemoria.buscarPorCnpj(cnpj);
    }

    public void listarEmpresas() {
        List<Empresa> empresas = empresaMemoria.listarEmpresas();
        if (empresas.isEmpty()) {
            System.out.println("Nenhuma empresa cadastrada no sistema.");
        } else {
            System.out.println("Empresas cadastradas:");
            for (Empresa empresa : empresas) {
                System.out.println(empresa);
            }
        }
    }

}
