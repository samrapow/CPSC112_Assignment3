package edu.yale.cpsc112_assignment3;

import java.util.Random;

public class CPSC112_Assignment3 {

  public static String mySecret = "";
  public static boolean DEBUG = true;
  public static Random r = new Random();
  public static int highestGuessAtm = 0;
  public static int count = 0;
  public static int terminate = 0;
  public static int lie = 0;
  public static boolean canLie = true;
  public static boolean printLie = false;
  public static int lieSwitch = 0;
  
  public static void main(String[] args) {
    makeMySecret();
    isGameOver("1234");
    isGameOver("4562");
    isGameOver("2563");
    isGameOver("3456");
    isGameOver("4561");
    isGameOver("1234");
    isGameOver("4567");
    isGameOver("4765");
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
       System.out.println("Secret: " + mySecret);
    }
  }

  public static boolean isGuessValid(String input) {
     //Part 2 code goes here
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
	  int correctP = 0;
	  int common = 0;
	  lie = (r.nextInt(100) + 1);
	  int lieSpot = r.nextInt(2);
	  printLie = false;
	  
	 
	  if (terminate == 1)
	  {
		  return true;
	  }
	  if (isGuessValid(input) == false)
	  {
		  return false;
	  }
	  if (input == mySecret)
		  {
			  System.out.println("You won!");
			  terminate = 1;
			  return true;
		  }
	  if (count > 0 && Integer.parseInt(input) < highestGuessAtm && count >= 3 && Integer.parseInt(input) > Integer.parseInt(mySecret))
			
		{
			System.out.println("Your guess was lower than allowed.  You have 0 exceptions remaining.");
			System.out.println("You're out of exceptions and you've guessed too high!  The secret was " + mySecret + ".");
			terminate = 1;
			 return true;
		}
		  while (isGuessValid(input) != false || input != mySecret) 
		  {
			 for (int i = 0; i<=3; i++)
			 {
			  if (input.charAt(i) == mySecret.charAt(i))
			  {
				  correctP += 1;
			  }
			 }
			for (int i = 0; i<=3; i++)
			{
				int secret = mySecret.charAt(i);
				for (int j = 0; j<=3; j++)
				{
					int guess = input.charAt(j);
					if (secret == guess)
					{
						common += 1;
					}
				}
			}
			
			//Lie with 33% probability
			if (lieSpot == 0 && lie < 34 && canLie == true && DEBUG == true)
			{
				int notCommon = common;	
				common = (r.nextInt(4) + 1);
				while (correctP > common || common == notCommon)
				{
					common = (r.nextInt(4) + 1);
				}
				lieSwitch = 1;
				printLie = true;
				canLie = false;
			}
			if (lieSpot == 1 && lie < 34 && canLie == true && DEBUG == true)
			{	
				int notCorrectP = correctP;
				correctP = (r.nextInt(4) + 1);
				while (correctP == notCorrectP || correctP > common || (common == 4 && (correctP == 3 || correctP == 4)))
				{
					correctP = (r.nextInt(4) + 1);
				}
				lieSwitch = 1;
				printLie = true;
				canLie = false;
			}
			if (lie >= 34 || printLie == false)
			{
				canLie = true;
			}

			
			if (count > 0 && terminate != 1)
			{
				if (Integer.parseInt(input) < highestGuessAtm && count < 4)
				{
					System.out.println("Your guess was lower than allowed. You have " + (3-count) + " exceptions remaining.");
					count++;
					System.out.println("Guess: " + input + "; Result: " + common + "," + correctP);
					if (printLie == true && DEBUG == true)
					{
						System.out.println("Lie");
					}
					 return false;
					 
				}
				else if (Integer.parseInt(input) > Integer.parseInt(mySecret) && count > 3)
				{
					System.out.println("Your guess was lower than allowed.  You have 0 exceptions remaining.");
					System.out.println("You're out of exceptions and you've guessed too high! The secret was " + mySecret);
					return false;
				}
				else if (Integer.parseInt(input) < highestGuessAtm  && count > 3)
				{
					System.out.println("Your guess was lower than allowed.  You have 0 exceptions remaining.");
					System.out.println("Guess: " + input + "; Result: " + common + "," + correctP);
					if (printLie == true && DEBUG == true)
					{
						System.out.println("Lie");
					}
					 return false;
				}
				else if (Integer.parseInt(input) > highestGuessAtm )
				{
					System.out.println("Guess: " + input + "; Result: " + common + "," + correctP);
					if (printLie == true && DEBUG == true)
					{
						System.out.println("Lie");
					}
					highestGuessAtm = Integer.parseInt(input);
					 return false;
				}
				else
				{
					System.out.println("Guess: " + input + "; Result: " + common + "," + correctP);
					if (printLie == true && DEBUG == true)
					{
						System.out.println("Lie");
					}
					 return false;
				}
			}
			while (count == 0 && terminate != 1)
			{
				System.out.println("Guess: " + input + "; Result: " + common + "," + correctP);
				if (printLie == true && DEBUG == true)
				{
					System.out.println("Lie");
				}
				count++;
				highestGuessAtm = Integer.parseInt(input);
				return false;
			}
			return false;
		  }
		  return true;
  }
	  
  }