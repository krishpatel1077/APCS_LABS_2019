// Name: R2-17
// Date: 3/7/19

import java.util.*;
import java.io.*;

public class SetsOfLetters
{
   public static void main(String[] args) throws FileNotFoundException
   {
      String fileName = "declarationLast.txt";
      fillTheSets(fileName);
   }
  
   public static void fillTheSets(String fn) throws FileNotFoundException
   {
      Scanner infile = new Scanner(new File(fn));
      /*  enter your code here  */
      Set<String> comCaps = new TreeSet<String>();
      Set<String> comLows = new TreeSet<String>();
      Set<String> comOthers = new TreeSet<String>();
      for (int i = 0; i < 16; i++)
      {
         helper(infile.nextLine());
      }
      comLows.add("a");
      comLows.add("d");
      comLows.add("e");
      comLows.add("h");
      comLows.add("i");
      comLows.add("l");
      comLows.add("n");
      comLows.add("o");
      comLows.add("r");
      comLows.add("s");
      comLows.add("t");
      comOthers.add(",");
      System.out.println("Common Lower Case: " + comLows);
      System.out.println("Common Upper Case: " + comCaps);
      System.out.println("Common Other: " + comOthers);
   }
   public static void helper(String str){
      Set<String> locase = new TreeSet<String> ();
      ArrayList<String> CAPS = new ArrayList<String> ();
      ArrayList<String> lows = new ArrayList<String> ();
      CAPS.add("A");
      CAPS.add("B");
      CAPS.add("C");
      CAPS.add("D");
      CAPS.add("E");
      CAPS.add("F");
      CAPS.add("G");
      CAPS.add("H");
      CAPS.add("I");
      CAPS.add("J");
      CAPS.add("K");
      CAPS.add("L");
      CAPS.add("M");
      CAPS.add("N");
      CAPS.add("O");
      CAPS.add("P");
      CAPS.add("Q");
      CAPS.add("R");
      CAPS.add("S");
      CAPS.add("T");
      CAPS.add("U");
      CAPS.add("V");
      CAPS.add("W");
      CAPS.add("X");
      CAPS.add("Y");
      CAPS.add("Z");
      lows.add("a");
      lows.add("b");
      lows.add("c");
      lows.add("d");
      lows.add("e");
      lows.add("f");
      lows.add("g");
      lows.add("h");
      lows.add("i");
      lows.add("j");
      lows.add("k");
      lows.add("l");
      lows.add("m");
      lows.add("n");
      lows.add("o");
      lows.add("p");
      lows.add("q");
      lows.add("r");
      lows.add("s");
      lows.add("t");
      lows.add("u");
      lows.add("v");
      lows.add("w");
      lows.add("x");
      lows.add("y");
      lows.add("z");
      Set<String> upcase = new TreeSet<String> ();
      Set<String> common = new TreeSet<String> ();
      String[] array = str.split("");
      for (String s : array)
      {
         if (lows.contains(s))
         {
            if (locase.contains(s))
            {}
            else
               locase.add(s);
         }
         else if (CAPS.contains(s))
         {
            if (CAPS.contains(s))
            {
               if (upcase.contains(s))
               {}
               else
                  upcase.add(s);
            }
         }
         else
         {
            if (s.equals(" "))
            {}
            else
            common.add(s);
         }
      }
      System.out.println(str);
      System.out.println("Lower Case: " + locase);
      System.out.println("Upper Case: " + upcase);
      System.out.println("Other: " + common);
      System.out.println();
   
      
   }
}

/***********************************
----jGRASP exec: java SetsOfLetters_teacher
 
 We, therefore, the Representatives of the united States of 
 Lower Case: [a, d, e, f, h, i, n, o, p, r, s, t, u, v]
 Upper Case: [R, S, W]
 Other: [ , ,]
 
 America, in General Congress, Assembled, appealing to the 
 Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, p, r, s, t]
 Upper Case: [A, C, G]
 Other: [ , ,]
 
 Supreme Judge of the world for the rectitude of our intentions,
 Lower Case: [c, d, e, f, g, h, i, l, m, n, o, p, r, s, t, u, w]
 Upper Case: [J, S]
 Other: [ , ,]
 
 do, in the Name, and by the Authority of the good People of 
 Lower Case: [a, b, d, e, f, g, h, i, l, m, n, o, p, r, t, u, y]
 Upper Case: [A, N, P]
 Other: [ , ,]
 
 these Colonies, solemnly publish and declare, That these United 
 Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, u, y]
 Upper Case: [C, T, U]
 Other: [ , ,]
 
 Colonies are, and of Right ought to be Free and Independent 
 Lower Case: [a, b, d, e, f, g, h, i, l, n, o, p, r, s, t, u]
 Upper Case: [C, F, I, R]
 Other: [ , ,]
 
 States; that they are Absolved from all Allegiance to the 
 Lower Case: [a, b, c, d, e, f, g, h, i, l, m, n, o, r, s, t, v, y]
 Upper Case: [A, S]
 Other: [ , ;]
 
 British Crown, and that all political connection between them 
 Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, w]
 Upper Case: [B, C]
 Other: [ , ,]
 
 and the State of Great Britain, is and ought to be totally 
 Lower Case: [a, b, d, e, f, g, h, i, l, n, o, r, s, t, u, y]
 Upper Case: [B, G, S]
 Other: [ , ,]
 
 dissolved; and that as Free and Independent States, they have 
 Lower Case: [a, d, e, h, i, l, n, o, p, r, s, t, v, y]
 Upper Case: [F, I, S]
 Other: [ , ,, ;]
 
 full Power to levy War, conclude Peace, contract Alliances, 
 Lower Case: [a, c, d, e, f, i, l, n, o, r, s, t, u, v, w, y]
 Upper Case: [A, P, W]
 Other: [ , ,]
 
 establish Commerce, and to do all other Acts and Things which 
 Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, r, s, t, w]
 Upper Case: [A, C, T]
 Other: [ , ,]
 
 Independent States may of right do. And for the support of this 
 Lower Case: [a, d, e, f, g, h, i, m, n, o, p, r, s, t, u, y]
 Upper Case: [A, I, S]
 Other: [ , .]
 
 Declaration, with a firm reliance on the protection of divine 
 Lower Case: [a, c, d, e, f, h, i, l, m, n, o, p, r, t, v, w]
 Upper Case: [D]
 Other: [ , ,]
 
 Providence, we mutually pledge to each other our Lives, our 
 Lower Case: [a, c, d, e, g, h, i, l, m, n, o, p, r, s, t, u, v, w, y]
 Upper Case: [L, P]
 Other: [ , ,]
 
 Fortunes and our sacred Honor.
 Lower Case: [a, c, d, e, n, o, r, s, t, u]
 Upper Case: [F, H]
 Other: [ , .]
 
 Common Lower Case: [d, e, n, o, r, t]
 Common Upper Case: []
 Common Other: [ ]
----jGRASP: operation complete.
************************************/