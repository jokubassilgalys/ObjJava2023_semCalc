package calcMain;
import calcUI.CalcGUI;

public class CalculatorMain {
    public static void main(String args[]){      
        //new CalcGUI();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalcGUI();
            }
        });
    }  
}
