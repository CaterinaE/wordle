package stacs.wordle;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.text.Normalizer.Form;

import static org.junit.jupiter.api.Assertions.*;

public class WordleAppTest {

 //testing if the words are in the file
  @Test
  public void loadWordlist() throws FileNotFoundException {

    String[] wordlist = WordleApp.getWordList("src/test/resources/wordlist-test.txt");
    assertEquals(3, wordlist.length);

  }

   //testing file cant be null
  @Test
  public void shouldGetWordListFile() throws FileNotFoundException {

    String[] wordlist = WordleApp.getWordList("src/test/resources/wordlist-test.txt");

      
    assertNotNull(wordlist);
  }

 //testing word is 5 letters
  @Test
  public void shouldGetRamdomWord() throws FileNotFoundException {

    String[] wordlist = WordleApp.getWordList("src/test/resources/wordlist-test.txt");

    String word = WordleApp.getWord(wordlist);

    assertEquals(5, word.length());
  }

  
  //testing word cant be null
  @Test
  public void shouldGetWord() throws FileNotFoundException {

    String[] wordlist = WordleApp.getWordList("src/test/resources/wordlist-test.txt");

    String word = WordleApp.getWord(wordlist);
    
    assertNotNull(word);
  } 
@Test
public void testChosenWord() {


    String chosenWord = WordleApp.getWord(WordleApp.getWordList("src/test/resources/wordlist-test.txt"));
    assertNotNull(chosenWord);
}

  //tried test cases for this but the terminall would freeze
  /*@Test
public void testDisplayBoardGame() {
String[][] boardGame = new String[6][5];
boardGame[0][1] = "C";
boardGame[0][2] = "A";
boardGame[0][3] = "C";
boardGame[0][4] = "H";
boardGame[0][5] = "E";
String expected = "CACHE";
String result = WordleApp.displayBoardGame(boardGame);
 
 assertTrue(expected, result.length());
}

@Test
public void testDisplayBoardGame() {
    WordleApp wordle = new WordleApp();
    String[][] boardGame = new String[6][5];
    for (int i = 0; i < boardGame.length; i++) {
        for (int j = 0; j < boardGame[i].length; j++)
            boardGame[i][j] = "_";
    }
    WordleApp.displayBoardGame(boardGame);
    assertNotNull(boardGame);
}*/

}