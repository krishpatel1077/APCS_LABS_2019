// Name: 
// Date: 

import java.util.*;

interface Fibber
{
   public abstract int fib(int n);
}

public class Fib
{
   public static final int FIBsubN = 40;
   public static void main(String[] args)
   {
      System.out.println("Recursive");
      calculate(new Fib1(), FIBsubN);
      System.out.println("Iterative, stored in an array");
      calculate(new Fib2(FIBsubN + 1), FIBsubN);
      System.out.println("Recursive, stored in an arrayList");
      calculate(new Fib3(), FIBsubN);
      System.out.println("Recursive, stored in a hashMap");
      calculate(new Fib4(), FIBsubN);		
   }
      
   public static void calculate(Fibber fibber, int n)
   {
      long start = System.nanoTime();
      int f = fibber.fib(n);
      long finish = System.nanoTime();
      long time = finish - start;
      
      System.out.print("fib(" + n + ") = " + f);
      System.out.println(" (" + time + "nanoseconds)");		
      System.out.println();		
   }
}
    
class Fib1 implements Fibber
{
   public Fib1()    
   {
   }
   
   public int fib(int n)
   {
      if(n == 1 || n == 2)
         return 1;
      else
         return fib(n - 1) + fib(n - 2);
   }
}
   
class Fib2 implements Fibber
{
   private int[] array;
   
   public Fib2(int n)
   {
   array = new int[n];
   array[0] = n;
   array[1] = n;
   }
   
   public int fib(int n)
   {
   int ret = 0;
   for (int i = 1; i < array.length; i++)
   {
   ret+= array[i-1]+array[i];
   }
   return ret;
   }
   
   public int[] getArray()   //nice to have
   {
    return array;
   }
}
   
class Fib3 implements Fibber
{
   private ArrayList<Integer> myFibList;
   
   public Fib3()
   {
   myFibList = new ArrayList<Integer> ();
   }
   
   public int fib(int n)
   {
   return n;
   }
   
   public ArrayList<Integer> getArrayList()   //nice to have
   {
      return myFibList;
   }
}

class Fib4 implements Fibber
{
   private Map<Integer, Integer> myFibMap;
   
   public Fib4()
   {
   myFibMap = new TreeMap<Integer, Integer> ();
   }
   
   public int fib(int n)
   {
   return n;
   }
   
   public Map<Integer, Integer> getMap()  //nice to have
   {
   return myFibMap;
   }
}
	
   
   
   /*
    Recursive
    fib(42) = 267914296 (3276558048 nanoseconds)
    
    Iterative, stored in an array
    fib(42) = 267914296 (4988 nanoseconds)
    
    Recursive, stored in an arrayList
    fib(42) = 267914296 (64025 nanoseconds)
    
    Recursive, stored in a hashMap
    fib(42) = 267914296 (177793 nanoseconds)
    
   	*/
