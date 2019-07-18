
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class MaquinaVirtual extends javax.swing.JFrame {

    public Instrucao[] area_instrucoes;
    public String[] pilhaDados = new String[100000];
    public String[] pilhaTipos = new String[100000];
    public int topo = 0;
    public int ponteiro = 1;
    
    public String saida = "";
    
    /**
     * Creates new form MaquinaVirtual
     */
    public MaquinaVirtual(Tabela tabela) {
        this.setTitle("Maquina Virtual");
        int aux = 0;
        area_instrucoes = new Instrucao[tabela.area_instrucoes.size()+1];
        for (Instrucao in : tabela.area_instrucoes)
        {
            aux++;
            area_instrucoes[aux] = in;
        }
        initComponents();
    }
    
    public void executeActions()
    {
        try
        {
            while(!area_instrucoes[ponteiro].codigo.equals("STP"))
            {
                switch(area_instrucoes[ponteiro].codigo)
                {
                    case "ADD":
                        add();
                        break;

                    case "DIV":
                        div();
                        break;

                    case "DIR":
                        dir();
                        break;

                    case "MUL":
                        mul();
                        break;

                    case "SUB":
                        sub();
                        break;

                    case "POW":
                        pow();
                        break;

                    case "MOD":
                        mod();
                        break;

                    case "ALB":
                        alb();
                        break;

                    case "ALI":
                        ali();
                        break;

                    case "ALR":
                        alr();
                        break;

                    case "ALS":
                        als();
                        break;

                    case "LDB":
                        ldb();
                        break;

                    case "LDI":
                        ldi();
                        break;

                    case "LDR":
                        ldr();
                        break;

                    case "LDS":
                        lds();
                        break;

                    case "LDV":
                        ldv();
                        break;

                    case "STR":
                        if (area_instrucoes[ponteiro+1].codigo.equals("STR"))
                            str();
                        else
                            last_str();
                        break;

                    case "AND":
                        and();
                        break;

                    case "NOT":
                        str();
                        break;

                    case "OR":
                        str();
                        break;

                    case "BGE":
                        bge();
                        break;

                    case "BGR":
                        bgr();
                        break;

                    case "DIF":
                        dif();
                        break;

                    case "EQL":
                        eql();
                        break;

                    case "SME":
                        sme();
                        break;

                    case "SMR":
                        smr();
                        break;

                    case "JMF":
                        jmf();
                        break;

                    case "JMP":
                        jmp();
                        break;

                    case "JMT":
                        jmt();
                        break;

                    case "STP":
                        stp();
                        break;

                    case "STC":
                        stc();
                        break;

                    case "REA":
                        rea();
                        break;

                    case "WRT":
                        wrt();
                        break;
                }
            }
        }
        catch(Runtime_Exception err)
        {
            saida += err.message;
            vmShell.setText(saida);
        }
        
    }
    
    public void add() throws Runtime_Exception
    {
        if (!pilhaTipos[topo - 1].equals("natural") && !pilhaTipos[topo - 1].equals("real")
                || !pilhaTipos[topo].equals("natural") && !pilhaTipos[topo].equals("real"))
        {
            throw new Runtime_Exception("ERRO: TIPOS INVALIDOS PARA SOMA");
        }
        if (pilhaTipos[topo - 1].equals("real") || pilhaTipos[topo].equals("real"))
        {
            pilhaDados[topo - 1] = String.valueOf(new Double(pilhaDados[topo - 1]) + new Double(pilhaDados[topo]));
            pilhaTipos[topo - 1] = "real";
        }
        else
        {
            pilhaDados[topo - 1] = String.valueOf(new Integer(pilhaDados[topo - 1]) + new Integer(pilhaDados[topo]));
            pilhaTipos[topo - 1] = "natural";
        }
        topo = topo - 1;
        ponteiro = ponteiro + 1;
    }
    
    public void div() throws Runtime_Exception // divisao inteira
    {
        if (!pilhaTipos[topo - 1].equals("natural") && !pilhaTipos[topo - 1].equals("real")
                || !pilhaTipos[topo].equals("natural") && !pilhaTipos[topo].equals("real"))
        {
            throw new Runtime_Exception("ERRO: TIPOS INVALIDOS PARA DIVISAO INTEIRA");
        }
        
        if (pilhaDados[topo].equals("0") || pilhaDados[topo].equals("0.0"))
        {
            throw new RuntimeException("RUNTIME error: divisao por 0!");
        }
        
        pilhaDados[topo - 1] = String.valueOf(new Integer(new Double(pilhaDados[topo - 1]).intValue() / new Double(pilhaDados[topo]).intValue()));
        pilhaTipos[topo - 1] = "natural";
        topo = topo - 1;
        ponteiro = ponteiro + 1;
    }
    
    public void dir() throws Runtime_Exception // divisao real
    {
        if (new Integer(pilhaDados[topo]) == 0)
        {
            throw new RuntimeException("RUNTIME error: divisao por 0!");
        }
        
        if (!pilhaTipos[topo - 1].equals("natural") && !pilhaTipos[topo - 1].equals("real")
                || !pilhaTipos[topo].equals("natural") && !pilhaTipos[topo].equals("real"))
        {
            throw new Runtime_Exception("ERRO: TIPOS INVALIDOS PARA DIVISAO");
        }
        
        pilhaDados[topo - 1] = String.valueOf(new Double(pilhaDados[topo - 1]) / new Double(pilhaDados[topo]));
        pilhaTipos[topo - 1] = "real";
        topo = topo - 1;
        ponteiro = ponteiro + 1;
    }
    
    public void mul() throws Runtime_Exception
    {
        if (!pilhaTipos[topo - 1].equals("natural") && !pilhaTipos[topo - 1].equals("real")
                || !pilhaTipos[topo].equals("natural") && !pilhaTipos[topo].equals("real"))
        {
            throw new Runtime_Exception("ERRO: TIPOS INVALIDOS PARA MULTIPLICACAO");
        }
        
        if (pilhaTipos[topo - 1].equals("real") || pilhaTipos[topo].equals("real"))
        {
            pilhaDados[topo - 1] = String.valueOf(new Double(pilhaDados[topo - 1]) * new Double(pilhaDados[topo]));
            pilhaTipos[topo - 1] = "real";
        }
        else
        {
           pilhaDados[topo - 1] = String.valueOf(new Integer(pilhaDados[topo - 1]) * new Integer(pilhaDados[topo]));
           pilhaTipos[topo - 1] = "natural";
        }
        
        topo = topo - 1;
        ponteiro = ponteiro + 1;
    }
    
    public void sub() throws Runtime_Exception
    {
        if (!pilhaTipos[topo - 1].equals("natural") && !pilhaTipos[topo - 1].equals("real")
                || !pilhaTipos[topo].equals("natural") && !pilhaTipos[topo].equals("real"))
        {
            throw new Runtime_Exception("ERRO: TIPOS INVALIDOS PARA SUBTRACAO");
        }
        if (pilhaTipos[topo - 1].equals("real") || pilhaTipos[topo].equals("real"))
        {
            pilhaDados[topo - 1] = String.valueOf(new Double(pilhaDados[topo - 1]) - new Double(pilhaDados[topo]));
            pilhaTipos[topo - 1] = "real";
        }
        else
        {
            pilhaDados[topo - 1] = String.valueOf(new Integer(pilhaDados[topo - 1]) - new Integer(pilhaDados[topo]));
            pilhaTipos[topo - 1] = "natural";
        }
        topo = topo - 1;
        ponteiro = ponteiro + 1;
    }
    
    public void pow() throws Runtime_Exception // potencia
    {
        if (!pilhaTipos[topo - 1].equals("natural") && !pilhaTipos[topo - 1].equals("real")
                || !pilhaTipos[topo].equals("natural") && !pilhaTipos[topo].equals("real"))
        {
            throw new Runtime_Exception("ERRO: TIPOS INVALIDOS PARA POTENCIA");
        }
        
        if (pilhaTipos[topo - 1].equals("real"))
        {
            pilhaDados[topo - 1] = String.valueOf(Math.pow(new Double(pilhaDados[topo - 1]), new Double(pilhaDados[topo])));
            pilhaTipos[topo - 1] = "real";
        }
        else
        {
            pilhaDados[topo - 1] = String.valueOf(new Integer(new Double(Math.pow(new Double(pilhaDados[topo - 1]), new Double(pilhaDados[topo]))).intValue()));
            pilhaTipos[topo - 1] = "natural";
        }
        
        
        topo = topo - 1;
        ponteiro = ponteiro + 1;
    }
    
    public void mod() throws Runtime_Exception // resto da divisao inteira
    {
        if (!pilhaTipos[topo - 1].equals("natural") && !pilhaTipos[topo - 1].equals("real")
                || !pilhaTipos[topo].equals("natural") && !pilhaTipos[topo].equals("real"))
        {
            throw new Runtime_Exception("ERRO: TIPOS INVALIDOS PARA RESTO DE DIVISAO INTEIRA");
        }
        
        if (pilhaTipos[topo - 1].equals("real"))
        {
            pilhaDados[topo - 1] = String.valueOf(new Double(pilhaDados[topo - 1]) % new Double(pilhaDados[topo]));
            pilhaTipos[topo - 1] = "real";
        }
        else
        {
            pilhaDados[topo - 1] = String.valueOf(new Integer((new Double(new Double(pilhaDados[topo - 1]) % new Double(pilhaDados[topo]))).intValue()));
            pilhaTipos[topo - 1] = "natural";
        }
        
        topo = topo - 1;
        ponteiro = ponteiro + 1;
    }
    
    public void alb()
    {
        for (int i=topo+1; i<=topo+new Integer(area_instrucoes[ponteiro].parametro); i++)
        {
            pilhaDados[i] = "false";
            pilhaTipos[i] = "boolean";
        }
        topo = topo + new Integer(area_instrucoes[ponteiro].parametro);
        ponteiro = ponteiro + 1;
    }
    
    public void ali()
    {
        for (int i=topo+1; i<=topo+new Integer(area_instrucoes[ponteiro].parametro); i++)
        {
            pilhaDados[i] = "0";
            pilhaTipos[i] = "natural";
        }
        topo = topo + new Integer(area_instrucoes[ponteiro].parametro);
        ponteiro = ponteiro + 1;
    }
    
    public void alr()
    {
        for (int i=topo+1; i<=topo+new Integer(area_instrucoes[ponteiro].parametro); i++)
        {
            pilhaDados[i] = "0.0";
            pilhaTipos[i] = "real";
        }
        topo = topo + new Integer(area_instrucoes[ponteiro].parametro);
        ponteiro = ponteiro + 1;
    }
    
    public void als()
    {
        for (int i=topo+1; i<=topo+new Integer(area_instrucoes[ponteiro].parametro); i++)
        {
            pilhaDados[i] = "";
            pilhaTipos[i] = "char";
        }
        topo = topo + new Integer(area_instrucoes[ponteiro].parametro);
        ponteiro = ponteiro + 1;
    }
    
    public void ldb()
    {
        topo = topo + 1;
        pilhaDados[topo] = area_instrucoes[ponteiro].parametro;
        pilhaTipos[topo] = "boolean";
        ponteiro = ponteiro + 1;
    }
    
    public void ldi()
    {
        topo = topo + 1;
        pilhaDados[topo] = area_instrucoes[ponteiro].parametro;
        pilhaTipos[topo] = "natural";
        ponteiro = ponteiro + 1;
    }
    
    public void ldr()
    {
        topo = topo + 1;
        pilhaDados[topo] = area_instrucoes[ponteiro].parametro;
        pilhaTipos[topo] = "real";
        ponteiro = ponteiro + 1;
    }
    
    public void lds()
    {
        topo = topo + 1;
        pilhaDados[topo] = area_instrucoes[ponteiro].parametro;
        pilhaTipos[topo] = "char";
        ponteiro = ponteiro + 1;
    }
    
    public void ldv()
    {
        topo = topo + 1;
        pilhaDados[topo] = pilhaDados[new Integer(area_instrucoes[ponteiro].parametro)];
        pilhaTipos[topo] = pilhaTipos[new Integer(area_instrucoes[ponteiro].parametro)];
        ponteiro = ponteiro + 1;
    }
    
    public void str() throws Runtime_Exception
    {
        if (pilhaTipos[new Integer(area_instrucoes[ponteiro].parametro)].equals("real"))
        {
            if (pilhaTipos[topo].equals("real") || pilhaTipos[topo].equals("natural"))
                {
                    pilhaDados[new Integer(area_instrucoes[ponteiro].parametro)] = new Double(pilhaDados[topo]).toString();
                    pilhaTipos[new Integer(area_instrucoes[ponteiro].parametro)] = "real";
                }
                else
                {
                    throw new Runtime_Exception("ERRO: TIPO INVALIDO PARA ATRIBUIÇÃO, ESPERAVA-SE REAL OU NATURAL");
                }
        }
        else if (pilhaTipos[new Integer(area_instrucoes[ponteiro].parametro)].equals(pilhaTipos[topo]))
        {
            pilhaDados[new Integer(area_instrucoes[ponteiro].parametro)] = pilhaDados[topo];
            pilhaTipos[new Integer(area_instrucoes[ponteiro].parametro)] = pilhaTipos[topo];
        }
        else
        {
            throw new Runtime_Exception("ERRO: TIPO INVALIDO PARA ATRIBUIÇÃO, ESPERAVA-SE " + 
                    pilhaTipos[new Integer(area_instrucoes[ponteiro].parametro)].toUpperCase());
        }
        
        ponteiro = ponteiro + 1;
    }
    
    public void last_str() throws Runtime_Exception
    {
        str();
        topo = topo - 1;
    }
    
    public void and() throws Runtime_Exception
    {
        if (!pilhaTipos[topo - 1].equals("boolean") && !pilhaTipos[topo].equals("boolean"))
        {
            throw new Runtime_Exception("ERRO: TIPO INVALIDO PARA OPERACAO AND");
        }
        pilhaDados[topo -1] = String.valueOf(Boolean.valueOf(pilhaDados[topo - 1]) & Boolean.valueOf(pilhaDados[topo]));
        pilhaTipos[topo -1] = "boolean";
        topo--;
        ponteiro++;
    }
    
    public void not() throws Runtime_Exception
    {
        if (!pilhaTipos[topo - 1].equals("boolean") && !pilhaTipos[topo].equals("boolean"))
        {
            throw new Runtime_Exception("ERRO: TIPO INVALIDO PARA OPERACAO NOT");
        }
        pilhaDados[topo -1] = String.valueOf(! Boolean.valueOf(pilhaDados[topo]));
        pilhaTipos[topo -1] = "boolean";
        ponteiro++;
    }
    
    public void or() throws Runtime_Exception
    {
        if (!pilhaTipos[topo - 1].equals("boolean") && !pilhaTipos[topo].equals("boolean"))
        {
            throw new Runtime_Exception("ERRO: TIPO INVALIDO PARA OPERACAO OR");
        }
        pilhaDados[topo -1] = String.valueOf(Boolean.valueOf(pilhaDados[topo - 1]) || Boolean.valueOf(pilhaDados[topo]));
        pilhaTipos[topo -1] = "boolean";
        topo--;
        ponteiro++;
    }
    
    public void bge() throws Runtime_Exception
    {    
        if (pilhaTipos[topo -1].equals("char") || pilhaTipos[topo -1].equals("boolean") || pilhaTipos[topo].equals("char") || pilhaTipos[topo].equals("boolean"))
        {
            System.out.println("LOOOOL");
            System.out.println(pilhaTipos[topo -1]);
            System.out.println(pilhaTipos[topo]);
            throw new Runtime_Exception("ERRO: TIPOS INVALIDOS PARA OPERACAO MAIOR OU IGUAL");
        }
        pilhaDados[topo -1] = String.valueOf(Double.valueOf(pilhaDados[topo - 1]) >= Double.valueOf(pilhaDados[topo]));
        pilhaTipos[topo -1] = "boolean";
        topo--;
        ponteiro++;
    }
    
    public void bgr() throws Runtime_Exception
    {
        if (pilhaTipos[topo -1].equals("char") || pilhaTipos[topo -1].equals("boolean") || pilhaTipos[topo].equals("char") || pilhaTipos[topo].equals("boolean"))
        {
            throw new Runtime_Exception("ERRO: TIPOS INVALIDOS PARA OPERACAO MAIOR QUE ");
        }
        pilhaDados[topo -1] = String.valueOf(Double.valueOf(pilhaDados[topo - 1]) > Double.valueOf(pilhaDados[topo]));
        pilhaTipos[topo -1] = "boolean";
        topo--;
        ponteiro++;
    }
    
    public void dif() throws Runtime_Exception
    {
        if (!pilhaTipos[topo -1].equals(pilhaTipos[topo])
                && !(pilhaTipos[topo-1].equals("natural") || pilhaTipos[topo-1].equals("real"))
                && !(pilhaTipos[topo].equals("natural") || pilhaTipos[topo].equals("real")))
        {
            throw new Runtime_Exception("ERRO: TIPOS INVALIDOS PARA OPERACAO DIFERENTE");
        }
        switch (pilhaTipos[topo -1])
        {
            case "natural":
                pilhaDados[topo -1] = String.valueOf(Double.parseDouble(pilhaDados[topo - 1]) != Double.parseDouble(pilhaDados[topo]));
                break;
                
            case "real":
                pilhaDados[topo -1] = String.valueOf(Double.parseDouble(pilhaDados[topo - 1])!= Double.parseDouble(pilhaDados[topo]));
                break;
            
            case "boolean":
                pilhaDados[topo -1] = String.valueOf(Boolean.parseBoolean(pilhaDados[topo - 1]) != Boolean.parseBoolean(pilhaDados[topo]));
                break;
                
            case "char":
                pilhaDados[topo -1] = String.valueOf(!pilhaDados[topo - 1].equals(pilhaDados[topo]));
                break;
        }
        pilhaTipos[topo -1] = "boolean";
        topo--;
        ponteiro++;
    }
    
    public void eql() throws Runtime_Exception
    {
        if (!pilhaTipos[topo -1].equals(pilhaTipos[topo])
                && !(pilhaTipos[topo-1].equals("natural") || pilhaTipos[topo-1].equals("real"))
                && !(pilhaTipos[topo].equals("natural") || pilhaTipos[topo].equals("real")))
        {
            throw new Runtime_Exception("ERRO: TIPOS INVALIDOS PARA OPERACAO IGUAL");
        }
        switch (pilhaTipos[topo -1])
        {
            case "natural":
                pilhaDados[topo -1] = String.valueOf(Double.parseDouble(pilhaDados[topo - 1]) == Double.parseDouble(pilhaDados[topo]));
                break;
                
            case "real":
                pilhaDados[topo -1] = String.valueOf(Double.parseDouble(pilhaDados[topo - 1])== Double.parseDouble(pilhaDados[topo]));
                break;
            
            case "boolean":
                pilhaDados[topo -1] = String.valueOf(Boolean.parseBoolean(pilhaDados[topo - 1]) == Boolean.parseBoolean(pilhaDados[topo]));
                break;
                
            case "char":
                pilhaDados[topo -1] = String.valueOf(pilhaDados[topo - 1].equals(pilhaDados[topo]));
                break;
        }
        pilhaTipos[topo -1] = "boolean";
        topo--;
        ponteiro++;
    }
    
    public void sme() throws Runtime_Exception
    {
        if (pilhaTipos[topo -1].equals("char") || pilhaTipos[topo -1].equals("boolean") || pilhaTipos[topo].equals("char") || pilhaTipos[topo].equals("boolean"))
        {
            throw new Runtime_Exception("ERRO: TIPOS INVALIDOS PARA OPERACAO MENOR OU IGUAL");
        }
        pilhaDados[topo -1] = String.valueOf(Double.valueOf(pilhaDados[topo - 1]) <= Double.valueOf(pilhaDados[topo]));
        pilhaTipos[topo -1] = "boolean";
        topo--;
        ponteiro++;
    }
    
    public void smr() throws Runtime_Exception
    {
        if (pilhaTipos[topo -1].equals("char") || pilhaTipos[topo -1].equals("boolean") || pilhaTipos[topo].equals("char") || pilhaTipos[topo].equals("boolean"))
        {
            throw new Runtime_Exception("ERRO: TIPOS INVALIDOS PARA OPERACAO MENOR QUE");
        }
        pilhaDados[topo -1] = String.valueOf(Double.valueOf(pilhaDados[topo - 1]) < Double.valueOf(pilhaDados[topo]));
        pilhaTipos[topo -1] = "boolean";
        topo--;
        ponteiro++;
    }
    
    public void jmf() throws Runtime_Exception
    {
        if (!(pilhaTipos[topo].equals("boolean")))
        {
            throw new Runtime_Exception("TIPO INVALIDO PARA EXPRESSAO DE LOOP OU REPETICAO");
        }
        if ( Boolean.valueOf(pilhaDados[topo]) == false) {
            ponteiro = Integer.valueOf(area_instrucoes[ponteiro].parametro);
        }
        else
        {
            ponteiro++;
        }
        topo--;
    }
    
    public void jmp()
    {
        ponteiro = Integer.valueOf(area_instrucoes[ponteiro].parametro);
    }
    
    public void jmt() throws Runtime_Exception
    {
        if (!(pilhaTipos[topo].equals("boolean")))
        {
            throw new Runtime_Exception("TIPO INVALIDO PARA EXPRESSAO DE LOOP OU REPETICAO");
        }
        if ( Boolean.valueOf(pilhaDados[topo]) == true) {
            ponteiro = Integer.valueOf(area_instrucoes[ponteiro].parametro);
        }
        else
        {
            ponteiro++;
        }
        topo--;
    }
    
    public void stp()
    {
        
    }
    
    public void stc()
    {
        for (int i=topo-new Integer(area_instrucoes[ponteiro].parametro); topo <= topo-1; topo++)
        {
            pilhaDados[i] = pilhaDados[topo];
        }
        topo = topo - 1;
        ponteiro = ponteiro + 1;
    }
    
    public void rea() throws Runtime_Exception
    {
        topo = topo + 1;
        String valor = JOptionPane.showInputDialog("Insira o dado: ");
        pilhaDados[topo] = valor;
        pilhaTipos[topo] = identificaTipo(area_instrucoes[ponteiro].parametro, valor);
        ponteiro = ponteiro + 1;
    }
    
    public void wrt()
    {
        saida += pilhaDados[topo] + "\n";
        vmShell.setText(saida);
        topo = topo + 1;
        ponteiro = ponteiro + 1;
    }
    
    public String identificaTipo(String tipo, String valor) throws Runtime_Exception
    {
        switch (tipo)
        {
            case "1":
                try{
                    new Integer(valor);
                }
                catch(NumberFormatException er)
                {
                    throw new Runtime_Exception("RUNTIME ERROR: TIPO INVALIDO -> ESPERAVA-SE NATURAL");
                }
                break;
                
            case "2":
                try{
                    new Float(valor);
                }
                catch(NumberFormatException er)
                {
                    throw new Runtime_Exception("RUNTIME ERROR: TIPO INVALIDO -> ESPERAVA-SE REAL");
                }
                break;
                
            case "4":
                if (!(valor.toLowerCase().equals("false") | valor.toLowerCase().equals("true")))
                {
                    throw new Runtime_Exception("RUNTIME ERROR: TIPO INVALIDO -> ESPERAVA-SE BOOLEAN");
                }
                
        }
        
        switch (tipo)
        {
            case "1":
                return "natural";
                
            case "2":
                return "real";
                
            case "3":
                return "char";
                
            case "4":
                return "boolean";
        }
        throw new Runtime_Exception("RUNTIME ERROR: TIPO INVALIDO PARA LEITURA!");
    }
    
    public void call() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
        this.executeActions();

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                this.executeActions();
                this.setVisible(true); // To bugado
            }
        });*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        vmShell = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        vmShell.setEditable(false);
        vmShell.setBackground(new java.awt.Color(0, 0, 0));
        vmShell.setColumns(20);
        vmShell.setForeground(new java.awt.Color(255, 255, 255));
        vmShell.setRows(5);
        jScrollPane1.setViewportView(vmShell);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MaquinaVirtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MaquinaVirtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MaquinaVirtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MaquinaVirtual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MaquinaVirtual().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea vmShell;
    // End of variables declaration//GEN-END:variables
}
