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
public void testDisplayBoardGame() {
String[][] boardGame = new String[6][5];
boardGame[0][0] = "C";
boardGame[0][1] = "A";
boardGame[0][2] = "C";
boardGame[0][3] = "H";
boardGame[0][4] = "E";
String expected = "CACHE";
ByteArrayOutputStream outContent = new ByteArrayOutputStream();
System.setOut(new PrintStream(outContent));
WordleApp.displayBoardGame(boardGame);
String result = outContent.toString();
assertEquals(expected, result);
}

}