// Name:   
// Date:
 
import java.util.*;
import java.io.*;

/* Resource classes and interfaces
 * for use with Graphs3: EdgeList,
 * Graphs4: DFS-BFS
 * and Graphs5: EdgeListCities
 */

/* Graphs 3: EdgeList 
 */
interface VertexInterface
{
   String toString(); // Don't use commas in the list.  Example: "C [C D]"
   String getName();
   ArrayList<Vertex> getAdjacencies();
   void addEdge(Vertex v);
} 

class Vertex implements VertexInterface 
{
   private final String name;
   private String tbd;
   private ArrayList<Vertex> adjacencies;
   private Vertex v;
  
  /* enter your code here  */
   public Vertex(String str)
   {
      name = str;
      adjacencies = new ArrayList<Vertex> ();
   }
   public String getName()
   {
      return name;
   }
   public ArrayList<Vertex> getAdjacencies()
   {
      return adjacencies;
   }
   public void addEdge(Vertex v)
   {
      adjacencies.add(v);
   }
   public String toString()
   {
      String s = this.getName() + "[";
      for (int i = 0; i < adjacencies.size(); i++)
      {
         if (i == adjacencies.size() - 1)
            s += adjacencies.get(i).getName();
         else
            s += adjacencies.get(i).getName() + " ";
      }
      s += "]";
      return s;
   }
}   

interface AdjListInterface 
{ 
   List<Vertex> getVertices();
   Vertex getVertex(int i) ;
   Vertex getVertex(String vertexName);
   Map<String, Integer> getVertexMap();
   void addVertex(String v);
   void addEdge(String source, String target);
   String toString();  //returns all vertices with their edges (omit commas)
}

  
/* Graphs 4: DFS and BFS 
 */
interface DFS_BFS
{
   List<Vertex> depthFirstSearch(String name);
   List<Vertex> depthFirstSearch(Vertex v);
   List<Vertex> breadthFirstSearch(String name);
   List<Vertex> breadthFirstSearch(Vertex v);
   //List<Vertex> depthFirstRecur(String name);
   //List<Vertex> depthFirstRecur(Vertex v);
   //void depthFirstRecurHelper(Vertex v, ArrayList<Vertex> reachable);
}

/* Graphs 5: Edgelist with Cities 
 */
interface EdgeListWithCities
{
   void graphFromEdgeListData(String fileName) throws FileNotFoundException;
   int edgeCount();
   boolean isReachable(String source, String target);
   boolean isFullyReachable();
}
public class AdjList implements EdgeListWithCities
{
   private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
   private Map<String, Integer> nameToIndex = new TreeMap<String, Integer>();
  
