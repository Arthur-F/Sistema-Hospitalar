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
public final class CadastrarFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form CadastroSetor
     */
    public CadastrarFuncionario() {
        initComponents();
        iniciaTela();
    }

    public void iniciaTela(){
        ComboBox_crm.removeAllItems();
        List<Medico> list = new ArrayList<>();
        DBManager dbm = new DBManager();
        list = dbm.getMedico(null);
        ComboBox_crm.addItem("");
        for (Medico medico : list) {
            ComboBox_crm.addItem(medico.getCRM());
        }
        List<Equipe> list_eq = new ArrayList<>();
        list_eq = dbm.getEquipe(null);
        this.preencheTabela(list_eq);
    }
    
    public void preencheTabela(List<Equipe> list){
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setNumRows(0);
        for (Equipe equipe : list) {
            model.addRow(new String[]{equipe.getID().toString(),equipe.getNome(),equipe.getSupervisor_cpf()});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        Header_eq = new javax.swing.JLabel();
        Label_nome = new javax.swing.JLabel();
        TextField_nome = new javax.swing.JTextField();
        Label_CRM = new javax.swing.JLabel();
        ComboBox_crm = new javax.swing.JComboBox<>();
        Button_consultar = new javax.swing.JButton();
        Button_cadastrar = new javax.swing.JButton();
        Button_editar = new javax.swing.JButton();
        Button_apagar = new javax.swing.JButton();
        TextField_nome1 = new javax.swing.JTextField();
        Label_nome1 = new javax.swing.JLabel();
        Label_CRM1 = new javax.swing.JLabel();
        ComboBox_crm1 = new javax.swing.JComboBox<>();
        Label_CRM2 = new javax.swing.JLabel();
        ComboBox_crm2 = new javax.swing.JComboBox<>();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 300));
        setResizable(false);

        Header_eq.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Header_eq.setText("FUNCIONÁRIO");

        Label_nome.setText("Nome");

        Label_CRM.setLabelFor(ComboBox_crm);
        Label_CRM.setText("Setor");

        ComboBox_crm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBox_crm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_crmActionPerformed(evt);
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

        Label_nome1.setText("CPF");

        Label_CRM1.setLabelFor(ComboBox_crm);
        Label_CRM1.setText("Profissional");

        ComboBox_crm1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBox_crm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_crm1ActionPerformed(evt);
            }
        });

        Label_CRM2.setLabelFor(ComboBox_crm);
        Label_CRM2.setText("Subsetor");

        ComboBox_crm2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBox_crm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_crm2ActionPerformed(evt);
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
                                .addComponent(TextField_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ComboBox_crm, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextField_nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(Label_nome1))
                    .addComponent(ComboBox_crm1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Label_CRM1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(Label_CRM))
                    .addComponent(ComboBox_crm2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(Label_CRM2)))
                .addGap(44, 44, 44)
                .addComponent(Header_eq, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(654, 654, 654))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Button_consultar)
                .addGap(18, 18, 18)
                .addComponent(Button_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Button_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Button_apagar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(Label_nome))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(Header_eq, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(Label_nome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_nome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label_CRM1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBox_crm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label_CRM)
                .addGap(2, 2, 2)
                .addComponent(ComboBox_crm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_CRM2)
                .addGap(2, 2, 2)
                .addComponent(ComboBox_crm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_apagar)
                    .addComponent(Button_editar)
                    .addComponent(Button_cadastrar)
                    .addComponent(Button_consultar))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_consultarActionPerformed
        Equipe eq = new Equipe();
        String nome = null;
        String CRM = null;
        List<Equipe> list = new ArrayList<>();
        DBManager dbm = new DBManager();
        if(TextField_nome.getText().length() > 0){
            nome = TextField_nome.getText();
        }
        if(ComboBox_crm.getSelectedItem().toString() != ""){
            CRM = ComboBox_crm.getSelectedItem().toString();
        }
        if(nome != null || CRM != null){
            eq.setNome(nome);
            eq.setSupervisor_cpf(CRM);
            list = dbm.getEquipe(eq);
            this.preencheTabela(list);
        }
    }//GEN-LAST:event_Button_consultarActionPerformed

    private void Button_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_cadastrarActionPerformed
        String nome = null;
        String crm = null;
        DBManager dbm = new DBManager();
        if(TextField_nome.getText().length() > 0){
            nome = TextField_nome.getText();
        }
        if(ComboBox_crm.getSelectedItem().toString() != ""){
            crm = ComboBox_crm.getSelectedItem().toString();
        }
        if(nome != null && crm != null){
            List<Equipe> list = new ArrayList<>();
            Equipe eq = new Equipe();
            eq.setNome(nome);
            eq.setSupervisor_cpf(crm);
            list = dbm.cadastrarEquipe(eq);
            TextField_nome.setText(null);
            ComboBox_crm.setSelectedIndex(0);
            this.preencheTabela(list);
            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!!!");
        }else{
            JOptionPane.showMessageDialog(null,"Por favor informe todos os campos");
        }
    }//GEN-LAST:event_Button_cadastrarActionPerformed

    private void Button_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_editarActionPerformed
        String nome = null;
        String crm = null;
        DBManager dbm = new DBManager();
        List<Equipe> list = new ArrayList<>();
        if(TextField_nome.getText().length() > 0){
            nome = TextField_nome.getText();
        }
        if(ComboBox_crm.getSelectedItem().toString() != ""){
            crm = ComboBox_crm.getSelectedItem().toString();
        }
        int linha = Table.getSelectedRow();
        if(linha >= 0){
            if(nome != null && crm != null){
                JOptionPane.showMessageDialog(null,"Somente um dos campos pode ser alterado","ERRO",JOptionPane.ERROR_MESSAGE);
            }else if(nome != null){
                if(JOptionPane.showConfirmDialog(null,"Tem certeza ?","EDITAR",JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
                    Equipe eq = new Equipe();
                    eq.setID(Integer.parseInt(Table.getValueAt(linha,0).toString()));
                    eq.setSupervisor_cpf(Table.getValueAt(linha,2).toString());
                    eq.setNome(nome);
                    list = dbm.editarEquipe(eq);
                    TextField_nome.setText(null);
                    ComboBox_crm.setSelectedIndex(0);
                    this.preencheTabela(list);
                    JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso!!!");
                }
            }else if(crm != null){
                if(JOptionPane.showConfirmDialog(null,"Tem certeza ?","EDITAR",JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
                    Equipe eq = new Equipe();
                    eq.setID(Integer.parseInt(Table.getValueAt(linha,0).toString()));
                    eq.setSupervisor_cpf(crm);
                    eq.setNome(Table.getValueAt(linha,1).toString());
                    list = dbm.editarEquipe(eq);
                    TextField_nome.setText(null);
                    ComboBox_crm.setSelectedIndex(0);
                    this.preencheTabela(list);
                    JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso!!!");
                }
            }     
        }else{
            JOptionPane.showMessageDialog(null,"Necessário selecionar uma linha");
        }
    }//GEN-LAST:event_Button_editarActionPerformed

    private void Button_apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_apagarActionPerformed
        int linha = Table.getSelectedRow();
        if(linha >= 0){
            if(JOptionPane.showConfirmDialog(null,"Tem certeza ?","APAGAR",JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
                List<Equipe> list = new ArrayList<>();
                Equipe eq = new Equipe();
                DBManager dbm = new DBManager();
                eq.setID(Integer.parseInt(Table.getValueAt(linha,0).toString()));
                list = dbm.deletarEquipe(eq);
                this.preencheTabela(list);
                JOptionPane.showMessageDialog(null,"Deleção realizada com sucesso!!!");
            }                      
        }else{
            JOptionPane.showMessageDialog(null,"Necessário selecionar uma linha");
        }
    }//GEN-LAST:event_Button_apagarActionPerformed

    private void ComboBox_crmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_crmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_crmActionPerformed

    private void ComboBox_crm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_crm1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_crm1ActionPerformed

    private void ComboBox_crm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_crm2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_crm2ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CadastrarFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_apagar;
    private javax.swing.JButton Button_cadastrar;
    private javax.swing.JButton Button_consultar;
    private javax.swing.JButton Button_editar;
    private javax.swing.JComboBox<String> ComboBox_crm;
    private javax.swing.JComboBox<String> ComboBox_crm1;
    private javax.swing.JComboBox<String> ComboBox_crm2;
    private javax.swing.JLabel Header_eq;
    private javax.swing.JLabel Label_CRM;
    private javax.swing.JLabel Label_CRM1;
    private javax.swing.JLabel Label_CRM2;
    private javax.swing.JLabel Label_nome;
    private javax.swing.JLabel Label_nome1;
    private javax.swing.JTextField TextField_nome;
    private javax.swing.JTextField TextField_nome1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
