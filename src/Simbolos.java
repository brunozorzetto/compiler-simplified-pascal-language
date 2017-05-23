/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno
 */
public class Simbolos {
    private String lexema;
    private String token;
    private String cat;
    private String tipo;
    private String valor;
    private String escopo;
    private String utilizada;
    private String endereco;
    
    public Simbolos(){
        
    }
    
    public Simbolos(String lexema, String token, String cat, String tipo, String valor, String escopo, String utilizada, String endereco){
        setLexema(lexema);
        setToken(token);
        setCat(cat);
        setTipo(tipo);
        setValor(valor);
        setEscopo(escopo);
        setUtilizada(utilizada);
        setEndereco(endereco);
    }

    /**
     * @return the lexema
     */
    public String getLexema() {
        return lexema;
    }

    /**
     * @param lexema the lexema to set
     */
    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the cat
     */
    public String getCat() {
        return cat;
    }

    /**
     * @param cat the cat to set
     */
    public void setCat(String cat) {
        this.cat = cat;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the escopo
     */
    public String getEscopo() {
        return escopo;
    }

    /**
     * @param escopo the escopo to set
     */
    public void setEscopo(String escopo) {
        this.escopo = escopo;
    }

    /**
     * @return the utilizada
     */
    public String getUtilizada() {
        return utilizada;
    }

    /**
     * @param utilizada the utilizada to set
     */
    public void setUtilizada(String utilizada) {
        this.utilizada = utilizada;
    }
    
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the utilizada to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