 /* enter your code here  */
   public AdjList()
   {
   }
   public boolean isFullyReachable()
   {
      // boolean toRet = false;
   //       String name = vertices.get(0).getName();
   //       for (int i = 1; i < vertices.size(); i++)
   //       {
   //          if (vertices.get(i).getAdjacencies().get(1).equals(name))
   //             toRet = true;
   //       }
   //       return toRet;
      return false;
   }
   public boolean isReachable(String source, String target)
   {
      boolean toRet = false;
      Vertex v = new Vertex("");
      for (Vertex vert : vertices)
      {
         if (vert.getName().equals(source))
            v = vert;
      }
      for (Vertex ve : v.getAdjacencies())
      {
         if (ve.getName().equals(target))
         {
            toRet = true;
         }
      }
      return toRet;
   }
   public int edgeCount()
   {
      int count = 0;
      for (Vertex v : vertices)
      {
         count += v.getAdjacencies().size();
      }
      return count;
   }
   public void graphFromEdgeListData(String fileName) throws FileNotFoundException
   {
      File f = new File(fileName);
      Scanner sc = new Scanner(f);
      while (sc.hasNextLine())
      {
         String line = sc.nextLine();
         String[] array = line.split(" ");
         String from = array[0];
         String to = array[1];
         this.addEdge(from, to);
      }
   }
   public List<Vertex> depthFirstSearch(String name)
   {
      Stack<Vertex> stk = new Stack<Vertex> ();
      ArrayList<Vertex> reachables = new ArrayList<Vertex> ();
      for (int i = 0; i < vertices.size(); i++)
      {
         Vertex tmp = new Vertex("");
         for (Vertex v : vertices)
         {
            if (v.getName().equals(name))
            {
               tmp = v;
               stk.push(tmp);
            }
         }
         reachables.add(stk.pop());
         for (Vertex v : tmp.getAdjacencies())
         {
            stk.push(v);
         }
         for (int z = 0; z < tmp.getAdjacencies().size(); z++)
         {
            if (reachables.contains(stk.peek()))
            {
               stk.pop();
            }
            else
            {
               name = stk.pop().getName();
               break;
            }
         }
      }
      return reachables;   
   }
   public List<Vertex> depthFirstSearch(Vertex v)
   {
      Stack<Vertex> stk = new Stack<Vertex> ();
      ArrayList<Vertex> reachables = new ArrayList<Vertex> ();
      for (int i = 0; i < vertices.size(); i++)
      {
         Vertex tmp = v;
         stk.push(tmp);
         reachables.add(stk.pop());
         for (Vertex ve : tmp.getAdjacencies())
         {
            stk.push(ve);
         }
         for (int z = 0; z < tmp.getAdjacencies().size(); z++)
         {
            if (stk.peek() == v)
            {
               stk.pop();
            }
            else
            {
               v = stk.pop();
               break;
            }
         }
      }
      return reachables;
   }
   public List<Vertex> breadthFirstSearch(String name)
   {
      Queue<Vertex> q = new LinkedList<Vertex> ();
      ArrayList<Vertex> reachables = new ArrayList<Vertex> ();
      for (int i = 0; i < vertices.size(); i++)
      {
         Vertex v = this.getVertex(name);
         q.add(v);
         reachables.add(q.remove());
         for (Vertex ve : v.getAdjacencies())
         {
            q.add(ve);
         }
         for (int x = 0; x < v.getAdjacencies().size(); x++)
         {
            Vertex verti = q.remove();
            boolean a = false;
            for (Vertex vertice : reachables)
            {
            if (vertice.getName().equals(verti.getName()))
            a = true;
            }
            if (a)
            {}
            else
            {
               name = verti.getName();
               break;
            }
         }
      }
      return reachables;
   }
   public List<Vertex> breadthFirstSearch(Vertex v)
   {
      Queue<Vertex> q = new LinkedList<Vertex> ();
      ArrayList<Vertex> reachables = new ArrayList<Vertex> ();
      for (int i = 0; i < vertices.size(); i++)
      {
         Vertex tmp = v;
         q.add(tmp);
         reachables.add(q.remove());
         for (Vertex ve : tmp.getAdjacencies())
         {
            q.add(ve);
         }
         for (int z = 0; z < tmp.getAdjacencies().size(); z++)
         {
            Vertex vo = q.remove();
            if (reachables.contains(vo))
            {
            }
            else
            {
               v = q.remove();
               break;
            }
         }
      }
      return reachables;
   
   }
   public List<Vertex> getVertices()
   {
      return vertices;
   }
   public Map<String, Integer> getVertexMap()
   {
      return nameToIndex;
   }
   public void addVertex(String v)
   {
      int i = 0;
      for (Vertex ve : vertices)
      {
         nameToIndex.put(ve.getName(),i);
         if (ve.getName().equals(v))
            return;
         i++;
      }
      vertices.add(new Vertex(v));
      nameToIndex.put(v, vertices.size() + 1);
   }
   public String toString()
   {
      String str = "";
      for (Vertex v : vertices)
      {
         str += v.toString() + "\n";
      }
      return str; 
   }
   public void addEdge(String from, String to)
   {
      for (Vertex v : vertices)
      {
         if (v.getName().equals(from))
         {
            v.addEdge(new Vertex(to));
            return;
         }
      }
      Vertex v = new Vertex(from);
      v.addEdge(new Vertex(to));
      vertices.add(v);
   }
   public Vertex getVertex(int i)
   {
      return vertices.get(i);
   }
   public Vertex getVertex(String vertexName)
   {
      for (Vertex v : vertices)
      {
         if (v.getName().equals(vertexName))
            return v;
      }
      return null;
   }
}




