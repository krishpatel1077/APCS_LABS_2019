 //name:     date:
import java.util.*;
import java.io.*;
public class InsertionSort_Driver
{
   public static void main(String[] args) throws Exception
   {
     //Part 1, for doubles
      int n = (int)(Math.random()*100)+20;
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random()*100;	
      
      Insertion.sort(array);
      print(array);
      
      if( isAscending(array) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
      System.out.println();
      
      //Part 2, for Strings
      int size = 100;
      Scanner sc = new Scanner(new File("declaration.txt"));
      Comparable[] arrayStr = new String[size];
      for(int k = 0; k < arrayStr.length; k++)
         arrayStr[k] = sc.next();	
   
      Insertion.sort(arrayStr);
      print(arrayStr);
      System.out.println();
      
      if( isAscending(array) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
   }
   public static void print(double[] a)
   {
      for(double d: a)         //for-each
         System.out.print(d+" ");
      System.out.println();
   }
   public static void print(Object[] papaya)
   
   {
      for(Object abc : papaya)     //for-each
         System.out.print(abc+" ");
   }
   public static boolean isAscending(double[] a)
   {
      for (int x = 1; x < a.length; x++)
         if (a[x-1] > a[x])
            return false;
      return true;
   }
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
   public static boolean isAscending(Comparable[] a)
   {
      for (int x = 1; x < a.length; x++)
         if (a[x-1].compareTo(a[x]) > 0)
            return false;
      return true;
   }
}

//**********************************************************
 //name:     date:
class Insertion
{
   public static double[] sort(double[] array)
   { 
      for (int i = 1; i < array.length; i++) {
         for (int j = i; j > 0; j--) {
            if (array[j-1] > array[j]) {
               shift(array, j-1, array[j]);
            }
            else 
               break;
         }
      }
      return array;
   }
   private static int shift(double[] array, int index, double value)
   {
      double temp = array[index];
      array[index] = array[index+1];
      array[index+1] = temp;
      return index;
   }
   @SuppressWarnings("unchecked")
    public static Comparable[] sort(Comparable[] array)
   { 
      for (int x = 1; x < array.length; x++) {//Checks array Upwards
         for (int y = x; y > 0; y--) {//Checks array downwards from x
            if (array[y-1].compareTo(array[y]) > 0) {
               shift(array, y-1, array[y]);//Calls shift to change up values
            }
            else 
               break;//Breaks out of second for loop to increase the value of x by 1, giving y an increased range
         }
      }
      return array;
   }
   @SuppressWarnings("unchecked")
    private static int shift(Comparable[] array, int index, Comparable value)
   {
      Comparable temp = array[index];
      array[index] = value;
      array[index+1] = temp;
      return index;
   }
}
