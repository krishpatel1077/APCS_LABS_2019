// Name: R2-17
// Date: 12/30/18

import java.util.*;

public class ParenMatch
{
   public static final String left  = "([{<";
   public static final String right = ")]}>";
   
   public static void main(String[] args)
   {
      System.out.println("Parentheses Match");
      ArrayList<String> parenExp = new ArrayList<String>();
      /* enter test cases here */
      parenExp.add("5+7");
      parenExp.add("(5+7)");
      parenExp.add(")5+7(");
      parenExp.add("((5+7)*3)");
      parenExp.add("[(5+7)*]3");
      parenExp.add("(5+7)*3");
      parenExp.add("5+(7*3)");
      parenExp.add("((5+7)*3");
      parenExp.add("[(5+7]*3)");
      parenExp.add("[(5+7)*3])");
      parenExp.add("([(5+7)*3]");
      for( String s : parenExp )
      {
         boolean good = checkParen(s);
         if(good)
            System.out.println(s + "\t good!");
         else
            System.out.println(s + "\t BAD");
      }
   }
   
   public static boolean checkParen(String exp)
   {
      int count = 0;
      Stack<String> stk = new Stack<String> ();
      String[] arr = exp.split("");
      for (String str : arr){
         stk.push(str);
      }
      String leftparen = "";
      String rightparen = "";
      while (!stk.isEmpty()){
         String str = stk.pop();
         if (str.equals("("))
         {
            count++;
            leftparen = str;
         }
         if (str.equals("["))
         {
            count++;
            leftparen = str;
         }
         if (str.equals("{"))
         {
            count++;
            leftparen = str;
         }
         if (str.equals(")"))
         {
            count++;
            rightparen = str;
         }
         if (str.equals("]"))
         {
            count++;
            rightparen = str;
         }
         if (str.equals("}"))
         {
            count++;
            rightparen = str;
         }
      }
      if (count % 2 == 0){
      //       if ((stk.search(">") > stk.search("<")) ||(stk.search(")") > stk.search("(")) || (stk.search("]") > stk.search("[")))
      //          return true;
      //          return false;
         if (arr.indexOf(leftparen) < arr.indexOf(rightparen))
         {
            return true;
         }
      }
      return false;
   }
}

/*
 Parentheses Match
 5+7	 good!
 (5+7)	 good!
 )5+7(	 BAD\
 ((5+7)*3)	 good!
 <{5+7}*3>	 good!
 [(5+7)*]3	 good!
 (5+7)*3	 good!
 5+(7*3)	 good!
 ((5+7)*3	 BAD
 [(5+7]*3)	 BAD
 [(5+7)*3])	 BAD
 ([(5+7)*3]	 BAD
 */