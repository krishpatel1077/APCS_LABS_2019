// Name: R2-17
// Date: 12/31/18

import java.util.*;

public class Postfix
{
   public static void main(String[] args)
   {
      System.out.println("Postfix  -->  Evaluate");
      ArrayList<String> postfixExp = new ArrayList<String>();
      /*  build your list of expressions here  */
      postfixExp.add("3 4 5 * +");
      postfixExp.add("3 4 * 5 +");
      postfixExp.add("10 20 + -6 6 * +"); 
      postfixExp.add("3 4 + 5 6 + *");
      postfixExp.add("3 4 5 + * 2 - 5 /");
      postfixExp.add("8 1 2 * + 9 3 / -");
      postfixExp.add("20 3 %");
      postfixExp.add("21 3 %");
      postfixExp.add("22 3 %");
      postfixExp.add("23 3 %");
      postfixExp.add("5 !");
      postfixExp.add("1 1 1 1 1 + + + + !");
      for( String pf : postfixExp )
      {
         System.out.println(pf + "\t\t" + eval(pf));
      }
   }
   
   public static int eval(String pf)
   {
      List<String> postfixParts = new ArrayList<String>(Arrays.asList(pf.split(" ")));
      /*  enter your code here  */
      int cumsum = 0;
      Stack<String> stk = new Stack<String> ();
      for (String str : postfixParts)
      {
         if (isOperator(str))
         {
            int a = Integer.parseInt(stk.pop());
            int b = Integer.parseInt(stk.pop());
            cumsum = eval(a, b, str);
            stk.push("" + cumsum);
         }
         else if (str.equals("!"))
         {
            int factorial = Integer.parseInt(stk.pop());
            cumsum = eval(factorial, 1, "!");
            stk.push("" + cumsum);
         }
         else
         {
            stk.push(str);
         }
      }
      return Integer.parseInt(stk.pop());          
   }
   
   public static int eval(int a, int b, String ch)
   {  
      if (ch.equals("+"))
         return a + b;
      if (ch.equals("-"))
         return a-b;
      if (ch.equals("*"))
         return a*b;
      if (ch.equals("/"))
         return b/a;
      if (ch.equals("%"))
         return b%a;
      else
      {
         return factorial(a, a);
      }
   }
   public static int factorial(int num, int sum)
   {
      if (num == 1)
         return sum;
      else
      {
         return factorial(num-1, sum*(num-1));
      }
   }
   public static boolean isOperator(String op)
   {
      if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("%"))
         return true;
      return false;
   }
}