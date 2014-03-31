class Account {
    /*
     * A class to calculate the closing balance for a bank account
    */ 

    public String name;
    public String accountNumber;
    public String phoneNumber;
    public String ssn;
    public double openBalance;
    public String accountType;
    public double interestRate;
    public double closeBalance;
    
    public Account() {}
    
    public Account(String Name, String AccountNumber, String PhoneNumber, String SSN, double OpenBalance, String AccountType) {
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