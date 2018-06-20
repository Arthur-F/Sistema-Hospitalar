package sistema.hospitalar;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SoNumeros extends PlainDocument{
    
    private int limit;
    
    public SoNumeros(int limite){
        this.limit = limite;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if(str == null){
            return;
        }else if((getLength() + str.length()) <= limit){
            super.insertString(offs, str.replaceAll("[^0-9]", ""), a);
        }
    }
    
}