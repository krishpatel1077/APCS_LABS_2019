// Name: R2-17  
// Date: 9/18/18
import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Cemetery
{
   public static void main (String [] args)
   {
      File file = new File("cemetery.txt");
      int numEntries = countEntries(file);
      Person[] cemetery = readIntoArray(file, numEntries); 
      int min = locateMinAgePerson(cemetery);
      int max = locateMaxAgePerson(cemetery); 
      //for testing only
      //for (int i = 0; i < cemetery.length; i++) 
         //System.out.println(cemetery[i]);
      System.out.println("In the St. Mary Magdelene Old Fish Cemetery --> ");
      System.out.println("Name of youngest person: " + cemetery[min].getName());
      System.out.println("Age of youngest person: " + cemetery[min].getAge());    
      System.out.println("Name of oldest person: " + cemetery[max].getName());
      System.out.println("Age of oldest person: " + cemetery[max].getAge());     
   }
   
   /* Counts and returns the number of entries in File f.
      Uses a try-catch block.   
      @param f -- the file object
   */
   public static int countEntries(File f)
   {
      int count = 0;
      try {
         Scanner sc = new Scanner("cemetery.txt");
         while(sc.hasNextLine()) {
           count++;
           sc.nextLine();
           }
      }
      catch(Exception x) {
         System.out.println("oops");
         System.exit(0);
      }
      return count -1;
   }

   /* Reads the data.
      Fills the array with Person objects.
      Uses a try-catch block.   
      @param f -- the file object 
      @param num -- the number of lines in the File f  
   */
   public static Person[] readIntoArray (File f, int num)
   {
   
      Person[] arr = new Person[num];
      try {
         Scanner sc2 = new Scanner("cemetery.txt");	
         for (int i = 0; i < arr.length; i++) {
            arr[i] = makeObjects(sc2.nextLine());
            num++;
         }
         
      }
      catch (Exception e){
         System.out.println("oops!");
         System.exit(0);
      }
      return arr;
   }
   
   /* A helper method that instantiates one Person object.
      @param entry -- one line of the input file.
   */
   private static Person makeObjects(String entry)
   {
      String name = entry.substring(0, 24);
      String date = entry.substring(24, 36);
      String age = entry.substring(37, entry.indexOf(""));
      double agemod = Double.parseDouble(age);
      return new Person(name, date, agemod);
   }  
   
   /* Finds and returns the location (the index) of the Person
      who is the youngest.
      @param arr -- an array of Person objects.
   */
   public static int locateMinAgePerson(Person[] arr)
   {
      int index = 0;
      for (int x = 0; x < arr.length; x ++) {
         while(arr[x].getAge() < arr[index].getAge()) {
            index = x;
         }
      }
      return index;
   }     
   
   /* Finds and returns the location (the index) of the Person
      who is the oldest.
      @param arr -- an array of Person objects.
   */
   public static int locateMaxAgePerson(Person[] arr)
   {
      int index = 0;
      for (int x = 0; x < arr.length; x ++) {
         if (arr[x].getAge() > arr[index].getAge()) {
            index = x;
            
         }
      }
      return index;
   }        
} 

class Person
{
   /* private fields  */
   private DecimalFormat df = new DecimalFormat("0.0000");
   private String name;
   private String date;
   private double age = 0;   
   /* a three-arg constructor  */
   public Person(String n, String d, double a) {
      n.equals(name);
      d.equals(date);
      a = age;
   }
   /* any necessary accessor methods */
   public String getName() {
      return name;
   }
   public String getDate() {
      return date;
   }
   public double getAge() {
      return age;
   }
   public double calculateAge(String a)
   {
      if (a.contains("d")) {
         a.replace("d", "");
         double a2 = Double.parseDouble(a);
         a2 = (a2)/265;
         return a2;
      }
      else if (a.contains("w")) {
         a.replace("w", "");
         double a3 = Double.parseDouble(a);
         a3 = (a3)/52;
         return a3;
      }  
      else {
         double a4 = Double.parseDouble(a);
         a4 = (a4)/1;
         return a4;
      }
   }
}