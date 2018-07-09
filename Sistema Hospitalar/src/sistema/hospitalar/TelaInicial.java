/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalar;

//import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import java.awt.event.ComponentListener;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel
 */
public final class TelaInicial extends javax.swing.JFrame {
    
    private String usuario;
    private int tipoUsuario;
    private String receitaAux; 
    private String laudoAux; 
    
    public TelaInicial() {
        initComponents();
        TextField_pac_ag.setDocument(new SoNumeros(11));
        TextField_med_ag.setDocument(new Tamanho(13));
        limpaTelas();
        iniTela();
		
    }
	public Paciente buscarPaciente(String cpf){
        
        DBManager dbm = new DBManager();
        Paciente pac = new Paciente();
        if(!cpf.isEmpty())
        { 
             Long cpfpac = Long.parseLong(cpf);
             pac.setCPF(cpfpac);       
        
           
            if (!dbm.getPaciente(pac).isEmpty())
            {
                 pac = dbm.getPaciente(pac).get(0);
                return pac;
            }
        }
        
        return null;
    }
	public void popularReceitas(Paciente pac)
    {
        DBManager dbm = new DBManager();
        pac = buscarPaciente(jTextPane2.getText());
        DefaultListModel<Receita> modelReceitas;
        modelReceitas = new DefaultListModel();
        List<Receita> listaReceitas;
        listaReceitas = new ArrayList();
        listaReceitas = dbm.getReceitasDoPaciente(pac.getCPF());
        for(Receita receita : listaReceitas)
        {
            modelReceitas.addElement(receita);  
        }
        
        jList1.setModel(modelReceitas);
        
    }
        public void popularLaudos(Paciente pac)
    {
        DBManager dbm = new DBManager();
        pac = buscarPaciente(jTextPane4.getText());
        DefaultListModel<Laudo> modelLaudos;
        modelLaudos = new DefaultListModel();
        List<Laudo> listaLaudos;
        listaLaudos = new ArrayList();
        listaLaudos = dbm.getLaudosDoPaciente(pac.getCPF());
        for(Laudo laudo : listaLaudos)
        {
            modelLaudos.addElement(laudo);  
        }
        
        jList2.setModel(modelLaudos);
        
    }
    public void setUsuario(TelaLogin tela1, String user){
        this.usuario = user;
        List<Funcionario> list_func = new ArrayList<>();
        DBManager dbm = new DBManager();
        Long cpf = Long.parseLong(user);
        Funcionario func = new Funcionario() {};
        func.setCPF(cpf);
        list_func = dbm.getFuncionarios(func);
        for (Funcionario funcionario : list_func) {
            String saudacao = "Olá, " + funcionario.getNome() + ".";
            Label_usuario.setText(saudacao);
            switch (funcionario.getPapel_id())
            {
                //Enfermeiro
                case 1:
                jTabbedPane1.remove(jPanel4);
                jTabbedPane1.remove(jPanel2);
                jButton4.setVisible(false);
                jButton5.setVisible(false);
                jButton7.setVisible(false);
                break;
                //Medico
                case 2:
                jTabbedPane1.remove(jPanel4);
                jTabbedPane1.remove(jPanel2);
                break;
                
                //FuncionarioAdmnistrativo
                case 3:
                jButton4.setVisible(false);
                jButton5.setVisible(false);
                jButton7.setVisible(false);
                break;
            }
                
        }        
    }
    
    public void iniTela(){
        DBManager dbm = new DBManager();
        List<Equipe> list_eq = new ArrayList<>();
        List<Sala> list_sl = new ArrayList<>();
        list_eq = dbm.getEquipe(null);
        list_sl = dbm.getSala(null);        
        ComboBox_eq_ag.addItem("");
        ComboBox_proc_ag.addItem("");
        ComboBox_sl_ag.addItem("");
        for (Sala sala : list_sl) {
            ComboBox_sl_ag.addItem(sala.getQuartos().toString());
        }
        for (Equipe equipe : list_eq) {
            ComboBox_eq_ag.addItem(equipe.getNome());
        }
        ComboBox_proc_ag.addItem("Internação");
        ComboBox_proc_ag.addItem("Consulta");
        ComboBox_proc_ag.addItem("Exame");
        ComboBox_proc_ag.addItem("Cirurgia");
    }
    
