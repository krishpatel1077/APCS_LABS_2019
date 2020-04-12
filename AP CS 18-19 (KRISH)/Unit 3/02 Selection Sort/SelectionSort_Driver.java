 // name: R2-17    date: 10/25/18
import java.util.*;
import java.io.*;
public class SelectionSort_Driver
{
   public static void main(String[] args) throws Exception
   {
     //Part 1, for doubles
      int n = (int)(Math.random()*100)+20;
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random()*100;	
      
      Selection.sort(array);
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
   
      Selection.sort(arrayStr);
      print(arrayStr);
      System.out.println();
      
      if( isAscending(arrayStr) )
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
//*********************************************
//name:    date:
class Selection
{
   public static void sort(double[] array){
   for (int i = array.length -1; i >0; i--)
         swap(array, findMax(array, i), i);
   }
   private static int findMax(double[] array, int upper)//"upper" controls where the inner  																//loop of the Selection Sort ends
   {
      int max = 0;
      for (int i = 0; i <= upper; i++){
         if (array[i] > array[max])
            max = i;
      }
      return max;
   }
   private static void swap(double[] array, int a, int b)
   {
      double temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }   	
   
	/*******  for Comparables ********************/
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
    public static void sort(Comparable[] array)
   {
   for (int i = array.length -1; i >0; i--)
         swap(array, findMax(array, i), i);
   }
   @SuppressWarnings("unchecked")
    public static int findMax(Comparable[] array, int upper)
   {
      int max = 0;
      for (int i = 0; i <= upper; i++){
         if (array[i].compareTo(array[max]) > 0)
            max = i;
      }
      return max;
   }
   public static void swap(Object[] array, int a, int b)
   {
      Object temp = array[a];
      array[a] = array[b];
      array[b] = temp;
   }
}
