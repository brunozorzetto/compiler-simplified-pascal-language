
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class TableToken extends AbstractTableModel{
    
    private int col_linha=0;
    private int col_token=1;
    private int col_lexema=2;
    private int col_inicial=3;
    private int col_final=4;
    
    Highlighter.HighlightPainter tokenHighlightPainter;   
    
    //Lista de nome que serão exibidos
    private List<Token> token;
    
    
    //Construtor sem argumentos
    public TableToken(){
        token = new ArrayList();
        tokenHighlightPainter = new TokenHighlighter(Color.red);
    }
    
    //Construtor com argumento
    public TableToken(List<Token> lista){
        this();
        token.addAll(lista);
    }
    
    public void inserir(Token t){
        
        //for (Token tk: token)
            //if (tk.getToken().equals(t.getToken())) 
                //return;
        
        token.add(t);
        
        /*método que avisa todos os listeners da tabela que houve uma mudança 
        nos dados, um deles é o responsável por desenhar a tabela e ao 
        ser notificado irá redesenhá-la.*/
        fireTableDataChanged();
    }
    
    public void excluir(Token t){
        token.remove(t);
        /*método que avisa todos os listeners da tabela que houve uma mudança 
        nos dados, um deles é o responsável por desenhar a tabela e ao 
        ser notificado irá redesenhá-la.*/
        fireTableDataChanged();
    }
    
    //////////////////////////////////////
    ////Funções que Manipulam a tabela////
    //////////////////////////////////////
    
    //Retorna o numero de linhas que a tabela tem
    @Override
    public int getRowCount(){
        //Cada produto na lista será uma linha
        return token.size();
    }
    
    //Retorna o numero de colunas que a tabela tem
    @Override
    public int getColumnCount(){
        //Serão LINHA, TOKEN, LEXEMA, Coluna inicial e Coluna final sendo 5 colunas
        return 5;
    }
    
    //Retorna o nome que será exibido na coluna
    @Override
    public String getColumnName(int column){
        //qual o nome da coluna
        if (column == col_linha) {
            return "LINHA";
        } else if (column == col_token) {
            return "TOKEN";
        } else if (column == col_lexema) {
            return "LEXEMA";
        } else if (column == col_inicial) {
            return "Col.In.";
        } else if (column == col_final) {
            return "Col.Fin.";
        }
        return "";
    }
    
    public Class getCloumnClass(int columnIndex){
        //retorna a classe que representa a coluna
        if (columnIndex == col_linha) {
            return String.class;
        } else if (columnIndex == col_token) {
            return String.class;
        } else if (columnIndex == col_lexema) {
            return String.class;
        } else if (columnIndex == col_inicial) {
            return String.class;
        } else if (columnIndex == col_final) {
            return String.class;
        }
        return String.class;
    }
    
    //método utilizado pela JTable para escrever os valores nas células
    //Internamente a JTable passa em todas as celulas chamando este método para setar 
    //os valores;
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        
        //Pega o procuto da linha
        Token t = token.get(rowIndex);
        
        //Verifica qual o valor deve ser retornado
        if (columnIndex == col_linha) {
            return t.getLinha();
        } else if (columnIndex == col_token) {
            return t.getToken();
        } else if (columnIndex == col_lexema) {
            return t.getLexema();
        }else if (columnIndex == col_inicial) {
            return t.getColInicial();
        }else if (columnIndex == col_final) {
            return t.getColFinal();
        }
        
        return String.class;
    }
    
    //Método que a JTablel chama quando uma célula é editada
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
       //Pega o produto da linha
        Token t = token.get(rowIndex);
        
        //Verifica qual o valor será alterado
        if(columnIndex==col_token){
            t.setToken(aValue.toString());
        }
        else if(columnIndex==col_lexema){
            t.setLexema(aValue.toString());
        }
        //avisa que os dados mudaram
        fireTableDataChanged();
    }
    
    //método para saber se a célula é ou não editável
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        //Nesse caso todas são editáveis
        return true;
    }

   
    /* Metodo para encontrar erros lexicos.
     * Chama dois metodos da classe AnaliseString para encontrar estes erros
     *
     */

    public void identificaErros(JTextArea text, JTable table){
        int i, j;
        //String str, aux;

        text.setText("");

        //AnaliseString analise = new AnaliseString();

        for(i=0; i<table.getRowCount(); i++){
            if(table.getValueAt(i, 2).equals("#OP_DESC")){
                text.append("Linha: "+table.getValueAt(i, 0)+
                            " -> Identificador invalido: "+table.getValueAt(i, 1)+"\n");
            }
        }
        
        if (text.getText().equals("")) {
            text.append("Sem erros lexicos!");
        }
    }
    
    
    /**
     * 
     * Busca na Tabela os TOKENs Desconhecidos
     * 
     **/
    public void destacaErros(JTextArea txt, JTable tbl) {
        // Remove os erros antigos
        removeHighlights(txt);
        
        for(int i = 0; i < tbl.getRowCount(); i++) {
            if (tbl.getValueAt(i, 2).equals("#OP_DESC")){
                highlight(txt, tbl.getValueAt(i, 1).toString());
            }
        }
    }
    
    // Removes only our private highlights
    public void removeHighlights(JTextComponent textComp) {
        Highlighter hilite = textComp.getHighlighter();
        Highlighter.Highlight[] hilites = hilite.getHighlights();

        for (int i=0; i < hilites.length; i++) {
            if (hilites[i].getPainter() instanceof TokenHighlighter) {
                hilite.removeHighlight(hilites[i]);
            }
        }
    }
    
    // Creates highlights around all occurrences of pattern in textComp
    public void highlight(JTextComponent textComp, String pattern) {
        // First remove all old highlights
        //removeHighlights(textComp);

        try {
            Highlighter hilite = textComp.getHighlighter();
            Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;

            // Search for pattern
            while ((pos = text.indexOf(pattern, pos)) >= 0) {
                // Create highlighter using private painter and apply around pattern
                hilite.addHighlight(pos, pos+pattern.length(), tokenHighlightPainter);
                pos += pattern.length();
            }
        } catch (BadLocationException e) {
        }
    }
    
}
