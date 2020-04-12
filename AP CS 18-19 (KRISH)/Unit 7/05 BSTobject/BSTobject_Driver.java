// Name: R2-17
// Date: 2/22/19

import java.util.*;
import java.io.*;
public class BSTobject_Driver
{
   public static BSTobject<String> tree = null;
   public static BSTobject<Widget> treeOfWidgets = null;
   public static int numberOfWidgets = 10;
   public static void main( String[] args ) 
   {
      // Day one 
      tree = new BSTobject<String>();
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a String: ");
      String str = sc.nextLine();
      tree = buildS(tree, str);
      System.out.print(tree);
      System.out.println("Size: " + tree.size());
      System.out.println("Is empty: "+ tree.isEmpty());
   		
   	// Day two
   	// Your assignment the second day is to finish the BSTobje  ct class.  
   	// Specifically, prompt the user for a string, put the characters into 
      // a BST, call toString on this tree, and print the size of the tree.
      
      // Day two, Widgets		       	
   	// Next, fill your BST with 10 Widget objects from widgets.txt.  Display 
      // the tree. Then prompt the user to enter cubits and hands.  If the tree 
      // contains that Widget, delete it, of course restoring the BST order. 
      // Display the new tree and its size. If the tree does not contain that 
      // Widget, print "Not found".*/
      treeOfWidgets =  new BSTobject<Widget>();
      treeOfWidgets = buildW(treeOfWidgets, new File("widgets.txt"));
      System.out.println("--------------------------------------------------------");
      System.out.print(treeOfWidgets);
      Scanner infile = new Scanner(System.in);
      System.out.println("Delete which Object: ");
      String s = sc.nextLine();
      String[] arr = s.split(" ");
      int cubits = Integer.parseInt(arr[0]);
      int hands = Integer.parseInt(arr[1]);
      treeOfWidgets.delete(new Widget(cubits, hands));
      System.out.print(treeOfWidgets);
   	// Day three -- AVL tree  -----------------------
   }
  
   /* Build the tree for Strings, Day 1
    */
   public static BSTobject<String> buildS(BSTobject<String> tree, String str)
   {
      String[] arr = str.split("");
      for (int i = 0; i < arr.length; i++)
      {
         tree.add(arr[i]);
      }
      return tree;
   }
   
   /* Build the tree for Widgets, Day 2
    */
   public static BSTobject<Widget> buildW(BSTobject<Widget> tree, File file)
   {
      Scanner infile = null;
      try{
         infile = new Scanner( file  );
      }
      catch (Exception e)
      {
         System.out.println("File not found.");
      }
      
      for(int i = 0; i < numberOfWidgets; i++)   
      {
         int cubits = Integer.parseInt(infile.next());
         int hands = Integer.parseInt(infile.next());
         tree.add(new Widget(cubits, hands));
      }
      return tree;
   }
}

interface BSTinterface<E extends Comparable<E>>
{
   public E add( E element );             //returns the object
   public boolean contains( E element );
   public boolean isEmpty();
   public E delete( E element );          //returns the object, not a Node<E>
   public int size();
   public String toString();
}

class BSTobject <E extends Comparable<E>> implements BSTinterface<E>
{ 
   // Declare 2 fields
   private Node<E> root;
   private int size; 
   // Create a default constructor
   public BSTobject()
   {
      root = null;
      size = 0;
   }   
   //instance methods
   public E add( E obj )
   {
      Node<E> n = add( root, obj );
      root = n;
      size++;
      return obj;
   }
   
   //recursive helper method
   private Node<E> add( Node<E> t, E obj )
   {
      if (t == null)
      {
         t = new Node(obj);
      }
      else if (t.getValue().compareTo(obj) < 0)
      {
         t.setRight(add(t.getRight(), obj));
      }
      else if (t.getValue().compareTo(obj) >= 0)
      {
         t.setLeft(add(t.getLeft(), obj));
      }
      return t;
   
   }
   
   public boolean contains(E element)
   {
      return contains(root, element);
   }
   
