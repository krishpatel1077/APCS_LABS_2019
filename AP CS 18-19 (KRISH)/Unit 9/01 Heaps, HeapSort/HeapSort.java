// Name: R2-17
// Date: 3/28/19
import java.util.*;
import java.io.*;
import java.text.*;
public class HeapSort
{
   public static int SIZE;  //9 or 100
   private static DecimalFormat df = new DecimalFormat("#.##");
   public static void main(String[] args)
   {
      //Part 1: Given a heap, sort it. Do this part first. 
      SIZE = 9;  
      double heap[] = {-1,99,80,85,17,30,84,2,16,1};
          
      display(heap);
      sort(heap);
      display(heap);
      System.out.println(isSorted(heap));
      
      //Part 2:  Generate 100 random numbers, make a heap, sort it.
      // SIZE = 100;
   //       double[] heap = new double[SIZE + 1];
   //       heap = createRandom(heap);
   //       display(heap);
   //       makeHeap(heap, SIZE);
   //       display(heap); 
   //       sort(heap);
   //       display(heap);
   //       System.out.println(isSorted(heap));
   }
   
	//******* Part 1 ******************************************
   public static void display(double[] array)
   {
      for(int k = 1; k < array.length; k++)
         System.out.print(array[k] + "    ");
      System.out.println("\n");	
   }
   
   public static void sort(double[] array)
   {
      /* enter your code here */
      for (int i = 0; i < array.length; i++)
      {
         for (int z = i; z < array.length; z++)
         {
            if (array[z] > array[i])
            {
               swap(array, i, z);
            }
         }
      }
      
   
   //    if(array[1] > array[2])   //just an extra swap, if needed.
   //          swap(array, 1, 2);
   }
  
   public static void swap(double[] array, int a, int b)
   {
      double val = array[a];
      array[a] = array[b];
      array[b] = val;
   }
   
   public static void heapDown(double[] array, int k, int size)
   {
      swap(array, 0, k);
      array[size
   }
   
   public static boolean isSorted(double[] arr)
   {
      for (int i = 1; i < arr.length; i++)
      {
         if (arr[i] > arr[i-1])
            return false;
      }
      return true;
   }
   
   //****** Part 2 *******************************************
   //Generate 100 random numbers (between 1 and 100, formatted to 2 decimal places) 
   public static double[] createRandom(double[] array)
   {  
      array[0] = -1;   //because it will become a heap
      for (int i = 1; i < array.length; i++)
      {
         double value = Math.random() * 100 + 1;
         String pattern = df.format(value);
         array[i] = Double.parseDouble(pattern);
      }
       
      return array;
   }
   
   //turn the random array into a heap
   public static void makeHeap(double[] array, int size)
   {
      for (int k = size/2; k >= 1; k--)
      {
         heapDown(array, k, size);
      }
   }
}

