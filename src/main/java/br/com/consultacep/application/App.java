package br.com.consultacep.application;

import java.util.Scanner;

import br.com.consultacep.model.Endereco;
import br.com.consultacep.service.ServicoEndereco;
import br.com.consultacep.service.Util;

/**
 * Interface usuário aplicação (main)
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	String cep;
    	Scanner entrada = new Scanner(System.in);
    	
    	//Recebe do usuário o CEP a ser consultado!
        System.out.print( "Informe o CEP: " );
        cep = entrada.nextLine();
        
        Endereco endereco = ServicoEndereco.buscaEndereco(cep);

        String[] conteudo = {"CEP..........: " + endereco.getCep(),
				 "Logradouro...: " + endereco.getLogradouro(),
				 "Complemento..: " + endereco.getComplemento(),
				 "Localidade...: " + endereco.getLocalidade(),
				 "Logradouro...: " + endereco.getUf(), 
				 };
        
        Util.CriaTela(50, 6, "SEU ENDEREÇO", conteudo);
    }
}
