// Name:              Date:
import java.util.*;
import java.io.*;
public class deHuffman
{
   public static void main(String[] args) throws IOException
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("\nWhat binary message (middle part)? ");
      String middlePart = keyboard.next();
      Scanner sc = new Scanner(new File("message."+middlePart+".txt")); 
      String binaryCode = sc.next();
      Scanner huffLines = new Scanner(new File("scheme."+middlePart+".txt")); 
 
      TreeNode root = huffmanTree(huffLines);
      String message = dehuff(binaryCode, root);
      System.out.println(message);
      	
      sc.close(); 
      huffLines.close();
   }
   public static TreeNode huffmanTree(Scanner huffLines)
   {
      TreeNode t = new TreeNode("");
      TreeNode temp = new TreeNode("");
      while (huffLines.hasNext())
      {
         String decode = huffLines.next();
         decode = decode.substring(1) + decode.substring(0, 1);
         t = huffRecursize(t, decode);
         
      }
      return t;
   }
   public static TreeNode huffRecursize(TreeNode t, String binary)
   {
      String val = "";
      if (binary.length() <= 1)
         val = binary;
      else
         val = binary.substring(0, 1);
      if (val.equals("0"))
      {
         t.setValue("");
         t.setLeft(huffRecursize(t, binary.substring(1)));
      }
      else if (val.equals("1"))
      {
         t.setValue("");
         t.setRight(huffRecursize(t, binary.substring(1)));
      }
      else
      {
         t.setValue(val);
      }
      return t;
   }
   public static String dehuff(String text, TreeNode root)
   {
      String toRet = "";
      String[] arr = text.split("");
      for (String s : arr)
      {
         if (s.equals("0"))
         {
            toRet += dehuff(text.substring(1), root.getLeft());
         }
         if (s.equals("1"))
         {
            toRet += dehuff(text.substring(1), root.getRight());
         }
         if (!root.getValue().equals("0") || !root.getValue().equals("1"))
            toRet += root.getValue() + "";   
      }
      return toRet;
   }
}

 /* TreeNode class for the AP Exams */
class TreeNode
{
   private Object value; 
   private TreeNode left, right;
   
   public TreeNode(Object initValue)
   { 
      value = initValue; 
      left = null; 
      right = null; 
   }
   
   public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight)
   { 
      value = initValue; 
      left = initLeft; 
      right = initRight; 
   }
   
   public Object getValue()
   { 
      return value; 
   }
   
   public TreeNode getLeft() 
   { 
      return left; 
   }
   
   public TreeNode getRight() 
   { 
      return right; 
   }
   
   public void setValue(Object theNewValue) 
   { 
      value = theNewValue; 
   }
   
   public void setLeft(TreeNode theNewLeft) 
   { 
      left = theNewLeft;
   }
   
   public void setRight(TreeNode theNewRight)
   { 
      right = theNewRight;
   }
}
