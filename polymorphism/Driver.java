/* 
Matthew Bourque
2/17/2014
Project 2

Algorithm:

  Read in customer information into data arrays
  For each customer:
      if account type is "Business"
          Create business account object
          interest rate = 0
          closing balance = opening balance + (opening balance * interest rate)
      if account type is "Checking"
          Create checking account object
          interest rate = 0.025
          closing balance = opening balance + (opening balance * interest rate)
      if account type is "Savings"
          Create savings account object
          if opening balance < $5,000
              interest rate = 0.04
          else
              interest rate = 0.05
          closing balance = opening balance + (opening balance * interest rate)
  Write information including closing balance to output file

Purpose:  

  This program produces a monthly statement showing closing balances for a set 
  of bank accounts.  Interest gained depends on the type of account; Business 
  accounts gain no interest, Checking accounts gain 2.5% interest, and savings 
  account gain 4% or 5% interest if the starting balance is less than or 
  greater than (or equal to) $5000, respectively.  Interest gained is added 
  to the opening balance in order to calculate a closing balance.  Data is
  writting to the output file "accounts.dat".
*/

class driver {
  
    public static void main(String[] args) { 
    
        // Read in data
        FileIO fileObj = new FileIO();
        String data = fileObj.readFile("bank.dat");
        
        // Create and populate an array of Account objects
        Account[] accounts = new Account[7];
        accounts = createAccounts(data, accounts);
        
        // Write data to output file
        fileObj.writeFile(accounts, "accounts.dat");
    }
    
    public static Account[] createAccounts(String data, Account[] accounts) {
        /* 
         * Parses data from input file and populates accounts array with
         * account objects based on accountType.
        */
        
        // Parse data into arrays
        String[] lines = data.split("\\n");
        String[] names = new String[7];
        String[] accountNumbers = new String[7];
        String[] phoneNumbers = new String[7];
        String[] ssns = new String[7];
        Double[] openBalances = new Double[7];
        String[] accountTypes = new String[7];
        for(int i=0; i<lines.length; i++) {
            String[] parts = lines[i].split("\\s+");
            names[i] = parts[0];
            accountNumbers[i] = parts[1];
            phoneNumbers[i] = parts[2];
            ssns[i] = parts[3];
            openBalances[i] = Double.parseDouble(parts[4]);
            accountTypes[i] = parts[5];
        }  
        
        // For each line of data, create account object based on accountType
        // and calculate the interest
        for(int i=0; i<lines.length; i++) {
            if (accountTypes[i].equals("B")) {
                accounts[i] = new BusinessAccount(names[i], accountNumbers[i], phoneNumbers[i], ssns[i], openBalances[i], accountTypes[i]);
                accounts[i].calculateInterest();
            } else if (accountTypes[i].equals("C")) {
                accounts[i] = new CheckingAccount(names[i], accountNumbers[i], phoneNumbers[i], ssns[i], openBalances[i], accountTypes[i]);
                accounts[i].calculateInterest();
            } else if (accountTypes[i].equals("S")) {
                accounts[i] = new SavingsAccount(names[i], accountNumbers[i], phoneNumbers[i], ssns[i], openBalances[i], accountTypes[i]);
                accounts[i].calculateInterest();
            }
        }
        
        return accounts;
    }
}