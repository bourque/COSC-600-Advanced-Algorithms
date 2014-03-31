import java.util.*;
import java.io.*;

class FileIO {
    /*
     * A class for file input/output
    */
  
    public String readFile(String inputFile) {
        /*
         * Reads in data from input file
        */
        
        String data = "";
        try {
            data = new Scanner(new File(inputFile)).useDelimiter("\\Z").next();
        } catch(Exception e) {
            System.out.println("Error " + e.toString());
        }
        
        return data;
    }
    
    public void writeFile(Account[] accounts, String outputFile) {
        /*
         * Writes account information to output file
        */
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(String.format("%s\t%s\t%s\t%s\t%s%n",
                                       "Name",
                                       "Account Number",
                                       "Phone Number",
                                       "Opening Balace",
                                       "Closing Balance"));
            for(int i=0; i<accounts.length; i++){
                writer.write(String.format("%5s%10s%10s%10s%10s%n",
                                           accounts[i].name,
                                           accounts[i].accountNumber,
                                           accounts[i].phoneNumber,
                                           accounts[i].openBalance,
                                           accounts[i].closeBalance));
            }
        writer.close();
        } catch(Exception e) {
            System.out.println("Error " + e.toString());
        }            
    }
}