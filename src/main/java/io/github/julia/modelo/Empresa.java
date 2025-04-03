package io.github.julia.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa extends Pessoa {

    String cnpj;
    List<Colaborador> listaDeColaboradores;
    List<String> listaDeDepartamentos;

    public Empresa(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
        this.listaDeColaboradores = new ArrayList<>();
        this.listaDeDepartamentos = new ArrayList<>();
    }

    public List<Colaborador> getListaDeColaboradores() {
        return listaDeColaboradores;
    }

    public String getNomeFantasia() {
        return nome;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nome = nomeFantasia;
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
        return "Empresa: " + nome + " | " + "CNPJ: " + cnpj;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



    }

}

