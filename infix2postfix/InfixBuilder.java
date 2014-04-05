import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class InfixBuilder extends JFrame { 
  
    String expression = "";
    
    public InfixBuilder() {
    /*
     * The constructor method
    */
 
        JFrame frame;
        setVisible(true);
        setTitle("Infix Expression Converter and Evaluator");
        setSize(315, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    
    
    public void runGUI() {
    /*
     * Build and runs the GUI
    */
     
        // Initialize Panel
        JPanel jp = new JPanel(new BorderLayout());
        getContentPane().add(jp);
        jp.setLayout(null);
        
        // Initialize Text Field
        final JTextField jtf = new JTextField("", 12);
        //jtf.setBackground( Color.white );
        //jtf.setHorizontalAlignment(JTextField.RIGHT);
        //jtf.setFont(new Font("Tahoma", Font.PLAIN, 24));
        jp.add(jtf);
        
        // Build number buttons
        addButton("1", 50, 50, 10, 10, jp, jtf);
        addButton("2", 50, 50, 70, 10, jp, jtf);
        addButton("3", 50, 50, 130, 10, jp, jtf);
        addButton("4", 50, 50, 10, 70, jp, jtf);
        addButton("5", 50, 50, 70, 70, jp, jtf);
        addButton("6", 50, 50, 130, 70, jp, jtf);
        addButton("7", 50, 50, 10, 130, jp, jtf);
        addButton("8", 50, 50, 70, 130, jp, jtf);
        addButton("9", 50, 50, 130, 130, jp, jtf);
        addButton("0", 50, 50, 10, 190, jp, jtf);
        
        // Build operation buttons
        addButton("(", 50, 50, 190, 10, jp, jtf);
        addButton(")", 50, 50, 250, 10, jp, jtf);
        addButton("+", 50, 50, 190, 70, jp, jtf);
        addButton("-", 50, 50, 250, 70, jp, jtf);
        addButton("*", 50, 50, 190, 130, jp, jtf);
        addButton("/", 50, 50, 250, 130, jp, jtf);
        addButton("^", 50, 50, 190, 190, jp, jtf);
        
        // Build decimal button
        addButton(".", 50, 50, 70, 190, jp, jtf);
        
         // Build Enter button
        addButton("Enter", 100, 25, 10, 250, jp, jtf);
        
        // Build Clear button
        addButton("Clear", 100, 25, 110, 250, jp, jtf);
        
        // Build Quit button
        addButton("Quit", 100, 25, 210, 250, jp, jtf);
        
        System.out.println("Please enter an infix expression. Press 'Enter' when finished.");
    }    
    
    
    public void addButton(String label, int sizeX, int sizeY, int placeX, int placeY, JPanel panel, JTextField jtf) {
    /*
     * Adds a button to the panel
    */
    
        JButton numberButton = new JButton(label);
        numberButton.setBounds(placeX, placeY, sizeX, sizeY); 
        addListener(jtf, numberButton, label);
        panel.add(numberButton);  
    }
    
    
    public void addListener(final JTextField jtf, JButton button, final String buttonValue) {
    /*
     * Adds appropriate ActionListener to the button
    */
      
        // ActionListener for numbers and operators
        ActionListener buttonListener = new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent event) {
              
                jtf.setText(jtf.getText() + buttonValue);
            }
        };
        
        // ActionListener for Enter button
        ActionListener enterListener = new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent event) {
                expression = jtf.getText();
                convertExpression(expression);
            }
        };
        
        //ActionListener for Clear button
        ActionListener clearListener = new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent event) {
                jtf.setText("");
            }
        };
        
        // ActionListener for Quit button
        ActionListener quitListener = new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        };
        
        // Determine appropriate ActionListener to add to button
        if (buttonValue.equals("Quit")) {
            button.addActionListener(quitListener);
        } else if (buttonValue.equals("Enter")) {
            button.addActionListener(enterListener);
        } else if (buttonValue.equals("Clear")) {
            button.addActionListener(clearListener);
        } else {
            button.addActionListener(buttonListener);
        }
    }
    
    
    public void convertExpression(String expression) {
    /*
     * Converts infix expression to postfix expression and evaluates
    */
      
        // Convert expression to postfix
        System.out.println("Converting the expression: " + expression);
        InfixConverter ic = new InfixConverter();
        String postfixExpression = ic.convert(expression);
        System.out.println("The postfix expression is: " + postfixExpression);
      
        // Evaluate postfix expression
        PostfixEvaluator pe = new PostfixEvaluator();
        double result = pe.evaluate(postfixExpression);
      
        // Display result
        System.out.println("Result: " + result);
    }
}