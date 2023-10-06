package br.com.alura.tabelaFipe.principal;


import br.com.alura.tabelaFipe.model.DadosMarca;
import br.com.alura.tabelaFipe.services.ConsumoApi;
import br.com.alura.tabelaFipe.services.ConverteDados;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

import java.lang.reflect.Array;
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
        DadosMarca[] jsonmarcas = converteDados.converteDados(json, DadosMarca[].class);
        ArrayList<DadosMarca> marcas = new ArrayList<>(Arrays.asList(jsonmarcas));
        marcas.forEach(System.out::println);
        System.out.println("Digite o código da marca que está buscando: ");
        Integer CodigoMarca = sc.nextInt();
        sc.nextLine();


    }
}
