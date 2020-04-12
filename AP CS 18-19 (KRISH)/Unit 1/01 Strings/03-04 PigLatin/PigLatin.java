//name:      date:  
import java.util.*;
import java.io.*;
public class PigLatin
{
   public static void main(String[] args) 
   {
      part_1_using_pig();
     //part_2_using_piglatenizeFile();
   }
   
   public static void part_1_using_pig()
   {
      Scanner sc = new Scanner(System.in);
      while(true)
      {
         System.out.print("\nWhat word? ");
         String s = sc.next();
         if (s.equals("-1")) 
            System.exit(0);
         String p = pig(s);
         System.out.println( p );
      }		
   }
   static String[] vowel  = "aeiouyAEIOUY".split("");   
   static String[] punct = ".,?!:;\"(){}{}<>".split("");
   public static String pig(String s)
   {
      
   }
      
   public static void part_2_using_piglatenizeFile() 
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("input filename including .txt: ");
      String fileNameIn = sc.next();
      System.out.print("output filename including .txt: ");
      String fileNameOut = sc.next();
      piglatenizeFile( fileNameIn, fileNameOut );
      System.out.println("Piglatin done!");
   }

/****************************** 
*  precondition:  both Strings include .txt
*  postcondition:  output a piglatinized .txt file 
******************************/
   public static void piglatenizeFile(String fileNameIn, String fileNameOut) 
   {
    /*  Enter your code here.  Try to preserve lines and paragraphs. ***/
   
   
   
   
   
      outfile.close();
      infile.close();
   }
}
