package br.com.alura.tabelaFipe.principal;


import br.com.alura.tabelaFipe.model.DadosAno;
import br.com.alura.tabelaFipe.model.DadosGerais;
import br.com.alura.tabelaFipe.model.DadosModelo;
import br.com.alura.tabelaFipe.model.DadosVeiculo;
import br.com.alura.tabelaFipe.services.ConsumoApi;
import br.com.alura.tabelaFipe.services.ConverteDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Principal {

    Scanner sc = new Scanner(System.in);
    ConsumoApi consumoApi = new ConsumoApi();
    ConverteDados converteDados = new ConverteDados();
    String chave = "https://parallelum.com.br/fipe/api/v1/";
    String json;

    public void exibeMenu() {
        System.out.print("Digite o tipo de veículo que está buscando: ");
        String tipoVeiculo = sc.nextLine().toLowerCase();
        json = consumoApi.obterDados(chave + tipoVeiculo + "/marcas");
        DadosGerais[] jsonMarcas = converteDados.converteDados(json, DadosGerais[].class);
        ArrayList<DadosGerais> marcas = new ArrayList<>(Arrays.asList(jsonMarcas));

        marcas.forEach(System.out::println);
        System.out.print("Digite o código da marca que está buscando: ");
        Integer codigoMarca = sc.nextInt();
        sc.nextLine();
        json = consumoApi.obterDados(chave + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos");
        DadosModelo jsonModelos = converteDados.converteDados(json, DadosModelo.class);
        ArrayList<DadosGerais> modelos = new ArrayList<>(Arrays.asList(jsonModelos.modelos()));

        modelos.forEach(System.out::println);
        System.out.println("Digite o código do veículo: ");
        Integer codigoVeiculo = sc.nextInt();
        sc.nextLine();
        json = consumoApi.obterDados(chave + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoVeiculo + "/anos");
        DadosAno[] dadosAnos = converteDados.converteDados(json, DadosAno[].class);
        ArrayList<DadosAno> anos = new ArrayList<>(Arrays.asList(dadosAnos));

        anos.forEach(System.out::println);
        System.out.println("Digite o código ano: ");
        String codigoAno = sc.nextLine();
        json = consumoApi.obterDados(chave + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoVeiculo + "/anos/" + codigoAno);
        DadosVeiculo dadosVeiculo = new
    }
}
