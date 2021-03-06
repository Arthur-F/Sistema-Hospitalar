/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class TelaCadastrarFuncionários extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastrarFuncionários
     */
    public TelaCadastrarFuncionários() {
        initComponents();
        TextField_nome.setDocument(new SoLetras(30));
        TextField_cpf.setDocument(new SoNumeros(11));
        TextField_salario.setDocument(new SoNumeros(10));
        InicioTela();
    }
    
    private Long gv_cpf = null;
    
    public void EditarFunc(TelaConsultarFuncionario tela, Long cpf, String prof) throws ParseException{
        this.gv_cpf = cpf;
        List<Funcionario> list_func = new ArrayList<>();
        DBManager dbm = new DBManager();
        Funcionario func = new Funcionario() {};
        func.setCPF(cpf);
        list_func = dbm.getFuncionarios(func);
        List<Setor> list_setor = new ArrayList<>();
        List<Subsetor> list_subsetor = new ArrayList<>();
        list_setor = dbm.getSetor(null);
        list_subsetor = dbm.getSubSetor(null);
        for (Funcionario funcionario : list_func) {
            TextField_cpf.setText(cpf.toString());
            TextField_cpf.setEnabled(false);
            TextField_nome.setText(funcionario.getNome());
            if(funcionario.getDataNascimento() != null){
                Date data = new SimpleDateFormat("yyyyMMdd").parse(funcionario.getDataNascimento());
                DateChooser.setDate(data);
                DateChooser.setEnabled(false);
            }            
            TextField_salario.setText(funcionario.getSalario().toString());
            int lv_count = 1;
            int lv_aux = 0;
            for (Setor setor : list_setor) {
                if(setor.getId().intValue() == funcionario.getSetor_id().intValue()){
                    lv_aux = lv_count;
                }else{
                    lv_count = lv_count + 1;
                }
            }
            ComboBox_setor.setSelectedIndex(lv_aux);
            lv_aux = 0;
            lv_count = 1;
            for (Subsetor subsetor : list_subsetor) {
                if(subsetor.getId().intValue() == funcionario.getPapel_id().intValue()){
                    lv_aux = lv_count;
                }else{
                    lv_count = lv_count + 1;
                }
            }
            ComboBox_subsetor.setSelectedIndex(lv_aux);
            if(prof == "Médico"){
                ComboBox_prof.setSelectedIndex(1);
                Label_1.setText("CRM");
                Label_1.setVisible(true);
                TextField_1.setVisible(true);
                Label_area.setVisible(true);
                TextField_area.setVisible(true);
                List<Medico> list_med = new ArrayList<>();
                Medico med = new Medico();
                med.setCPF(cpf);
                list_med = dbm.getMedico(med);
                for (Medico medico : list_med) {
                    TextField_1.setText(medico.getCRM());
                    TextField_1.setEditable(false);
                    TextField_area.setText(medico.getAreaDeAtuacao());
                }
            }else if(prof == "Enfermeiro"){
                ComboBox_prof.setSelectedIndex(2);
                Label_1.setText("Especialidade");
                Label_1.setVisible(true);
                TextField_1.setVisible(true);
                Label_area.setVisible(false);
                TextField_area.setVisible(false);
                List<Enfermeiro> list_enf = new ArrayList<>();
                Enfermeiro enfe = new Enfermeiro();
                enfe.setCPF(cpf);
                list_enf = dbm.getEnfermeiros(enfe);
                for (Enfermeiro enfermeiro : list_enf) {
                    TextField_1.setText(enfermeiro.getTipo());                    
                }
            }else if(prof == "Administrativo"){
                ComboBox_prof.setSelectedIndex(3);
                Label_1.setText("Cargo");
                Label_1.setVisible(true);
                TextField_1.setVisible(true);                
                Label_area.setVisible(false);
                TextField_area.setVisible(false);
                List<FuncionarioAdministrativo> list_funcad = new ArrayList<>();
                FuncionarioAdministrativo funcad = new FuncionarioAdministrativo();
                funcad.setCPF(cpf);
                list_funcad = dbm.getFuncAdm(funcad);
                for (FuncionarioAdministrativo funcionarioAdministrativo : list_funcad) {
                    TextField_1.setText(funcionarioAdministrativo.getCargo());
                }
            }
        }
    }
    
    public void InicioTela(){
        ComboBox_prof.addItem("");
        ComboBox_prof.addItem("Médico");
        ComboBox_prof.addItem("Enfermeiro");
        ComboBox_prof.addItem("Administrativo");
        List<Setor> list_setor = new ArrayList<>();
        List<Subsetor> list_subsetor = new ArrayList<>();
        DBManager dbm = new DBManager();
        list_setor = dbm.getSetor(null);
        list_subsetor = dbm.getSubSetor(null);
        ComboBox_setor.addItem("");
        ComboBox_subsetor.addItem("");
        for (Subsetor subsetor : list_subsetor) {
            ComboBox_subsetor.addItem(subsetor.getNome());
        }
        for (Setor setor : list_setor) {
            ComboBox_setor.addItem(setor.getNome());
        }
        Label_1.setVisible(false);
        Label_area.setVisible(false);
        TextField_1.setVisible(false);
        TextField_area.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField6 = new javax.swing.JTextField();
        Header = new javax.swing.JLabel();
        Label_nome = new javax.swing.JLabel();
        TextField_nome = new javax.swing.JTextField();
        Label_cpf = new javax.swing.JLabel();
        TextField_cpf = new javax.swing.JTextField();
        Label_setor = new javax.swing.JLabel();
        ComboBox_setor = new javax.swing.JComboBox<>();
        Label_subsetor = new javax.swing.JLabel();
        Label_dt = new javax.swing.JLabel();
        DateChooser = new com.toedter.calendar.JDateChooser();
        ComboBox_subsetor = new javax.swing.JComboBox<>();
        Label_prof = new javax.swing.JLabel();
        ComboBox_prof = new javax.swing.JComboBox<>();
        Label_salario = new javax.swing.JLabel();
        TextField_salario = new javax.swing.JTextField();
        Label_1 = new javax.swing.JLabel();
        TextField_1 = new javax.swing.JTextField();
        Label_area = new javax.swing.JLabel();
        TextField_area = new javax.swing.JTextField();
        Button_gravar = new javax.swing.JButton();
        Button_canc = new javax.swing.JButton();

        jTextField6.setToolTipText("Nome");
        jTextField6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Header.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Header.setText("Cadastrar Funcionarios");

        Label_nome.setText("Nome");

        Label_cpf.setText("CPF");

        TextField_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_cpfActionPerformed(evt);
            }
        });

        Label_setor.setText("Setor");

        Label_subsetor.setText("SubSetor");

        Label_dt.setText("Data de Nascimento");

        Label_prof.setText("Profissional");

        ComboBox_prof.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBox_profItemStateChanged(evt);
            }
        });

        Label_salario.setText("Salário");

        Label_1.setText("label");

        Label_area.setText("Área de atuação");

        Button_gravar.setText("Gravar");
        Button_gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_gravarActionPerformed(evt);
            }
        });

        Button_canc.setText("Cancelar");
        Button_canc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_cancActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_area)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextField_area))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_salario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextField_salario, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_subsetor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBox_subsetor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextField_nome))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_setor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBox_setor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Header))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_dt)
                            .addComponent(Label_cpf)
                            .addComponent(Label_prof)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Button_gravar)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Label_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Button_canc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextField_cpf)
                            .addComponent(DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(ComboBox_prof, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TextField_1))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_nome)
                    .addComponent(TextField_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_cpf)
                    .addComponent(TextField_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Label_setor)
                            .addComponent(ComboBox_setor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Label_dt))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Label_subsetor, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboBox_subsetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Label_prof)
                                    .addComponent(ComboBox_prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_salario)
                    .addComponent(TextField_salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_1)
                    .addComponent(TextField_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_area)
                    .addComponent(TextField_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_gravar)
                    .addComponent(Button_canc))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void TextField_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_cpfActionPerformed

    private void ComboBox_profItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBox_profItemStateChanged
        if(ComboBox_prof.getSelectedItem().toString().equals("Médico")){
            Label_1.setText("CRM");
            Label_1.setVisible(true);
            TextField_1.setVisible(true);
            TextField_1.setText("");
            Label_area.setVisible(true);
            TextField_area.setVisible(true);
        }else if(ComboBox_prof.getSelectedItem().toString().equals("Enfermeiro")){
            Label_1.setText("Especialidade");
            Label_1.setVisible(true);
            TextField_1.setVisible(true);
            TextField_1.setText("");
            Label_area.setVisible(false);
            TextField_area.setVisible(false);
        }else if(ComboBox_prof.getSelectedItem().toString().equals("Administrativo")){
            Label_1.setText("Cargo");
            Label_1.setVisible(true);
            TextField_1.setVisible(true);
            TextField_1.setText("");
            Label_area.setVisible(false);
            TextField_area.setVisible(false);
        }else{
            Label_1.setVisible(false);
            Label_area.setVisible(false);
            TextField_1.setVisible(false);
            TextField_1.setText("");
            TextField_area.setVisible(false);
        }
    }//GEN-LAST:event_ComboBox_profItemStateChanged

    private void Button_gravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_gravarActionPerformed
        String nome = null;
        Long cpf = null;        
        Integer setor_id = null;
        Integer subsetor = null;
        String prof = null;
        Double salario = null;
        String str = null;
        String area = null;
        String data = null;
        String mensagem = null;
        DBManager dbm = new DBManager();
        if(TextField_nome.getText().length() > 0){
            nome = TextField_nome.getText();           
        }
        if(TextField_cpf.getText().length() > 0){
            cpf  = Long.parseLong(TextField_cpf.getText());
        }
        if(ComboBox_setor.getSelectedItem().toString() != ""){
            List<Setor> list_setor = new ArrayList<>();
            Setor st = new Setor();
            st.setNome(ComboBox_setor.getSelectedItem().toString());
            list_setor = dbm.getSetor(st);
            for (Setor setor1 : list_setor) {
                setor_id = setor1.getId();
            }
        }
        if(DateChooser.getDate() != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            data = sdf.format(DateChooser.getDate());
        }
        if(ComboBox_subsetor.getSelectedItem().toString() != ""){
            List<Subsetor> list_sub = new ArrayList<>();
            Subsetor sub = new Subsetor();
            sub.setNome(ComboBox_subsetor.getSelectedItem().toString());
            list_sub = dbm.getSubSetor(sub);
            for (Subsetor subsetor1 : list_sub) {
                subsetor = subsetor1.getId();
            }
        }
        if(TextField_salario.getText().length() > 0){
            salario = Double.parseDouble(TextField_salario.getText());
        }
        if(TextField_1.getText().length() > 0){
            str = TextField_1.getText();
        }
        if(ComboBox_prof.getSelectedItem().toString() != ""){
            prof = ComboBox_prof.getSelectedItem().toString();
            if(prof.equals("Médico")){
                if(TextField_area.getText().length() > 0){
                    area = TextField_area.getText();
                }
            }                
        }
        if(nome != null && cpf != null){
            Funcionario func = new Funcionario() {};
            func.setCPF(cpf);
            func.setDataNascimento(data);
            func.setNome(nome);
            func.setSalario(salario);
            func.setSetor_id(setor_id);
            func.setPapel_id(subsetor);
            if(prof.equals("Médico")){
                if(str != null){
                    if(gv_cpf != null){
                        dbm.deletarFuncionario(func);
                        mensagem = "Alteração realizada com sucesso!";
                    }else{
                        mensagem = "Cadastro realizado com sucesso!";
                    }
                   dbm.cadastrarFuncionario(func);
                   Medico med = new Medico();
                   med.setCRM(str);
                   med.setCPF(cpf);
                   med.setAreaDeAtuacao(area);
                   dbm.cadastrarMedico1(med);
                   JOptionPane.showMessageDialog(null,mensagem);
                }else{
                    JOptionPane.showMessageDialog(null,"O CRM deve está preenchido!","ERRO",JOptionPane.ERROR_MESSAGE);
                }
            }else if(prof.equals("Enfermeiro")){
                if(str != null){
                    if(gv_cpf != null){
                        dbm.deletarFuncionario(func);
                        mensagem = "Alteração realizada com sucesso!";
                    }else{
                        mensagem = "Cadastro realizado com sucesso!";
                    }
                    dbm.cadastrarFuncionario(func);
                    Enfermeiro enf = new Enfermeiro();
                    enf.setTipo(str);
                    enf.setCPF(cpf);
                    dbm.cadastrarEnfermeiro1(enf);
                    JOptionPane.showMessageDialog(null,mensagem);
                }else{
                    JOptionPane.showMessageDialog(null,"O Tipo deve está preenchido!","ERRO",JOptionPane.ERROR_MESSAGE);
                }
            }else if(prof.equals("Administrativo")){
                if(str != null){
                    if(gv_cpf != null){
                        dbm.deletarFuncionario(func);
                        mensagem = "Alteração realizada com sucesso!";
                    }else{
                        mensagem = "Cadastro realizado com sucesso!";
                    }
                    dbm.cadastrarFuncionario(func);
                    FuncionarioAdministrativo funcAd = new FuncionarioAdministrativo();
                    funcAd.setCargo(str);
                    funcAd.setCPF(cpf);
                    dbm.cadastrarFuncAdm(funcAd);
                    JOptionPane.showMessageDialog(null,mensagem);
                }else{
                    JOptionPane.showMessageDialog(null,"O Cargo deve está preenchido!","ERRO",JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"O Nome e CPF devem está preenchidos!","ERRO",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Button_gravarActionPerformed

    private void Button_cancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_cancActionPerformed
        this.dispose();
    }//GEN-LAST:event_Button_cancActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastrarFuncionários.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarFuncionários.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarFuncionários.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarFuncionários.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastrarFuncionários().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_canc;
    private javax.swing.JButton Button_gravar;
    private javax.swing.JComboBox<String> ComboBox_prof;
    private javax.swing.JComboBox<String> ComboBox_setor;
    private javax.swing.JComboBox<String> ComboBox_subsetor;
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JLabel Header;
    private javax.swing.JLabel Label_1;
    private javax.swing.JLabel Label_area;
    private javax.swing.JLabel Label_cpf;
    private javax.swing.JLabel Label_dt;
    private javax.swing.JLabel Label_nome;
    private javax.swing.JLabel Label_prof;
    private javax.swing.JLabel Label_salario;
    private javax.swing.JLabel Label_setor;
    private javax.swing.JLabel Label_subsetor;
    private javax.swing.JTextField TextField_1;
    private javax.swing.JTextField TextField_area;
    private javax.swing.JTextField TextField_cpf;
    private javax.swing.JTextField TextField_nome;
    private javax.swing.JTextField TextField_salario;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
