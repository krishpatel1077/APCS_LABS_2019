// Name: R2-17
// Date: 2/1/18

import java.util.*;

public class TreeLab
{
   public static TreeNode root = null;
   private static int le = 0;
   private static int ri = 0;
   public static String r = "";
   public static String e = "";
   public static String s = "XCOMPUTERSCIENCE";
   //public static String s = "XThomasJeffersonHighSchool"; 
   //public static String s = "XAComputerScienceTreeHasItsRootAtTheTop";
   //public static String s = "XA";   //comment out lines 44-46 below
   //public static String s = "XAF";  //comment out lines 44-46 below
   //public static String s = "XAFP";  //comment out lines 44-46 below
   //public static String s = "XDFZM";  //comment out lines 44-46 below 
   
   public static void main(String[] args)
   {
      root = buildTree( root, s );
      System.out.print( display( root, 0) );
   
      System.out.print("\nPreorder: " + preorderTraverse(root));
      System.out.print("\nInorder: " + inorderTraverse(root));
      System.out.print("\nPostorder: " + postorderTraverse(root));
   
      System.out.println("\n\nNodes = " + countNodes(root));
      System.out.println("Leaves = " + countLeaves(root));
      System.out.println("Only children = " + countOnlys(root));
      System.out.println("Grandparents = " + countGrandParents(root));
   
      System.out.println("\nHeight of tree = " + height(root));
      System.out.println("Longest path = " + longestPath(root));
      System.out.println("Min = " + min(root));
      System.out.println("Max = " + max(root));	
   
      System.out.println("\nBy Level: ");
      System.out.println(displayLevelOrder(root));
   }
 
   public static TreeNode buildTree(TreeNode root, String s)
   {
      root = new TreeNode("" + s.charAt(1), null, null);
      for(int pos = 2; pos < s.length(); pos++)
         insert(root, "" + s.charAt(pos), pos,(int)(1 + Math.log(pos) / Math.log(2)));
      insert(root, "A", 17, 5); 
      insert(root, "B", 18, 5); 
      insert(root, "C", 37, 6); //B's right child
      return root;
   }

   public static void insert(TreeNode t, String s, int pos, int level)
   {
      TreeNode p = t;
      for(int k = level - 2; k > 0; k--)
      {
         if((pos & (1 << k)) == 0)
            p = p.getLeft();
         else
            p = p.getRight();
      }
      if((pos & 1) == 0)
         p.setLeft(new TreeNode(s, null, null));
      else
         p.setRight(new TreeNode(s, null, null));
   }
   
   private static String display(TreeNode t, int level)
   {
      // turn your head towards left shoulder visualize tree
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.getValue() + "\n";
      toRet += display(t.getLeft(), level + 1); //recurse left
      return toRet;
   }
   
   public static String preorderTraverse(TreeNode t)
   { 
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += t.getValue() + " ";              //preorder visit
      toReturn += preorderTraverse(t.getLeft());   //recurse left
      toReturn += preorderTraverse(t.getRight());  //recurse right
      return toReturn;
   }
   
   public static String inorderTraverse(TreeNode t)
   {
      if (t == null){
         return "";
      }
      inorderTraverse(t.getLeft());
      r += (t.getValue() + " ");
      inorderTraverse(t.getRight());
      return r;
   }
   public static String postorderTraverse(TreeNode t)
   {
      if (t == null){
         return "";
      }
      postorderTraverse(t.getLeft());
      postorderTraverse(t.getRight());
      e += (t.getValue() + " ");
      return e;
   }
   
   public static int countNodes(TreeNode t)
   {
      if (t == null)
         return 0;
      else
         return 1 + countNodes(t.getLeft()) + countNodes(t.getRight());
   }
   
   public static int countLeaves(TreeNode t)
   {
      if (t == null)
         return 0;
      else
      {
         if ((t.getLeft() == null) && (t.getRight() == null))
            return 1;
         else
            return countLeaves(t.getLeft()) + countLeaves(t.getRight());
      }
   
   }
   
   /*  there are clever ways and hard ways to count grandparents  */ 
   public static int countGrandParents(TreeNode t)
   {
      if (t.getLeft() == null && t.getRight() == null){
         return -1;
      }
      else{
         int lgrand = height(t.getLeft());
         int rgrand = height(t.getRight());
         return lgrand + rgrand - 1;
      }
   }
   
   public static int countOnlys(TreeNode t)
   {
      if(t == null || numKid(t)==0)
      {
         return 0;
      }
      if(numKid(t)== 1)
      {
         return 1+ countOnlys(t.getLeft()) + countOnlys(t.getRight());
      }
      if(numKid(t)== 2)
      {
         return countOnlys(t.getLeft()) + countOnlys(t.getRight());
      }
      return 0;
   }
   
   public static int numKid (TreeNode t){
      int count = 0;
      if(t.getLeft() != null )
         count++;
      if(t.getRight() != null)
         count++;       
      return count;   
   }
   /* Returns the max of the heights on both sides of the tree
	 */
   public static int height(TreeNode t)
   {
      if (t == null) 
         return -1; 
      else 
      { 
         int l = height(t.getLeft()); 
         int r = height(t.getRight()); 
         if (l > r) 
            return (l + 1); 
         else 
            return (r + 1); 
      } 
   }
   
   /* Returns the max of sum of heights on both sides of tree
	 */   
   public static int longestPath(TreeNode t)
   {
      int lheight = height(t.getLeft()) + 1;
      int rheight = height(t.getRight()) + 1;
      return lheight + rheight;
   }
   
   /*  Object must be cast to Comparable in order to call .compareTo  
    */
   @SuppressWarnings("unchecked")
   public static Object min(TreeNode t)
   {
      String[] str = inorderTraverse(t).split(" ");
      String min = str[0];
      for (int i = 1; i < str.length; i++){
      if (str[i].compareTo(min) < 0)
      min = str[i];
      }
      return min;
   }
   
   /*  Object must be cast to Comparable in order to call .compareTo  
    */
   @SuppressWarnings("unchecked")
   public static Object max(TreeNode t)
   {
       String[] str = inorderTraverse(t).split(" ");
      String max = str[0];
      for (int i = 1; i < str.length; i++){
      if (str[i].compareTo(max) > 0)
      max = str[i];
      }
      return max;
   }
      
   /* This method is not recursive.  Use a local queue
    * to store the children of the current TreeNode.
    */
   public static String displayLevelOrder(TreeNode t)
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
      return str;
   }
   
}

/***************************************************
    ----jGRASP exec: java TreeLab
 		  	E
 		E
 			C
 	M
 			N
 		T
 			E
 C
 			I
 		U
 			C
 	O
 			S
 					C
 				B
 		P
 				A
 			R
 
 Preorder: C O P R A S B C U C I M T E N E C E 
 Inorder: R A P B C S O C U I C E T N M C E E 
 Postorder: A R C B S P C I U O E N T C E E M C 
 
 Nodes = 18
 Leaves = 8
 Only children = 3
 Grandparents = 5
 
 Height of tree = 5
 Longest path = 8
 Min = A
 Max = U
 
 By Level: 
 COMPUTERSCIENCEABC    
 *******************************************************/
