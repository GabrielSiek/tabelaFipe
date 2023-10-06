package br.com.alura.tabelaFipe.services;

public interface IConverteDados {

    <T> T converteDados(String json,Class <T> classe);
}
