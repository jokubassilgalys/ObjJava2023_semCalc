package calcUI;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.math.BigDecimal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import calcException.ExceptionDivideByZero;
import calcModes.*;


public class CalcGUI extends JFrame implements ActionListener{
    JButton numButton[] = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, powButton,
            clearButton, modButton, logButton, lnButton, sinButton,
            cosButton, tanButton, equalsButton, decButton, saveButton, loadButton;
    JTextArea calcTextArea = new JTextArea();
    String arg1 = "0", arg2 = "0", operator = "", answer = "";
    File saveFile = new File(".\\calcProg\\save\\save.bin");

    public CalcGUI(){
        JFrame calcFrame = new JFrame("Calculator");
        Container calcPane = calcFrame.getContentPane();
        GridBagConstraints grid = new GridBagConstraints();
        JScrollPane areaScrollPane = new JScrollPane(calcTextArea);

        calcFrame.setLocationRelativeTo(null);
        calcFrame.setResizable(false);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcPane.setBackground(new Color(200, 200, 200));
        calcPane.setLayout(new GridBagLayout());
        calcTextArea.setText("0");
        calcTextArea.setEditable(false);
        calcTextArea.setLineWrap(true);
        calcTextArea.setFont(new Font("Serif Plain",Font.BOLD,18));
        areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(  ClassNotFoundException | InstantiationException | 
                IllegalAccessException | UnsupportedLookAndFeelException e){
            System.out.println(e.getMessage());
        }

        grid.fill = GridBagConstraints.HORIZONTAL;
        grid.ipady = 30;
        grid.insets = new Insets(2,2,2,2);

        powButton = new JButton("^");
        grid.gridx = 0;
        grid.gridy = 1;
        powButton.addActionListener(this);
        calcPane.add(powButton, grid);

        modButton = new JButton("mod");
        grid.gridx = 0;
        grid.gridy = 2;
        modButton.addActionListener(this);
        calcPane.add(modButton, grid);

        logButton = new JButton("log");
        grid.gridx = 0;
        grid.gridy = 3;
        logButton.addActionListener(this);
        calcPane.add(logButton, grid);

        lnButton = new JButton("ln");
        grid.gridx = 0;
        grid.gridy = 4;
        lnButton.addActionListener(this);
        calcPane.add(lnButton, grid);

        clearButton = new JButton("C");
        grid.gridx = 0;
        grid.gridy = 5;
        grid.gridwidth = 2;
        clearButton.addActionListener(this);
        calcPane.add(clearButton, grid);

        grid.gridwidth = 1;
        sinButton = new JButton("sin");
        grid.gridx = 1;
        grid.gridy = 1;
        sinButton.addActionListener(this);
        calcPane.add(sinButton, grid);

        cosButton = new JButton("cos");
        grid.gridx = 2;
        grid.gridy = 1;
        cosButton.addActionListener(this);
        calcPane.add(cosButton, grid);

        tanButton = new JButton("tan");
        grid.gridx = 3;
        grid.gridy = 1;
        tanButton.addActionListener(this);
        calcPane.add(tanButton, grid);

        int x = 1, y = 2;
        for(int i = 1; i <= 9; ++i){
            numButton[i] = new JButton(i + "");
            grid.gridx = x;
            grid.gridy = y;
            numButton[i].addActionListener(this);

            if(x == 3){ x = 1; y++; }
            else { x++; }

            calcPane.add(numButton[i], grid);
        }
        numButton[0] = new JButton("0");
        grid.gridx = 2;
        grid.gridy = 5;
        numButton[0].addActionListener(this);
        calcPane.add(numButton[0], grid);

        addButton = new JButton("+");
        grid.gridx = 4;
        grid.gridy = 1;
        addButton.addActionListener(this);
        calcPane.add(addButton, grid);

        subButton = new JButton("-");
        grid.gridx = 4;
        grid.gridy = 2;
        subButton.addActionListener(this);
        calcPane.add(subButton, grid);

        mulButton = new JButton("*");
        grid.gridx = 4;
        grid.gridy = 3;
        mulButton.addActionListener(this);
        calcPane.add(mulButton, grid);

        divButton = new JButton("/");
        grid.gridx = 4;
        grid.gridy = 4;
        divButton.addActionListener(this);
        calcPane.add(divButton, grid);
        
        decButton = new JButton(".");
        grid.gridx = 3;
        grid.gridy = 5;
        decButton.addActionListener(this);
        calcPane.add(decButton, grid);

        equalsButton = new JButton("=");
        grid.gridx = 4;
        grid.gridy = 5;
        grid.gridheight = 2;
        Dimension d = equalsButton.getPreferredSize();
        equalsButton.setPreferredSize(new Dimension(d.width, d.height*3+12));
        equalsButton.addActionListener(this);
        calcPane.add(equalsButton, grid);

        saveButton = new JButton("Save");
        grid.gridx = 0;
        grid.gridy = 6;
        grid.gridheight = 1;
        grid.gridwidth = 2;
        saveButton.addActionListener(this);
        calcPane.add(saveButton, grid);

        loadButton = new JButton("Load");
        grid.gridx = 2;
        grid.gridy = 6;
        loadButton.addActionListener(this);
        calcPane.add(loadButton, grid);

        grid.gridx = 0;
        grid.gridy = 0;
        grid.gridwidth = 5;
        calcPane.add(areaScrollPane, grid);

        calcFrame.pack();
        calcFrame.setSize(300,470);
        calcFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        JButton callerButton = (JButton)e.getSource();
        String currentText = calcTextArea.getText(); 
        
        if(!(answer.isEmpty()) && callerButton != saveButton){
            if(answer.equals("null")){
                answer = "0";
            }
            currentText = arg1 = answer;
            answer = operator = "";
            arg2 = "0";
        }

        if( callerButton == addButton || callerButton == subButton ||
            callerButton == mulButton || callerButton == divButton ||
            callerButton == powButton || callerButton == modButton ){
            
            if(operator.isEmpty()){
                currentText += " " + callerButton.getText() + " ";
                operator = callerButton.getText();
            }
            else if(arg2.equals("0")){
                currentText = currentText.substring(0, currentText.length() - 2) + callerButton.getText() + " ";
                operator = callerButton.getText();
            }
            else {
                answer = "" + evaluate();

                currentText = arg1 = answer;
                answer = operator = "";
                arg2 = "0";

                currentText += " " + callerButton.getText() + " ";
                operator = callerButton.getText();
            }
            
        }
        else if(callerButton == sinButton || callerButton == cosButton || callerButton == tanButton ||
                callerButton == logButton || callerButton == lnButton){
            currentText = callerButton.getText() + "(" + arg1 + ")";
            operator = callerButton.getText();
            answer = "" + evaluate();
            currentText += "\n= " + answer;
        }
        else if(callerButton == decButton){
            if(operator.isEmpty()){
                if(!(arg1.contains("."))){
                    arg1 += ".";
                    currentText += "."; 
                }
            }
            else if(!(arg2.contains(".")) && !(currentText.substring(currentText.length() - 1).equals(" "))){
                arg2 += ".";
                currentText += "."; 
            }
            else {
                arg2 += "0.";
                currentText += "0.";
            }
        }
        else if(callerButton == clearButton){
            currentText = arg1 = arg2 = "0";
            operator = answer = "";
        }
        else if(callerButton == equalsButton){
            if(!(operator.isEmpty())){
                if(currentText.substring(currentText.length() - 1).equals(" ")){
                    currentText += arg2 + "";
                }
                answer = "" + evaluate();
                currentText += "\n= " + answer;
            }
            else {
                answer = arg1 + "";
                currentText += "\n= " + arg1;
            }
            
        }
        else if(callerButton == saveButton){
            try{
                if(saveFile.createNewFile()){
                    System.out.println("File "+ saveFile.getName() + " created");
                }
                else {
                    System.out.println("File "+ saveFile.getName() + " already exists");
                }
            }
            catch(IOException exc){
                System.out.println("File opening/creating error");
            }

            try{
                FileWriter saveWriter = new FileWriter(saveFile);
                saveWriter.write(arg1 + "\n" + operator + "\n" + arg2 + "\n" + answer + "\n" + currentText);
                System.out.println("Saved to file "+ saveFile.getName());
                saveWriter.close();
            }
            catch(IOException exc){
                System.out.println("File writing error");
            }
        }
        else if(callerButton == loadButton){
            try {
                Scanner saveReader = new Scanner(saveFile);
                arg1 = saveReader.nextLine(); operator = saveReader.nextLine();
                arg2 = saveReader.nextLine(); answer = saveReader.nextLine();

                currentText = saveReader.nextLine();
                if(saveReader.hasNextLine()){
                    currentText += "\n" + saveReader.nextLine();
                }
                saveReader.close();
            }
            catch(FileNotFoundException exc){
                System.out.println("File"+ saveFile.getName() +"found");
            }
        }
        else {
            for(int i = 0; i <= 9; ++i){
                if(callerButton == numButton[i]){
                    if(!(currentText.substring(currentText.length() - 1).equals("0"))){
                        currentText += i;
                    }          
                    else{
                        if(currentText.length() > 1){
                            if((currentText.substring(currentText.length() - 2, currentText.length() - 1)).equals(" ")){
                                currentText = currentText.substring(0, currentText.length() - 1) + i;
                            }
                            else{
                                currentText += i;
                            }
                        }
                        else{
                            currentText = currentText.substring(0, currentText.length() - 1) + i;
                            arg1 = "";
                        }
                    }

                    if(operator.isEmpty()){ arg1 += i; }
                    else { arg2 += i; }
                }
            }
        }

        calcTextArea.setText(currentText);
    } 

