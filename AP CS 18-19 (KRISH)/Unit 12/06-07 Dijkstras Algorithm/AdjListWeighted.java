// Name:   
// Date:
 
import java.util.*;
import java.io.*;

/* Resource classes and interfaces
 * for use with Graphs6: Dijkstra
 * and Graphs7: Dijkstra with Cities
 */

class Edge 
{
   //public fields not common on AP exam
   public final wVertex target;  
   public final double weight;   
  
   public Edge(wVertex argTarget, double argWeight) 
   {
      target = argTarget;
      weight = argWeight;
   }
}

interface wVertexInterface 
{
   String getName();
   double getMinDistance();
   void setMinDistance(double m);
   //wVertex getPrevious();   //for Dijkstra 7
   //void setPrevious(wVertex v);  //for Dijkstra 7
   ArrayList<Edge> getAdjacencies();
   void addEdge(wVertex v, double weight);   
   int compareTo(wVertex other);
}

class wVertex implements Comparable<wVertex>, wVertexInterface
{
   private final String name;
   private ArrayList<Edge> adjacencies;
   private double minDistance = Double.POSITIVE_INFINITY;
   //private wVertex previous;  //for building the actual path in Dijkstra 7
   
   /*  enter your code for this class here   */ 
   public wVertex(String vname)
   {
      name = vname;
      adjacencies = new ArrayList<Edge> ();
   }
   public String getName()
   {
      return name;
   }
   public double getMinDistance()
   {
      return minDistance;
   }
   public void setMinDistance(double m)
   {
      minDistance = m;
   }
   public ArrayList<Edge> getAdjacencies()
   {
      return adjacencies;
   }
   public void addEdge(wVertex v, double weight)
   {
      adjacencies.add(new Edge(v, weight));
   }
   public int compareTo(wVertex other)
   {
      double w1 = this.getMinDistance();
      double w2 = other.getMinDistance();
      if (w1 > w2)
      {
         return 1;
      }
      else if (w1 < w2)
      {
         return -1;
      }
      return 0;
   }
}

interface AdjListWeightedInterface 
{
   List<wVertex> getVertices();
   Map<String, Integer> getNameToIndex();
   wVertex getVertex(int i);   
   wVertex getVertex(String vertexName);
   void addVertex(String v);
   void addEdge(String source, String target, double weight);
   void minimumWeightPath(String vertexName);   //Dijkstra's
}

/* Interface for Graphs 7:  Dijkstra with Cities 
 */
/*
interface AdjListWeightedInterfaceWithCities 
{       
   List<String> getShortestPathTo(wVertex v);
   AdjListWeighted graphFromEdgeListData(File vertexNames, File edgeListData) throws FileNotFoundException ;
}
*/ 

public class AdjListWeighted implements AdjListWeightedInterface  //AdjListWeightedInterfaceWithCities
{
   private List<wVertex> vertices = new ArrayList<wVertex>();
   private Map<String, Integer> nameToIndex = new HashMap<String, Integer>();
   //the constructor is a no-arg constructor 
   public AdjListWeighted()
   {
   
   }
   /*  enter your code for Graphs 6 */ 
   public void minimumWeightPath(String vertexName)
   {
      wVertex v = this.getVertex(vertexName);
      for (wVertex w : vertices)
      {
         v.setMinDistance(dijjyHelper(vertexName, w.getName()));
      }
      
   }
   public double dijjyHelper(String source, String target)
   {
      double distance = 0.0;
      if (source.equals(target))
      {
         return 0.0;
      }
      else
      {
         wVertex vertex = this.getVertex(source);
         Edge minEdge = new Edge(new wVertex(""), 0.0);
         double tmp = 100.0;
         for (Edge e : vertex.getAdjacencies())
         {
            if (e.weight < tmp)
            {
               tmp = e.weight;
               minEdge = e;
            }
         }
         distance += tmp;
         if (!target.equals(minEdge.target.getName()))
            distance += dijjyHelper(minEdge.target.getName(), target);
      }
      return distance;
   }
   public void addEdge(String source, String target, double weight)
   {
      wVertex v1 = this.getVertex(source);
      wVertex v2 = this.getVertex(target);
      v1.addEdge(v2, weight);
   }
   public void addVertex(String v)
   {
      vertices.add(new wVertex(v));
   }
   public List<wVertex> getVertices()
   {
      return vertices;
   }
   public Map<String, Integer> getNameToIndex()
   {
      return nameToIndex;
   }
   public wVertex getVertex(int i)
   {
      return vertices.get(i);
   }
   public wVertex getVertex(String vertexName)
   {
      for (wVertex w : vertices)
      {
         if (w.getName().equals(vertexName))
            return w;
      }
      return new wVertex(vertexName);
   }
   
   
   
   /*  enter your code for two new methods in Graphs 7 */
   
   
}   


