package sistema.hospitalar;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
 
 
import sistema.hospitalar.JFilePicker;
 
/**
 * Aplicação para enviar e-mails com anexos via servidor SMTP.
 */
public class SwingEmailSender extends JFrame {
	private ConfigUtility configUtil = new ConfigUtility();
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFile = new JMenu("Arquivo");
	private JMenuItem menuItemSetting = new JMenuItem("Configurações..");
	
	private JLabel labelTo = new JLabel("Para: ");
	private JLabel labelSubject = new JLabel("Assunto: ");
	
	private JTextField fieldTo = new JTextField(30);
	private JTextField fieldSubject = new JTextField(30);
	
	private JButton buttonSend = new JButton("ENVIAR");
	
	private JFilePicker filePicker = new JFilePicker("Anexo:", "Anexar...");
	
	private JTextArea textAreaMessage = new JTextArea(10, 30);
	
	private GridBagConstraints constraints = new GridBagConstraints();
	
	public SwingEmailSender() {
		super("Enviar e-mail");
		
		// set up layout
		setLayout(new GridBagLayout());
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);
	
		setupMenu();
		setupForm();
		
		pack();
		setLocationRelativeTo(null);	// center on screen
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
	}

	private void setupMenu() {
		menuItemSetting.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				SettingsDialog dialog = new SettingsDialog(SwingEmailSender.this, configUtil);
				dialog.setVisible(true);
			}
		});
		
		menuFile.add(menuItemSetting);
		menuBar.add(menuFile);
		setJMenuBar(menuBar);		
	}
	
	private void setupForm() {
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(labelTo, constraints);
		
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		add(fieldTo, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		add(labelSubject, constraints);
		
		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		add(fieldSubject, constraints);
		
                fieldSubject.setText("Seu laudo médico");
                textAreaMessage.setText("Caro paciente, \nEm anexo está o seu laudo." );
		
                constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.BOTH;
		buttonSend.setFont(new Font("Arial", Font.BOLD, 16));
		add(buttonSend, constraints);
		
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				buttonSendActionPerformed(event);
			}
		});
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridheight = 1;
		constraints.gridwidth = 3;
		filePicker.setMode(JFilePicker.MODE_OPEN);
		add(filePicker, constraints);
		
		constraints.gridy = 3;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		
		add(new JScrollPane(textAreaMessage), constraints);		
	}
	
	private void buttonSendActionPerformed(ActionEvent event) {
		if (!validateFields()) {
			return;
		}
		
		String toAddress = fieldTo.getText();
		String subject = fieldSubject.getText();
		String message = textAreaMessage.getText();
		File[] attachFiles = null;
		
		if (!filePicker.getSelectedFilePath().equals("")) {
			File selectedFile = new File(filePicker.getSelectedFilePath());
			attachFiles = new File[] {selectedFile};
		}
		
		try {
			Properties smtpProperties = configUtil.loadProperties();
			EmailUtility.sendEmail(smtpProperties, toAddress, subject, message, attachFiles);
			
			JOptionPane.showMessageDialog(this, 
					"E-mail enviado com sucesso!");
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, 
					"Erro ao enviar e-mail: " + ex.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private boolean validateFields() {
		if (fieldTo.getText().equals("")) {
			JOptionPane.showMessageDialog(this, 
					"Adicione um destinatário!",
					"Error", JOptionPane.ERROR_MESSAGE);
			fieldTo.requestFocus();
			return false;
		}
		
		if (fieldSubject.getText().equals("")) {
			JOptionPane.showMessageDialog(this, 
					"Adicione um assunto!",
					"Error", JOptionPane.ERROR_MESSAGE);
			fieldSubject.requestFocus();
			return false;
		}
		
		if (textAreaMessage.getText().equals("")) {
			JOptionPane.showMessageDialog(this, 
					"Escreva uma mensagem!",
					"Error", JOptionPane.ERROR_MESSAGE);
			textAreaMessage.requestFocus();
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// set look and feel to system dependent
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingEmailSender().setVisible(true);
			}
		});
	}
}