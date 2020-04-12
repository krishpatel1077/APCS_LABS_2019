 //Name: R2-17
 //Date: 3/30/19
 
import java.util.*;


/* implement the API for java.util.PriorityQueue
 * test this class with HeapPriorityQueue_Driver.java.
 * test this class with LunchRoom.java.
 * add(E) and remove()  must work in O(log n) time
 */
public class HeapPriorityQueue<E extends Comparable<E>> 
{
   private ArrayList<E> myHeap;
   
   public HeapPriorityQueue()
   {
      myHeap = new ArrayList<E>();
      myHeap.add(null);
   }
   public boolean add(E obj)
   {
      return myHeap.add(obj);
   }
   public E remove()
   {
      return myHeap.remove(myHeap.size()-1);
   }
   public E peek()
   {
   return myHeap.get(myHeap.size()-1);
   }
   public boolean isEmpty()
   {
    return myHeap.isEmpty();
   }
   private void heapUp(int k)
   {
         
   }
   private void swap(int a, int b)
   {
    E obj = myHeap.get(a);
    myHeap.set(a, myHeap.get(b));
    myHeap.set(b, obj);
   }
   private void heapDown(int k, int size)
   {
   E tmp = myHeap.get(k);
      int child;
   
      for(; 2*k <= size; k = child)
      {
         child = 2*k;
         if(child != size && (myHeap.get(child).compareTo(myHeap.get(child+1)) < 0)) 
         {
            child++;
         }
         else if(tmp.compareTo(myHeap.get(child)) < 0)
         {
            myHeap.set(k, myHeap.get(child));
         }
         else
         {
            break;
         }
      }
      myHeap.set(k, tmp);
   }
   public String toString()
   {
      return myHeap.toString();
   }  
}