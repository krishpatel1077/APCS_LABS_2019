//name: R2-17  date: 10/15/18
import java.util.*;
import java.io.*;
public class MazeMaster
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the maze's filename (no .txt): ");
      Maze m = new Maze(sc.next());
      // Maze m = new Maze();     //extension:  generate a random maze
      m.display();      //display maze
      System.out.println("Options: ");
      System.out.println("1: Mark all paths.");
      System.out.println("2: Mark all paths, and display the count of all STEPs.");
      System.out.println("3: Mark only the correct path.");
      System.out.println("4: Mark only the correct path. If no path exists, say so.");
      System.out.println("5: Mark only the correct path and display the count of STEPs.\n\tIf no path exists, say so.");
      System.out.print("Please make a selection: ");
      m.solve(sc.nextInt());
      m.display();      //display solved maze
   
   } 
}


class Maze
{
   //Constants
   private final char WALL = 'W';
   private final char DOT = '.';
   private final char START = 'S';
   private final char EXIT = 'E';
   private final char STEP = '*';
   //fields
   private char[][] maze;
   private int startRow, startCol;
  
  //constructors
   public Maze()  //extension:  generate a random maze
   {
   }
   public Maze(char[][] m)  //copy constructor
   {
      maze = m;
      for(int r = 0; r < maze.length; r++)
      {
         for(int c = 0; c < maze[0].length; c++)
         { 
            if(maze[r][c] == START)      //identify start
            {
               startRow = r;
               startCol = c;
            }
         }
      }
   } 
   public Maze(String filename)    
   {
       //use a try-catch block
       //use next(), not nextLine()
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File(filename));
      }
      catch (Exception e)
      {
         System.out.println("File not found");
         System.exit(0);
      }
      /* enter your code here */
      int row = infile.nextInt();
      int col = infile.nextInt();
      char[][] reader = new char[row][col];
      for (int i = 0; i < reader.length; i++) {
         reader[i] = infile.next().toCharArray();
      }
      maze = reader;
      for (int r = 0; r < row; r++){
         for (int c = 0; c < col; c++) {
            if (maze[r][c] == START){
               startRow  = r;
               startCol = c;
            }
         }
      }  
   }
   public char[][] getMaze()
   {
      return maze;
   }
   public void display()
   {
      if(maze==null) 
         return;
      for(int a = 0; a<maze.length; a++)
      {
         for(int b = 0; b<maze[0].length; b++)
         {
            System.out.print(maze[a][b]);
         }
         System.out.println("");
      }
      System.out.println("");
   }
   
   public void solve(int n)
   {
      switch(n)
      {
         case 1:
            {
               markAllPaths(startRow, startCol);
               break;
            }
         case 2:
            {
               int count = markAllPathsAndCountStars(startRow, startCol);
               System.out.println("Number of steps = " + count);
               break;
            }
         case 3:
            {
               markTheCorrectPath(startRow, startCol);
               break;
            }
         case 4:         //use mazeNoPath.txt 
            {
               if( !markTheCorrectPath(startRow, startCol) )
                  System.out.println("No path exists."); 
               break;
            }
         case 5:
            {
               if( !markCorrectPathAndCountSteps(startRow, startCol, 0) )
                  System.out.println("No path exists."); 
               break;
            }
         default:
            System.out.println("File not found");   
      }
   }   
    /*  1  almost like AreaFill*/
   public void markAllPaths(int r, int c)
   {
      if (maze[r][c] == DOT)
         maze[r][c] = STEP;
         
      if (r < 0 || r > maze.length -1 || c < 0 || c > maze[0].length -1)
         return;
         
      if (r > 0 && maze[r-1][c] == DOT)
         markAllPaths(r-1, c);
         
      if (c > 0 && maze[r][c-1] == DOT)
         markAllPaths(r, c-1);
      
      if (r < maze.length - 1 && maze[r+1][c] == DOT)
         markAllPaths(r+1, c);
      
      if (c < maze[0].length-1 && maze[r][c+1] == DOT)
         markAllPaths(r, c+1);
      
   }
   /*  2  like AreaFill's counting without a static variable */  
   public int markAllPathsAndCountStars(int r, int c)
   {
      int count = 0;
      if (maze[r][c] == DOT){
         maze[r][c] = STEP;
         count++;
      }
      if (r < 0 || r > maze.length -1 || c < 0 || c > maze[0].length -1)
         return 0;
      if (r > 0 &&maze[r-1][c] == DOT)
         count += markAllPathsAndCountStars(r-1, c);
      if (c > 0 &&maze[r][c-1] == DOT)
         count += markAllPathsAndCountStars(r, c-1);
      if (r < maze.length - 1 &&maze[r+1][c] == DOT)
         count += markAllPathsAndCountStars(r+1, c);
      if (c < maze[0].length-1 &&maze[r][c+1] == DOT)
         count += markAllPathsAndCountStars(r, c+1);   
      return count;
   }

   /*  3   recur until you find E, then mark the True path */
   public boolean markTheCorrectPath(int r, int c)
   {
      boolean left = false;
      boolean right = false;
      boolean up = false;
      boolean down = false;
      System.out.println("Row: " + r + " Col: " + c);

      if (maze[r][c] == DOT){
         maze[r][c] = 'o';
         System.out.println("PLACED  "+DOT);
      }
      
      if (maze[r][c] == EXIT){
         System.out.println("EXIT");
         return true;
      }    
      if (r < 0 || r > maze.length -1 || c < 0 || c > maze[0].length -1){
         System.out.println("END  ");
         return false;
         }
   
      if (r > 0 && maze[r-1][c] == DOT){
      //if (maze[r-1][c] == DOT){
         up = true;
         maze[r][c] = '*';

         markTheCorrectPath(r-1, c);
      }
      
      if (c > 0 && maze[r][c-1] == DOT){
         maze[r][c] = '*';
         left = true;
         markTheCorrectPath(r, c-1);
      }
      if (r < maze.length - 1 && maze[r+1][c] == DOT){
      maze[r][c] = '*';

         down = true;
         markTheCorrectPath(r+1, c);
      }
       if (c < maze[0].length-1 && maze[r][c+1] == DOT){
      maze[r][c] = '*';
         right = true;
         markTheCorrectPath(r, c+1);
      }
     
         
      if (maze[r][c] !=START &&  up == false && down == false && right == false && left == false){
         maze[r][c] = DOT;
         }
  
       /*if (maze[r][c] !=START &&( up == true | down == true | right == true | left == true)){
         maze[r][c] = '*';
         }*/
      return false;
   }    
   /*  5  Mark only the correct path and display the count of STEPs.
          If no path exists, say so. */
   public boolean markCorrectPathAndCountSteps(int r, int c, int count)
   {
    
      boolean left = false;
      boolean right = false;
      boolean up = false;
      boolean down = false;
      System.out.println("Row: " + r + " Col: " + c);

      if (maze[r][c] == DOT){
         maze[r][c] = 'o';
         System.out.println("PLACED  "+DOT);
         count++;
      }
      
      if (maze[r][c] == EXIT){
         System.out.println("EXIT");
         count++;
         return true;
      }    
      if (r < 0 || r > maze.length -1 || c < 0 || c > maze[0].length -1){
         System.out.println("END  ");
         return false;
         }
   
      if (r > 0 && maze[r-1][c] == DOT){
      //if (maze[r-1][c] == DOT){
         up = true;
         maze[r][c] = '*';
count++;
         markTheCorrectPath(r-1, c);
      }
      
      if (c > 0 && maze[r][c-1] == DOT){
         maze[r][c] = '*';
         left = true;
         count++;
         markTheCorrectPath(r, c-1);
      }
      if (r < maze.length - 1 && maze[r+1][c] == DOT){
      maze[r][c] = '*';
         count++;
         down = true;
         markTheCorrectPath(r+1, c);
      }
       if (c < maze[0].length-1 && maze[r][c+1] == DOT){
      maze[r][c] = '*';
         right = true;
         count++;
         markTheCorrectPath(r, c+1);
      }
     
         
      if (maze[r][c] !=START &&  up == false && down == false && right == false && left == false){
         maze[r][c] = DOT;
         count++;
         }
   System.out.println(count);
      return false;
   }
}


