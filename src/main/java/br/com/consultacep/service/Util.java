package br.com.consultacep.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

public class Util {
	 public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
		 String resposta, jsonEmString = "";
		 //Faz a leitura linha a linha da resposta JSON e grava como String
	     while ((resposta = buffereReader.readLine()) != null) {
	    	 jsonEmString += resposta;
	     }
	     return jsonEmString;
	  }
	 
	 public static void criaLinha(int coluna) {
		 for (int i = 0; i < coluna; i++) {
				if (i == 0) {
					System.out.print("+");
				}
				
				System.out.print("-");
				
				if (i+1 == coluna) {
					System.out.print("+\n");
				}
			}
	 }
	 
	 public static void CriaTela(int coluna, int linha, String titulo, String[] conteudo) {

		criaLinha(coluna);
		for (int j = 0; j < conteudo.length; j++) {
			System.out.println("|" + conteudo[j]);
			for (int i = 0; i < conteudo.length; i++) {
				
			}
		}
		criaLinha(coluna);		 
	 }
}
