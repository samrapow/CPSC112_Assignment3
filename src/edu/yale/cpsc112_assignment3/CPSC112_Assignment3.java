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
    // Part 2 code goes here
		try 
		{
		int a = Integer.parseInt(input.substring(0,1));
		int b = Integer.parseInt(input.substring(1,2));
		int c = Integer.parseInt(input.substring(2,3));
		int d = Integer.parseInt(input.substring(3,4));
		  
		  if (input.length() != 4 || a == b || a == c || a  == d || b == c || b == d || c == d || a > 7 || b > 7 || c > 7 || d > 7 || a < 1|| b < 1 || c < 1 || d < 1)
		  {
			  System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
			  return false;
		  }
		  
		  else
		  {
			  return true;
		  }
		}
		catch (Exception e)
		{
			System.out.println("Input must be a 4-digit number with digits between 1 and 7.");
			  return false;
		}
  }

  public static boolean isGameOver(String input) {
    // Parts 3 and 4 code goes here
  }
}