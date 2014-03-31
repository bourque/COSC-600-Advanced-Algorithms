/* 
Matthew Bourque
2/8/2014
Project 1

Algorithm:

    Read in scores from "scores.dat" file
    sum = sum of all scores
    mean = sum / # of scores
    For each score:
      if score > mean + mean*10%
        grade = "O"
      else if score < mean - mean*10%
        grade = "U"
      else
        grade = "S"
    Write scores and grades to output file ("grades.dat")

Purpose:

    This program is used to determine the grades associated with a set of 
    test scores. The grades are assigned as follows:
        O (Outstaning) if the score is at least 10% above average
        S (Satisfactory) if the score is within 10% of the average
        U (Unsatisfactory) if the score is 10% or more below the average

    Test scores are read in from the file "scores.dat", and the scores with
    their final grades are written to the file "grades.dat".
*/

import java.util.*;
import java.io.*;

class Driver {
  public static void main(String args[]){
    // Main method
    int[] scores = readScores();
    double mean = computeMean(scores);
    char[] grades = computeGrades(scores, mean);
    writeGrades(scores, grades, mean);
  }
  
  public static int[] readScores(){
    // Read in scores from file and save to an array
    int[] scores = new int[10];
    int i = 0;
    try {
      Scanner scanner = new Scanner(new File("scores.dat"));
      while(scanner.hasNextInt()) {
        scores[i++] = scanner.nextInt();
      }
    } catch(Exception e) {
      System.out.println("Error " + e.toString());
    }
    return scores;
  }
  
  public static double computeMean(int[] scores){
    // Calculate mean of all scores
    double sum = 0.0;
    for(int i=0; i<scores.length; i++){
      sum += scores[i];
    }
    double mean = sum / scores.length;
    return mean;
  }
  
  public static char[] computeGrades(int[] scores, double mean){
    // Detemine the letter grade for each score
    char[] grades = new char[10];
    AssignGrade assignObj = new AssignGrade(); 
    for(int i=0; i<scores.length; i++){
      grades[i] = assignObj.assign(scores[i], mean);
    }
    return grades;
  }
  
  public static void writeGrades(int[] scores, char[] grades, double mean){
    // For each score, assign a grade and write to output
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("grades.dat"));
      writer.write("Score\tGrade\n");
      for(int i=0; i<scores.length; i++){
        writer.write(scores[i] + "\t" + grades[i] + "\n");
      }
      writer.close();
    } catch(Exception e) {
      System.out.println("Error " + e.toString());
    }    
  }
}


class AssignGrade {
  public char assign(int score, double mean){
    // Assign a letter grade (O, S, or U) based on score relative to mean
    if (score > mean + mean*0.10)
      return 'O';
    else if (score < mean - mean*0.10)
      return 'U';
    else
      return 'S';
  }
}