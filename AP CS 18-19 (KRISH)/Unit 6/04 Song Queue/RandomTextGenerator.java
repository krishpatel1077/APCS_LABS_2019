import java.util.Random;
import java.io.*;
public class RandomTextGenerator {
   public static void main (String[] args) throws Exception {
      PrintWriter out = new PrintWriter(new FileWriter("bigboi.txt"));

         Random r = new Random();
      
         String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏĞÑÒÓÔÕÖØÙÚÛÜİŞßàáâãäåæçèéêëìíîïğ1234567890!@#$%^&*(){}|[]:',.<>/?";
         for (int z = 0; z < 1000000; z++) {
            out.print(alphabet.charAt(r.nextInt(alphabet.length())));
         }
      
      out.close();
   }
}