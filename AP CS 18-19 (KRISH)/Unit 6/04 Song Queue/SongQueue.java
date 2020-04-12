// Name:
// Date:

import java.io.*;
import java.util.*;

public class SongQueue
{
   private static Scanner keyboard;  //use this global Scanner for this lab only
   private static Queue<String> songQueue;
   
   public static void main(String[] args) throws Exception
   {
      keyboard = new Scanner(System.in);
      songQueue = readPlayList();
      printSongList();
      System.out.println();
      String prompt = "Add song (A), Play song (P), Delete song (D), Quit (Q):  ";
      String str = "";
      do{      
         System.out.println(prompt);
         str = keyboard.nextLine().toUpperCase();
         processRequest( str );
         System.out.println();
      }while(!str.equals("Q"));
   }
   
   public static Queue<String> readPlayList() throws IOException
   {
      Queue<String> playlist = new LinkedList<String> ();
      Scanner infile = new Scanner (new File("songs.txt"));
      while (infile.hasNextLine()){
         playlist.add(infile.nextLine());
      }
      return playlist;
   }
   
   public static void processRequest(String str)
   {
      if (str.equalsIgnoreCase("A")){
         Scanner sc = new Scanner(System.in);
         System.out.println("Song to Add?");
         String adder = sc.nextLine();
         songQueue.add(adder);
         System.out.print("Your music Queue: ");
         printSongList();
      }
      else if (str.equalsIgnoreCase("P")){
         if (songQueue.size() == 0){
         System.out.println("Empty Queue");
         System.out.print("Your music Queue: ");
         printSongList();
         }
         else{
         System.out.print("Now playing: " + songQueue.element());
         songQueue.remove();
         System.out.println();
         System.out.print("Your music Queue: ");
         printSongList();
         }
      }
      else if (str.equalsIgnoreCase("D")){
         Scanner scanny = new Scanner(System.in);
         System.out.println("Delete which song:");
         String remover = scanny.nextLine();
         if (songQueue.contains(remover)){
         songQueue.remove((remover));
         System.out.print("Your music Queue: ");
         printSongList();
         }
         else {
            System.out.println("Error: Song not in list");
         }
      }
   }

   public static void printSongList()
   {
      System.out.print(songQueue);
   }
   
   public static Queue<String> getQueue()
   {
      return songQueue;
   }
}

/*********************************************

 Your music queue: [Really Love, Uptown Funk, Thinking Out Loud, Alright, Traveller, Alright]
 Add song (A), Play song (P), Delete song (D), Quit (Q):  p
 Now playing: Really Love
 Your music queue: [Uptown Funk, Thinking Out Loud, Alright, Traveller, Alright]
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  p
 Now playing: Uptown Funk
 Your music queue: [Thinking Out Loud, Alright, Traveller, Alright]
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  d
 Your music queue: [Thinking Out Loud, Alright, Traveller, Alright]
 Delete which song (exact match)?  Alright
 Your music queue: [Thinking Out Loud, Traveller]
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  d
 Your music queue: [Thinking Out Loud, Traveller]
 Delete which song (exact match)?  xxx
 Error:  Song not in list.
 Your music queue: [Thinking Out Loud, Traveller]
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  a
 Song to add? Girl Crush
 Your music queue: [Thinking Out Loud, Traveller, Girl Crush]
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  p
 Now playing: Thinking Out Loud
 Your music queue: [Traveller, Girl Crush]
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  p
 Now playing: Traveller
 Your music queue: [Girl Crush]
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  p
 Now playing: Girl Crush
 Your music queue: []
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  p
 Empty queue!
 Your music queue: []
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  q
 
 No more music today!

**********************************************/