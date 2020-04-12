 // Name: R2-17
 // Date: 3/20/19

import java.util.*;

public class Polynomial_Driver
{
   public static void main(String[] args)
   {
      Polynomial poly = new Polynomial();    // 2x^3 + -4x + 2
      poly.makeTerm(1, -4);
      poly.makeTerm(3, 2);
      poly.makeTerm(0, 2);
      System.out.println("Map:  " + poly.getMap());
      System.out.println("String:  " + poly.toString());
      double evaluateAt = 2.0;
      System.out.println("Evaluated at "+ evaluateAt +": " +poly.evaluateAt(evaluateAt));
      
      System.out.println("-----------");
      Polynomial poly2 = new Polynomial();  // 2x^4 + x^2 + -5x + -3
      poly2.makeTerm(1, -5);
      poly2.makeTerm(4, 2);
      poly2.makeTerm(0, -3);
      poly2.makeTerm(2, 1);
      System.out.println("Map:  " + poly2.getMap()); 
      System.out.println("String:  " +poly2.toString());
      evaluateAt = -10.5;
      System.out.println("Evaluated at "+ evaluateAt +": " +poly.evaluateAt(evaluateAt));
      
      
      System.out.println("-----------");
      System.out.println("Sum: " + (poly.add(poly2)).toString());
      System.out.println("Product:  " + poly.multiply(poly2).toString());
      
      /*  Another case:   (x+1)(x-1) -->  x^2 + -1    */
      // System.out.println("===========================");
      // Polynomial poly3 = new Polynomial();   // (x+1)
      // poly3.makeTerm(1, 1);
      // poly3.makeTerm(0, 1);
      // System.out.println("Map:  " + poly3.getMap());
      // System.out.println("String:  " + poly3.toString());
   //       
      // Polynomial poly4 = new Polynomial();    // (x-1)
      // poly4.makeTerm(1, 1);
      // poly4.makeTerm(0, -1);
      // System.out.println("Map:  " + poly4.getMap());
      // System.out.println("String:  " + poly4.toString());
      // System.out.println("Product:  " + poly4.multiply(poly3));   // x^2 + -1 
   //    
   //    /*  testing the one-arg constructor  */
      // System.out.println("==========================="); 
      // Polynomial poly5 = new Polynomial("2x^3 + 4x^2 + 6x^1 + -3");
      // System.out.println("Map:  " + poly5.getMap());  
      // System.out.println(poly5);
   
   }
}
interface PolynomialInterface
{
   public void makeTerm(Integer exp, Integer coef);
   public Map<Integer, Integer> getMap();
   public double evaluateAt(double x);
   public Polynomial add(Polynomial other);
   public Polynomial multiply(Polynomial other);
   public String toString();
}

class Polynomial implements PolynomialInterface
{
   private Map<Integer, Integer> map;
   public Polynomial()
   {
      map = new TreeMap<Integer, Integer> ();
   }
   public Map<Integer, Integer> getMap()
   {
      return map;
   }
   public void makeTerm(Integer exp, Integer coef)
   {
      map.put(exp, coef);
   }
   public double evaluateAt(double x)
   {
      double toRet = 0.0;
      for (int d : map.keySet())
      {
         toRet += ((double)((double)map.get(d) * Math.pow(x, d)));
      }
      return toRet;
   }
   public Polynomial add(Polynomial other)
   {
      int i = 0;
      Map<Integer, Integer> otherMap = other.getMap();
      Polynomial toRet = new Polynomial();
      if (otherMap.size() < map.size())   
      {
         for (int val : map.keySet())
         {
            if (otherMap.get(val) == null)
            {
               int coef = 0 + map.get(val);
               i = coef;
            }
            else
            {
               int coef = map.get(val) + otherMap.get(val);
               i =  coef;
            }
            int exp = val;
            toRet.makeTerm(val, i);
         }
      }
      else
      {
         for (int val : otherMap.keySet())
         {
            if (map.get(val) == null)
            {
               int coef = 0 + otherMap.get(val);
               i = coef;
            }
            else
            {
               int coef = map.get(val) + otherMap.get(val);
               i =  coef;
            }
            int exp = val;
            toRet.makeTerm(val, i);
         }
      }
      return toRet;
   }
   public Polynomial multiply(Polynomial other)
   {
      Map<Integer, Integer> otherMap = other.getMap();
      return new Polynomial();
   }
   public String toString()
   {
      if (map.isEmpty())
      {
         return "";
      }
      String toRet = "";
      for (int val : map.keySet())
      {
         if (val == 0)
         toRet = "" + map.get(val) + toRet;
         else if (val == 1)
         toRet = "" + map.get(val)+ "x + " +toRet;
         else
         toRet = "" + map.get(val) + "x^" +val + " + " + toRet; 
      }
      return toRet;
   }
}


/***************************************  
  ----jGRASP exec: java Polynomial_teacher
 Map:  {0=2, 1=-4, 3=2}
 String:  2x^3 + -4x + 2
 Evaluated at 2.0: 10.0
 -----------
 Map:  {0=-3, 1=-5, 2=1, 4=2}
 String:  2x^4 + x^2 + -5x + -3
 Evaluated at -10.5: -2271.25
 -----------
 Sum: 2x^4 + 2x^3 + x^2 + -9x + -1
 Product:  4x^7 + -6x^5 + -6x^4 + -10x^3 + 22x^2 + 2x + -6
 
  ----jGRASP: operation complete.
 ********************************************/