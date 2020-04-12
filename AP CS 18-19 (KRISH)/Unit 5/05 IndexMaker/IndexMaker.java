// Name: R2-17
// Date: 12/13/18

import java.io.*;
import java.util.*;

/**
 * Program takes a text file then creates an index (by line numbers)
 * for all the words in the file.
 * Writes the index into output file.
 * Program prompts user for file names.
 */  
public class IndexMaker
{
   public static void main(String[] args) throws IOException
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("\nEnter input file name: ");
      String inFileName = keyboard.nextLine().trim();
      Scanner inputFile = new Scanner(new File(inFileName));
      String outFileName = "fishIndex.txt";
      PrintWriter outputFile = new PrintWriter(new FileWriter(outFileName));
      indexDocument(inputFile, outputFile);
      inputFile.close(); 						
      outputFile.close();
      System.out.println("Done.");
   }
   
   public static void indexDocument(Scanner inputFile, PrintWriter outputFile)
   {
      DocumentIndex index = new DocumentIndex();
      String line = null;
      int lineNum = 0;
      while(inputFile.hasNextLine())
      {
         lineNum++;
         index.addAllWords(inputFile.nextLine(), lineNum);
      }
      for(IndexEntry entry : index)
         outputFile.println(entry);
   }   
}

class DocumentIndex extends ArrayList<IndexEntry>
{
    //constructors
   public DocumentIndex(){
      super();
   }
   public DocumentIndex(int i){
      super(i);
   }
   /**
    * Calls foundOrInserted, which returns an index.
    * At that position, updates that IndexEntry's 
    * list of line numbers with num.   
    */
   public void addWord(String word, int num)
   {
      get(foundOrInserted(word)).add(num);
   }
      
   /**
    * Extracts all words from str, skipping 
    * punctuation and whitespace.
    * For each word calls addWord(word, num).
    * Use split with punct = ",./;:'\"?<>[]{}|`~!@#$%^&*()" 
    */
   public void addAllWords(String str, int num) 
   {
      String[] arr = str.split("[,./;:'\"?<>{}|`~!@#$%^&*()]");
      for (int i = 0; i < arr.length; i++){
         addWord(arr[i], i);
      }
   }
      
   /** 
    * Traverses this DocumentIndex comparing word to the words in the 
    * IndexEntry objects in list, looking for correct position of word. 
    * If an IndexEntry with word is not already in that position, the 
    * method creates and inserts a new IndexEntry at that position. 
    * @return position of either the found or the inserted IndexEntry.
    */
   private int foundOrInserted(String word)
   {
      
   }
}
   
class IndexEntry implements Comparable<IndexEntry>
{
   //fields
   private String word;
   private ArrayList<Integer> numsList;
   //constructors
   public IndexEntry(String w){
      word = w.toUpperCase();
      numsList = new ArrayList<Integer> ();
   }
   
   
   /** 
    * Appends num to numList but only if not already in list. 
    */
   public void add(int num)
   {
      Integer adder = (Integer) num;
      if (numsList.contains(adder)){
      
      }
      else {
         numsList.add(adder);
      }
   }
      
   public String getWord()
   {
      return word;
   }
      
   public String toString()
   {
      return word.toUpperCase() + numsList.toString();
   }
}

