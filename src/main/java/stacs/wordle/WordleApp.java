package stacs.wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;


public class WordleApp {
/**
 * This is an exercise for Practical 1, will print out a word count of the words  and show the words being counted from a text file.
 * @author 220026574
 */


    public static void main( String[] args ) {

        
        System.out.println("Welcome to CS5031 - Wordle");
    }


File textFile = new File("src/test/resources/wordlist-test.txt");
            Scanner input  = new Scanner(System.in);
   
   
            // Unimplemented skeleton
    // You may refactor this method
    protected static ArrayList<String> loadWordlist(String wordlistPath) throws FileNotFoundException { 
    
ArrayList<String> wordlist = loadWordlist("src/test/resources/wordlist-test.txt");

        return new ArrayList<String>();
        for(int index=0; index<wordlist.length; index++){
            System.out.println(wordlist.get(index));
            //
        }
        
    }
}
