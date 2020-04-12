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
      postfixExp.add("2 3 + 5 / 4 5 - *"); 
      postfixExp.add("3 4 * 5 +");
      postfixExp.add("10 20 + -6 6 * +"); 
      postfixExp.add("3 4 + 5 6 + *");
      postfixExp.add("3 4 5 + * 2 - 5 /");
      postfixExp.add("8 1 2 * + 9 3 / -");
      postfixExp.add("2 3 ^");
      postfixExp.add("20 3 %");
      postfixExp.add("21 3 %");
      postfixExp.add("22 3 %");
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
          int finale = 0;
          Stack<String> stk = new Stack<String> ();
          Stack<String> tempstk = new Stack<String> ();
          for (String s : postfixParts){
             if (isOperator(s)){
                int x = Integer.parseInt(stk.pop());
                int y = Integer.parseInt(stk.pop());
                finale = eval(x, y, s);
                stk.push(""+ finale);
             }
             else if (s.equals("!")){
             int z = Integer.parseInt(stk.pop());
             finale = eval(z, 1, "!");
             stk.push(""+finale);
             }
             else {
                stk.push(s);
             }
          }
          return Integer.parseInt(stk.pop());
//       int sum = 0;
//       Stack<String> stk = new Stack<String> ();
//       for (String str : postfixParts)
//       {
//          if (isOperator(str))
//          {
//             int a = Integer.parseInt(stk.pop());
//             sum = eval(a, Integer.parseInt(stk.pop()), str);
//             stk.push("" + sum);
//          }
//          else if (str.equals("!"))
//          {
//             int factorial = Integer.parseInt(stk.pop());
//             sum = eval(factorial, 1, "!");
//             stk.push("" + sum);
//          }
//          else
//          {
//             stk.push(str);
//          }
//       }
//       return Integer.parseInt(stk.pop());
   }
   
   public static int eval(int a, int b, String ch)
   {  
      int finale = 0;
      if (ch.equals("+"))
         finale = a+b;
      else if (ch.equals("-"))
         finale = b-a;
      else if (ch.equals("*"))
         finale = a*b;
      else if (ch.equals("/"))
         finale = b/a;
      else if (ch.equals("^"))
         finale = (int) Math.pow(b, a);
      else if (ch.equals("%"))
         finale = b%a;
      else if (ch.equals("!")){
         int n = a;
         while (n > 1){
            a = a*(a-1);
            n--;
         }
         
         finale = a;
      }
      return finale;
   }
   
   public static boolean isOperator(String op)
   {
      if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("^") || op.equals("%"))
         return true;
      return false;
   }
}

/**********************************************
Postfix  -->  Evaluate
 3 4 5 * +		23
 3 4 * 5 +		17
 10 20 + -6 6 * +		-6
 3 4 + 5 6 + *		77
 3 4 5 + * 2 - 5 /		5
 8 1 2 * + 9 3 / -		7
 2 3 ^		8
 20 3 %		2
 21 3 %		0
 22 3 %		1
 23 3 %		2
 5 !		120
 1 1 1 1 1 + + + + !		120
 
 
 *************************************/