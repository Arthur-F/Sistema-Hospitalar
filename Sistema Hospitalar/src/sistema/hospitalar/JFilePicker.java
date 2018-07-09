package sistema.hospitalar;
 
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
 
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class JFilePicker extends JPanel {
    private String textFieldLabel;
    private String buttonLabel;
     
    private JLabel label;
    private JTextField textField;
    private JButton button;
     
    private JFileChooser fileChooser;
     
    private int mode;
    public static final int MODE_OPEN = 1;
    public static final int MODE_SAVE = 2;

    //Construtor !!!
    public JFilePicker(String textFieldLabel, String buttonLabel, JLabel label, JTextField textField, JButton button, JFileChooser fileChooser, int mode) {
        this.textFieldLabel = textFieldLabel;
        this.buttonLabel = buttonLabel;
        this.label = label;
        this.textField = textField;
        this.button = button;
        this.fileChooser = fileChooser;
        this.mode = mode;
    }
     
    public JFilePicker(String textFieldLabel, String buttonLabel) {
        this.textFieldLabel = textFieldLabel;
        this.buttonLabel = buttonLabel;
         
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir") + "\\laudos\\"));
    
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
 
        label = new JLabel(textFieldLabel);
         
        textField = new JTextField(30);
        button = new JButton(buttonLabel);
         
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                buttonActionPerformed(evt);            
            }
        });
         
        add(label);
        add(textField);
        add(button);
         
    }
     
    private void buttonActionPerformed(ActionEvent evt) {
        if (mode == MODE_OPEN) {
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        } else if (mode == MODE_SAVE) {
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        }
    }
 
    public void addFileTypeFilter(String extension, String description) {
        FileTypeFilter filter = new FileTypeFilter(extension, description);
        fileChooser.addChoosableFileFilter(filter);
    }
     
    public void setMode(int mode) {
        this.mode = mode;
    }
     
    public String getSelectedFilePath() {
        return textField.getText();
    }
     
    public JFileChooser getFileChooser() {
        return this.fileChooser;
    }
}