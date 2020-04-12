// Name: R2-17
// Date:6/11/19
 
import java.util.*;
import java.io.*;
 
/* Resource classes and interfaces
 * for use with Graph0 AdjMat_0_Driver,
 * Graph1 WarshallDriver,
 * and Graph2 FloydDriver
 */
 
interface AdjacencyMatrix
{
   void addEdge(int source, int target);
   void removeEdge(int source, int target);
   boolean isEdge(int from, int to);
   String toString();   
   int edgeCount();
   List<Integer> getNeighbors(int source);
   //public List<String> getReachables(String from);  //Warshall extension
}
 
interface Warshall      
{
   boolean isEdge(String from, String to); //done
   Map<String, Integer> getVertices();     
   void readNames(String fileName) throws FileNotFoundException;
   void readGrid(String fileName) throws FileNotFoundException;
   void displayVertices();
   void allPairsReachability();  // Warshall's Algorithm
}
 
interface Floyd
{
   int getCost(int from, int to);
   int getCost(String from, String to);
   void allPairsWeighted(); 
}
 
public class AdjMatWarshall implements Warshall 
{
   private int n;
   private int[][] grid = null;   //adjacency matrix representation
   private Map<String, Integer> vertices = null;   // name-->index (for Warshall & Floyd)
 
   /*  enter your code here  */  
   public AdjMat(int size)
   {
      n = size;
      grid = new int[n][n];
      vertices = new TreeMap<String, Integer> ();
   }
   public Map<String, Integer> getVertices()
   {
      return vertices;
   }
   public void readNames(String fileName) throws FileNotFoundException
   {
      Scanner sc = new Scanner(new File(fileName));
      int maxindex = Integer.parseInt(sc.next());
      int i = 0;
      while (i < maxindex)
      {
         String str = sc.next();
         vertices.put(str, i);
         i = i + 1;
      }
   }
   public void readGrid(String fileName) throws FileNotFoundException
   {
      Scanner sc = new Scanner(new File(fileName));
      int x = Integer.parseInt(sc.nextLine());
      for (int i = 0; i < x; i++)
      {
         String str = sc.nextLine();
         String[] array = str.split(" ");
         for (int j = 0; j < array.length; j++)
         {
            grid[i][j] = Integer.parseInt(array[j]);
         }
      }
   }
   public void addEdge(int source, int target)
   {
      grid[source][target] = 1;
   }
   public void removeEdge(int source, int target)
   {
      if (grid[source][target] == 1)
         grid[source][target] = 0;
   }
   public boolean isEdge(String from, String to)
   {
      boolean a = false;
      boolean b = false;
      for (int i = 0; i < n; i++)
      {
         if (grid[vertices.get(from)][i] == 1)
            a = true;
      }
      for (int j = 0; j < n; j++)
      {
         if (grid[j][vertices.get(to)] == 1)
            b = true;
      }
      if (a == b && a == true)
      {
      return true;
      }
      return false;
   }
   public int edgeCount()
   {
      int count  = 0;
      for (int i = 0; i < n; i++)
      {
         for (int j =0; j < n; j++)
         {
            if (grid[i][j] == 1)
               count++;
         }
      }
      return count;
   }
   public void displayVertices()
   {
      int i = 0;
      for (String str : vertices.keySet())
      {
         System.out.println(i + "-" + str);
         i = i + 1;
      }
   }
   public String toString()
   {
      String str = "";
      for (int i = 0; i < n; i++)
      {
         for (int j = 0; j < n; j++)
         {
            str += grid[i][j] + " ";
         }
         str += "\n";
      }
      return str;
   }
   public void allPairsReachability()
   {
      for (int i =0; i < n; i++)
      {
         for (int j = 0; j < n; j++)
         {
            for (int k = 0; k < n; k++)
            {
               if (grid[i][j] + grid[j][k] == 2)
                  grid[i][k] = 1;
            }
         }
      }
   }
   public List<String> getReachables(String str)
   {
      ArrayList<String> l = new ArrayList<String> ();
      return l;
   } 
}