package stacs.wordle;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class WordleAppTest {

  @Test
  public void loadWordlist() throws FileNotFoundException {

    String[] wordlist = WordleApp.getWordList("src/test/resources/wordlist-test.txt");
    assertEquals(3, wordlist.length);

  }

  @Test
  public void shouldGetRamdomWord() throws FileNotFoundException {

    String[] wordlist = WordleApp.getWordList("src/test/resources/wordlist-test.txt");

    String word = WordleApp.getWord(wordlist);

    assertEquals(5, word.length());
  }


  @Test
  public void shouldGetWordList() throws FileNotFoundException {

    String[] wordlist = WordleApp.getWordList("src/test/resources/wordlist-test.txt");

      
    assertNotNull(wordlist );
  }


  @Test
  public void shouldGetWord() throws FileNotFoundException {

    String[] wordlist = WordleApp.getWordList("src/test/resources/wordlist-test.txt");

    String word = WordleApp.getWord(wordlist);

    assertNotNull(word );
  }

 

 
}
