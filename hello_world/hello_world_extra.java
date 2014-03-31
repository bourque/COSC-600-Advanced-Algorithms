/* Matthew Bourque
 * Project 0
 * 
 * This program prints "Hello, Towson" and "How are you today?" to the screen.
 * It also tests out some basic Java commands.
*/

import java.util.*;
import java.io.*;

class hellotowson 
{  
  
  public static void main(String[] args) 
  { 
    System.out.println("Hello, Towson");
    howAreYou();
    
    String forcastFile = "forcast.dat";
    forcast(forcastFile);
    
    int endCount = countToTen();
    System.out.println(endCount);
 
  }  
  
  
  public static void howAreYou()
  {
    // Ask "How are you?"
    System.out.println("How are you today?");
    Scanner keyboard = new Scanner(System.in);
    String answer = keyboard.nextLine();
    if (answer.equals("good"))
      System.out.println(":)");
    else if(answer.equals("bad"))
      System.out.println(":(");
    else
      System.out.println("Alrighty then.");
  }
  
  
  public static void forcast(String inputFile)
  {
    // Read in forcast from forcast.dat
    System.out.println("\nToday's forcast is: ");
    try {
      Scanner sc = new Scanner(new File(inputFile));
      while(sc.hasNext()) {
        String OneLine = sc.next();
        System.out.println(OneLine);
      }
    } catch(Exception e) {
      System.out.println("Error " + e.toString());
    }
    
    // Print what tomorrow's forcast is
    double temperature = 40.5;
    String weather = "Sunny";
    System.out.printf("Tomorrow's forcast is %s and %3.1f\n",weather,temperature);
  }

  
  public static int countToTen()
  {
    int count = 0;
    for(int i=0; i<=10; i++)
      count = i;
    return count;
  }

}