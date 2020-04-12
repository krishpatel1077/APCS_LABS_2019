import java.util.*;
public class HeapSort2
{
   public static void main(String[] args)
   {
      int[] heap = {4, 10, 3, 5, 1};
      display(heap);
      heap = heapSort(heap, heap.length);
      display(heap);
   }
   public static void display(int[] heap)
   {
   for (int val : heap)
   {
   System.out.print(val + " ");
   }
   System.out.println();
   }
   public static int[] heapSort(int[] heap, int size)
   {
      if (size == 0)
      {
         return heap;
      }
      else
      {
         swap(heap, findMaxIndex(heap, size), 0);
         swap(heap, 0, size-1);
         return heapSort(heap, size-1);
      }
   }
   public static int findMaxIndex(int[] heap, int size)
   {
      int maxIndex = 0;
      for (int i = 0; i < size; i++)
      {
         if (heap[i] > heap[maxIndex])
            maxIndex = i;
      } 
      return maxIndex;
   }
   public static void swap(int[] heap, int a, int b)
   {
      int val = heap[a];
      heap[a] = heap[b];
      heap[b] = val;
   }
}