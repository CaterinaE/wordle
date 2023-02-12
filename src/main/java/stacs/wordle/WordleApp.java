package stacs.wordle;

import java.nio.file.Files;
import java.util.Scanner;
import java.nio.file.Path;

// Start Java Class
public class WordleApp {
  private final String YELLOW = "\u001B[43m ";
  private final String GREEN = "\u001B[42m";
  private final String RESET = "\u001B[0m";
  // enter the letters
  private Scanner input = new Scanner(System.in); 
  boolean winGame = false;
  int attempted = 0;

  // word list
  // Declare the method getWordList to get the word list from the file "words.txt"
  static String[] getWordList(String path) {

    try {

      Path fileName = Path.of(path);
      
      // turn to a string
      String s = Files.readString(fileName);

       // store all of the words in the word list in
      String[] wordList = s.split("\\s+");

      // Return the word list
      return wordList;
    }

    /** This will print out file and/or word not found error handling */
    catch (Exception e) {

      System.out.println("Error file didnt load");

      return null;
    }
  }

  // Declare the method getWord to select a random word from the word list it is
  public static  String getWord(String[] wordList) {

    int index = (int) (Math.random() * wordList.length);

    // stored in the variable wordIndex
    String word = wordList[index];
    // Return the word stored in the variable word
    return word;
   }



  
  // Declare the method game to run the game
  private void game() {
    // Take a random word from the word list to be guessed by the user
    String chosenWord = getWord(getWordList("/cs/home/ce57/Documents/wordle/src/test/resources/wordlist-test.txt"));

    // Create a gameboard that stores all of the user's guesses and alerts them if
    // they are correct or wrong
    String[][] gameBoard = new String[6][5];

    // Fill the gameboard with temporary placeholders
    for (int i = 0; i < gameBoard.length; i++) {

      /// lines for the letters
      for (int j = 0; j < gameBoard[i].length; j++)
        gameBoard[i][j] = "5_|";

    }

    // 6 attempts to win game
    while (!winGame && attempted < 6) {
      // Give the user another attempt by calling the method attempt, and store
      // whether they won or not to the variable userWon
      winGame = attempt(gameBoard, chosenWord, attempted);

      // added up the attempts 
      attempted++;
    }

    // If the user did not win after 5 attempts, end the game
    if (!winGame) {
      // End the game
      endGame(gameBoard, chosenWord, false);
    }
  }


  // Declare the method attempt to allow the user to attempt a new word
  private boolean attempt(String[][] gameBoard, String chosenWord, int attempt) {

    // Call printGameBoard to print the gameboard in terminal
    printGameBoard(gameBoard);

    // Declare the variable loop to loop certain code
    boolean letword = true;

    // Loop a piece of code while the variable loop is set to true
    while (letword) {
      // Ask the user to input a five letter word

      System.out.print(chosenWord);

      // Declare the variable answer to store the user's input to the variable
      System.out.println("Type a 5 letter word:");
      String answer = input.nextLine();

      if (answer.length() > 5) {

        System.out.println("The word is more than five letters\n");
      }

      else if (answer.length() < 5) {

        System.out.println("The word less than five letters\n");

      }

      else if (answer.equals(chosenWord)) {

        // stores answers on board
        for (int i = 0; i < 5; i++)

          gameBoard[attempt][i] = GREEN + Character.toString(answer.charAt(i)).toUpperCase() + RESET;

        // End the game
        endGame(gameBoard, chosenWord, true);

        return true;
      }

      else {

        // If the variable answer's length is five letters and is not the chosen word,
        // check it against the word list to see if it is a valid word
        for (String word : getWordList("/cs/home/ce57/Documents/wordle/src/test/resources/wordlist-test.txt")) {
          // If the variable answer is in the word list, check all letters to see if they
          // are either in the word, and if they are in the correct spot if in the word.
        
          if (answer.equalsIgnoreCase(word)) {
            // Check all letters using a for loop to see if they are either in the word, and
            // if they are in the correct spot if in the word.

            for (int i = 0; i < 5; i++) {

              // Declare the variable letter to store the letter at variable i
              String letter = Character.toString(answer.charAt(i));

              // correct spot if in the word.


              if (letter.equals(chosenWord.substring(i, i + 1))) {
               
                // to the chosen word, color green and capatalize the variable letter
                letter = GREEN + letter.toUpperCase() + RESET;
              }
              
              else if (chosenWord.contains(letter)) {
                // If the variable letter is in the chosen word but is not in the same spot
                // compared to the chosen word, color yellow and capatalize the variable letter
                letter = YELLOW + letter.toUpperCase() + RESET;
              }
              
              else {
                // If the variable letter is not in the chosen word and is not in the same spot
                // compared to the chosen word, only capatalize the variable letter
                letter = letter.toUpperCase();
              }

              // Store the variable letter to the correct spot in the gameboard
              gameBoard[attempt][i] = letter;
            }

            // Return false to alert the program that the user did not win
            return false;
          }
        }

        // word not in list
        System.out.println("Word not found in word list!\n");

      }
    }

    return false;
  }

  // Declare the method printGameBoard to print the gameboard in the terminal
  private void printGameBoard(String[][] gameBoard) {

    // being of board
    for (int i = 0; i < gameBoard.length - 1; i++) {
      // Print "| " in terminal
      System.out.print("|");

      // Print row i of the gameboard in terminal
      for (int j = 0; j < gameBoard[i].length; j++)
        System.out.print(gameBoard[i][j] + " ");

      // Print "|" in terminal
      System.out.println("|");
    }

  }

  // Declare the method gameEnd to allow the program to end the game
  private void endGame(String[][] gameBoard, String chosenWord, boolean Winner) {

    // Call printGameBoard to print the gameboard in terminal
    printGameBoard(gameBoard);

    // Redirect code based on if user won or not
    if (Winner) {
      // If the user won, alert the user that they won
      System.out.println("\nMagnificent correct word");

    }

    else {

      // Print the chosen word in the terminal
      System.out.println("\nIncorrect the word was " + chosenWord.toUpperCase());

    }

  }

  // Declare the Constructor that will run the first game
  public WordleApp() {

    game();
  }

  // Declare the main method that the application will run on launch
  public static void main(String[] args) {

    System.out.println("Welcome to CS5031 - Wordle\n");

 
     //getWordList("/cs/home/ce57/Documents/wordle/src/test/resources/wordlist-test.txt");

    // Call the Constructor that will run the first game
    WordleApp app = new WordleApp();
  }

}