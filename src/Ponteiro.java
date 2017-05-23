/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bruno
 */
public class Ponteiro {
    
    static int  posicao;
    
    public Ponteiro(){
        posicao=0;
    }

    /**
     * @return the posicao
     */
    public int getPosicao() {
        return posicao;
    }

    /**
     * @param posicao the posicao to set
     */
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
    public void proxsimbolo(){
        this.posicao=this.posicao+1;
    }
    
}
