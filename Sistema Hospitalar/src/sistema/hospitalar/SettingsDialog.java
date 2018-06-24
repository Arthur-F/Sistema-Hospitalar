package sistema.hospitalar;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;
 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
/**
 * Formulário que permite configurar as configurações SMTP.
 */

public class SettingsDialog extends JDialog {
 
    private ConfigUtility configUtil;
     
    private JLabel labelHost = new JLabel("Nome do host: ");
    private JLabel labelPort = new JLabel("Número da porta: ");
    private JLabel labelUser = new JLabel("E-mail: ");
    private JLabel labelPass = new JLabel("Senha: ");
     
    private JTextField textHost = new JTextField(20);
    private JTextField textPort = new JTextField(20);
    private JTextField textUser = new JTextField(20);
    private JTextField textPass = new JTextField(20);
     
    private JButton buttonSave = new JButton("Salvar");
     
    public SettingsDialog(JFrame parent, ConfigUtility configUtil) {
        super(parent, "SMTP Settings", true);
        this.configUtil = configUtil;
         
        setupForm();
         
        loadSettings();
         
        pack();
        setLocationRelativeTo(null);
    }
     
    private void setupForm() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 5, 10);
        constraints.anchor = GridBagConstraints.WEST;
         
        add(labelHost, constraints);
         
        constraints.gridx = 1;
        add(textHost, constraints);
         
        constraints.gridy = 1;
        constraints.gridx = 0;
        add(labelPort, constraints);
         
        constraints.gridx = 1;
        add(textPort, constraints);
 
        constraints.gridy = 2;
        constraints.gridx = 0;
        add(labelUser, constraints);
         
        constraints.gridx = 1;
        add(textUser, constraints);
 
        constraints.gridy = 3;
        constraints.gridx = 0;
        add(labelPass, constraints);
         
        constraints.gridx = 1;
        add(textPass, constraints);
         
        constraints.gridy = 4;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        add(buttonSave, constraints);
         
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                buttonSaveActionPerformed(event);
            }
        });    
    }
     
    private void loadSettings() {
        Properties configProps = null;
        try {
            configProps = configUtil.loadProperties();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao ler as configurações: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
         
        textHost.setText(configProps.getProperty("mail.smtp.host"));
        textPort.setText(configProps.getProperty("mail.smtp.port"));
        textUser.setText(configProps.getProperty("mail.user"));
        textPass.setText(configProps.getProperty("mail.password"));    
    }
     
    private void buttonSaveActionPerformed(ActionEvent event) {
        try {
            configUtil.saveProperties(textHost.getText(),
                    textPort.getText(),
                    textUser.getText(),
                    textPass.getText());
            JOptionPane.showMessageDialog(SettingsDialog.this,
                    "Configurações salvas com sucesso!");    
            dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao salvar configurações: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }      
    }
}