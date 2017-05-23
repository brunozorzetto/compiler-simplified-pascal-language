
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Compilador extends javax.swing.JFrame {
    
    //Variável do tipo da classe de token
    private TableToken tableToken;
    private static TabSimbolos tabsimbolos;
    private static String t,t1;
    private static int proc,par,cond,desvio;
    private static StringBuffer texto;
    
    private File arquivo;
    private FileReader fileReader;
    //private LineNumberedPaper codArea;
    //public int pos=0; //posicao na tabela de tokens usado na analise sintatica
    Ponteiro pos=new Ponteiro();

    //AnaliseString
    public List<String> stringTest;
      
    public Compilador() {
        initComponents();
        
        // Define a numeracao das linhas
        codArea.setBorder(new LineNumberedBorder(
               LineNumberedBorder.LEFT_SIDE,
               LineNumberedBorder.LEFT_JUSTIFY));
                
        // instancia a tabela
        resetaTabelaToken();
        
        stringTest = new ArrayList(); //Instanciando a lista
    }
    
    private void resetaConfigsAnteriories() {
        resetaTabelaToken();
        // Remove os Destaques se Existirem
        tableToken.removeHighlights(codArea);
        // Remove todos os Erros do Log de Erros
        jTextArea1.setText(null);
    }
    
    // Isso evita a sobreposição de elementos na tabela
    private void resetaTabelaToken()
    {
        //Lista dinámica para servir de modelo para tabela
        List<Token> listaToken = new ArrayList<Token>();
        
        //Cria o modelo da tabela
        //A tabela tera o mesmo modelo da classe tableToken
        tableToken = new TableToken(listaToken);
        
        //Atribui o modelo criado acima para jTable
        jTableToken.setModel(tableToken);
        //Especifica a largura da coluna
        jTableToken.getColumnModel().getColumn(0).setMaxWidth(50); //Nr. da linha
        jTableToken.getColumnModel().getColumn(1).setMaxWidth(300); //Token
        jTableToken.getColumnModel().getColumn(2).setMaxWidth(500); //Lexema
        jTableToken.getColumnModel().getColumn(3).setMaxWidth(300); //Nr. da coluna inicial
        jTableToken.getColumnModel().getColumn(4).setMaxWidth(300); //Nr. da coluna final
    }

    // Isso evita a sobreposição de elementos na tabela
    private void resetaTabelaSimbolos(TabSimbolos tabsimbolos)
    {
        //Lista dinámica para servir de modelo para tabela
        List<Simbolos> listaSimbolos = new ArrayList<Simbolos>();
        
        //Cria o modelo da tabela
        //A tabela tera o mesmo modelo da classe tabSimbolos
        tabsimbolos = new TabSimbolos(listaSimbolos);
    }
    public void abrirArq() throws FileNotFoundException, IOException 
    {
        JFileChooser fc = new JFileChooser(new File(".").getCanonicalPath());

        // define o filtro de arquivo que pode ser aberto
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos de Texto", "txt");
        
        fc.setFileFilter(filtro);
        
        // Veficia de foi pressionado Abrir na Janela de abrir aquivo.
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            // pega o arquivo selecionado
            arquivo = fc.getSelectedFile();
            
            // Define o nome do arquivo na barra de titulo
            setTitle("Compilador - Arquivo: " + arquivo.getName());

            // leitura do arquivo  
            fileReader = new FileReader(arquivo);

            codArea.read(fileReader, "codArea");
        }
        
        // Reseta Janela
        resetaConfigsAnteriories();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        codArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableToken = new javax.swing.JTable();
        btnAnalisar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btnAbrir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnGeracao = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAbrir = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador");
        setName("MainWindow"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        codArea.setColumns(20);
        codArea.setRows(5);
        codArea.setTabSize(4);
        codArea.setName("codArea"); // NOI18N
        jScrollPane3.setViewportView(codArea);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTableToken.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jTableToken.setName("jTableToken"); // NOI18N
        jScrollPane1.setViewportView(jTableToken);

        btnAnalisar.setText("EXECUTAR");
        btnAnalisar.setName("btnAnalisar"); // NOI18N
        btnAnalisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnalisarMouseClicked(evt);
            }
        });
        btnAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisarActionPerformed(evt);
            }
        });

        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N
        jToolBar1.setOpaque(false);

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document-open.png"))); // NOI18N
        btnAbrir.setFocusable(false);
        btnAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbrir.setName("btnAbrir"); // NOI18N
        btnAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbrirMouseClicked(evt);
            }
        });
        jToolBar1.add(btnAbrir);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName("jTextArea1"); // NOI18N
        jScrollPane2.setViewportView(jTextArea1);

        btnGeracao.setText("Gerar Código");
        btnGeracao.setName("btnGeracao"); // NOI18N
        btnGeracao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGeracaoMouseClicked(evt);
            }
        });
        btnGeracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeracaoActionPerformed(evt);
            }
        });

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setName("jTextArea2"); // NOI18N
        jScrollPane4.setViewportView(jTextArea2);

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu1.setText("Arquivo");
        jMenu1.setName("jMenu1"); // NOI18N

        menuAbrir.setText("Abrir");
        menuAbrir.setName("menuAbrir"); // NOI18N
        menuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(menuAbrir);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jMenu1.add(jSeparator1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(btnAnalisar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGeracao, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalisar)
                    .addComponent(btnGeracao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(859, 522));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //Analisador Sintático
    private void AnalisadorSintatico(){
        List aux;
        aux=new ArrayList();
        
        for(int i=0; i<jTableToken.getRowCount(); i++){
            
            aux.add(i, jTableToken.getValueAt(i, 1));
            
        }
        //Iterator it=aux.iterator();
        
        //jTextArea1.append(it.next().toString());
        
        List<Simbolos> listaSimbolos = new ArrayList<Simbolos>();
        tabsimbolos = new TabSimbolos(listaSimbolos);
        
        proc=0;
        par=0;
        t=""; t1="";
        desvio=0;
        texto=new StringBuffer();
        Ponteiro.posicao=0;
        programa(Ponteiro.posicao);
        /*
        bloco();
        partedeclaracoesvar();
        partedeclaracoessubrotinas();
        comandocomposto();
        tipo():
        indice();
        parametrosFormais();
        comando();
        comandoSemRotulo();
        termo();
        fator();
        expressao();
        expressaoSimples();
        listaexpressoes();
        
        */
        
    }

    //jTextArea1.append("\n POS: "+Ponteiro.posicao);
    //jTextArea1.append("\n"+tabsimbolos.getValueAt(0,0));
    //int soma = Integer.parseInt(a) // converter string em int
    
    private void programa (int i){
        int ultima;
        if ("program".equals(jTableToken.getValueAt(i, 1))){
            texto.append("INPP");
            Ponteiro.posicao=Ponteiro.posicao+1;
            identificador(Ponteiro.posicao);
            if ("IDENTIFICADOR".equals(jTableToken.getValueAt(Ponteiro.posicao-1, 2))){
                Simbolos s=new Simbolos("meu_prog","id","meu_prog","","-1","","","");
                setListSimbolos(s);
            }
            if (";".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                Ponteiro.posicao=Ponteiro.posicao+1;
                bloco(Ponteiro.posicao);
            }
            else{ //ERRO
                jTextArea1.append("\n Erro: ';' esperado.");
                bloco(Ponteiro.posicao);
            }
                        
        }        
        else{ //ERRO
            jTextArea1.append("\n Erro: 'program' esperado.");
            identificador(Ponteiro.posicao);
        }
        ultima=jTableToken.getRowCount()-1;
        //jTextArea1.append("\n ultima: " + ultima);
        if (".".equals(jTableToken.getValueAt(ultima, 1))){
                //ok
            }
            else{
                jTextArea1.append("\n Erro: '.' esperado.");
            }
        //alocar memoria para as variaveis
        tabsimbolos.alocar_memoria();
        //avisa que as variaveis declaradas nao sao utilizadas caso o campo utilizada = N
        for(int j = 0; j < tabsimbolos.getRowCount(); j++){
            if (tabsimbolos.getValueAt(j, 6).equals("N")){
                jTextArea1.append("\n Aviso: Identificador '"+tabsimbolos.getValueAt(j, 0) +"' nunca e utilizado.");
            }       
            //jTextArea1.append("\n valor: "+tabsimbolos.getValueAt(j, 0)+" - "
            //          +tabsimbolos.getValueAt(j, 1)+" - "+tabsimbolos.getValueAt(j, 2)+" - END:"+tabsimbolos.getValueAt(j, 7));
        }
        texto.append("\nPARA");
    }
    
    
    
    private void identificador (int i){
        if ("IDENTIFICADOR".equals(jTableToken.getValueAt(i, 2))){
            Ponteiro.posicao=Ponteiro.posicao+1;
        }
        else{ //ERRO
            jTextArea1.append("\n Erro: Identificador esperado.");
        
        }
        
    }
    
    private void bloco (int i){
        if ("var".equals(jTableToken.getValueAt(i, 1))){
            partedeclaracoesvar(Ponteiro.posicao);
        }
        if ("procedure".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
            partedeclaracoessubrotinas(Ponteiro.posicao);
            while ("procedure".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                partedeclaracoessubrotinas(Ponteiro.posicao);
            }
        }
        comandocomposto(Ponteiro.posicao);
    }
    
     private void tipo(int i){
        if (("boolean".equals(jTableToken.getValueAt(i, 1))) || ("integer".equals(jTableToken.getValueAt(i, 1))) ||
                ("real".equals(jTableToken.getValueAt(i, 1))) ){
            if ("integer".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                Simbolos s;
                if (proc==1){
                    s=new Simbolos("","IDENTIFICADOR","proc","integer","","","",""); 
                }
                else if (par==1){
                    s=new Simbolos("","IDENTIFICADOR","par","integer","","","",""); 
                } 
                else s=new Simbolos("","IDENTIFICADOR","var","integer","","","",""); 
                tabsimbolos.alterarTipo(s);
            }
            else if ("real".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                Simbolos s2;
                if (proc==1){
                    s2=new Simbolos("","IDENTIFICADOR","proc","real","","","",""); 
                }
                else if (par==1){
                    s2=new Simbolos("","IDENTIFICADOR","par","real","","","",""); 
                } 
                else s2=new Simbolos("","IDENTIFICADOR","var","real","","","",""); 
                tabsimbolos.alterarTipo(s2);
            }
            else {
                Simbolos s3;
                if (proc==1){
                    s3=new Simbolos("","IDENTIFICADOR","proc","booleano","","","",""); 
                }
                else if (par==1){
                    s3=new Simbolos("","IDENTIFICADOR","par","booleano","","","",""); 
                } 
                else s3=new Simbolos("","IDENTIFICADOR","var","booleano","","","",""); 
                tabsimbolos.alterarTipo(s3);
            }
            Ponteiro.posicao=Ponteiro.posicao+1;
        }
        else{
            jTextArea1.append("\n Erro: TIPO do identificador esperado.");
        }
    }
    
    private void partedeclaracoesvar(int i){
        if ("var".equals(jTableToken.getValueAt(i, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
            declaracaovar(Ponteiro.posicao);
            while ("IDENTIFICADOR".equals(jTableToken.getValueAt(Ponteiro.posicao+1, 2))){
                texto.append("\nAMEM  1");
                Ponteiro.posicao=Ponteiro.posicao+1;
                declaracaovar(Ponteiro.posicao);
            }
        }
        else{ //erro
            jTextArea1.append("\n Erro: 'var' esperado.");
            declaracaovar(Ponteiro.posicao);
        }
        if (";".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
        }
        else{
            jTextArea1.append("\n Erro: ';' esperado.");
        }
    }
    
    private void declaracaovar(int i){
        listaidentificadores(i);
        if (":".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
            tipo(Ponteiro.posicao);
        }
        else{
            jTextArea1.append("\n Erro: ':' esperado.");
            tipo(Ponteiro.posicao);
        }
    }
    
    private void listaidentificadores(int i){
        if ("IDENTIFICADOR".equals(jTableToken.getValueAt(i, 2)))
            while ("IDENTIFICADOR".equals(jTableToken.getValueAt(Ponteiro.posicao, 2))){
                texto.append("\nAMEM  1");
                Simbolos s;
                if (proc==1){
                    s=new Simbolos(""+jTableToken.getValueAt(Ponteiro.posicao, 1),"IDENTIFICADOR","proc","","","procedimento","N","");
                }
                else if (par==1){
                    s=new Simbolos(""+jTableToken.getValueAt(Ponteiro.posicao, 1),"IDENTIFICADOR","par","","","parametro","N","");
                } 
                else s=new Simbolos(""+jTableToken.getValueAt(Ponteiro.posicao, 1),"IDENTIFICADOR","var","","","","N","");
                if (tabsimbolos.buscar(s)==0){
                    setListSimbolos(s);
                }
                else{
                    jTextArea1.append("\n Erro: Identificador '"+jTableToken.getValueAt(Ponteiro.posicao, 1)+"' já declarado.");
                }
                identificador(Ponteiro.posicao);
                if (",".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                    Ponteiro.posicao=Ponteiro.posicao+1;
                }
            }
        else{
            jTextArea1.append("\n Erro: Identificador esperado.");
        }
    }
    
    private void partedeclaracoessubrotinas(int i){
        if ("procedure".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
            declaracaoproc(Ponteiro.posicao);
        }
    }
    
    private void declaracaoproc(int i){
        Simbolos s=new Simbolos(""+jTableToken.getValueAt(Ponteiro.posicao, 1),"id","proc","","","procedimento","","");
        setListSimbolos(s);
        identificador(i);
        par=1;
        parametrosformais(Ponteiro.posicao);
        par=0;
        proc=1;
        if (";".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
            bloco(Ponteiro.posicao);
        }
        else{
            jTextArea1.append("\n Erro: ';' esperado.");
            bloco(Ponteiro.posicao);
        }
        
        if (";".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
        }
        else{
            jTextArea1.append("\n Erro: ';' esperado.");
        }
        proc=0;
    }
    
    private void parametrosformais(int i){
        if ("(".equals(jTableToken.getValueAt(i, 1)) ){
            Ponteiro.posicao=Ponteiro.posicao+1;
            secaoparametrosformais(Ponteiro.posicao);
            while (";".equals(jTableToken.getValueAt(Ponteiro.posicao, 1)) ){
                Ponteiro.posicao=Ponteiro.posicao+1;
                secaoparametrosformais(Ponteiro.posicao);
            }
        }
        else{
            jTextArea1.append("\n Erro: '(' esperado.");
            secaoparametrosformais(Ponteiro.posicao);
            while (";".equals(jTableToken.getValueAt(Ponteiro.posicao, 1)) ){
                Ponteiro.posicao=Ponteiro.posicao+1;
                secaoparametrosformais(Ponteiro.posicao);
            }
        }
        if (")".equals(jTableToken.getValueAt(Ponteiro.posicao, 1)) ){
            Ponteiro.posicao=Ponteiro.posicao+1;
        }
        else{
            jTextArea1.append("\n Erro: ')' esperado.");
        }
    
    }
    
    private void secaoparametrosformais(int i){
        if ("var".equals(jTableToken.getValueAt(i, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
            listaidentificadores(Ponteiro.posicao);
            if ((":".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) ){
                Ponteiro.posicao=Ponteiro.posicao+1;
                tipo(Ponteiro.posicao);
            }
            else{
                jTextArea1.append("\n Erro: ':' esperado.");
                tipo(Ponteiro.posicao);
            }
        }
        else if (("IDENTIFICADOR".equals(jTableToken.getValueAt(Ponteiro.posicao, 2))) &&
                (";".equals(jTableToken.getValueAt(Ponteiro.posicao-1, 1)))){
                listaidentificadores(Ponteiro.posicao);
                if ((":".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) ){
                    Ponteiro.posicao=Ponteiro.posicao+1;
                    tipo(Ponteiro.posicao);
                }
                else{
                    jTextArea1.append("\n Erro: ':' esperado.");
                    tipo(Ponteiro.posicao);
                }
        }
        else{
            jTextArea1.append("\n Erro: 'var' esperado.");
            listaidentificadores(Ponteiro.posicao);
            if ((":".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) ){
                Ponteiro.posicao=Ponteiro.posicao+1;
                tipo(Ponteiro.posicao);
            }
            else{
                jTextArea1.append("\n Erro: ':' esperado.");
                tipo(Ponteiro.posicao);
            }
        }
    }
    
    private void comandocomposto(int i){
        if ("begin".equals(jTableToken.getValueAt(i, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
            comando(Ponteiro.posicao);
            while (!("end".equals(jTableToken.getValueAt(Ponteiro.posicao, 1)))){
                comando(Ponteiro.posicao);
            }
        }
        else{
            jTextArea1.append("\n Erro: 'begin' esperado.");
            comando(Ponteiro.posicao);
            while (!("end".equals(jTableToken.getValueAt(Ponteiro.posicao, 1)))){
                comando(Ponteiro.posicao);
            }
        }
        if ("end".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
        }
        else{
            jTextArea1.append("\n Erro: 'end' esperado.");
        }
    }
    
    private void comando(int i){
        if ((":=".equals(jTableToken.getValueAt(i+1, 1))) && ("IDENTIFICADOR".equals(jTableToken.getValueAt(i, 2)))){
            atribuicao(Ponteiro.posicao);
        }
        else if ("IDENTIFICADOR".equals(jTableToken.getValueAt(i, 2))){
            chamadaproc(Ponteiro.posicao);
        }
        else if ("begin".equals(jTableToken.getValueAt(i, 1))){
            comandocomposto(Ponteiro.posicao);
        }
        else if ("if".equals(jTableToken.getValueAt(i, 1))){
            comandocond1(Ponteiro.posicao);
        }
        else if ("while".equals(jTableToken.getValueAt(i, 1))){
            comandorep1(Ponteiro.posicao);
        }
        else if (("read".equals(jTableToken.getValueAt(i, 1))) || ("write".equals(jTableToken.getValueAt(i, 1))) ){
            leituraescrita(Ponteiro.posicao);
        }
        else{
            jTextArea1.append("\n Erro: Começo de comando esperado.");
            chamadaproc(Ponteiro.posicao);
        }
    }
    
    private void  atribuicao(int i){
        String end="";
        if ("IDENTIFICADOR".equals(jTableToken.getValueAt(i, 2))){
            Simbolos s;
            s=new Simbolos(""+(jTableToken.getValueAt(Ponteiro.posicao, 1)),"IDENTIFICADOR","par","","","","S","");
            
            if(tabsimbolos.buscar(s)==1){
                //achou id de parametro utilizada
            } else
            if (proc==1){
                s=new Simbolos(""+(jTableToken.getValueAt(i, 1)),"IDENTIFICADOR","proc","","","","S",""); 
            }
            else if (par==1){
                s=new Simbolos(""+(jTableToken.getValueAt(i, 1)),"IDENTIFICADOR","par","","","parametro","S",""); 
            } 
            else s=new Simbolos(""+(jTableToken.getValueAt(i, 1)),"IDENTIFICADOR","var","","","","S",""); 
            if (tabsimbolos.buscar(s)==0){
                jTextArea1.append("\n Erro: Identificador '"+jTableToken.getValueAt(Ponteiro.posicao, 1)+"' não declarado.");
            }
            tabsimbolos.alterarUtilizada(s);
            for(int j = 0; j < tabsimbolos.getRowCount(); j++){
                if ( (tabsimbolos.getValueAt(j, 0).equals(s.getLexema())) && (tabsimbolos.getValueAt(j, 1).equals(s.getToken())) 
                        && (tabsimbolos.getValueAt(j, 2).equals(s.getCat()))){
                    end=tabsimbolos.getValueAt(j, 7).toString();
                    
                }
            }
            end=""+tabsimbolos.busca_endereco(s);
            identificador(Ponteiro.posicao);
        }
        else{
            jTextArea1.append("\n Erro: Identificador esperado.");
        }
        
        if (":=".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
            Ponteiro.posicao=Ponteiro.posicao+2;
            expressao(Ponteiro.posicao);
        }
        else{
            if ("=".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                jTextArea1.append("\n Erro: ':=' esperado.");
                Ponteiro.posicao=Ponteiro.posicao+1; //DEIXAR ESSA OPERACAO****
                expressao(Ponteiro.posicao);
        
            }
            else{
                jTextArea1.append("\n Erro: ':=' esperado.");
                expressao(Ponteiro.posicao);
            }
        }
        if (";".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
        }
        else{
            jTextArea1.append("\n Erro: ';' esperado.");
        }
        
        texto.append("\nARMZ    "+end);
    }
    
    
    private void  leituraescrita(int i){
        String tipo1="",tipo2="",end="";
        Simbolos s;
        if (("write".equals(jTableToken.getValueAt(i, 1))) || ("read".equals(jTableToken.getValueAt(i, 1)))  ){
            if ("write".equals(jTableToken.getValueAt(i, 1))){
                texto.append("\nIMPE    ");
            }
            else{
                texto.append("\nLEIT   ");
                texto.append("\nARMZ   ");
            }
            Ponteiro.posicao=Ponteiro.posicao+1;
            if ("(".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                Ponteiro.posicao=Ponteiro.posicao+1;
                if ("IDENTIFICADOR".equals(jTableToken.getValueAt(Ponteiro.posicao, 2))){
                    s=new Simbolos(""+(jTableToken.getValueAt(Ponteiro.posicao, 1)),"IDENTIFICADOR","par","","","","S","");
                    if(tabsimbolos.buscar(s)==1){
                        //achou id de parametro utilizada
                    } else 
                    if (proc==1){
                        s=new Simbolos(""+jTableToken.getValueAt(Ponteiro.posicao, 1),"IDENTIFICADOR","proc","","","","S","");
                    }
                    else if(par==1){
                        s=new Simbolos(""+jTableToken.getValueAt(Ponteiro.posicao, 1),"IDENTIFICADOR","par","","","","S","");
                    } else s=new Simbolos(""+jTableToken.getValueAt(Ponteiro.posicao, 1),"IDENTIFICADOR","var","","","","S","");
                    if (tabsimbolos.buscar(s)==0){
                        jTextArea1.append("\n Erro: Identificador '"+jTableToken.getValueAt(Ponteiro.posicao, 1)+"' não declarado.");
                    }
                    else{
                        tipo1=tabsimbolos.recupera_tipo(s);
                    }
                    tabsimbolos.alterarUtilizada(s);
                    texto.append(""+tabsimbolos.busca_endereco(s));
                    end=tabsimbolos.busca_endereco(s);
                    jTextArea1.append(end);
                }
                identificador(Ponteiro.posicao);
                while (",".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) {
                    Ponteiro.posicao=Ponteiro.posicao+1;
                    if ("IDENTIFICADOR".equals(jTableToken.getValueAt(Ponteiro.posicao, 2))){
                        s=new Simbolos(""+(jTableToken.getValueAt(Ponteiro.posicao, 1)),"IDENTIFICADOR","par","","","","S","");
                        if(tabsimbolos.buscar(s)==1){
                            //achou id de parametro utilizada
                        } else 
                        if (proc==1){
                            s=new Simbolos(""+jTableToken.getValueAt(Ponteiro.posicao, 1),"IDENTIFICADOR","proc","","","","S","");
                        }
                        else if(par==1){
                            s=new Simbolos(""+jTableToken.getValueAt(Ponteiro.posicao, 1),"IDENTIFICADOR","par","","","","S","");
                        } else s=new Simbolos(""+jTableToken.getValueAt(Ponteiro.posicao, 1),"IDENTIFICADOR","var","","","","S","");
                        if (tabsimbolos.buscar(s)==0){
                            jTextArea1.append("\n Erro: Identificador '"+jTableToken.getValueAt(Ponteiro.posicao, 1)+"' não declarado.");
                        }
                        else{
                            tipo2=tabsimbolos.recupera_tipo(s);
                        }
                        if (!(tipo1.equals(tipo2))){
                            jTextArea1.append("\n Erro: Tipos incompatíveis.");
                        }
                        tabsimbolos.alterarUtilizada(s);
                        identificador(Ponteiro.posicao);
                    }
                }
            }
            else{
                jTextArea1.append("\n Erro: '(' esperado.");
                identificador(Ponteiro.posicao);
            }
        }
        else{
            jTextArea1.append("\n Erro: 'read ou write' esperado.");
        }
        if (")".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                Ponteiro.posicao=Ponteiro.posicao+1;
        }
        else{
            jTextArea1.append("\n Erro: ')' esperado.");
        }
        if (";".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                Ponteiro.posicao=Ponteiro.posicao+1;
        }
        else{
            jTextArea1.append("\n Erro: ';' esperado.");
        }
    }
    
    private void chamadaproc(int i){
        if ("IDENTIFICADOR".equals(jTableToken.getValueAt(i, 2))){
            Simbolos s;
            s=new Simbolos(""+(jTableToken.getValueAt(Ponteiro.posicao, 1)),"IDENTIFICADOR","par","","","","S","");
            if(tabsimbolos.buscar(s)==1){
                //achou id de parametro utilizada
            } 
            else if (proc==1){
                s=new Simbolos(""+(jTableToken.getValueAt(i, 1)),"IDENTIFICADOR","proc","","","","S",""); 
            }
            else if (par==1){
                s=new Simbolos(""+(jTableToken.getValueAt(i, 1)),"IDENTIFICADOR","par","","","","S",""); 
            } 
            else s=new Simbolos(""+(jTableToken.getValueAt(i, 1)),"IDENTIFICADOR","var","","","","S",""); 
            if (tabsimbolos.buscar(s)==0){
                jTextArea1.append("\n Erro: Identificador '"+jTableToken.getValueAt(Ponteiro.posicao, 1)+"' não declarado.");
            }
            tabsimbolos.alterarUtilizada(s);
            Ponteiro.posicao=Ponteiro.posicao+1;
            if ("(".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                Ponteiro.posicao=Ponteiro.posicao+1;
                listaexpressoes(Ponteiro.posicao);
                if (")".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                Ponteiro.posicao=Ponteiro.posicao+1;
                }
                else{
                    jTextArea1.append("\n Erro: ')' esperado.");
                }
            }
            else{
                listaexpressoes(Ponteiro.posicao);
            }
            
        }
        else{
            jTextArea1.append("\n Erro: 'IDENTIFICADOR' esperado.");
        }
    }
    
    private void comandocond1(int i){
        cond=0;
        if ("if".equals(jTableToken.getValueAt(i, 1))){
            cond=1;
            Ponteiro.posicao=Ponteiro.posicao+1;
            if ("(".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                expressao(Ponteiro.posicao);
            }
            else{
                jTextArea1.append("\n Erro: '(' esperado.");
                expressao(Ponteiro.posicao);
            }
            Ponteiro.posicao=Ponteiro.posicao-1;
            if (")".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                Ponteiro.posicao=Ponteiro.posicao+1;
                texto.append("\nCMMA");
                texto.append("\nDSVF     "+desvio);
            }
            else{
                jTextArea1.append("\n Erro: ')' esperado.");
            }
        }
        else{
            jTextArea1.append("\n Erro: 'if' esperado.");
            expressao(Ponteiro.posicao);
        }
        cond=0;
        if ("then".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
            comando(Ponteiro.posicao);
            if ("else".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                Ponteiro.posicao=Ponteiro.posicao+1;
                comando(Ponteiro.posicao);
            }
        }
        else{
            jTextArea1.append("\n Erro: 'then' esperado.");
            comando(Ponteiro.posicao);
        }
        
        if (("end".equals(jTableToken.getValueAt(Ponteiro.posicao-1, 1))) &&(";".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) ){
            Ponteiro.posicao=Ponteiro.posicao+1;
        }
        texto.append("\n"+desvio+"  NADA");
        desvio++;
    }
    
    private void comandorep1(int i){
        if ("while".equals(jTableToken.getValueAt(i, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
            if ("(".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                expressao(Ponteiro.posicao);
            }
            else{
                jTextArea1.append("\n Erro: '(' esperado.");
                expressao(Ponteiro.posicao);
            }
            Ponteiro.posicao=Ponteiro.posicao-1;
            if (")".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                Ponteiro.posicao=Ponteiro.posicao+1;
            }
            else{
                jTextArea1.append("\n Erro: ')' esperado.");
            }
        }
        else{
            jTextArea1.append("\n Erro: 'while' esperado.");
            expressao(Ponteiro.posicao);
        }
        if ("do".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
            comando(Ponteiro.posicao);
        }
        else{
            jTextArea1.append("\n Erro: 'do' esperado.");
            comando(Ponteiro.posicao);
        }
        if (("end".equals(jTableToken.getValueAt(Ponteiro.posicao-1, 1))) &&(";".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) ){
            Ponteiro.posicao=Ponteiro.posicao+1;
        }
        
    }
    private void expressao(int i){
        expressaosimples(Ponteiro.posicao);
        if (("<>".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) || ("<".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) || 
                (">".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) || ("<=".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) || 
                (">=".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) || ("=".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) ){
            relacao(Ponteiro.posicao);
            expressaosimples(Ponteiro.posicao);
        }
    }
    
    private void expressaosimples(int i){
        int op=0;
        if (("+".equals(jTableToken.getValueAt(i, 1))) || ("-".equals(jTableToken.getValueAt(i, 1))) ) {
            if ("+".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                op=1;
            } else op=0;
            Ponteiro.posicao=Ponteiro.posicao+1;
            termo(Ponteiro.posicao);
            if (op==1){
                texto.append("\nSOMA");
            } else texto.append("\nSUBT");
        }  
        else{
            termo(Ponteiro.posicao);
        }
  
        while (("+".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) || ("-".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) 
                || ("or".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) ) {
            if ("+".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                op=1;
            } else op=0;
            Ponteiro.posicao=Ponteiro.posicao+1;
            termo(Ponteiro.posicao);
            if (op==1){
                texto.append("\nSOMA");
            } else texto.append("\nSUBT");
        }
    }
    
    private void termo(int i){
        String t2="";
        t=""; t1="aaa";
        fator(Ponteiro.posicao);
         while (("*".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) || ("div".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) 
                || ("and".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))) ) {
            t1="";
            if ("*".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                t2="integer";
            }
            else if ("div".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                t2="integer";
            }
            else if ("and".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                t2="booleano";
            }
            Ponteiro.posicao=Ponteiro.posicao+1;
            fator(Ponteiro.posicao);
            
            if (!(t.equals(t1))) {
                jTextArea1.append("\n Erro: Incompatibilidade de tipos: "+t+" e "+t1 );
            }
            else if (!(t.equals(t2))) {
                    jTextArea1.append("\n Erro: Incompatibilidade de tipos: "+t+" e "+t2);
                }
        }
    }
    
    private void fator(int i){
        String tipo="";
        String end="";
        if ("IDENTIFICADOR".equals(jTableToken.getValueAt(i, 2))){
            Simbolos s;
            //if (cond==1){
            //}
            //CONFERE SE O ID FOI UTILIZADO e DECLARADO
            s=new Simbolos(""+(jTableToken.getValueAt(Ponteiro.posicao, 1)),"IDENTIFICADOR","par","","","","S","");
            if(tabsimbolos.buscar(s)==1){
                //achou id de parametro utilizada
            } 
            else if (proc==1){
                s=new Simbolos(""+(jTableToken.getValueAt(Ponteiro.posicao, 1)),"IDENTIFICADOR","proc","","","","S",""); 
            }
            else if (par==1){
                s=new Simbolos(""+(jTableToken.getValueAt(Ponteiro.posicao, 1)),"IDENTIFICADOR","par","","","","S",""); 
            } 
            else {
                s=new Simbolos(""+(jTableToken.getValueAt(Ponteiro.posicao, 1)),"IDENTIFICADOR","var","","","","S","");
            } 
            
            if (tabsimbolos.buscar(s)==0){
                jTextArea1.append("\n Erro: Identificador '"+jTableToken.getValueAt(Ponteiro.posicao, 1)+"' não declarado.");
            }
            tabsimbolos.alterarUtilizada(s);
            //--------------------------------
            for(int j = 0; j < tabsimbolos.getRowCount(); j++){
                if ((tabsimbolos.getValueAt(j, 3).equals("integer")) && (tabsimbolos.getValueAt(j, 0).equals(s.getLexema()))
                        && (tabsimbolos.getValueAt(j, 2).equals(s.getCat())) ){
                    tipo="integer";
                    break;
                }
                else if ((tabsimbolos.getValueAt(j, 3).equals("real")) && (tabsimbolos.getValueAt(j, 0).equals(s.getLexema()))
                        && (tabsimbolos.getValueAt(j, 2).equals(s.getCat())) ){
                        tipo="real";
                        break;
                    }
                else if ((tabsimbolos.getValueAt(j, 3).equals("booleano")) && (tabsimbolos.getValueAt(j, 0).equals(jTableToken.getValueAt(Ponteiro.posicao, 1)))
                        && (tabsimbolos.getValueAt(j, 2).equals(s.getCat())) ){
                        tipo="booleano";
                        break;
                    }
            }
            if (tipo.equals("integer")){
                if (t.equals("")) t="integer";
                if (t1.equals("")){
                    t1="integer";
                }
            }
            else if (tipo.equals("real")){
                if (t.equals("")) t="real";
                if (t1.equals("")){
                    t1="real";
                }
            }
            else {
                if (t.equals("")) t="real/booleano";
                if (t1.equals("")) t1="real/booleano";
            }
            for(int j = 0; j < tabsimbolos.getRowCount(); j++){
                    if(s.getLexema()==tabsimbolos.getValueAt(j, 0) && (s.getToken()==tabsimbolos.getValueAt(j, 1) &&
                            (s.getCat()==tabsimbolos.getValueAt(j, 2))) ){
                        end=(tabsimbolos.getValueAt(j, 7)).toString();
                    }
                }
            texto.append("\nCRVL    ").append(end);
            identificador(Ponteiro.posicao);
        }
        else if ("NR. REAL".equals(jTableToken.getValueAt(i, 2))){ 
            //if (cond==1){
                texto.append("\nCRCT    "+jTableToken.getValueAt(Ponteiro.posicao,1));
            //}
            Ponteiro.posicao=Ponteiro.posicao+1;
            if (t.equals("")) t="real";
            if (t1.equals("")) t1="real";
        }
        else if ("NR. INTEIRO".equals(jTableToken.getValueAt(i, 2))){
            //if (cond==1){
                texto.append("\nCRCT    "+jTableToken.getValueAt(Ponteiro.posicao,1));
            //}
            Ponteiro.posicao=Ponteiro.posicao+1;
            if (t.equals("")) t="integer";
            if (t1.equals("")){
                t1="integer";
            }
        }
        else if ("(".equals(jTableToken.getValueAt(i, 1))){
                Ponteiro.posicao=Ponteiro.posicao+1; 
                expressao(Ponteiro.posicao);
                if (")".equals(jTableToken.getValueAt(Ponteiro.posicao, 1))){
                    Ponteiro.posicao=Ponteiro.posicao+1; 
                }
                else{
                    jTextArea1.append("\n Erro: ')' esperado.");
                }
        }
        else {
            jTextArea1.append("\n Erro: Identificador ou Numero esperado."); 
        }
    }
    
    private void relacao(int i){
        Ponteiro.posicao=Ponteiro.posicao+1;
    }
    
    /*private void variavel(int i){
        if ("IDENTIFICADOR".equals(jTableToken.getValueAt(i, 2))){
            Ponteiro.posicao=Ponteiro.posicao+1;
            i=Ponteiro.posicao;
        }
        else{
            i=Ponteiro.posicao;
            jTextArea1.append("\n Erro: Identificador esperado.");
        }
        if (("+".equals(jTableToken.getValueAt(i, 1))) || ("-".equals(jTableToken.getValueAt(i, 1))) 
                || ("IDENTIFICADOR".equals(jTableToken.getValueAt(i, 2))) ) {
            Ponteiro.posicao=Ponteiro.posicao+1;
            expressao(Ponteiro.posicao);
            
        }   
    }*/
    
    private void listaexpressoes(int i){
        expressao(Ponteiro.posicao);
        i=Ponteiro.posicao;
        while (",".equals(jTableToken.getValueAt(i, 1))){
            Ponteiro.posicao=Ponteiro.posicao+1;
            expressao(Ponteiro.posicao);
            i=Ponteiro.posicao;
            
        }
        
    }
    
    
    private void btnAnalisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnalisarMouseClicked
        AnaliseString str = new AnaliseString();
        String linhas[];
        Token token;
        int qtddLinha = 0;
                
        // pega todas as linhas do codArea e joga no array linhas
        linhas = codArea.getText().split("\\r\\n|\\n");
        
        resetaTabelaToken();

        //for percorre todas as linhas do array
        for (String linha: linhas) {             
            //O método separaString Divide a String e joga no ArrayList StringTest
            stringTest = str.separaString(linha);
           
            //incrementa a quantidade de linhas
            qtddLinha++;
            
            if (linha.length() > 0) {
                for(String s : stringTest){
                    
                    token = new Token(qtddLinha, s, str.retornaLexema(s),1,1); 
                    setListToken(token); //Adiciona o objeto token a tabela
                    
                }   
            }
        }
        
        //Identifica os tokens com erro e joga no TextArea
        tableToken.identificaErros(jTextArea1, jTableToken);
            
        // Destaca os Erros
        tableToken.destacaErros(codArea, jTableToken);
        if ("Sem erros lexicos!".equals(jTextArea1.getText())){
            jTextArea1.append("\n");
            AnalisadorSintatico();
        }
        
    }//GEN-LAST:event_btnAnalisarMouseClicked

    
    //Insere os tokens em uma Variável.
    public void setListToken(Token token) {
        tableToken.inserir(token);
    }    
    
    //Insere os tokens em uma Variável.
    public void setListSimbolos(Simbolos simbolo) {
        tabsimbolos.inserir(simbolo);
    }    
    
    
    private void menuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirActionPerformed
        try {
            // inicia o processo de abertura do arquivo
            abrirArq();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuAbrirActionPerformed

    private void btnAbrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirMouseClicked
        menuAbrirActionPerformed(null);
    }//GEN-LAST:event_btnAbrirMouseClicked

    private void btnAnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnalisarActionPerformed

    private void btnGeracaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGeracaoMouseClicked
        if (!(jTextArea2.getText().equals(""))){
            jTextArea2.setText("");
        }
        jTextArea2.append(texto.toString());
        //texto=new StringBuffer();
        /*if (("Sem erros lexicos!\n").equals(jTextArea1.getText())){
            
            try{  
                // o true significa q o arquivo será constante  
                String caminho = System.getProperty("user.home");
                String arquivo = "/nome do programa/texto.txt";
                File file = new File(pasta+arquivo); 
                FileWriter x = new FileWriter(caminho,true);   
             
                x.write(texto); // armazena o texto no objeto x, que aponta para o arquivo             
                x.close(); // cria o arquivo              
                JOptionPane.showMessageDialog(null,"Geração de código feita com sucesso","Concluído",JOptionPane.INFORMATION_MESSAGE);  
            }  
            // em caso de erro apreenta mensagem abaixo  
            catch(Exception e){  
                JOptionPane.showMessageDialog(null,e.getMessage(),"Atenção",JOptionPane.WARNING_MESSAGE);  
            }  
        }*/
        
    }//GEN-LAST:event_btnGeracaoMouseClicked

    private void btnGeracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeracaoActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_btnGeracaoActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Compilador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAnalisar;
    private javax.swing.JButton btnGeracao;
    private javax.swing.JTextArea codArea;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTableToken;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menuAbrir;
    // End of variables declaration//GEN-END:variables


}
