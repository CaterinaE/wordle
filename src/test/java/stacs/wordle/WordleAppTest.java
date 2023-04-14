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


}