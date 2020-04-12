//Name: R2-17
//Date: 4/19/19
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
      TreeNode t = new TreeNode(null);
      while(huffLines.hasNext())
      {
         String decode = huffLines.nextLine();
         String val = decode.substring(0,1);
         decode = decode.substring(1);
         TreeNode temp = t;
         while(decode.length() != 0)
         {
            if(decode.substring(0,1).equals("0"))
            {
               if(temp.getLeft() == null)
                  temp.setLeft(new TreeNode(""));
               temp = temp.getLeft();
               decode = decode.substring(1);
            }
            else
            {
               if(temp.getRight() == null)
                  temp.setRight(new TreeNode(""));
               temp = temp.getRight();
               decode = decode.substring(1);
            }	
         }
         temp.setValue(val);
      }
      return t;
   }
   public static String dehuff(String text, TreeNode root)
   {
      String str = "";
      TreeNode temp = root;
      while(!text.equals(""))
      {
         if(text.substring(0,1).equals("0"))
         {
            temp = temp.getLeft();
            text = text.substring(1);
         }
         else
         {
            temp = temp.getRight();
            text = text.substring(1);
         }
         if(temp.getRight() == null && temp.getLeft() == null)
         {
            str += temp.getValue() + "";
            temp = root;
         }
      }
      return str;
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


