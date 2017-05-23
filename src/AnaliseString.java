/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

public class AnaliseString {

    String[][] token = {
                            {"and","<AND>"},
                            {"array","<ARRAY>"},
                            {"begin","<BEGIN>"},
                            {"boolean", "<BOOLEAN>"},
                            {"do", "<DO>"},
                            {"else", "<ELSE>"},
                            {"end","<END>"},
                            {"false", "<BOOLEANO>"},
                            {"for","<FOR>"},
                            {"if", "<IF>"},
                            {"integer","<INTEGER>"},
                            {"mod","<MOD>"},
                            {"not","<NOT>"},
                            {"of","<OF>"},
                            {"or","<OR>"},
                            {"procedure","<PROCEDURE>"},
                            {"program","<PROGRAM>"},
                            {"read","<READ>"},
                            {"real","<REAL>"},
                            {"then", "<THEN>"},
                            {"true","<BOOLEANO>"},
                            {"while","<WHILE>"},
                            {"write","<WRITE>"},
                            {"var","<VAR>"},
                            {"=","<IGUAL>"},
                            {":=","<ATRIBUICAO>"},
                            {"<>","<DIFERENTE>"},
                            {"/","<OP_DIVISAO>"},
                            {"+","<OP_SOMA>"},
                            {"-","<OP_SUBTRACAO>"},
                            {"*","<OP_MULTIPLICACAO>"},
                            {":","<DOIS_PONTOS>"},
                            {">","<MAIOR>"},
                            {">=","<MAIOR_IGUAL>"},
                            {"<=","<MENOR_IGUAL>"},
                            {"<","<MENOR>"},
                            {".","<PONTO>"},
                            {";","<PONTO_E_VIRGULA>"},
                            {",","<VIRGULA>"},
                            {"(","<AP>"},
                            {")","<FP>"},
                            {"{","<A_CHAVE>"},
                            {"}","<F_CHAVE>"}
                            };
    public List<String> listaString;
    public boolean ehComentario;
    
    
    AnaliseString(){
        listaString = new ArrayList<String>();
        listaString.clear();
        
        ehComentario = false;
    }
    

    //Metodo que retorna o lexema que se refere o token
    public String retornaLexema(String s){
        // percorre a tabela de tokens procurando
        for (int i = 0; i < token.length; i++)
            if (token[i][0].equals(s))
                return (token[i][1]);
        
        //Caso não encontrar no array o token, ele tentar verificar se eh ID
        return verificaIdentificador(s);
    }
    
    private String verificaIdentificador(String str){
        //Divide a String e joga em um array de char
        char[] c = str.toCharArray(); 
        
        if(Character.isDigit(c[0])){
            return eNumero(str);
        }
        else if(Character.isLetter(c[0]) || c[0] == '_'){
            for(int i=1; i < c.length; i++){
                if(!Character.isLetterOrDigit(c[i]) && c[i]!='_'){
                    return "#OP_DESC";
                }
            }
            return "IDENTIFICADOR";
        }
        else
            return "#OP_DESC";
    }
    
    //Metodo que verifica se é inteiro ou real 
    private String eNumero( String s ) {  
        char[] c = s.toCharArray();  
        String x = "NR. INTEIRO";   

        for ( int i = 0; i < c.length; i++ )  {
            // verifica se o char não é um dígito 
            if (!Character.isDigit(c[i]))  {  
                if (".".equals(c[i])) {
                    // encontrou um "." entao é real e sai do laço
                    x = "NR. REAL";  
                    return x;
                    //break;
                }
                else {
                    return "#OP_DESC"; //Nesse caso o token encontrado não nada previsto no array
                                       //tambem nao e numero.
                }
            }
        }
        return x; 
    }
    
    
    //Metodo que separa a string
    public ArrayList separaString(String str) {
        char[] c = str.toCharArray();
        String auxString = "";
        
        int posString = 0;    //Posicao corrente na String
        //int lengthString=str.length(); //Retorna o Tamanho da String str

        listaString.clear();

        // percorre a sring
        while (posString < str.length()) {
            // verifica por comentario - Inicio
            if (c[posString] == '{') {
                
                ehComentario = true;
            }
            
            // verifica por comentario - Final
            if (c[posString] == '}') {
               
                ehComentario = false;
                
                continue;
            }
                              
            
            if (!ehComentario) {
                if (Character.isLetterOrDigit(c[posString]) && !Character.isSpaceChar(c[posString])) {
                    //Converte o char para String e soma a auxString
                    auxString += Character.toString(c[posString]);
                    //Incrementa a posicao da string
                    posString++;
                    //No caso do ultimo elemento da linha ser um caracter ou uma sequencia de caracter
                    if (posString == str.length()) {
                        listaString.add(auxString);
                    }
                    
                } 
                else {
                    if (c[posString] == '_') {
                        auxString += Character.toString(c[posString]);
                        posString++;
                    } 
                    else {
                        if (!auxString.equals("")) {
                            listaString.add(auxString);
                        }
                        auxString = "";
                        //posString++;
                        if (c[posString] == '<') {
                            if (c[posString + 1] == '=' || c[posString + 1] == '>') {
                                listaString.add(Character.toString(c[posString]) + Character.toString(c[++posString]));
                            } else {
                                listaString.add(Character.toString(c[posString++]));
                            }
                        } else if (c[posString] == '>') {
                            if (c[posString + 1] == '=') {
                                listaString.add(Character.toString(c[posString]) + Character.toString(c[++posString]));
                            } else {
                                listaString.add(Character.toString(c[posString++]));
                            }
                        } else if (c[posString] == ':' && c[posString + 1] == '=') {
                            listaString.add(Character.toString(c[posString]) + Character.toString(c[++posString]));
                        } else if (c[posString] == '=' && c[posString + 1] == '=') {
                            listaString.add(Character.toString(c[posString]) + Character.toString(c[++posString]));
                        } else {
                            if (!Character.isSpaceChar(c[posString]) && c[posString] != '\t') {
                                listaString.add(Character.toString(c[posString++]));
                            } else {
                                posString++;
                            }
                        }
                    }
                }
                
            }
            // Eh comentario, ignora tudo.
            else {
                //listaString.add(str);
                posString++;
            }
        }
        
        
        return (ArrayList) listaString;
    }
    
}