    public BigDecimal evaluate(){
        BaseCalculator inputNumbers = new BaseCalculator();
        switch(operator){
            case "+":
                inputNumbers = new BaseCalculator(new BigDecimal(arg1), new BigDecimal(arg2));
                inputNumbers.addition();
                break;
            case "-":
                inputNumbers = new BaseCalculator(new BigDecimal(arg1), new BigDecimal(arg2));
                inputNumbers.subtraction();
                break;
            case "*":
                inputNumbers = new BaseCalculator(new BigDecimal(arg1), new BigDecimal(arg2));
                inputNumbers.multiplication();
                break;
            case "/":
                inputNumbers = new BaseCalculator(new BigDecimal(arg1), new BigDecimal(arg2));
                try {
                    inputNumbers.division();
                }
                catch(ExceptionDivideByZero e){
                    System.out.println(e.getMessage());
                }
                break;
            case "sin":
                inputNumbers = new ScientificCalculator(new BigDecimal(arg1));
                ((ScientificCalculator)inputNumbers).sin();
                break;
            case "cos":
                inputNumbers = new ScientificCalculator(new BigDecimal(arg1));
                ((ScientificCalculator)inputNumbers).cos();
                break;
            case "tan":
                inputNumbers = new ScientificCalculator(new BigDecimal(arg1));
                ((ScientificCalculator)inputNumbers).tan();
                break;
            case "log":
                inputNumbers = new ScientificCalculator(new BigDecimal(arg1));
                ((ScientificCalculator)inputNumbers).log();
                break;
            case "ln":
                inputNumbers = new ScientificCalculator(new BigDecimal(arg1));
                ((ScientificCalculator)inputNumbers).ln();
                break;
            case "^":
                inputNumbers = new SimpleCalculator(new BigDecimal(arg1), new BigDecimal(arg2));
                ((SimpleCalculator)inputNumbers).power();
                break;
            case "mod":
                inputNumbers = new SimpleCalculator(new BigDecimal(arg1), new BigDecimal(arg2));
                try {
                    ((SimpleCalculator)inputNumbers).mod();
                }
                catch(ExceptionDivideByZero e){
                    System.out.println(e.getMessage());
                }
                break;
            default:
               System.out.println("Invalid operator");
        }
        return inputNumbers.getAnswer();   
    }
}

// number button if logic
// save load threads
// diferent button actions 

// more exep
// log -1
// ln 0
// 1/3

// keayboard?