    public void limpaTelas(){
        ComboBox_eq_ag.removeAllItems();
        ComboBox_proc_ag.removeAllItems();
        ComboBox_sl_ag.removeAllItems();
        TextField_med_ag.setText(null);
        TextField_pac_ag.setText(null);
        DefaultTableModel tabela = (DefaultTableModel) Table_ag.getModel();
        tabela.setNumRows(0);
    }
    
    public void preencheTabelaAg(List<Agendamento> list){
        DefaultTableModel model = (DefaultTableModel) Table_ag.getModel();
        model.setNumRows(0);
        for (Agendamento agendamento : list) {
            model.addRow(new String[]{agendamento.getPac_nome(),agendamento.getPaciente_id().toString(),
            agendamento.getData(),agendamento.getHora(),agendamento.getSala_id().toString(),
            agendamento.getEq_nome()});
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        Label_usuario = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jButton9 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Header_cadastrar = new javax.swing.JLabel();
        Link_empresas = new javax.swing.JLabel();
        Link_equipe = new javax.swing.JLabel();
        Link_func = new javax.swing.JLabel();
        Link_pac = new javax.swing.JLabel();
        Link_sala = new javax.swing.JLabel();
        Link_setor = new javax.swing.JLabel();
        Link_subsetor = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Label_pac_ag = new javax.swing.JLabel();
        TextField_pac_ag = new javax.swing.JTextField();
        Label_med_ag = new javax.swing.JLabel();
        TextField_med_ag = new javax.swing.JTextField();
        Label_eq_ag = new javax.swing.JLabel();
        ComboBox_eq_ag = new javax.swing.JComboBox<>();
        Label_proc_ag = new javax.swing.JLabel();
        ComboBox_proc_ag = new javax.swing.JComboBox<>();
        Label_sl_ag = new javax.swing.JLabel();
        ComboBox_sl_ag = new javax.swing.JComboBox<>();
        Button_consultar = new javax.swing.JButton();
        Calendar_ag = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_ag = new javax.swing.JTable();
        Button_canc_ag = new javax.swing.JButton();
        Button_agendar = new javax.swing.JButton();
        Button_sair = new javax.swing.JButton();
        Button_alt_senha = new javax.swing.JButton();

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane7.setViewportView(jTextArea3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo2_1.png"))); // NOI18N

        Label_usuario.setText("Olá, ......................");

        jLabel1.setText("Bem vindo!");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Início", jPanel7);

        jPanel8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel8FocusGained(evt);
            }
        });

        jScrollPane9.setViewportView(jTextPane4);

        jLabel5.setText("CPF do Paciente:");

