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
       try {
        ArrayList<String> wordlist = loadWordlist("/cs/home/ce57/wordlist-test.txt"); //change to file location
        for(int index=0; index<wordlist.size(); index++){
            System.out.println(wordlist.get(index));
            //
        }
        String chosenWord = wordlist.get(((int) (Math.random()*wordlist.size())));
        System.out.println("chosenWord "+chosenWord);
       } catch (Exception e) {
        System.out.println("hi");// TODO: handle exception
       }
    }



   
   
            // Unimplemented skeleton
    // You may refactor this method
    protected static ArrayList<String> loadWordlist(String wordlistPath) throws FileNotFoundException { 
    
        ArrayList<String> listOfWords = new ArrayList<>();
        File textFile = new File(wordlistPath);
        Scanner input  = new Scanner(textFile);
        while (input.hasNextLine()) {

            String line = input.nextLine();
            listOfWords.add(line);

        }

        
        return listOfWords;
       
        
    }
}
