/* 
Matthew Bourque
4/5/14
Project 5

Algorithm:
        

Purpose:
*/

class Driver {

  
    public static void main(String args[]) {
    /*
     * The main method.
    */
      
    try {
          
        listCommands();
            
        // Read in command from user
        BufferedReader inputData = new BufferedReader(new InputStreamReader(System.in));
        String line = inputData.readLine();
        CommandParser cp = new CommandParser();
        
        while (!line.equals("done")) {
          
            switch (line) {
              
              case "option1":
                  cp.method1
                  break;
              case "option2":
                  cp.method2
                  break;
                  
            System.out.println("Enter another command:");
            line = inputData.readLine();
        
    }
    
    
    public static ArrayList<Integer> getSequence() {
        /*
         * Reads in sequence of integers from keyboard
        */
    
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a sequence of integers. Enter 'q' to quit.");
        while (keyboard.hasNextInt()) {
            sequence.add(keyboard.nextInt());
        }
        
        return sequence;
    }
    
    
    public static void listCommands() {
    /*
     * Lists commands for user
    */
      
    System.out.print("Commands");

}