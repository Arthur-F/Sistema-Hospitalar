/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalar;

import cieloecommerce.sdk.ecommerce.SaleResponse;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author ArthurFerreiraPinto
 */

public class TelaPagamentos extends javax.swing.JPanel {

    /**
     * Creates new form TelaPagamento
     */
    DBManager dbm = new DBManager();
    public final void popularEmpresas()
    {
        for (Empresa empr : dbm.getEmpresa(null))
        {
            jComboBox2.addItem(empr);
        }
    }
    public TelaPagamentos() {
        initComponents();
        popularEmpresas();
        jLabel5.setVisible(false);
        jComboBox3.setVisible(false);
    }

public void popularPagamentos(Long cpf)
{
    DefaultListModel<Pagamento> modelpagamentos = new DefaultListModel<>();
    ArrayList<Pagamento> listapagto = dbm.buscarPagamentos(cpf);
    for(Pagamento pgto : listapagto)
    {
        if (!pgto.isPago())
        modelpagamentos.addElement(pgto);
    }
    jList1.setModel(modelpagamentos);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        jButton2.setText("Realizar Pagamento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Opções de pagamento:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Convênio", "Particular" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Empresa conveniada:");

        jLabel1.setText("Registro de Pagamentos");

        jLabel5.setText("Forma de Pagamento:");

        jLabel2.setText("CPF do Paciente:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crédito", "Débito", "Dinheiro" }));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jLabel3))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, 147, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //       new PagamentoCielo().setVisible(true);
        PayManager pm = new PayManager();
        int resposta;
        if(!jList1.isSelectionEmpty()){
            Pagamento pagtoselecionado = jList1.getSelectedValue();
            if (((String)jComboBox1.getSelectedItem()).equals("Particular"))
            {
                switch (jComboBox3.getSelectedIndex())
                {
                    case 0:
                    resposta = pm.criarVenda(pagtoselecionado.getPaciente().getNome() + ": " + pagtoselecionado.getId(),pagtoselecionado.getValor().intValue(),0);
                    if (resposta == 1 || resposta == 2){
                        dbm.realizarPagamento(pagtoselecionado.getId(), "Crédito");

                    }
                    break;
                    case 1:

                    resposta = pm.criarVenda(pagtoselecionado.getPaciente().getNome() + ": " + pagtoselecionado.getId(),pagtoselecionado.getValor().intValue(),1);
                    if (resposta == 1 || resposta == 2){
                        dbm.realizarPagamento(pagtoselecionado.getId(), "Débito");
                    }
                    break;
                    case 2:
                    dbm.realizarPagamento(pagtoselecionado.getId(), "Dinheiro");
                    break;

                }
            }
            if (((String)jComboBox1.getSelectedItem()).equals("Convênio"))
            {
                dbm.realizarPagamento(pagtoselecionado.getId(), "Convênio");
            }

        }
        Long cpfpac = Long.parseLong(jTextField1.getText());
        popularPagamentos(cpfpac);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (((String)jComboBox1.getSelectedItem()).equals("Particular"))
        {
            jLabel4.setVisible(false);
            jComboBox2.setVisible(false);
            jLabel5.setVisible(true);
            jComboBox3.setVisible(true);
        }
        if (((String)jComboBox1.getSelectedItem()).equals("Convênio"))
        {
            jLabel5.setVisible(false);
            jComboBox3.setVisible(false);
            jLabel4.setVisible(true);
            jComboBox2.setVisible(true);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Long cpfpac = Long.parseLong(jTextField1.getText());
        popularPagamentos(cpfpac);

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<Empresa> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<Pagamento> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
