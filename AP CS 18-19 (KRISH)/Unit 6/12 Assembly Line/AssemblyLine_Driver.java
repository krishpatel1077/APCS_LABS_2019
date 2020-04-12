//Name: R2-17
//Date: 1/29/18
import java.util.*;

public class AssemblyLine_Driver
{
   static int NDISKS = 50;
   static int MAXRADIUS = 100;
   public static void main(String[] args)
   {
      AssemblyLine a = new AssemblyLine(NDISKS, MAXRADIUS);
      a.showInput();
      a.process();
      a.showOutput();
   }
}
   
class AssemblyLine
{
   private Queue<Disk> assemblyLineIn;
   private Queue<Pyramid> assemblyLineOut;
   private Pyramid robotArm;
   	/**
   		* initializes this object so the assemblyLineIn contains 
   		* nDisks with random radii;  assemblyLineOut is initialized to * an empty Queue; robotArm is initialized to an empty Pyramid.
   		**/
   	//Part A
   public AssemblyLine( int nDisks, int maxRadius )
   {	
      assemblyLineIn = new LinkedList<> ();
      for (int i = 0; i < nDisks; i++){
         int num = (int) ((Math.random() * maxRadius) + 1);
         assemblyLineIn.add(new Disk(num));
      }
      assemblyLineOut = new LinkedList<Pyramid> ();
      robotArm =  new Pyramid();
   }
   
   	/**
   		* "flips over" the pyramid in the robotArm and adds it to the
   		* assemblyLineOut queue.
   		* Precondition:  robotArm is not empty and holds an inverted 
   		*				pyramid of disks
   		**/
   	// Part B
   private void unloadRobot()
   { 
      Pyramid temp = new Pyramid();
      while (!robotArm.isEmpty()){
         temp.push(robotArm.pop());
      }
      assemblyLineOut.add(temp);
   }
   
   	/**
   		* processes all disks from assemblyLineIn; a disk is processed
   		* as follows:  if robotArm is not empty and the next disk does
   		* not fit on top of robotArm (which must be an inverted 
   		* pyramid) then robotArm is unloaded first; the disk from
   		* assemblyLineIn is added to robotArm; when all the disks
   		* have been retrieved from assemblyLineIn, robotArm is unloaded.
   		*  Precondition:  robotArm is empty;
   		*				assemblyLineOut is empty
   		**/
   	//Part C
   public void process()
   {
      while (!assemblyLineIn.isEmpty())
      {
         Disk disk = assemblyLineIn.remove();
         if (!robotArm.isEmpty() && disk.compareTo(robotArm.peek()) <= 0)
            unloadRobot();
         robotArm.push(disk);
      }
//       if (!robotArm.isEmpty()){
//          unloadRobot();
//       }
   }
      
   public void showInput()
   {
      System.out.println(assemblyLineIn);
   }
   public void showOutput()
   {
      System.out.println(assemblyLineOut);
   }
}
   //Disk is standard and straightforward.
class Disk implements Comparable<Disk>
{
   private int radius;
   public Disk(int r){
      radius = r;
   }
   public int getRadius(){
      return radius;
   }
   public String toString() {
      return "" + radius;
   }
   public int compareTo(Disk d){
      if (radius < d.getRadius())
         return -1;
      else if (radius > d.getRadius())
         return 1;
      else 
         return 0;
   }
   
}
   //Pyramid is sly.
class Pyramid extends Stack<Disk>
{
   public Pyramid() {
      Stack<Disk> s = new Stack<Disk> ();
      Queue<Disk> q =  new LinkedList<Disk> ();
      while (!s.isEmpty()){
         q.add(s.pop());
      }
      while (!q.isEmpty()){
         s.push(q.remove());
      }
   }
}