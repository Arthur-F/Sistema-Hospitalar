/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalar;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class TelaAlterarSenha extends javax.swing.JFrame {
    
    private String usuario;
   
    public TelaAlterarSenha() {
        initComponents();
        PasswordField_atual.setDocument(new Tamanho(10));
        PasswordField_nv.setDocument(new Tamanho(10));
        PasswordField_con_nv.setDocument(new Tamanho(10));
    }
    
    public void setUsuario(TelaInicial tela, String user){
        this.usuario = user;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label_Alt_senha = new javax.swing.JLabel();
        Label_senha_atu = new javax.swing.JLabel();
        Label_nv = new javax.swing.JLabel();
        Label_con_nv = new javax.swing.JLabel();
        Button_salvar = new javax.swing.JButton();
        PasswordField_atual = new javax.swing.JPasswordField();
        PasswordField_nv = new javax.swing.JPasswordField();
        PasswordField_con_nv = new javax.swing.JPasswordField();
        Button_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Label_Alt_senha.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Label_Alt_senha.setText("Alterar Senha");

        Label_senha_atu.setLabelFor(PasswordField_atual);
        Label_senha_atu.setText("Senha atual");

        Label_nv.setLabelFor(PasswordField_nv);
        Label_nv.setText("Nova senha");

        Label_con_nv.setLabelFor(PasswordField_con_nv);
        Label_con_nv.setText("Confirmar nova senha");

        Button_salvar.setText("Salvar");
        Button_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_salvarActionPerformed(evt);
            }
        });

        Button_cancelar.setText("Cancelar");
        Button_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PasswordField_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordField_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(Label_Alt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(Button_salvar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Button_cancelar))
                                .addComponent(PasswordField_con_nv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(Label_senha_atu))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(Label_nv))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(Label_con_nv)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Label_Alt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(Label_senha_atu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordField_atual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label_nv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordField_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_con_nv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordField_con_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_salvar)
                    .addComponent(Button_cancelar))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_salvarActionPerformed
        Long user = Long.parseLong(usuario);
        List<Funcionario> list_func = new ArrayList<>();
        DBManager dbm = new DBManager();
        if(PasswordField_atual.getText().length() < 0 ||
           PasswordField_nv.getText().length() < 0 ||
           PasswordField_con_nv.getText().length() < 0){
            JOptionPane.showMessageDialog(null,"Alguns dos campos não está preenchido.");
        }else if(!PasswordField_nv.getText().toString().equals(PasswordField_con_nv.getText().toString())){
            JOptionPane.showMessageDialog(null,"Senhas diferentes.");
        }else if(PasswordField_nv.getText().toString().equals(PasswordField_atual.getText().toString())){
            JOptionPane.showMessageDialog(null,"Senha atual igual a nova.");
        }else{
        list_func = dbm.getFuncionarios(user);
            for (Funcionario funcionario : list_func) {
                if(funcionario.getSenha().equals(PasswordField_atual.getText().toString())){
                   funcionario.setSenha(PasswordField_nv.getText().toString());
                    dbm.alteraFuncionario(funcionario);
                    this.dispose();
                    JOptionPane.showMessageDialog(null,"Senha Alterada com sucesso."); 
                }else{
                    JOptionPane.showMessageDialog(null,"Senha atual está incorreta.");
                }                
            }
        }
    }//GEN-LAST:event_Button_salvarActionPerformed

    private void Button_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_Button_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAlterarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlterarSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_cancelar;
    private javax.swing.JButton Button_salvar;
    private javax.swing.JLabel Label_Alt_senha;
    private javax.swing.JLabel Label_con_nv;
    private javax.swing.JLabel Label_nv;
    private javax.swing.JLabel Label_senha_atu;
    private javax.swing.JPasswordField PasswordField_atual;
    private javax.swing.JPasswordField PasswordField_con_nv;
    private javax.swing.JPasswordField PasswordField_nv;
    // End of variables declaration//GEN-END:variables
}
