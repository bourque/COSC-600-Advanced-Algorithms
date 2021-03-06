public class BusinessAccount extends Account {
    /*
     * A class to calculate the closing balance for a business account
    */ 
  
    public BusinessAccount(String Name, String AccountNumber, String PhoneNumber, String SSN, double OpenBalance, String AccountType) {
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
        
        double interestRate = 0.0;
        closeBalance = openBalance + (openBalance * interestRate);
    }
}
