/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalar;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel
 */
public final class TelaConsultarFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form CadastroSetor
     */
    public TelaConsultarFuncionario() {
        initComponents();
        TextField_nome.setDocument(new SoLetras(20));
        TextField_cpf.setDocument(new SoNumeros(11));
        iniciaTela();
    }

    public void iniciaTela(){
        ComboBox_prof.addItem("");
        ComboBox_prof.addItem("Médico");
        ComboBox_prof.addItem("Enfermeiro");
        ComboBox_prof.addItem("Administrativo");
        ComboBox_setor.addItem("");
        ComboBox_subsetor.addItem("");
        List<Setor> list_setor = new ArrayList<>();
        List<Subsetor> list_subsetor = new ArrayList<>();
        DBManager dbm = new DBManager();
        list_setor = dbm.getSetor(null);
        list_subsetor = dbm.getSubSetor(null);
        for (Subsetor subsetor : list_subsetor) {
            ComboBox_subsetor.addItem(subsetor.getNome());            
        }
        for (Setor setor : list_setor) {
            ComboBox_setor.addItem(setor.getNome());
        }
    }
    
    public void preencheTabela(List<Funcionario> list){
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setNumRows(0);
        DBManager dbm = new DBManager();
        for (Funcionario funcionario : list) {
            String nome = "";
            String cpf  = "";
            String data = "";
            String salario = "";
            String setor = "";
            String subsetor = "";
            String prof = "";
            String crm = "";
            String area = "";
            String espec = "";
            String cargo = "";
            List<Medico> list_med = new ArrayList<>();
            Medico med = new Medico();
            med.setCPF(funcionario.getCPF());
            list_med = dbm.getMedico(med);
            for (Medico medico : list_med) {
                prof = "Médico";
                crm = medico.getCRM();
                area = medico.getAreaDeAtuacao();
            }
            List<Enfermeiro> list_enf = new ArrayList<>();
            Enfermeiro enf = new Enfermeiro();
            enf.setCPF(funcionario.getCPF());
            list_enf = dbm.getEnfermeiros(enf);
            for (Enfermeiro enfermeiro : list_enf) {
                prof = "Enfermeiro";
                espec = enfermeiro.getTipo();
            }
            List<FuncionarioAdministrativo> list_func = new ArrayList<>();
            FuncionarioAdministrativo func = new FuncionarioAdministrativo();
            func.setCPF(funcionario.getCPF());
            list_func = dbm.getFuncAdm(func);
            for (FuncionarioAdministrativo funcionarioAdministrativo : list_func) {
                prof = "Administrativo";
                cargo = funcionarioAdministrativo.getCargo();
            }
            List<Setor> list_setor = new ArrayList<>();
            Setor st = new Setor();
            st.setId(funcionario.getSetor_id());
            list_setor = dbm.getSetor(st);
            for (Setor setor1 : list_setor) {
                setor = setor1.getNome();
            }
            List<Subsetor> list_subsetor = new ArrayList<>();
            Subsetor subst = new Subsetor();
            subst.setId(funcionario.getPapel_id());
            list_subsetor = dbm.getSubSetor(subst);
            for (Subsetor subsetor1 : list_subsetor) {
                subsetor = subsetor1.getNome();
            }
            nome = funcionario.getNome();;
            cpf = funcionario.getCPF().toString();
            data = funcionario.getDataNascimento();
            salario = funcionario.getSalario().toString();
            model.addRow(new String[]{nome,cpf,data,salario,setor,subsetor,prof,crm,area,espec,cargo});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        Header_eq = new javax.swing.JLabel();
        Label_nome = new javax.swing.JLabel();
        TextField_nome = new javax.swing.JTextField();
        Label_setor = new javax.swing.JLabel();
        ComboBox_setor = new javax.swing.JComboBox<>();
        Button_consultar = new javax.swing.JButton();
        Button_cadastrar = new javax.swing.JButton();
        Button_editar = new javax.swing.JButton();
        Button_apagar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        TextField_cpf = new javax.swing.JTextField();
        Label_cpf = new javax.swing.JLabel();
        Label_prof = new javax.swing.JLabel();
        ComboBox_prof = new javax.swing.JComboBox<>();
        Label_subsetor = new javax.swing.JLabel();
        ComboBox_subsetor = new javax.swing.JComboBox<>();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Header_eq.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Header_eq.setText("FUNCIONÁRIO");

        Label_nome.setText("Nome");

        Label_setor.setLabelFor(ComboBox_setor);
        Label_setor.setText("Setor");

        ComboBox_setor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_setorActionPerformed(evt);
            }
        });

        Button_consultar.setText("Consultar");
        Button_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_consultarActionPerformed(evt);
            }
        });

        Button_cadastrar.setText("Cadastar");
        Button_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_cadastrarActionPerformed(evt);
            }
        });

        Button_editar.setText("Editar");
        Button_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_editarActionPerformed(evt);
            }
        });

        Button_apagar.setText("Excluir");
        Button_apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_apagarActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Nascimento", "Salário", "Setores", "Subsetores", "Profissional", "CRM", "Área atuação", "Especialidade", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);

        Label_cpf.setText("CPF");

        Label_prof.setLabelFor(ComboBox_setor);
        Label_prof.setText("Profissional");

        ComboBox_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_profActionPerformed(evt);
            }
        });

        Label_subsetor.setLabelFor(ComboBox_setor);
        Label_subsetor.setText("Subsetor");

        ComboBox_subsetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_subsetorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(Label_nome))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TextField_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ComboBox_setor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextField_nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(Label_cpf))
                    .addComponent(ComboBox_prof, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Label_prof))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(Label_setor))
                    .addComponent(ComboBox_subsetor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(Label_subsetor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 306, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Header_eq, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Button_consultar)
                        .addGap(18, 18, 18)
                        .addComponent(Button_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_apagar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(294, 294, 294))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header_eq, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextField_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(Label_cpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextField_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Label_prof)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBox_prof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Label_setor)
                        .addGap(2, 2, 2)
                        .addComponent(ComboBox_setor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Label_subsetor)
                        .addGap(2, 2, 2)
                        .addComponent(ComboBox_subsetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_apagar)
                    .addComponent(Button_editar)
                    .addComponent(Button_cadastrar)
                    .addComponent(Button_consultar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_consultarActionPerformed
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setNumRows(0);
        String lv_nome = null;
        Long lv_cpf = null;
        String lv_prof = null;
        Integer lv_setor = null;
        Integer lv_subsetor = null;
        DBManager dbm = new DBManager();
        List<Funcionario> list = new ArrayList<>();
        List<Funcionario> list_aux = new ArrayList<>();
        Funcionario func = new Funcionario() {};
        if(TextField_cpf.getText().length() > 0){
            lv_cpf = Long.parseLong(TextField_cpf.getText());
        }
        if(TextField_nome.getText().length() > 0){
            lv_nome = TextField_nome.getText();
        }
        if(!ComboBox_prof.getSelectedItem().toString().equals("")){
            lv_prof = ComboBox_prof.getSelectedItem().toString();
        }
        if(!ComboBox_setor.getSelectedItem().toString().equals("")){
            List<Setor> list_setor = new ArrayList<>();
            Setor setor = new Setor();
            setor.setNome(ComboBox_setor.getSelectedItem().toString());
            list_setor = dbm.getSetor(setor);
            for (Setor setor1 : list_setor) {
                lv_setor = setor1.getId();
            }
        }
        if(!ComboBox_subsetor.getSelectedItem().toString().equals("")){
            List<Subsetor> list_subsetor = new ArrayList<>();
            Subsetor subsetor = new Subsetor();
            subsetor.setNome(ComboBox_setor.getSelectedItem().toString());
            list_subsetor = dbm.getSubSetor(subsetor);
            for (Subsetor subsetor1 : list_subsetor) {
                lv_subsetor = subsetor1.getId();
            }
        }
        if(lv_cpf != null){
            func.setCPF(lv_cpf);
            list_aux = dbm.getFuncionarios(func);
        }else if(lv_nome != null){
            func.setNome(lv_nome);
            list_aux = dbm.getFuncionarios(func);
        }else if(lv_setor != null){
            func.setSetor_id(lv_setor);
            list_aux = dbm.getFuncionarios(func);
        }else if(lv_subsetor != null){
            func.setPapel_id(lv_subsetor);
            list_aux = dbm.getFuncionarios(func);
        }else if(lv_prof != null){
            if(lv_prof.equals("Médico")){
                List<Medico> list_med = new ArrayList<>();
                list_med = dbm.getMedico(null);
                for (Medico medico : list_med) {
                    func.setCPF(medico.getCPF());
                    List<Funcionario> list_teste = new ArrayList<>();
                    list_teste = dbm.getFuncionarios(func);
                    for (Funcionario funcionario : list_teste) {
                        list_aux.add(funcionario);
                    }
                }
            }else if(lv_prof.equals("Enfermeiro")){
                List<Enfermeiro> list_enf = new ArrayList<>();
                list_enf = dbm.getEnfermeiros(null);
                for (Enfermeiro enfermeiro : list_enf) {
                    func.setCPF(enfermeiro.getCPF());
                    List<Funcionario> list_teste = new ArrayList<>();
                    list_teste = dbm.getFuncionarios(func);
                    for (Funcionario funcionario : list_teste) {
                        list_aux.add(funcionario);
                    }
                }
            }else if(lv_prof.equals("Administrativo")){
                List<FuncionarioAdministrativo> list_funcAd = new ArrayList<>();
                list_funcAd = dbm.getFuncAdm(null);
                for (FuncionarioAdministrativo funcionarioAdministrativo : list_funcAd) {
                    func.setCPF(funcionarioAdministrativo.getCPF());
                    List<Funcionario> list_teste = new ArrayList<>();
                    list_teste = dbm.getFuncionarios(func);
                    for (Funcionario funcionario : list_teste) {
                        list_aux.add(funcionario);
                    }
                }
            }                      
        }else{
            JOptionPane.showMessageDialog(null,"Informar pelo meno um campo.","ERRO",JOptionPane.ERROR_MESSAGE);
        }
        for (Funcionario funcionario : list_aux) {
            if(lv_nome != null && !funcionario.getNome().contains(lv_nome)){
                continue;
            }
            if(lv_setor != null && funcionario.getSetor_id().intValue() != lv_setor.intValue()){
                continue;
            }
            if(lv_subsetor != null && funcionario.getPapel_id().intValue() != lv_subsetor.intValue()){
                continue;
            }
            if(lv_prof != null && lv_prof.equals("Médico")){
                List<Medico> list_prof = new ArrayList<>();
                Medico prof_med = new Medico();
                prof_med.setCPF(funcionario.getCPF());
                list_prof = dbm.getMedico(prof_med);
                if(list_prof.size() == 0){
                    continue;
                }
            }else if(lv_prof != null && lv_prof.equals("Enfermeiro")){
                List<Enfermeiro> list_prof = new ArrayList<>();
                Enfermeiro prof_enf = new Enfermeiro();
                prof_enf.setCPF(funcionario.getCPF());
                list_prof = dbm.getEnfermeiros(prof_enf);
                if(list_prof.size() == 0){
                    continue;
                }
            }else if(lv_prof != null && lv_prof.equals("Administrativo")){
                List<FuncionarioAdministrativo> list_prof = new ArrayList<>();
                FuncionarioAdministrativo prof_funcAdm = new FuncionarioAdministrativo();
                prof_funcAdm.setCPF(funcionario.getCPF());
                list_prof = dbm.getFuncAdm(prof_funcAdm);
                if(list_prof.size() == 0){
                    continue;
                }
            }
            list.add(funcionario);
        }
        if(list.size() > 0){
            this.preencheTabela(list);
        }else{
            JOptionPane.showMessageDialog(null,"Nenhum funcionario encontrado.","ERRO",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Button_consultarActionPerformed

    private void Button_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_cadastrarActionPerformed
        new TelaCadastrarFuncionários().setVisible(true);
    }//GEN-LAST:event_Button_cadastrarActionPerformed

    private void Button_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_editarActionPerformed
        
    }//GEN-LAST:event_Button_editarActionPerformed

    private void Button_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_apagarActionPerformed
        int linha = Table.getSelectedRow();
        if(linha >= 0){
            if(JOptionPane.showConfirmDialog(null,"Tem certeza ?","APAGAR",JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
                DBManager dbm = new DBManager();
                Long cpf = Long.parseLong(Table.getValueAt(linha,1).toString());
                List<MembrosEquipe> list_eq_func = new ArrayList<>();
                MembrosEquipe mem_eq = new MembrosEquipe();
                mem_eq.setFunc_cpf(cpf);
                list_eq_func = dbm.consultarMembrosEquipe(mem_eq);
                if(list_eq_func.size() <= 0){
                    Funcionario func = new Funcionario() {};
                    func.setCPF(cpf);
                    dbm.deletarFuncionario(func);
                    JOptionPane.showMessageDialog(null,"Excluido com sucesso!!!");
                }else{
                    JOptionPane.showMessageDialog(null,"Funcionario pertence ao alguma equipe.","ERRO",JOptionPane.ERROR_MESSAGE);
                }               
            }            
        }else{
            JOptionPane.showMessageDialog(null,"Necessário selecionar uma linha");
        }
    }//GEN-LAST:event_Button_apagarActionPerformed

    private void ComboBox_setorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_setorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_setorActionPerformed

    private void ComboBox_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_profActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_profActionPerformed

    private void ComboBox_subsetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_subsetorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_subsetorActionPerformed

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
            java.util.logging.Logger.getLogger(TelaConsultarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultarFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_apagar;
    private javax.swing.JButton Button_cadastrar;
    private javax.swing.JButton Button_consultar;
    private javax.swing.JButton Button_editar;
    private javax.swing.JComboBox<String> ComboBox_prof;
    private javax.swing.JComboBox<String> ComboBox_setor;
    private javax.swing.JComboBox<String> ComboBox_subsetor;
    private javax.swing.JLabel Header_eq;
    private javax.swing.JLabel Label_cpf;
    private javax.swing.JLabel Label_nome;
    private javax.swing.JLabel Label_prof;
    private javax.swing.JLabel Label_setor;
    private javax.swing.JLabel Label_subsetor;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TextField_cpf;
    private javax.swing.JTextField TextField_nome;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
