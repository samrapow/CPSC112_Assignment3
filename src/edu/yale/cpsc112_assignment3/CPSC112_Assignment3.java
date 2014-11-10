package edu.yale.cpsc112_assignment3;

import java.util.Random;

public class CPSC112_Assignment3 {

  public static String mySecret = "";
  public static boolean DEBUG = true;
  public static Random r = new Random();

  public static void main(String[] args) {
    makeMySecret();
    isGameOver("1234");
    isGameOver("4321");
    isGameOver("2567");
    isGameOver("1432");
  }

  public static void makeMySecret() {
     // Part 1 code goes here (please leave the next few lines at the end of the makeMySecret method)
	  int i = 0,j = 0,k = 0,l = 0;
	  i = r.nextInt(7)+1;
	  j = r.nextInt(7)+1;
	  k = r.nextInt(7)+1;
	  l = r.nextInt(7)+1;
	  while (j == i){
	  j = r.nextInt(7)+1;
	  }
	  while (k == i || k ==j){
	  k = r.nextInt(7)+1;
	  }
	  while (l == i || l == j || l == k){
	  l = r.nextInt(7)+1;
	  }
	  mySecret = "" + i + j + k + l;
    if (DEBUG)
    {
       System.out.println(mySecret);
    }
  }

  public static boolean isGuessValid(String input) {
     //Part 2 code goes here
	  if (input.length() != 4 || input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(0)  == input.charAt(3) || input.charAt(1) == input.charAt(2) || input.charAt(1) == input.charAt(3) || input.charAt(2) == input.charAt(3))
	  {
		  System.out.println("Input must be a 4-digit number with digits between 1 and 7");
		  return false;
	  }
	  else
	  {
		  return true;
	  }
  }

  public static boolean isGameOver(String input) {
    // Parts 3 and 4 code goes here
	  
  }
}