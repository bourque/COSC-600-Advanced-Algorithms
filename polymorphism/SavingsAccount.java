public class SavingsAccount extends Account {
    /*
     * A class to calculate the closing balance for a savings account
    */ 
  
    public SavingsAccount(String Name, String AccountNumber, String PhoneNumber, String SSN, double OpenBalance, String AccountType) {
        /*
         * Constructor to initialize variables
        */
    
        name = Name;
        accountNumber = AccountNumber;
        phoneNumber = PhoneNumber;
        ssn = SSN;
        openBalance = OpenBalance;
        accountType = AccountType;
    }
    
    public void calculateInterest() {
        /*
         * Calculates the closing balance based on interest rate
        */
        
        double interestRate;

        if (openBalance < 5000.00) {
            interestRate = 0.04;
        } else {   
            interestRate = 0.05;
        }

        closeBalance = openBalance + (openBalance * interestRate);
    }
}