        jButton10.setText("Buscar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane10.setViewportView(jList2);

        jTextArea4.setEditable(false);
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane11.setViewportView(jTextArea4);

        jButton11.setText("Criar Novo Laudo");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton11MouseReleased(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Editar Laudo");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Cancelar");
        jButton13.setVisible(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setVisible(false);
        jButton14.setText("Salvar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Excluir Laudo");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton10))
                            .addComponent(jLabel5))
                        .addGap(431, 431, 431))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jButton11)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jButton12)
                                .addGap(18, 18, 18)
                                .addComponent(jButton14)
                                .addGap(18, 18, 18)
                                .addComponent(jButton13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton15))
                            .addComponent(jScrollPane11))
                        .addGap(62, 62, 62))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(jButton14)
                    .addComponent(jButton15))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Laudos Médicos", jPanel3);

        jLabel4.setText("CPF do Paciente:");

        jScrollPane8.setViewportView(jTextPane3);

        jButton9.setText("Efetuar Pagamentos");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9))
                    .addComponent(jLabel4))
                .addContainerGap(307, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(272, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pagamentos", jPanel4);

        jScrollPane2.setViewportView(jTextPane1);

        jLabel2.setText("CPF do Paciente:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jButton2.setText("Imprimir Prontuário");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Prontuários", jPanel5);

        jPanel6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel6FocusGained(evt);
            }
        });

        jScrollPane4.setViewportView(jTextPane2);

        jLabel3.setText("CPF do Paciente:");

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(jList1);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane6.setViewportView(jTextArea2);

        jButton4.setText("Criar Nova Receita");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Editar Receita");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Cancelar");
        jButton6.setVisible(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setVisible(false);
        jButton8.setText("Salvar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setText("Excluir Receita");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3))
                            .addComponent(jLabel3))
                        .addGap(431, 431, 431))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7))
                            .addComponent(jScrollPane6))
                        .addGap(62, 62, 62))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton8)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Receitas", jPanel6);

        Header_cadastrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Header_cadastrar.setText("Cadastros:");

        Link_empresas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Link_empresas.setText("Empresas Conveniadas");
        Link_empresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Link_empresasMouseClicked(evt);
            }
        });

        Link_equipe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Link_equipe.setText("Equipes");
        Link_equipe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Link_equipeMouseClicked(evt);
            }
        });

        Link_func.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Link_func.setText("Funcionários");
        Link_func.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Link_funcMouseClicked(evt);
            }
        });

        Link_pac.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Link_pac.setText("Pacientes");
        Link_pac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Link_pacMouseClicked(evt);
            }
        });

        Link_sala.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Link_sala.setText("Salas");
        Link_sala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Link_salaMouseClicked(evt);
            }
        });

        Link_setor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Link_setor.setText("Setores");
        Link_setor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Link_setorMouseClicked(evt);
            }
        });

        Link_subsetor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Link_subsetor.setText("Subsetores");
        Link_subsetor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Link_subsetorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(Header_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Link_equipe)
                            .addComponent(Link_empresas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Link_func, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Link_pac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Link_sala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Link_setor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Link_subsetor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Header_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Link_empresas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Link_equipe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Link_func)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Link_pac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Link_sala)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Link_setor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Link_subsetor)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastros", jPanel2);

        Label_pac_ag.setLabelFor(TextField_pac_ag);
        Label_pac_ag.setText("CPF - Paciente");

        Label_med_ag.setLabelFor(TextField_med_ag);
        Label_med_ag.setText("CRM - Médico");

        Label_eq_ag.setLabelFor(ComboBox_eq_ag);
        Label_eq_ag.setText("Equipe");

        ComboBox_eq_ag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Label_proc_ag.setLabelFor(ComboBox_proc_ag);
        Label_proc_ag.setText("Procedimento");

        ComboBox_proc_ag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Label_sl_ag.setLabelFor(ComboBox_sl_ag);
        Label_sl_ag.setText("Sala");

        ComboBox_sl_ag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Button_consultar.setText("Consultar");
        Button_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_consultarActionPerformed(evt);
            }
        });

        Table_ag.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "CPF", "Data", "Hora", "Sala", "Equipe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table_ag);

        Button_canc_ag.setText("Cancelar Agendamento");
        Button_canc_ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_canc_agActionPerformed(evt);
            }
        });

        Button_agendar.setText("Agendar");
        Button_agendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_agendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TextField_pac_ag, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextField_med_ag)
                            .addComponent(ComboBox_eq_ag, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBox_proc_ag, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBox_sl_ag, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Label_pac_ag)
                                            .addComponent(Label_med_ag)
                                            .addComponent(Label_eq_ag)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(Label_proc_ag))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(Label_sl_ag)))
                                .addGap(14, 14, 14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Calendar_ag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Button_consultar)
                        .addGap(18, 18, 18)
                        .addComponent(Button_canc_ag)
                        .addGap(18, 18, 18)
                        .addComponent(Button_agendar)
                        .addGap(0, 359, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Label_pac_ag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextField_pac_ag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_med_ag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextField_med_ag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_eq_ag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBox_eq_ag, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_proc_ag)
                        .addGap(7, 7, 7)
                        .addComponent(ComboBox_proc_ag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_sl_ag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBox_sl_ag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Calendar_ag, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_consultar)
                    .addComponent(Button_canc_ag)
                    .addComponent(Button_agendar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Agenda", jPanel1);

        Button_sair.setText("Sair");
        Button_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_sairActionPerformed(evt);
            }
        });

        Button_alt_senha.setText("Alterar Senha");
        Button_alt_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_alt_senhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Button_alt_senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Button_sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(452, 452, 452)
                        .addComponent(Label_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_alt_senha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_sair)))
                .addGap(7, 7, 7)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Início");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_consultarActionPerformed
        String med = null;
        String proc_id = null;
        Integer equipe_id = null;
        DBManager dbm = new DBManager();
        if(TextField_med_ag.getText().length() > 0){
            med = TextField_med_ag.getText();
        }
        Long pac = null;
        if(TextField_pac_ag.getText().length() > 0){
            pac = Long.parseLong(TextField_pac_ag.getText());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String data = sdf.format(Calendar_ag.getDate());
        if(ComboBox_proc_ag.getSelectedItem().toString() != ""){
            proc_id = ComboBox_proc_ag.getSelectedItem().toString();
        }        
        Integer sala = null;
        if(ComboBox_sl_ag.getSelectedItem().toString() != ""){
            sala = Integer.parseInt(ComboBox_sl_ag.getSelectedItem().toString());
        }
        if(ComboBox_eq_ag.getSelectedItem().toString() != ""){            
            List<Equipe> list_eq = new ArrayList<>();
            Equipe eq = new Equipe();
            eq.setNome(ComboBox_eq_ag.getSelectedItem().toString());
            list_eq = dbm.getEquipe(eq);
            for (Equipe equipe : list_eq) {
                equipe_id = equipe.getID();
            }
        }        
        List<Agendamento> list_ag = new ArrayList<>();
        list_ag = dbm.consultarAgendamento(data);
        List<Agendamento> list_ag1 = new ArrayList<>();
        for (Agendamento agendamento : list_ag) {
            if(pac != null){
                if(agendamento.getPaciente_id().longValue() != pac.longValue()){
                    continue;
                }
            }
            if(proc_id != null){
                if(!agendamento.getProc_nome().equalsIgnoreCase(proc_id)){
                    continue;
                }
            }
            if(sala != null){
                if(agendamento.getSala_id() != sala){
                    continue;
                }
            }
            if(equipe_id != null){
                if(agendamento.getEquipe_id() != equipe_id){
                    continue;
                }
            }
            if(med != null){
                if(!agendamento.getSupervisor_crm().intern().equalsIgnoreCase(med.intern())){
                    continue;
                }
            }
            list_ag1.add(agendamento);
            this.preencheTabelaAg(list_ag1);
        }
        if(list_ag1.size() == 0){
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhuma agendamento");
            DefaultTableModel model = (DefaultTableModel) Table_ag.getModel();
            model.setNumRows(0);
        }
    }//GEN-LAST:event_Button_consultarActionPerformed

    private void Button_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_sairActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Desejar Sair?", "SAIR", JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_Button_sairActionPerformed

    private void Button_alt_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_alt_senhaActionPerformed
        TelaAlterarSenha tela = new TelaAlterarSenha();
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        tela.setResizable(false);
        tela.setUsuario(this, usuario);
    }//GEN-LAST:event_Button_alt_senhaActionPerformed

    private void Link_empresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Link_empresasMouseClicked
        new TelaCadastrarEmpresas().setVisible(true);
    }//GEN-LAST:event_Link_empresasMouseClicked

    private void Button_canc_agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_canc_agActionPerformed
        int linha = Table_ag.getSelectedRow();
        if(linha >= 0){
            if(JOptionPane.showConfirmDialog(null,"Tem certeza ?","APAGAR",JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
                DBManager dbm = new DBManager();
                List<Agendamento> list = new ArrayList<>();
                Agendamento ag = new Agendamento();
                ag.setData(Table_ag.getValueAt(linha,2).toString());
                ag.setHora(Table_ag.getValueAt(linha,3).toString());
                ag.setPaciente_id(Long.parseLong(Table_ag.getValueAt(linha,1).toString()));
                list = dbm.cancelarAgendamento(ag);
                this.preencheTabelaAg(list);
                JOptionPane.showMessageDialog(null,"Cancelamento executado com sucesso!!!");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Necessário selecionar uma linha");
        }
    }//GEN-LAST:event_Button_canc_agActionPerformed

    private void Button_agendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_agendarActionPerformed
        new Agendar().setVisible(true);
    }//GEN-LAST:event_Button_agendarActionPerformed

    private void Link_equipeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Link_equipeMouseClicked
        new TelaConsultarEquipe().setVisible(true);
    }//GEN-LAST:event_Link_equipeMouseClicked

    private void Link_funcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Link_funcMouseClicked
        new TelaConsultarFuncionario().setVisible(true);
    }//GEN-LAST:event_Link_funcMouseClicked

      private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextArea1.setText("");
        Paciente pac = new Paciente();
        DBManager dbm = new DBManager();
        if(!jTextPane1.getText().isEmpty())
        { 
             pac = buscarPaciente(jTextPane1.getText());
        
           
        
             
             jTextArea1.append(pac.getNome() + "\nCPF:" + pac.getCPF() + "\n\n");
            for(Laudo laudo : dbm.getLaudosDoPaciente(pac.getCPF()))
            {
                jTextArea1.append("Laudo Médico: " + laudo.getLaudo() + "\n");
            }
            for(Receita receita : dbm.getReceitasDoPaciente(pac.getCPF()))
            {
            jTextArea1.append("Tipo de receita: " + receita.getTipo() + "\n");
            jTextArea1.append("Prescrição:\n\n " + receita.getReceita()+ "\n\n");
            }
           
           
        
        
        
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

          private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            jTextArea1.print();
        }catch (PrinterException p){
            System.out.println(p.getMessage());
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        Paciente pac = new Paciente();
        pac.setCPF(Long.parseLong(jTextPane2.getText()));
        popularReceitas(pac);
       
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        jTextArea2.setText("");
        jTextArea2.append(jList1.getSelectedValue().getReceita()+ "\n\n");
        
    }//GEN-LAST:event_jList1ValueChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      
        jTextArea2.setEditable(true);
        jButton8.setVisible(true);
        jButton6.setVisible(true);
        receitaAux = jTextArea2.getText();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTextArea2.setEditable(false);
        jButton8.setVisible(false);
        jButton6.setVisible(false);
        jTextArea2.setText(receitaAux);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
         DBManager dbm;
        dbm = new DBManager();
        jList1.getSelectedValue().setReceita(jTextArea2.getText());
        dbm.alterarReceita(jList1.getSelectedValue());
        jButton8.setVisible(false);
        jButton6.setVisible(false);
        jTextArea2.setEditable(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
        TelaCriarReceita telacriarreceita = new TelaCriarReceita(jTextPane2.getText());
        
        telacriarreceita.setVisible(true);
        jList1.clearSelection();
        DefaultListModel listmodel = (DefaultListModel) jList1.getModel();
        listmodel.removeAllElements();
        jTextArea2.setText("");
       // telacriarreceita.
        
        
        
    }//GEN-LAST:event_jButton4MouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPanel6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel6FocusGained
        
    }//GEN-LAST:event_jPanel6FocusGained

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        DBManager dbm = new DBManager();
        dbm.removerReceita(jList1.getSelectedValue());
        Paciente pac = new Paciente();
        pac.setCPF(Long.parseLong(jTextPane2.getText()));
        popularReceitas(pac);
        jList1.clearSelection();
        jList1.updateUI();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       
       TelaPagamento telaPagto = new TelaPagamento(jTextPane3.getText());
       telaPagto.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
                
        Paciente pac = new Paciente();
        pac.setCPF(Long.parseLong(jTextPane4.getText()));
        popularLaudos(pac);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
               jTextArea4.setText("");
        jTextArea4.append(jList2.getSelectedValue().getLaudo()+ "\n\n");
    }//GEN-LAST:event_jList2ValueChanged

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseReleased
        TelaCriarLaudo telaCriarLaudo = new TelaCriarLaudo(jTextPane4.getText());
        
        telaCriarLaudo.setVisible(true);
        jList2.clearSelection();
        DefaultListModel listmodel = (DefaultListModel) jList2.getModel();
        listmodel.removeAllElements();
        jTextArea4.setText("");
        
    }//GEN-LAST:event_jButton11MouseReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
              
        jTextArea4.setEditable(true);
        jButton13.setVisible(true);
        jButton14.setVisible(true);
        laudoAux = jTextArea4.getText();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
                jTextArea4.setEditable(false);
        jButton13.setVisible(false);
        jButton14.setVisible(false);
        jTextArea4.setText(laudoAux);
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
          
        DBManager dbm;
        dbm = new DBManager();
        jList2.getSelectedValue().setLaudo(jTextArea4.getText());
        dbm.alterarLaudo(jList2.getSelectedValue());
        jButton13.setVisible(false);
        jButton14.setVisible(false);
        jTextArea4.setEditable(false);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
      
        DBManager dbm = new DBManager();
        dbm.removerLaudo(jList2.getSelectedValue());
        Paciente pac = new Paciente();
        pac.setCPF(Long.parseLong(jTextPane4.getText()));
        popularLaudos(pac);
        jList2.clearSelection();
        jList2.updateUI();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jPanel8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel8FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel8FocusGained

    private void Link_salaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Link_salaMouseClicked
        new TelaConsultarSalas().setVisible(true);
    }//GEN-LAST:event_Link_salaMouseClicked

    private void Link_pacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Link_pacMouseClicked
        new TelaConsultaPaciente().setVisible(true);
    }//GEN-LAST:event_Link_pacMouseClicked

    private void Link_setorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Link_setorMouseClicked
                new TelaCadastrarSetor().setVisible(true);
    }//GEN-LAST:event_Link_setorMouseClicked

    private void Link_subsetorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Link_subsetorMouseClicked
                new TelaSubsetores().setVisible(true);
    }//GEN-LAST:event_Link_subsetorMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_agendar;
    private javax.swing.JButton Button_alt_senha;
    private javax.swing.JButton Button_canc_ag;
    private javax.swing.JButton Button_consultar;
    private javax.swing.JButton Button_sair;
    private com.toedter.calendar.JCalendar Calendar_ag;
    private javax.swing.JComboBox<String> ComboBox_eq_ag;
    private javax.swing.JComboBox<String> ComboBox_proc_ag;
    private javax.swing.JComboBox<String> ComboBox_sl_ag;
    private javax.swing.JLabel Header_cadastrar;
    private javax.swing.JLabel Label_eq_ag;
    private javax.swing.JLabel Label_med_ag;
    private javax.swing.JLabel Label_pac_ag;
    private javax.swing.JLabel Label_proc_ag;
    private javax.swing.JLabel Label_sl_ag;
    private javax.swing.JLabel Label_usuario;
    private javax.swing.JLabel Link_empresas;
    private javax.swing.JLabel Link_equipe;
    private javax.swing.JLabel Link_func;
    private javax.swing.JLabel Link_pac;
    private javax.swing.JLabel Link_sala;
    private javax.swing.JLabel Link_setor;
    private javax.swing.JLabel Link_subsetor;
    private javax.swing.JTable Table_ag;
    private javax.swing.JTextField TextField_med_ag;
    private javax.swing.JTextField TextField_pac_ag;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<Receita> jList1;
    private javax.swing.JList<Laudo> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    // End of variables declaration//GEN-END:variables
}
