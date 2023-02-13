package stacs.wordle;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.text.Normalizer.Form;

import static org.junit.jupiter.api.Assertions.*;

public class WordleAppTest {

  @Test
  public void loadWordlist() throws FileNotFoundException {

    String[] wordlist = WordleApp.getWordList("src/test/resources/wordlist-test.txt");
    assertEquals(3, wordlist.length);

  }

  @Test
  public void shouldGetWordList() throws FileNotFoundException {

    String[] wordlist = WordleApp.getWordList("src/test/resources/wordlist-test.txt");

      
    assertNotNull(wordlist);
  }


  @Test
  public void shouldGetRamdomWord() throws FileNotFoundException {

    String[] wordlist = WordleApp.getWordList("src/test/resources/wordlist-test.txt");

    String word = WordleApp.getWord(wordlist);

    assertEquals(5, word.length());
  }


  

  @Test
  public void shouldGetWord() throws FileNotFoundException {

    String[] wordlist = WordleApp.getWordList("src/test/resources/wordlist-test.txt");

    String word = WordleApp.getWord(wordlist);

    assertNotNull(word );
  } 

  @Test
  public void testGetAttemptWithWinningAnswer() {
    String[][] boardGame = new String[6][5];
    String chosenWord = "apple";
    int attempt = 0;
    boolean result = WordleApp.getAttempt(boardGame, chosenWord, attempt);
    assertTrue(result);
    assertEquals(GREEN + "A" + RESET, boardGame[attempt][0]);
    assertEquals(GREEN + "P" + RESET, boardGame[attempt][1]);
    assertEquals(GREEN + "P" + RESET, boardGame[attempt][2]);
    assertEquals(GREEN + "L" + RESET, boardGame[attempt][3]);
    assertEquals(GREEN + "E" + RESET, boardGame[attempt][4]);
  }
 

  
}
