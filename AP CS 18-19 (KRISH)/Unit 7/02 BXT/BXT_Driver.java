// Name: R2-17
// Date: 2/12/19

import java.util.*;

/*  Driver for a binary expression tree class.
 *  Input: a postfix string, space delimited tokens. 
 */
public class BXT_Driver
{
   public static void main(String[] args)
   {
      String r = "";
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
  /***********************
   Builds a BXT from a postfix expression.  Uses a helper stack of  
   TreeNodes.
  ****************************/

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
      {
         return 0.0;
      }
      else if (t.getLeft() == null && t.getRight() == null)
      {
         return Double.parseDouble(t.getValue() + "");
      }
      else if (isOperator(t.getLeft().getValue() + "") && isOperator(t.getRight().getValue() + ""))  {
         evaluateNode(t.getLeft());
         evaluateNode(t.getRight());
         toRet = evaluateNode(t);
      }
      else if (isOperator(t.getValue() + "") && (!isOperator(t.getLeft().getValue() + "") && !isOperator(t.getRight().getValue() + "")))
      {
         double a = Double.parseDouble(t.getLeft().getValue() + "");
         double b = Double.parseDouble(t.getRight().getValue() + "");
         String s = t.getValue() + "";
         t.setValue(computeTerm(s, a, b) + "");
         t.setLeft(null);
         t.setRight(null);
         toRet = computeTerm(s, a, b);
      }
      else if (isOperator(t.getValue() + "") && (isOperator(t.getLeft().getValue() + "") && !isOperator(t.getRight().getValue() + "")))
      {
         evaluateNode(t.getLeft());
         toRet = evaluateNode(t);
      }
      else if (isOperator(t.getValue() + "") && (!isOperator(t.getLeft().getValue() + "") && isOperator(t.getRight().getValue() + "")))
      {
         evaluateNode(t.getRight());
         toRet = evaluateNode(t);
      }
      return toRet;
   }
   
   private double computeTerm(String s, double a, double b)
   {
      double toRet = 0;
      if (s.equals("+"))
         toRet = a + b;
      else if (s.equals("-"))
         toRet = a - b;
      else if (s.equals("*"))
         toRet = a * b;
      else if (s.equals("/"))
         toRet = a/b;
      return toRet;
   }
   
   private boolean isOperator(String op)
   {
      if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("^") || op.equals("%"))
         return true;
      return false;
   }
   
   public String display()
   {
      return display(root, 0);
   }
   
   private String display(TreeNode t, int level)
   {
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
    
   public String inorderTraverse()
   {
      return inorderTraverse(root);
   }
   
   private  String inorderTraverse(TreeNode t)
   {
      String toRet = "";
      if (t == null){
         return "";
      }
      toRet += inorderTraverse(t.getLeft());
      toRet += t.getValue() + " ";
      toRet += inorderTraverse(t.getRight());
      return toRet;
   
   }
   
   public String preorderTraverse()
   {
      return preorderTraverse(root);
   }
   
   private String preorderTraverse(TreeNode root)
   {
      String toReturn = "";
      if(root == null)
         return "";
      toReturn += root.getValue() + " ";              //preorder visit
      toReturn += preorderTraverse(root.getLeft());   //recurse left
      toReturn += preorderTraverse(root.getRight());  //recurse right
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