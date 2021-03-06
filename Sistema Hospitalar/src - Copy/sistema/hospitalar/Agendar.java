/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.hospitalar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class Agendar extends javax.swing.JFrame {

    /**
     * Creates new form Agendar
     */
    public Agendar() {
        initComponents();
        TextField_pac_id.setDocument(new SoNumeros(11));
        limpaTela();
        iniTela();
    }
    
    public void limpaTela(){
        ComboBox_eq.removeAllItems();
        ComboBox_hora.removeAllItems();
        ComboBox_proc.removeAllItems();
        ComboBox_sl.removeAllItems();
        TextField_pac_id.setText(null);
    }
    
    public void iniTela(){
        DBManager dbm = new DBManager();
        List<Equipe> list_eq = new ArrayList<>();
        List<Procedimento> list_proc = new ArrayList<>();
        List<Sala> list_sl = new ArrayList<>();
        list_eq = dbm.getEquipe(null);
        list_proc = dbm.getProcedimento(null);
        list_sl = dbm.getSala(null);        
        ComboBox_eq.addItem("");
        ComboBox_proc.addItem("");
        ComboBox_sl.addItem("");
        for (Sala sala : list_sl) {
            ComboBox_sl.addItem(sala.getQuartos().toString());
        }
        for (Equipe equipe : list_eq) {
            ComboBox_eq.addItem(equipe.getNome());
        }
        for (Procedimento procedimento : list_proc) {
            ComboBox_proc.addItem(procedimento.getNome());
        }
        ComboBox_hora.addItem("00:00");ComboBox_hora.addItem("00:30");
        ComboBox_hora.addItem("01:00");ComboBox_hora.addItem("01:30");
        ComboBox_hora.addItem("02:00");ComboBox_hora.addItem("02:30");
        ComboBox_hora.addItem("03:00");ComboBox_hora.addItem("03:30");
        ComboBox_hora.addItem("04:00");ComboBox_hora.addItem("04:30");
        ComboBox_hora.addItem("05:00");ComboBox_hora.addItem("05:30");
        ComboBox_hora.addItem("06:00");ComboBox_hora.addItem("06:30");
        ComboBox_hora.addItem("07:00");ComboBox_hora.addItem("07:30");
        ComboBox_hora.addItem("08:00");ComboBox_hora.addItem("08:30");
        ComboBox_hora.addItem("09:00");ComboBox_hora.addItem("09:30");
        ComboBox_hora.addItem("10:00");ComboBox_hora.addItem("10:30");
        ComboBox_hora.addItem("11:00");ComboBox_hora.addItem("11:30");
        ComboBox_hora.addItem("12:00");ComboBox_hora.addItem("12:30");
        ComboBox_hora.addItem("13:00");ComboBox_hora.addItem("13:30");
        ComboBox_hora.addItem("14:00");ComboBox_hora.addItem("14:30");
        ComboBox_hora.addItem("15:00");ComboBox_hora.addItem("15:30");
        ComboBox_hora.addItem("16:00");ComboBox_hora.addItem("16:30");
        ComboBox_hora.addItem("17:00");ComboBox_hora.addItem("17:30");
        ComboBox_hora.addItem("18:00");ComboBox_hora.addItem("18:30");
        ComboBox_hora.addItem("19:00");ComboBox_hora.addItem("19:30");
        ComboBox_hora.addItem("20:00");ComboBox_hora.addItem("20:30");
        ComboBox_hora.addItem("21:00");ComboBox_hora.addItem("21:30");
        ComboBox_hora.addItem("22:00");ComboBox_hora.addItem("22:30");
        ComboBox_hora.addItem("23:00");ComboBox_hora.addItem("23:30");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header_Agendar = new javax.swing.JLabel();
        Data = new com.toedter.calendar.JDateChooser();
        Label_data = new javax.swing.JLabel();
        Label_hora = new javax.swing.JLabel();
        ComboBox_hora = new javax.swing.JComboBox<>();
        Label_paciente = new javax.swing.JLabel();
        TextField_pac_id = new javax.swing.JTextField();
        Label_eq = new javax.swing.JLabel();
        ComboBox_eq = new javax.swing.JComboBox<>();
        Label_proc = new javax.swing.JLabel();
        ComboBox_proc = new javax.swing.JComboBox<>();
        Label_sl = new javax.swing.JLabel();
        ComboBox_sl = new javax.swing.JComboBox<>();
        Button_Agendar = new javax.swing.JButton();
        Button_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Header_Agendar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Header_Agendar.setText("Agendar");

        Label_data.setLabelFor(Data);
        Label_data.setText("Data");

        Label_hora.setLabelFor(ComboBox_hora);
        Label_hora.setText("Hora");

        ComboBox_hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Label_paciente.setLabelFor(TextField_pac_id);
        Label_paciente.setText("Paciente");

        Label_eq.setLabelFor(ComboBox_eq);
        Label_eq.setText("Equipe");

        ComboBox_eq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Label_proc.setLabelFor(ComboBox_proc);
        Label_proc.setText("Procedimento");
        Label_proc.setToolTipText("");

        ComboBox_proc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Label_sl.setText("Sala");

        ComboBox_sl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Button_Agendar.setText("Agendar");
        Button_Agendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AgendarActionPerformed(evt);
            }
        });

        Button_voltar.setText("Voltar");
        Button_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ComboBox_eq, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Data, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboBox_hora, 0, 114, Short.MAX_VALUE)
                            .addComponent(ComboBox_proc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextField_pac_id)
                            .addComponent(ComboBox_sl, 0, 129, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(Label_eq)
                        .addGap(114, 114, 114)
                        .addComponent(Label_proc)
                        .addGap(119, 119, 119)
                        .addComponent(Label_sl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(Label_data)
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Label_hora)
                                .addGap(125, 125, 125)
                                .addComponent(Label_paciente))
                            .addComponent(Header_Agendar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(Button_Agendar)
                        .addGap(89, 89, 89)
                        .addComponent(Button_voltar)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header_Agendar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_data, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_hora, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Label_paciente, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ComboBox_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TextField_pac_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_eq)
                    .addComponent(Label_proc)
                    .addComponent(Label_sl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox_eq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox_proc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBox_sl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Agendar)
                    .addComponent(Button_voltar))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_AgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AgendarActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String data = null;
        String hora = null;
        Long pac = null;
        Integer sala = null;
        Integer equipe = null;
        Integer proc = null;
        DBManager dbm = new DBManager();
        if(Data.getDate() != null){
            data = sdf.format(Data.getDate());
        }
        if(TextField_pac_id.getText().length() > 0){
            List<Paciente> list_pac = new ArrayList<>();
            Paciente paciente = new Paciente();
            paciente.setCPF(Long.parseLong(TextField_pac_id.getText()));
            list_pac = dbm.getPaciente(paciente);
            for (Paciente paciente1 : list_pac) {
                pac = paciente1.getCPF();
                hora = ComboBox_hora.getSelectedItem().toString();
            }
        }
        if(ComboBox_sl.getSelectedItem().toString() != ""){
            sala = Integer.parseInt(ComboBox_sl.getSelectedItem().toString());
        }
        if(ComboBox_eq.getSelectedItem().toString() != ""){
            List<Equipe> list_eq = new ArrayList<>();
            Equipe eq = new Equipe();
            eq.setNome(ComboBox_eq.getSelectedItem().toString());
            list_eq = dbm.getEquipe(eq);
            for (Equipe equipe1 : list_eq) {
                equipe = equipe1.getID();
            }
        }
        if(ComboBox_proc.getSelectedItem().toString() != ""){
            List<Procedimento> list_proc = new ArrayList<>();
            Procedimento proc1 = new Procedimento() {};
            proc1.setNome(ComboBox_proc.getSelectedItem().toString());
            list_proc = dbm.getProcedimento(proc1);
            for (Procedimento procedimento : list_proc) {
                proc = procedimento.getId();
            }
        }
        if(data != null && pac != null && sala != null && equipe != null && proc != null){
            String aux = null;
            List<Agendamento> list_ag = new ArrayList<>();
            list_ag = dbm.consultarAgendamento(data);
            for (Agendamento agendamento : list_ag) {
                if(agendamento.getHora().equals(hora) && agendamento.getSala_id() == sala ||
                   agendamento.getHora().equals(hora) && agendamento.getEquipe_id() == equipe){
                    aux = "O " + agendamento.getPac_nome() + " está agendado para o " + data
                          + " no horario " + hora + " na sala " + agendamento.getSala_id().toString() +
                          " ou para a equipe " + agendamento.getEq_nome();
                }
            }
            if(aux == null){
                Agendamento ag = new Agendamento();
                ag.setData(data);
                ag.setEquipe_id(equipe);
                ag.setHora(hora);
                ag.setPaciente_id(pac);
                ag.setProcedimento_id(proc);
                ag.setSala_id(sala);
                dbm.agendar(ag);
                JOptionPane.showMessageDialog(null,"Agendamento realizado com sucesso!!!");
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null,aux);
            }
        }else if(hora != null){
            JOptionPane.showMessageDialog(null,"Por favor preencher todos os campos");
        }else{
            JOptionPane.showMessageDialog(null,"O paciente não está cadastrado");
        }
    }//GEN-LAST:event_Button_AgendarActionPerformed

    private void Button_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_Button_voltarActionPerformed

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
            java.util.logging.Logger.getLogger(Agendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agendar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Agendar;
    private javax.swing.JButton Button_voltar;
    private javax.swing.JComboBox<String> ComboBox_eq;
    private javax.swing.JComboBox<String> ComboBox_hora;
    private javax.swing.JComboBox<String> ComboBox_proc;
    private javax.swing.JComboBox<String> ComboBox_sl;
    private com.toedter.calendar.JDateChooser Data;
    private javax.swing.JLabel Header_Agendar;
    private javax.swing.JLabel Label_data;
    private javax.swing.JLabel Label_eq;
    private javax.swing.JLabel Label_hora;
    private javax.swing.JLabel Label_paciente;
    private javax.swing.JLabel Label_proc;
    private javax.swing.JLabel Label_sl;
    private javax.swing.JTextField TextField_pac_id;
    // End of variables declaration//GEN-END:variables
}
