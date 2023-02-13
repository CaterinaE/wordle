package stacs.wordle;

import java.nio.file.Files;
import java.util.Scanner;
import java.nio.file.Path;

// Start Java Class
public class WordleApp {
  private final static String YELLOW = "\u001B[43m ";
  private final static String GREEN = "\u001B[42m";
  private final static String RESET = "\u001B[0m";
  // enter the letters
  private static Scanner input = new Scanner(System.in);
  static boolean winGame = false;
  static int attempted = 0;

  // getWordList method to get the file to use for the word list
  static String[] getWordList(String path) {

    try {

      Path fileName = Path.of(path);

      // turn to a string
      String s = Files.readString(fileName);

      // store all of the words in the word list
      String[] wordList = s.split("\\s+");

      // Return the word list
      return wordList;
    }

    // This will print out file and/or word not found error handling
    catch (Exception e) {

      System.out.println("Error file didnt load");

      return null;
    }
  }

  // getWord method will select a random word from the word list
  public static String getWord(String[] wordList) {

    int index = (int) (Math.random() * wordList.length);

    // stored in the wordList index
    String word = wordList[index];

    // Return the word
    return word;
  }

  



  // Declare the method attempt to allow the user to attempt a new word
  public static boolean attempt(String[][] gameBoard, String chosenWord, int attempt) {

    // Call printGameBoard to print the gameboard in terminal
    displayBoardGame(gameBoard);

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
  public static void displayBoardGame(String[][] gameBoard) {

    // begining of board
    for (int i = 0; i < gameBoard.length - 1; i++) {

      System.out.print("| ");

      // Print row i of the gameboard in terminal
      for (int j = 0; j < gameBoard[i].length; j++)
        System.out.print(gameBoard[i][j] + " ");

      System.out.println("|");
    }

  }

// game method to run the game
  public static void game() {

    // Take a random word from the word list to be guessed by the user
    String chosenWord = getWord(getWordList("/cs/home/ce57/Documents/wordle/src/test/resources/wordlist-test.txt"));

    // Will store the input of the guesses enter
    String[][] gameBoard = new String[6][5];

    // Fill the gameboard with temporary placeholders
    for (int i = 0; i < gameBoard.length; i++) {

      /// lines for the letters temp so there will be a board game
      for (int j = 0; j < gameBoard[i].length; j++)
        // will disappear when letters are displayed
        gameBoard[i][j] = "_";

    }

    // 6 attempts to win game
    while (!winGame && attempted < 6) {

      // whether they won or not to the variable userWon
      winGame = attempt(gameBoard, chosenWord, attempted);

      // added up the attempts
      attempted++;
    }

    // end the game, didnt win the game
    if (!winGame) {
      // End the game
      endGame(gameBoard, chosenWord, false);
    }
  }

 

  // Declare the method gameEnd to allow the program to end the game
  public static void endGame(String[][] gameBoard, String chosenWord, boolean win) {

    // will print board game squares
    displayBoardGame(gameBoard);

    // Redirect code based on if user won or not
    if (win) {

      //Display incorrect  and then show the correct word
      System.out.println("\nMagnificent correct word");

    }

    else {

      //Display incorrect  and then show the correct word
      System.out.println("\nIncorrect the word was " + chosenWord.toUpperCase());

    }

  }






  // Declare the Constructor that will run the first game
  public WordleApp() {

    game();
  }

  // will start the game
  public static void main(String[] args) {

    System.out.println("Welcome to CS5031 - Wordle\n");

    // getWordList("/cs/home/ce57/Documents/wordle/src/test/resources/wordlist-test.txt");

    // will run the first game
    WordleApp app = new WordleApp();

  }
}