// Name: R2-17
// Date: 3/12/2019

import java.io.*;
import java.util.*;

public class Dictionary
{
   public static void main(String[] args) 
   {
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File("spanglish.txt"));
         System.setOut(new PrintStream(new FileOutputStream("dictionaryOutput.txt")));
      }
      catch(Exception e)
      {
      }
      
      Map<String, Set<String>> eng2spn = makeDictionary( infile );
      System.out.println("ENGLISH TO SPANISH");
      display(eng2spn);
   
      Map<String, Set<String>> spn2eng = reverse(eng2spn);
      System.out.println();
      System.out.println("SPANISH TO ENGLISH");
      display(spn2eng);
   }
   
   public static Map<String, Set<String>> makeDictionary(Scanner infile)
   {
      Map<String, Set<String>> dict = new TreeMap<String, Set<String>> ();
      Set<String> spanish = new TreeSet<String> ();
      while (infile.hasNextLine())
      {
         add(dict, infile.nextLine(), infile.nextLine());
      }
      return dict;
   }
   
   public static void add(Map<String, Set<String>> dictionary, String word, String translation)
   { 
      Set<String> trans = new TreeSet<String> ();
      while (!dictionary.containsKey(word))
         dictionary.put(word, trans);
      trans.add(translation);
   }
   
   public static void display(Map<String, Set<String>> m)
   {
      for (String s : m.keySet())
      {
         System.out.println(s + m.get(s));
      }
   }
   
   public static Map<String, Set<String>> reverse(Map<String, Set<String>> dictionary)
   {
      Map<String, Set<String>> rev = new TreeMap<String, Set<String>> ();
      for (String s : dictionary.keySet())
      {
         Set<String> set = dictionary.get(s);
         for (String str : set)
         {
            add(rev, str, s);
         }
      }
      return rev;
   }
}


   /********************
	INPUT:
   	holiday
		fiesta
		holiday
		vacaciones
		party
		fiesta
		celebration
		fiesta
     <etc.>
  *********************************** 
	OUTPUT:
		ENGLISH TO SPANISH
			banana [banana]
			celebration [fiesta]
			computer [computadora, ordenador]
			double [doblar, doble, duplicar]
			father [padre]
			feast [fiesta]
			good [bueno]
			hand [mano]
			hello [hola]
			holiday [fiesta, vacaciones]
			party [fiesta]
			plaza [plaza]
			priest [padre]
			program [programa, programar]
			sleep [dormir]
			son [hijo]
			sun [sol]
			vacation [vacaciones]

		SPANISH TO ENGLISH
			banana [banana]
			bueno [good]
			computadora [computer]
			doblar [double]
			doble [double]
			dormir [sleep]
			duplicar [double]
			fiesta [celebration, feast, holiday, party]
			hijo [son]
			hola [hello]
			mano [hand]
			ordenador [computer]
			padre [father, priest]
			plaza [plaza]
			programa [program]
			programar [program]
			sol [sun]
			vacaciones [holiday, vacation]

**********************/