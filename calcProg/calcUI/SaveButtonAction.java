package calcUI;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class SaveButtonAction extends AbstractAction {
    private String currentText, arg1, arg2, operator, answer;

    public SaveButtonAction(CalcGUI c){
        super("Save");
        this.currentText = c.calcTextArea.getText();
        this.arg1 = c.arg1;
        this.arg2 = c.arg2;
        this.operator = c.operator;
        this.answer = c.answer;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
