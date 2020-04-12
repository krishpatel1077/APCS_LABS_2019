 //name:     date:
import java.util.*;
import java.io.*;
public class MergeSort_Driver
{
   public static void main(String[] args) throws Exception
   {
      //Part 1, for doubles
      double[] array = {3,1,4,1,5,9,2,6};    // small example array from the MergeSort handout
      //int n = (int)(Math.random()*50+10);
      //double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random();
         	
      MergeSort.sort(array);
   
      print(array);
      if( isAscending(array) )
         System.out.println("In Order!");
      else
         System.out.println("oops!");
         
      //Part 2, for Comparables
      int size = 100;
      Scanner sc = new Scanner(new File("declaration.txt"));
      Comparable[] arrayStr = new String[size];
      for(int k = 0; k < arrayStr.length; k++)
         arrayStr[k] = sc.next();	
   
      MergeSort.sort(arrayStr);
      print(arrayStr);
      System.out.println();
      if( isAscending(arrayStr) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
   }

   
   public static void print(double[] a)   
   {                            // The for-each loop. 
      for(double number : a)    //doing something to each element
         System.out.print(number+" ");
      System.out.println();
   }
   public static boolean isAscending(double[] a)
   {
      for (int x = 1; x < a.length; x++)
         if (a[x-1] > a[x])
            return false;
      return true;
   }
   public static void print(Object[] peach)
   {
      for(Object abc : peach)     //for-each
         System.out.print(abc+" ");
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
/////////////////////////////////////////////
// 15 Oct 07
// MergeSort Code Handout
// from Lambert & Osborne, p. 482 - 485

class MergeSort
{
   private static final int CUTOFF = 10; // for small lists, recursion isn't worth it
   public static void sort(double[] array)
   { 
      double[] copyBuffer = new double[array.length];
      mergeSortHelper(array, copyBuffer, 0, array.length - 1);
   }
   /*  array			array that is being sorted
       copyBuffer		temp space needed during the merge process
       low, high		bounds of subarray
       middle			midpoint of subarray   */
   private static void mergeSortHelper(double[] array, double[] copyBuffer,
                                                      int low, int high)
   {  
      //if ( high - low  < CUTOFF )                  //switch to selection sort  when
      // SelectionLowHigh.sort(array, low, high);        //the list gets small enough 
      //else
      if (low < high)
      {
         int middle = (low + high) / 2;
         mergeSortHelper(array, copyBuffer, low, middle);
         mergeSortHelper(array, copyBuffer, middle + 1, high);
         merge(array, copyBuffer, low, middle, high);
      }
   }
   
   /* array				array that is being sorted
      copyBuffer		temp space needed during the merge process
      low				beginning of first sorted subarray
      middle			end of first sorted subarray
      middle + 1		beginning of second sorted subarray
      high				end of second sorted subarray   */
   public static void merge(double[] array, double[] copyBuffer,
                                   int low, int middle, int high)
   {
      // Initialize i1 and i2 to the first items in each subarray  
      // Interleave items from the subarrays into the copyBuffer in such 
      // a way that order is maintained.
      low = 0;
      middle = copyBuffer.length/2;
      high = copyBuffer.length;
      for (int i = 0; i < array.length; i++){
         copyBuffer[i] = array[i];
      }
      int max = 0;
      for (int i = low; i < middle; i++){
         if (copyBuffer[i] < copyBuffer[max]){
            double temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      max = 0;
      for (int i = middle; i < high; i++){
         if (copyBuffer[i] < copyBuffer[max]){
            double temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      for (int i = 0; i < array.length; i++){
         array[i] = copyBuffer[i];
      }
      max = 0;
      for (int i = low; i < middle/2; i++){
         if (copyBuffer[i] < copyBuffer[max]){
            double temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      max = 0;
      for (int i = middle/2; i < middle; i++){
         if (copyBuffer[i] < copyBuffer[max]){
            double temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      for (int i = middle; i < (3*middle)/2; i++){
         if (copyBuffer[i] < copyBuffer[max]){
            double temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      for (int i = (3*middle)/2; i < high; i++){
         if (copyBuffer[i] < copyBuffer[max]){
            double temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      for (int i = 0; i < array.length; i++){
         array[i] = copyBuffer[i];
      }
      max = 0;
      for (int i = low; i < high; i++){
         if (copyBuffer[i] < copyBuffer[max]){
            double temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      for (int i = 0; i < copyBuffer.length; i++){
         array[i] = copyBuffer[i];
      }
   }	
   
   
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
   public static void sort(Comparable[] array)
   { 
      Comparable[] copyBuffer = new Comparable[array.length];
      mergeSortHelper(array, copyBuffer, 0, array.length - 1);
   }

   /* array				array that is being sorted
      copyBuffer		temp space needed during the merge process
      low, high		bounds of subarray
      middle			midpoint of subarray  */
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
   private static void mergeSortHelper(Comparable[] array, Comparable[] copyBuffer, int low, int high)
   {  
         //if ( high - low  < CUTOFF )                  //switch to selection sort  when
      // SelectionLowHigh.sort(array, low, high);        //the list gets small enough 
      //else
      if (low < high)
      {
         int middle = (low + high) / 2;
         mergeSortHelper(array, copyBuffer, low, middle);
         mergeSortHelper(array, copyBuffer, middle + 1, high);
         merge(array, copyBuffer, low, middle, high);
      }
   }
   
   /* array				array that is being sorted
      copyBuffer		temp space needed during the merge process
      low				beginning of first sorted subarray
      middle			end of first sorted subarray
      middle + 1		beginning of second sorted subarray
      high				end of second sorted subarray   */
   
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
   public static void merge(Comparable[] array, Comparable[] copyBuffer,
                                   int low, int middle, int high)
   {
      low = 0;
      middle = copyBuffer.length/2;
      high = copyBuffer.length;
      for (int i = 0; i < array.length; i++){
         copyBuffer[i] = array[i];
      }
      int max = 0;
      for (int i = low; i < middle; i++){
         if (copyBuffer[i].compareTo(copyBuffer[max]) < 0){
            Comparable temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      max = 0;
      for (int i = middle; i < high; i++){
         if (copyBuffer[i].compareTo(copyBuffer[max]) < 0){
            Comparable temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      for (int i = 0; i < array.length; i++){
         array[i] = copyBuffer[i];
      }
      max = 0;
      for (int i = low; i < middle/2; i++){
         if (copyBuffer[i].compareTo(copyBuffer[max]) < 0){
            Comparable temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      max = 0;
      for (int i = middle/2; i < middle; i++){
         if (copyBuffer[i].compareTo(copyBuffer[max]) < 0){
            Comparable temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      for (int i = middle; i < (3*middle)/2; i++){
         if (copyBuffer[i].compareTo(copyBuffer[max]) < 0){
            Comparable temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      for (int i = (3*middle)/2; i < high; i++){
         if (copyBuffer[i].compareTo(copyBuffer[max]) < 0){
            Comparable temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      for (int i = 0; i < array.length; i++){
         array[i] = copyBuffer[i];
      }
   
      max = 0;
      for (int i = low; i < high; i++){
         if (copyBuffer[i].compareTo(copyBuffer[max]) < 0){
            Comparable temp = copyBuffer[i];
            copyBuffer[i] = copyBuffer[max];
            copyBuffer[max] = temp;
         }
         max = i;
      }
      for (int i = 0; i < copyBuffer.length; i++){
         array[i] = copyBuffer[i];
      }
   
   }    	
}

/***************************************************
This is the extension.  You will have to uncomment Lines 54-56 above.
name:   date:
***********************************************/
class SelectionLowHigh
{
   public static void sort(double[] array, int low, int high)
   {  
   
   }
   private static int findMax(double[] array, int low, int upper)
   {
      return 0;
   }
   private static void swap(double[] array, int a, int b)
   {
   
   } 
}
