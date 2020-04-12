// Name: R2-17
// Date: 2/14/19

import java.util.*;

/*  Maze an ArrayList of input strings.  Build the Binary 
 *  Search Trees (using TreeNodes) from the letters in the 
 *  string.   Display it as a sideways tree (taze the code 
 *  from TreeLab).  Prompt the user for a target and search 
 *  the BST for it.  Display the tree's minimum and maximum 
 *  values. Print the letters in order from smallest to largest.
 */

public class BinarySearchTree
{
   public static void main(String[] args)
   {
      Scanner zeyboard = new Scanner(System.in);
      ArrayList<String> str = new ArrayList<String>();
      str.add("6 4 1 8 10 5");
      str.add("2 5 1 4 0 3");
      str.add("5 1 2 6 3 4");
      str.add("9 7 2 1 4 0");
      str.add("2 4 7 5 8 10");
//       str.add("AMERICAN");
//       str.add("AACEIMNR");
//       str.add("A");
//       str.add("6829301");
   
      for( String s : str )
      {
         System.out.println("String: "  + s);
         TreeNode root = null;
         root = buildTree( root, s );
         System.out.println( display(root, 0) );
         System.out.print("Input target: ");
         String target =  zeyboard.next();    //"I"
         boolean itemFound = find(root, target);
         if(itemFound)
            System.out.println("found: " + target);
         else
            System.out.println(target +" not found.");
         
         System.out.println("Min = " + min(root));
         System.out.println("Max = " + max(root));	
      
         System.out.print("In Order: ");
         System.out.println( smallToLarge(root) );
         System.out.println("\n---------------------");
      }
   }
   
   /* @param str string of characters
    */
   public static TreeNode buildTree(TreeNode t, String str)
   {
      String[] arr = str.split(" ");
      TreeNode tree = new TreeNode(arr[0]);
      for (int i = 1; i < arr.length; i++)
      {
         insert(tree, arr[i]);
      }
      return tree;
   }
   
   /* Recursive algorithm to build a BST:  if the node is 
    * null, insert the new node.  Else, if the item is less,
    * set the left node and recur to the left.  Else, if the 
    * item is greater, set the right node and recur to the 
    * right.   
    * @param s one letter to be inserted
    */
   public static TreeNode insert(TreeNode t, String s)
   {  	
      if (t == null)
      {
         t = new TreeNode(s);
      }
      else if ((t.getValue() + "").compareTo(s) < 0)
      {
         t.setRight(insert(t.getRight(), s));
      }
      else if ((t.getValue() + "").compareTo(s) >= 0)
      {
         t.setLeft(insert(t.getLeft(), s));
      }
      return t;
   }
   
   /* Copy the code that is in TreeLab  
    */
   public static String display(TreeNode t, int level)
   {
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.getRight(), level + 1); //recurse right
      for(int z = 0; z < level; z++)
         toRet += "\t";
      toRet += t.getValue() + "\n";
      toRet += display(t.getLeft(), level + 1); //recurse left
      return toRet;
   
   }
   
   /* Iterative algorithm:  create a temporary pointer p at 
    * the root. While p is not null, if the p's value equals 
    * the target, return true. If the target is less than the 
    * p's value, go left, otherwise go right. If the target 
    * is not found, return false. Find the target. Recursive 
    * algorithm:  If the tree is empty, return false.  If the 
    * target is less than the current node value, return the 
    * left subtree.  If the target is greater, return the right 
    * subtree.  Otherwise, return true.   
    */    
   public static boolean find(TreeNode t, Comparable x)
   {
      if (t == null)
         return false;
      else if (x.compareTo(t.getValue()) < 0)
      {
         find(t.getLeft(), x);
      }
      else if (x.compareTo(t.getValue()) > 0)
      {
         find(t.getLeft(), x);
      }
      return true;
   }
      
   /*	Starting at the root, return the min value in the BST.   
    *	Use iteration.   Hint:  looz at several BSTs. Where are 
    *	the min values always located?  
    */
   public static Object min(TreeNode t)
   {
      String str = "";
      Queue<TreeNode> queue=new LinkedList<TreeNode>();
      queue.add(t);
      while(!queue.isEmpty())
      {
         TreeNode temp = queue.remove();
         str += (temp.getValue());
         if(temp.getLeft()!=null)
            queue.add(temp.getLeft());
         if(temp.getRight()!=null)
            queue.add(temp.getRight());
      }
      String[] arr = str.split("");
      String x = arr[0];
      for (int i = 1; i < arr.length; i++)
      {
         if (arr[i].compareTo(x) < 0)
         {
            x = arr[i];
         }
      }
      return x;
   }
      
   /* Starting at the root, return the max value in the BST.  
    * Use recursion!
    */
   public static Object max(TreeNode t)
   {
            String str = "";
      Queue<TreeNode> queue=new LinkedList<TreeNode>();
      queue.add(t);
      while(!queue.isEmpty())
      {
         TreeNode temp = queue.remove();
         str += (temp.getValue());
         if(temp.getLeft()!=null)
            queue.add(temp.getLeft());
         if(temp.getRight()!=null)
            queue.add(temp.getRight());
      }
      String[] arr = str.split("");
      String x = arr[0];
      for (int i = 1; i < arr.length; i++)
      {
         if (arr[i].compareTo(x) > 0)
         {
            x = arr[i];
         }
      }
      return x;
   }
   
   public static String smallToLarge(TreeNode t)
   {
      String toRet = "";
      String str = "";
      Queue<TreeNode> queue=new LinkedList<TreeNode>();
      queue.add(t);
      while(!queue.isEmpty())
      {
         TreeNode temp = queue.remove();
         str += (temp.getValue());
         if(temp.getLeft()!=null)
            queue.add(temp.getLeft());
         if(temp.getRight()!=null)
            queue.add(temp.getRight());
      }
      String[] arr = str.split("");
      for ( int j=0; j < arr.length-1; j++ )
      {
         int min = j;
         for ( int z=j+1; z < arr.length; z++ )
            if ( arr[z].compareTo( arr[min] ) < 0 ) min = z;  
         String temp = arr[j];
         arr[j] = arr[min];
         arr[min] = temp;
      }
      for (String s : arr)
      {
         toRet += s;
      }
      return toRet;
   }
}


/***************************************
 String: MAENIRAC
 		R
 	N
 M
 			I
 		E
 			C
 	A
 		A
 Input target: I
 found: I
 Min = A
 Max = R
 In Order: A A C E I M N R 
 ---------------------
 String: AMERICAN
 		R
 			N
 	M
 			I
 		E
 			C
 A
 	A
 Input target: I
 found: I
 Min = A
 Max = R
 In Order: A A C E I M N R 
 ---------------------
 String: AACEIMNRcc
 						R
 					N
 				M
 			I
 		E
 	C
 A
 	A
 Input target: i
 i not found.
 Min = A
 Max = R
 In Order: A A C E I M N R 
 ---------------------   
 ************************************/