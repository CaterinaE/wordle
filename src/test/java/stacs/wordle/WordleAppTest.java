package stacs.wordle;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;

public class WordleAppTest {



  @Test
public   void  loadWordlist() throws FileNotFoundException { 

   String[]  wordlist = WordleApp.getWordList("src/test/resources/wordlist-test.txt");
 assertEquals(3, wordlist.length);
  
}


 





 


 
}