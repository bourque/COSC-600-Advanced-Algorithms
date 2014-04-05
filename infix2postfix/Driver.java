/* 
Matthew Bourque
3/29/14
Optional Project 1

Algorithm:

    Read in infix expression from keyboard
    Ensure infix expression is surrounded by "()"
    Split infix expression into tokens
    For each token:
        c = first character in token
        if c is number:
            enq(token)
        if c is '(':
            push(token)
        if c is ')':
            while (peek(stack) != '(')
                enq(pop(stack))
            pop(stack)
        else
            while priority(c) <= priority(peek(stack))
                enq(pop(stack))
            push(token)
    Read out queue to gather postfix expression
    Print postfix expression to screen
    Split postfix expression into tokens
    for each token:
        c = first character in token
        if c is number:
            push(token)
        else:
            top = pop(stack)
            next = pop(stack)
            result = next c top
            push(result)
     Print result to screen
        

Purpose:

    This program reads in an infix expression from the keyboard, converts it to
    an postfix expression, and evaluates the expression.  The result is printed
    to the screen.  Expressions are converted and evaluated using nodes, stacks,
    and queues.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
  
public class Driver {
  
  
    public static void main(String args[]) {
    /*
     * The main method.
    */
    
        // Read in expression from keyboard
        String expression = getExpression();
      
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
    
    
    public static String getExpression() {
    /*
     * Retrieves infix expression from user keyboard
    */
       
        String expression = "";
        System.out.println("Please enter an infix expression:");
        
        try {
            // Read in data from keyboard
            BufferedReader inputData = new BufferedReader(new InputStreamReader(System.in));
            expression = inputData.readLine();
         
        } catch(Exception e) {
            System.out.println("Error " + e.toString());
        }
            
        return expression;    
    }
}