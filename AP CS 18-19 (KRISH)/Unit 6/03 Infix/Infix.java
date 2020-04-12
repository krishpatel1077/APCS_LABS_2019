// Name: R2-17
// Date: 1/15/19

import java.util.*;
public class Infix
{
   public static void main(String[] args)
   {
      System.out.println("Infix  \t-->\tPostfix\t\t-->\tEvaluate");
     /*build your list of Infix expressions here  */
      ArrayList<String> infixExp = new ArrayList<String>();
      infixExp.add("( 3 + 4 ) * 5");
       
   
      for( String infix : infixExp )
      {
         String pf = infixToPostfix(infix);
         System.out.println(infix + "\t\t\t" + pf + "\t\t\t" + Postfix.eval(pf));  //Postfix must work!
      }
   }
   
   public static String infixToPostfix(String infix)
   {
            List<String> infixParts = new ArrayList<String>(Arrays.asList(infix.split(" ")));
      /* enter your code here  */
      String result = "";
      Stack<String> stk = new Stack<String> ();
      for (String temp : infixParts){
         if (temp.equals("(")){
            stk.push(temp);
         }
         else if (temp.equals(")")){
            while (!stk.peek().equals("("))
               result = result + " " + stk.pop();
            stk.pop();
         }
         else {
            if (stk.isEmpty())
               stk.push(temp);
            else if (stk.peek().equals("("))
               stk.push(temp);
            else if (isLower(stk.peek().charAt(0), temp.charAt(0)))
               stk.push(temp);
            else{
               result = result + " " + stk.pop();
               stk.push(temp);
            }
         }
      }
      for (String st : stk)
      result += " " + st;
      return result;
   }
   
	//returns true if c1 has lower or equal precedence than c2
   public static boolean isLower(char c1, char c2)
   {
      if (c1 == '+' && c2 == '-')
         return true;
      else if (c1 == '-' && c2 == '+')
         return false;
      return true;
   }
}
	
/********************************************

 Infix  	-->	Postfix		-->	Evaluate
 3 + 4 * 5			3 4 5 * +			23
 3 * 4 + 5			3 4 * 5 +			17
 ( -5 + 15 ) - 6 / 3			-5 15 + 6 3 / -			8
 ( 3 + 4 ) * ( 5 + 6 )			3 4 + 5 6 + *			77
 ( 3 * ( 4 + 5 ) - 2 ) / 5			3 4 5 + * 2 - 5 /			5
 8 + -1 * 2 - 9 / 3			8 -1 2 * + 9 3 / -			3
 3 * ( 4 * 5 + 6 )			3 4 5 * 6 + *			78
 
***********************************************/