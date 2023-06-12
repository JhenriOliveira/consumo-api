package br.com.consultacep.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import br.com.consultacep.model.Endereco;

public class ServicoEndereco {
    public static Endereco buscaEndereco(String cep) throws Exception{
    	try {
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != 200)
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
            
            //Armazena a resposta da consulta
            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            //Converte a resposta Json em String usando a função de br.com.consultacep.service.Util.java
            String jsonEmString = Util.converteJsonEmString(resposta);

            //Dependencia google para facilitar a injeção das informações no objeto Endereço
            Gson gson = new Gson();
            Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);

            return endereco;
        } catch (Exception e) {
            throw new Exception("ERRO: " + e);
        }
    }
}