   private boolean contains(Node<E> tree, E element)
   {
      if (tree == null)
         return false;
      
      else
      {
         int compare = element.compareTo(tree.getValue());
         if (compare == 0)
            return true;
         else if (compare < 0)
            return contains(tree.getLeft(), element);
         else
            return contains(tree.getRight(), element);
      }
   }
   public E delete(E element)
   {
      return delete(root, element);
   }
   public E delete(Node<E> current, E target)
   {
      Node<E> root = current;  //don't lose the root!
      Node<E> parent = null;
      if (root == null)
      {
         return null;
      }
      else
      {
         int compare = target.compareTo(current.getValue());
        // ------->  your code goes here
         if (compare < 0)
         {
            root.setLeft(new Node(delete(root.getLeft(), target)));
         }
         else if (compare > 0)
         {
            root.setRight(new Node(delete(root.getRight(), target)));
         }
         else
         {
            if (root.getLeft() == null && root.getRight() != null)
               return root.getRight().getValue();
            else if (root.getRight() == null && root.getLeft() != null)
               return root.getLeft().getValue();
            else if (root.getLeft() == null && root.getRight()== null)
            {
               root.setValue(new Node(null));
               return null;
            }
            root.setValue(new Node(minVal(root.getRight())));
            root.setRight(new Node(delete(root.getRight(), root.getValue())));
         }
      }
      return root.getValue();
   }  
   public E minVal(Node<E> t)
   {
      E min = t.getValue();
      while (t.getLeft() != null)
      {
         min = t.getValue();
         t.setValue(t.getLeft());
      }
      return min;
   }
   /* Implement the interface here.  Use TreeNode as an example,
    * but root is a field. You need add, contains, isEmpty, 
    * delete, size, and toString.  
    */
   public String toString()
   {
      return toString(root, 1);
   }
   public String toString(Node<E> t, int level)
   {
      String toRet = "";
      if(t == null)
         return "";
      toRet += toString(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.getValue() + "\n";
      toRet += toString(t.getLeft(), level + 1); //recurse left
      return toRet;
   }
   public boolean isEmpty()
   {
      return isEmpty(root);
   }
   public boolean isEmpty(Node<E> n)
   {
      if(n.getValue() == null)
         return true;
      return false;
   }
   public int size()
   {
      return size(root);
   }
   public int size(Node<E> n)
   {
      return size;
   }
   /* Private inner class 
    */  
   private class Node<E>
   {
      // 3 fields
      private E root;
      private Node<E> left;
      private Node<E> right; 
      // 2 constructors, one-arg and three-arg
      public Node(E val)
      {
         this(null, val, null);
      }
      public Node(Node<E> l, E v, Node<E> r)
      {
         left = l;
         right = r;
         root = v;
      }
      //methods--Use TreeNode as an example. See Quick Reference Guide.
      public E getValue()
      {
         return root;
      }
      public Node<E> getLeft()
      {
         return left;
      }
      public Node<E> getRight()
      {
         return right;
      }
      public void setValue(Node<E> obj)
      {
         root = obj.getValue();
      }
      public void setLeft(Node<E> t)
      {
         left = t;
      }
      public void setRight(Node<E> t)
      {
         right = t;
      }
   }
   public class Widget implements Comparable<Widget>
   {
   
      private int myCubits, myHands;
   
      public Widget()
      {
         myCubits = myHands = 0;
      }
   
      public Widget(int x)
      {
         myCubits = x;
         myHands = 0;
      }
   
      public Widget(int x, int y)
      {
         myCubits = x;
         myHands = y;
      }
   
      public Widget(Widget arg)
      {
         myCubits = arg.getCubits();
         myHands = arg.getHands();
      }
   
      public int getCubits()
      {
         return myCubits;
      }
   
      public int getHands()
      {
         return myHands;
      }
   
      public void setCubits(int x)
      {
         myCubits = x;
      }
   
      public void setHands(int x)
      {
         myHands = x;
      }
   
      public int compareTo(Widget other)
      {
         if(myCubits < other.getCubits())
            return -1;
         if(myCubits > other.myCubits)
            return 1;
         if(myHands < other.myHands)
            return -1;
         if(myHands > other.getHands())
            return 1;
         return 0;
      }
   
      public boolean equals(Widget other)    //not equals(Object arg)
      {
         return compareTo(other) == 0;
      }
   
      public String toString()
      {
         return myCubits + " cubits " + myHands + " hands";
      }   
         
      public boolean equals(Object arg)
      {
         return equals((Widget)arg );
      }
   
      public int hashCode()
      {
         return toString().hashCode();
      }   
   }
}
