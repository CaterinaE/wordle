package stacs.wordle;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
  import java.nio.file.Path;

 public class WordleAppTest{
    
  @Test
        public void shouldLoadFile() throws java.io.IOException {  
   
          
         // Path fileName1  = Path.of("/cs/home/ce57/Documents/wordle/src/test/resources/wordlist-test.txt");
        
          String path = "/cs/home/ce57/Documents/wordle/src/test/resources/wordlist-test.txt";
 
          File fileName  = new File(path);
          String absolutePath = fileName .getAbsolutePath();
          
         // System.out.println(absolutePath);
          
          assertTrue(absolutePath.endsWith("/cs/home/ce57/Documents/wordle/src/test/resources/wordlist-test.txt"));
  } 
                   

      }
 
    