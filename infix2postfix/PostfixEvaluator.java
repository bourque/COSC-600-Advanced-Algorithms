import java.util.StringTokenizer;

public class PostfixEvaluator {

  
    public double evaluate(String expression) {
    /*
     * Evaluates a postfix expression and returns the result
    */
     
        // Initialize empty stack and queue
        Stack stack = new Stack();
        Queue queue = new Queue();
        
        // Initialze result variable
        double result = 0.0;
        
        // Split the expression into tokens by operators and whitespaces
        StringTokenizer st = new StringTokenizer(expression, "+-*x/^() ", true);
        
        while (st.hasMoreTokens()) {
          
            // Grab the token, and find the first character in it
            String x = st.nextToken();
            char c = x.charAt(0);
            
            // Ignore spaces
            if (!x.equals(" ")) {
        
                // Push any number to stack
                if (Character.isDigit(c)) {
                    stack.push(x);
            
                // Perform operations when needed
                } else {
                    double top = Double.parseDouble(String.valueOf(stack.pop()));
                    double next = Double.parseDouble(String.valueOf(stack.pop()));
                    result = calculateOperation(next, top, c);
                    stack.push(result);
                } 
            }
        }
    
        return result;
    }
    
    
    public double calculateOperation(double a, double b, char x) {
    /*
     * Performs the appropriate mathematical operation depending on operator 'x'
    */
      
        switch(x) {
          
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case 'x':
                return a * b;
            case '/':
                return a / b;
            case '^':
                return (int) Math.pow(a,b);
            default:
                System.out.println("Invalid operation.");
                return 0.0;   
        }    
    }
}