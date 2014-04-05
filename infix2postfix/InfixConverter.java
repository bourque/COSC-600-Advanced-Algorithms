import java.util.StringTokenizer;


public class InfixConverter {

    public String convert(String exp) {
    /*
     * Converts an infix expression to a postfix expression
    */
        
        // Ensure the given expression is surrounded by "()"
        String expression = "(" + exp + ")";
        
        // Split the expression into tokens by operators and whitespaces
        StringTokenizer st = new StringTokenizer(expression, "+-*x/^() ", true);        

        // Initialize empty stack and queue
        Stack stack = new Stack();
        Queue queue = new Queue();
        
        do {
            // Grab the token, and find the first character in it
            String x = st.nextToken();
            char c = x.charAt(0);
            
            // Ignore spaces
            if (!x.equals(" ")) {
            
                // Manipulate stack and queue based on token
                if (Character.isDigit(c)) {queue.enq(x);}
                else if (c == '(') {stack.push(x);}
                else if (c == ')') {
                    while (((String) stack.peek()).charAt(0) != '(') {
                        queue.enq(stack.pop());
                    }
                    stack.pop();
                } else{
                    while (!stack.isEmpty() && priority(c) <= priority(((String) stack.peek()).charAt(0))) {
                        queue.enq(stack.pop());
                    }
                    stack.push(x);
                }
            }   
        } while (st.hasMoreTokens());
        
        // Get the postfix expression from what is in the queue
        String postfixExpression = getExpressionFromQueue(queue);
        return postfixExpression;
    }
    
    
    private int priority(char c) {
    /*
     * Determines priority of infix operators
    */
          
        if (c == '^') {return 3;} 
        else if (c == '*' || c == '/' || c == 'x') {return 2;} 
        else if (c == '+' || c == '-') {return 1;} 
        else {return 0;}
    }
    
    
    private String getExpressionFromQueue(Queue queue) {
    /*
     * Builds a string containing the postfix expression from queue
    */
        
        String expression = "";
        
        // Iterate over contents of queue and add elements to expression string,
        // separated by whitespace
        while (!queue.isEmpty()) {
            expression += queue.peek();
            expression += " ";
            queue.dnq();
        }
      
        return expression;  
    }
}