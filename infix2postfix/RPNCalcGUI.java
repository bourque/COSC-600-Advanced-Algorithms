/* 
Matthew Bourque
3/29/14
Optional Project 1

Algorithm:

    Build GUI
        Add number buttons
        Add operator buttons
        Add decimal button
        Add Quit, Clear, and Enter buttons
        Add actionListeners to buttons
    Prompt user to enter infix expression
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

public class RPNCalcGUI {
  
  
    public static void main(String args[]) {
    /*
     * The main method.
    */

        // Run GUI
        InfixBuilder ib = new InfixBuilder();
        ib.runGUI();
    }
}