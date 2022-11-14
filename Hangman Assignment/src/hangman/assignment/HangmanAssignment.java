package hangman.assignment;

import java.util.Scanner;

/**
 *
 * @author Riley Chai
 */
public class HangmanAssignment {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        String secretWord;
        String p2Word = "";
        String p2Guess = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char restart;
        int numGuesses = 8;
        int wordLength;
        int findPos;
        int findPos2;
        boolean playAgain = true;
        
        Scanner scan = new Scanner(System.in);
         
        while(playAgain == true)//While the user wants to keep playing
        {   
            System.out.print("Player 1 please enter the secret word: ");
            secretWord = scan.nextLine();//Stores the user input in secretWord
            for(int clear = 0; clear < 50; clear++)//Clears the screen to hide the secret word
            {
                System.out.println("");
            } 
            wordLength = secretWord.length();//Finds the length of the secret word
            for(int i = 0; i < wordLength; i++)//For each letter in secret word add one dash to p2Word
            {
                p2Word = p2Word + "-";//Use concatenation to add dashes             
            }      
            while(secretWord.equals(p2Word) == false && numGuesses > 0)//While the user has not guessed the word AND still has guesses remaining
            {
                System.out.println("");//Separates the println statements
                hangmanFigures(numGuesses);//Displays the stick man figures
                System.out.println("");
                System.out.println(alphabet);
                System.out.println(p2Word);//Displays dash word
                System.out.println(numGuesses+" Guesses remaining");
                System.out.print("Player 2 please guess a letter: ");
                p2Guess = scan.nextLine();//Stores the user input in p2Guess
                findPos = secretWord.indexOf(p2Guess);//Checks if the letter guessed is in the secret word     
                findPos2 = alphabet.indexOf(p2Guess);//Checks if the letter has already been guessed
                    if(findPos >= 0 && findPos2 >= 0)//If the letter is in both secret word and the alphabet
                    {
                        System.out.println(p2Guess + " is one of the letters!");
                        findPos2 = alphabet.indexOf(p2Guess);//Finds the position of the guess
                        alphabet = alphabet.substring(0,findPos2++)+"/"+alphabet.substring(findPos2,alphabet.length());//Replaces the letter guessed in the alphabet with "/"
                        while(findPos >= 0)//Checks every letter in secret word to see if it matches with the guess
                        {
                            findPos = secretWord.indexOf(p2Guess, findPos);//Checks if the guess matches a letter in secretWord          
                            if(findPos >= 0)//If the guess matches a letter in secretWord
                            {
                            p2Word = p2Word.substring(0,findPos++)+p2Guess+p2Word.substring(findPos,secretWord.length());//Replaces the dashes with the letter guessed in the correct positions                        
                            findPos++;//Goes to check the next position
                            }                          
                        }
                    }
                else//If the guess is incorrect/same guess
                {               
                    System.out.println("Sorry "+p2Guess+" is not one of the letters.");
                    numGuesses--;//Subtract one from the guesss remaining   
                }                
            }
            if(secretWord.equals(p2Word) == true){//If player two guesses all the letters
                System.out.println("");
                System.out.println(p2Word);
                System.out.println("The Governor Called! You’re Saved!");//Tells player two that they have won    
                System.out.print("Would you like to play again? (y/n): ");//Asks the players if they want to play again
                restart = scan.nextLine().charAt(0);//detects if 'y' or 'n'
                if(restart == 'y')
                {
                    alphabet = "abcdefghijklmnopqrstuvwxyz";//Reset alphabet
                    numGuesses = 8;//Reset guesses
                    p2Word = "";//Reset p2Word
                }
                else
                {
                    playAgain = false;//Ends the game
                }
            }
            else//If player two ran out of guesses
            {
                System.out.println("");
                hangmanFigures(numGuesses);//Displays the stick man figures
                System.out.println("");
                System.out.println("Hangman!");
                System.out.println("Player 2 loses");//Tells player two that they lost
                System.out.println("The secret word was: "+secretWord);//Tells player two the secret word
                System.out.print("Would you like to play again? (y/n): ");
                restart = scan.nextLine().charAt(0);//detects if 'y' or 'n'
                if(restart == 'y')
                {
                    alphabet = "abcdefghijklmnopqrstuvwxyz";//Reset alphabet
                    numGuesses = 8;//Reset guesses
                    p2Word = "";//Reset p2Word
                }
                else
                {
                    playAgain = false;//Ends the game
                }
            }
        }
    }
public static void hangmanFigures(int numGuesses)
    {
        switch(numGuesses)//Displays the corresponding figure according to the amount of guesses remaining
        {
            case 7:
                System.out.println("  +---+");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break; 
            case 6:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break; 
            case 5:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 4:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 3:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 2:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 1:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" /    |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 0:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                System.out.println("      |");
                System.out.println("=========");
                break;
        }
    }       
}

