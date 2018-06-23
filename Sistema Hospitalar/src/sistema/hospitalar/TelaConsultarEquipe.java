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
public final class TelaConsultarEquipe extends javax.swing.JFrame {

    /**
     * Creates new form CadastroSetor
     */
    public TelaConsultarEquipe() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Button_menbros = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Header_eq.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Header_eq.setText("EQUIPE");

        Label_nome.setText("Nome");

        Label_CRM.setLabelFor(ComboBox_crm);
        Label_CRM.setText("Supervisor");

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

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Supervisor CRM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);

        Button_menbros.setText("Membros");
        Button_menbros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_menbrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(Header_eq, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(Label_nome))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ComboBox_crm, javax.swing.GroupLayout.Alignment.LEADING, 0, 125, Short.MAX_VALUE)
                                .addComponent(TextField_nome, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(Label_CRM))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Button_consultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Button_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Button_cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Button_apagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Button_menbros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header_eq, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextField_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Label_CRM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboBox_crm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Button_consultar)
                        .addGap(18, 18, 18)
                        .addComponent(Button_cadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(Button_editar)
                        .addGap(18, 18, 18)
                        .addComponent(Button_menbros)
                        .addGap(18, 18, 18)
                        .addComponent(Button_apagar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void Button_menbrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_menbrosActionPerformed
        int linha = Table.getSelectedRow();
        if( linha >= 0){
            TelaMembrosEquipe tela = new TelaMembrosEquipe();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
            tela.setResizable(false);
            //tela.setEquipe(this,Integer.parseInt(Table.getValueAt(linha,0).toString()))
        }else{
            JOptionPane.showMessageDialog(null,"Necessário selecionar uma linha");
        }
    }//GEN-LAST:event_Button_menbrosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaConsultarEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaConsultarEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaConsultarEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaConsultarEquipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new TelaConsultarEquipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_apagar;
    private javax.swing.JButton Button_cadastrar;
    private javax.swing.JButton Button_consultar;
    private javax.swing.JButton Button_editar;
    private javax.swing.JButton Button_menbros;
    private javax.swing.JComboBox<String> ComboBox_crm;
    private javax.swing.JLabel Header_eq;
    private javax.swing.JLabel Label_CRM;
    private javax.swing.JLabel Label_nome;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TextField_nome;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
