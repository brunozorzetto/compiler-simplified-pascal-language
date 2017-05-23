import javax.swing.table.AbstractTableModel;
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


public class TabSimbolos extends AbstractTableModel{
    
    private int col_lexema=0;
    private int col_token=1;
    private int col_cat=2;
    private int col_tipo=3;
    private int col_valor=4;
    private int col_escopo=5;
    private int col_utilizada=6;
    private int col_endereco=7;
    
    
    private List<Simbolos> simbolos;
    
    private TabSimbolos (){
        simbolos=new ArrayList();
    }
    
    public TabSimbolos(List<Simbolos> lista){
        this();
        simbolos.addAll(lista);
    }
    
    public void inserir(Simbolos s){
        simbolos.add(s);
    }
    
    public int buscar(Simbolos s){
        int x=0;
        for (Simbolos simb: simbolos){
            if ((simb.getToken().equals(s.getToken())) && (simb.getLexema().equals(s.getLexema())) && 
                    (simb.getCat().equals(s.getCat())) ) 
                x=1;
        }
        if (x==1){
            return 1;
        }else 
            return 0;
    }
    
    public void alterarTipo(Simbolos s){
        
        for (Simbolos simb: simbolos){
            if ((simb.getToken().equals(s.getToken())) && (simb.getCat().equals(s.getCat())) ) {
                simb.setTipo(s.getTipo());
            }
        }
        
    }
    
    public void alterarUtilizada(Simbolos s){
        
        for (Simbolos simb: simbolos){
            if ((simb.getToken().equals(s.getToken())) && (simb.getCat().equals(s.getCat())) &&
                    (simb.getLexema().equals(s.getLexema()))) {
                simb.setUtilizada("S");
            }
        }
        
    }
    
    public void alocar_memoria(){
        int cont=0;
        for (Simbolos simb: simbolos){
            if ((simb.getToken().equals("IDENTIFICADOR")) && (simb.getCat().equals("var")) &&
                    ( (simb.getTipo().equals("real")) || (simb.getTipo().equals("integer")) ) ) {
                simb.setEndereco(""+cont);
                cont++;
            }
            if ((simb.getToken().equals("IDENTIFICADOR")) && (simb.getCat().equals("proc")) &&
                    ( (simb.getTipo().equals("real")) || (simb.getTipo().equals("integer")) ) ) {
                simb.setEndereco(""+cont);
                cont++;
            }
            if ((simb.getToken().equals("IDENTIFICADOR")) && (simb.getCat().equals("par")) &&
                    ( (simb.getTipo().equals("real")) || (simb.getTipo().equals("integer")) ) ) {
                simb.setEndereco(""+cont);
                cont++;
            }
        }
        
    }
    
    public String busca_endereco(Simbolos s){
        for (Simbolos simb: simbolos){
            if ((simb.getToken().equals(s.getToken())) && (simb.getCat().equals(s.getCat())) && 
                    (simb.getLexema().equals(s.getLexema()))) {
                return (s.getEndereco());
            }
        }
        return (s.getEndereco());
    }
    
    public String recupera_tipo(Simbolos s){
        for (Simbolos simb: simbolos){
            if ((simb.getToken().equals(s.getToken())) && (simb.getCat().equals(s.getCat())) && 
                    (simb.getLexema().equals(s.getLexema()))) {
                return (s.getTipo());
            }
        }
        return (s.getTipo());
    }
    
    /*public int recupera_tipo2(Simbolos s){
        int pos=0,achou=0;
        for (Simbolos simb: simbolos){
            if (simb.getLexema().equals(s.getLexema()))
                achou=pos;
            pos++;
        }
        if (achou!=0) return pos;
        return 0;
    }*/
    
    @Override
    public int getRowCount() {
        return simbolos.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 7;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Class getCloumnClass(int columnIndex){
        //retorna a classe que representa a coluna
        if (columnIndex == col_lexema) {
            return String.class;
        } else if (columnIndex == col_token) {
            return String.class;
        } else if (columnIndex == col_cat) {
            return String.class;
        } else if (columnIndex == col_tipo) {
            return String.class;
        } else if (columnIndex == col_valor) {
            return String.class;
        } else if (columnIndex == col_escopo) {
            return String.class;
        }else if (columnIndex == col_utilizada) {
            return String.class;
        }else if (columnIndex == col_endereco) {
            return String.class;
        }
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        
        //Pega o procuto da linha
        Simbolos s = simbolos.get(rowIndex);
        
        //Verifica qual o valor deve ser retornado
        if (columnIndex == col_lexema) {
            return s.getLexema();
        } else if (columnIndex == col_token) {
            return s.getToken();
        } else if (columnIndex == col_cat) {
            return s.getCat();
        }else if (columnIndex == col_tipo) {
            return s.getTipo();
        }else if (columnIndex == col_valor) {
            return s.getValor();
        }else if (columnIndex == col_escopo) {
            return s.getEscopo();
        }else if (columnIndex == col_utilizada) {
            return s.getUtilizada();
        }else if (columnIndex == col_endereco) {
            return s.getEndereco();
        }
        
        return String.class;
    }
    //Método que a JTablel chama quando uma célula é editada
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
       //Pega o produto da linha
        Simbolos s = simbolos.get(rowIndex);
        
        //Verifica qual o valor será alterado
        if(columnIndex==col_lexema){
            s.setLexema(aValue.toString());
        }
        else if(columnIndex==col_token){
            s.setToken(aValue.toString());
        }
        if(columnIndex==col_cat){
            s.setCat(aValue.toString());
        }
        else if(columnIndex==col_tipo){
            s.setTipo(aValue.toString());
        }
        if(columnIndex==col_valor){
            s.setValor(aValue.toString());
        }
        else if(columnIndex==col_escopo){
            s.setEscopo(aValue.toString());
        }
        else if(columnIndex==col_utilizada){
            s.setUtilizada(aValue.toString());
        }
        else if(columnIndex==col_endereco){
            s.setEndereco(aValue.toString());
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
    
}
