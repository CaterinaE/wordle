package stacs.wordle;
import java.nio.file.Files;
import java.util.Scanner;
import java.nio.file.Path;
/**
 * This is an exercise for Practical 1, will print out a board game with 5 letter  word to enter to start the game
 * @author 220026574
 */
public class WordleApp {
  //the letter colors for the game
  private final static String YELLOW = "\u001B[43m ";
  private final static String GREEN = "\u001B[42m";
  private final static String RESET = "\u001B[0m";

  // enter the letters
  private static Scanner input = new Scanner(System.in);
  static boolean winGame = false;
  static int attempted = 0;
  static boolean letword = true;

  // getWordList method to get the file to use for the word list
  static String[] getWordList(String path) {

    try {
       //this  is the path of the text file 
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

  



  // The attempt method will allow user to guess a new word
  public static boolean getAttempt(String[][] boardGame, String chosenWord, int attempt) {

    displayBoardGame(boardGame);

      System.out.print(chosenWord);

    while (letword) {
 
      //The user will enter 5 letters
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

          boardGame[attempt][i] = GREEN + Character.toString(answer.charAt(i)).toUpperCase() + RESET;

        // End the game
        endGame(boardGame, chosenWord, true);

        return true;
      }

      else {

        // When the answer's length is five letters and is not the chosen word in the list
        for (String word : getWordList("/cs/home/ce57/Documents/wordle/src/test/resources/wordlist-test.txt")) {

          // If the variable answer is in the word list, check all letters to see if they
          // are either in the word, and if they are in the correct spot if in the word.
          if (answer.equalsIgnoreCase(word)) {
            // Check all letters using a for loop to see if they are either in the word, and

            // if they are in the correct spot if in the word.

            for (int i = 0; i < 5; i++) {

              // store the letter at var i
              String letter = Character.toString(answer.charAt(i));

              // correct spot if in the word.
              if (letter.equals(chosenWord.substring(i, i + 1))) {

                //the chosen word green and capatalizein the game board
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

              // Store the variable letter to the correct spot in the boardGame
              boardGame[attempt][i] = letter;
            }

            // return false whenn the user didnt win
            return false;
          }
        }

        // word not in list
        System.out.println("Word not found in word list!\n");

      }
    }

    return false;
  }






  //  displayBoardGame
  public static void displayBoardGame(String[][] boardGame) {

    // begining of board
    for (int i = 0; i < boardGame.length - 1; i++) {

      System.out.print("| ");

      // Will print the row i of the boardGame to the terminal, leaves the space
      for (int j = 0; j < boardGame[i].length; j++)
        System.out.print(boardGame[i][j] + " ");

      System.out.println("|");
    }

  }



// game method to run the game
  public static void game() {

    // Take a random word from the word list to be guessed by the user
    String chosenWord = getWord(getWordList("/cs/home/ce57/Documents/wordle/src/test/resources/wordlist-test.txt"));

    // Will store the input of the guesses enter
    String[][] boardGame = new String[6][5];

    // This will fill the boardGame with temporary placeholders before the game is played this is done for the look of the board
    for (int i = 0; i < boardGame.length; i++) {

      /// lines for the letters temp so there will be a board game
      for (int j = 0; j < boardGame[i].length; j++)
        
      // will disappear when letters are displayed
        boardGame[i][j] = "_";

    }

    // 6 attempts to win game
    while (!winGame && attempted < 6) {

      // when the user won the win or not
      winGame = getAttempt(boardGame, chosenWord, attempted);

      // added up the attempts
      attempted++;
    }

    // end the game, didnt win the game
    if (!winGame) {
      // End the game
      endGame(boardGame, chosenWord, false);
    }
  }

 

  //allow to end the game
  public static void endGame(String[][] boardGame, String chosenWord, boolean winGame) {

    // will print board game squares
    displayBoardGame(boardGame);

    // if they win the game print this
    if (winGame) {

      //Display incorrect  and then show the correct word
      System.out.println("\nMagnificent correct word");

    }

    else {

      //Display incorrect and then show the correct word
      System.out.println("\nIncorrect the word was " + chosenWord.toUpperCase());

    }

  }




  //Will run the first game
  public WordleApp() {

    game();
  }
/** This will his is the string to print out the words  and the words if they are in the text document
* @param args 
 *will start the game
 */
  public static void main(String[] args) {

    System.out.println("Welcome to CS5031 - Wordle\n");
    getWordList("/cs/home/ce57/Documents/wordle/src/test/resources/wordlist-test.txt");
    // will run the first game
    WordleApp app = new WordleApp();

  }
}