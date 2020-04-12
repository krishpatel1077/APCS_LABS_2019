// Name:
// Date:

import java.util.*;

/*  Driver for a binary expression tree class.
 *  Input: a postfix string, space delimited tokens. 
 */
public class BXT_DriverPrintable
{
   public static void main(String[] args)
   {
      ArrayList<String> postExp = new ArrayList<String>();
      postExp.add("14 -5 /");
      postExp.add("20.0 3.0 -4.0 + *");
      postExp.add("2 3 + 5 / 4 5 - *");
      postExp.add("5.6");
   
      for( String postfix : postExp )
      {
         System.out.println("Postfix Exp: "  + postfix);
         BXT tree = new BXT();
         tree.buildTree( postfix );
         System.out.println("BXT: "); 
         System.out.println( tree.display() );
         System.out.print("Infix order:  ");
         System.out.println( tree.inorderTraverse() );
         System.out.print("Prefix order:  ");
         System.out.println( tree.preorderTraverse() );
         System.out.print("Evaluates to " + tree.evaluateTree());
         System.out.println( "\n------------------------");
      }
   }
}

/*  Represents a binary expression tree.
 *  The BXT builds itself from postorder expressions. It can
 *  evaluate and print itself.  Also prints inorder and postorder strings. 
 */
class BXT
{
   private TreeNode root;
   
   public BXT()
   {
      root = null;
   }
    
   public void buildTree(String str)
   {
      String[] arr = str.split(" ");
      Stack<TreeNode> stk = new Stack<TreeNode> ();
      for (String s : arr)
      {
         if (isOperator(s))
         {
            TreeNode t = new TreeNode(s);
            t.setRight(stk.pop());
            t.setLeft(stk.pop());
            stk.push(t);
         }
         else
         {
            stk.push(new TreeNode(s));
         }
      }
      root = stk.pop();
   }
   
   public double evaluateTree()
   {
      return evaluateNode(root);
   }
   
   private double evaluateNode(TreeNode t)  //recursive
   {
      double toRet = 0.0;
      if (t == null)
         return 0.0;
      else if (isOperator(t.getValue() + "") && !isOperator(t.getLeft().getValue() + "") && !isOperator(t.getRight().getValue() + ""))
      {
         String s = t.getValue() + "";
         double a = (double) t.getLeft().getValue();
         double b = (double) t.getRight().getValue();
         toRet = computeTerm(s, a, b);
      }
      else if (isOperator(t.getValue() + "") && isOperator(t.getLeft().getValue() + "") && isOperator(t.getRight().getValue() + ""))
      {
         double a = evaluateNode(t.getLeft());
         double b = evaluateNode(t.getRight());
         String s = t.getValue() + "";
         toRet = computeTerm(s, a, b);
      }
      else if (isOperator(t.getValue() + "") && !isOperator(t.getLeft().getValue() + "") && isOperator(t.getRight().getValue() + ""))
      {
         double a = (double)t.getLeft().getValue();
         double b = evaluateNode(t.getRight());
         String s = t.getValue() + "";
         toRet = computeTerm(s, a, b);
      }
      else if (isOperator(t.getValue() + "") && isOperator(t.getLeft().getValue() + "") && !isOperator(t.getRight().getValue() + ""))
      {
         double a = evaluateNode(t.getLeft());
         double b = (double)t.getRight().getValue();
         String s = t.getValue() + "";
         toRet = computeTerm(s, a, b);
      }
      return toRet;
   }
   
   private double computeTerm(String s, double a, double b)
   {
      if (s.equals("+"))
         return a+b;
      else if (s.equals("-"))
         return a-b;
      else if (s.equals("*"))
         return a*b;
      return a/b;
   }
   
   private boolean isOperator(String s)
   {
    if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
    return true;
    return false;
   }
   
   public String display()
   {
      return display(root, 0);
   }
   
   private String display(TreeNode t, int level)
   {
   
   }
    
   public String inorderTraverse()
   {
      return inorderTraverse(root);
   }
   
   private  String inorderTraverse(TreeNode t)
   {
     String toRet = "";
     if (t == null)
     {
     return "";
     }
     inorderTraverse(t.getLeft());
     toRet += t.getValue();
     inorderTraverse(t.getRight());
     return toRet;
   }
   
   public String preorderTraverse()
   {
      return preorderTraverse(root);
   }
   
   private String preorderTraverse(TreeNode root)
   {
   String toReturn = "";
      if(t == null)
         return "";
      toReturn += t.getValue() + " ";             
      toReturn += preorderTraverse(t.getLeft());  
      toReturn += preorderTraverse(t.getRight()); 
      return toReturn;
   }

}

/***************************************

 Postfix Exp: 14 -5 /
 	-5
 /
 	14
 Infix order:  14 / -5 
 Prefix order:  / 14 -5 
 Evaluates to -2.8
 ------------------------
 Postfix Exp: 20.0 3.0 -4.0 + *
 		-4.0
 	+
 		3.0
 *
 	20.0
 Infix order:  20.0 * 3.0 + -4.0 
 Prefix order:  * 20.0 + 3.0 -4.0 
 Evaluates to -20.0
 ------------------------
 Postfix Exp: 2 3 + 5 / 4 5 - *
 		5
 	-
 		4
 *
 		5
 	/
 			3
 		+
 			2
 Infix order:  2 + 3 / 5 * 4 - 5 
 Prefix order:  * / + 2 3 5 - 4 5 
 Evaluates to -1.0
 ------------------------
 Postfix Exp: 5.6
 5.6
 Infix order:  5.6 
 Prefix order:  5.6 
 Evaluates to 5.6
 ------------------------
 
 *******************************************/