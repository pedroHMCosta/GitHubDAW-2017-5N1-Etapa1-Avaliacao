/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.util;

/**
 *
 * @author Monteiro
 */
public class Util {
    public static String getMensagemErro(Exception e) {
        while (e.getCause()!=null) {
           e = (Exception) e.getCause();
            
        }
        String retorno = e.getMessage();
        if (retorno.contains("viola restrição de chave estrangeira")) {
            retorno = "Registo nao pdoe ser excluído por possuir referência "
                    +"em outros objetos";
        }
        return retorno;
    }
}
