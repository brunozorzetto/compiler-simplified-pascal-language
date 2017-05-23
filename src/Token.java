/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class Token {
    
    private int linha;
    private String token;
    private String lexema;
    private int col_inicial;
    private int col_final;
    
    public Token(){
        
    }
    
    public Token(int linha, String token, String lexema, int col_inicial, int col_final){
        setToken(token);
        setLexema(lexema);
        setLinha(linha);
        setColInicial(col_inicial);
        setColFinal(col_final);
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getColInicial() {
        
        return col_inicial;
    }

    public void setColInicial(int col_inicial) {
        this.col_inicial = col_inicial;
    }
    public int getColFinal() {
        return col_final;
    }

    public void setColFinal(int ColFinal) {
        this.col_final = col_final;
    }

}
