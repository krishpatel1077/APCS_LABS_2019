//Name: R2-17
//Date: 3/23/19
import java.util.*;
public class CoinProblem
{
   public static void main(String[] args)
   {
      System.out.println("----------------------------COIN PROBLEM------------------------");
      System.out.println("Denominations: \nCent - 1\nNickel - 5\nDime - 10\nQuarter - 25");
      Map<Integer, Integer> map = new HashMap<Integer, Integer> ();
      System.out.println("\nENTER TARGET NUMBER (CENTS): ");
      Scanner sc = new Scanner(System.in);
      int target = Integer.parseInt(sc.next());
      int count = numCoins(target, map);
      System.out.println("\nMINIMUM NUMBER OF COINS REQUIRED: " + count);
      System.out.println( map.get(1) + " CENTS");
      System.out.println( map.get(5) + " NICKELS"); 
      System.out.println( map.get(10) + " DIMES");
      System.out.println( map.get(25) + " QUARTERS");
      System.out.println("------------------------------------------------------------------");    
   }
   public static int numCoins(int target, Map<Integer, Integer> map)
   {
      int cent = 1;
      int nickel = 5;
      int dime = 10;
      int quarter = 25;
      map.put(cent, 0);
      map.put(nickel, 0);
      map.put(dime, 0);
      map.put(quarter, 0);
      int count = 0;
      if (target >= 25)
      {
         if (target % 25 == 0)
         {
            count += target/25;
            map.put(quarter, count);
            return count;
         }
         else
         {
            count += target/25;
            map.put(quarter, count);
            int remtarget = target%25;
            if (remtarget >= 10)
            {
               if (remtarget %  10 == 0)
               {
                  count += remtarget/10;
                  map.put(dime, remtarget/10);
                  return count;
               }
               else
               {
                  count += remtarget/10;
                  map.put(dime, remtarget/10);
                  int fivetarget = remtarget%10;
                  if (fivetarget >= 5)
                  {
                     if (fivetarget % 5 == 0)
                     {
                        count += fivetarget/5;
                        map.put(nickel, fivetarget/5);
                     }
                     else
                     {
                        count += fivetarget/5;
                        map.put(nickel, fivetarget/5);
                        int ones = fivetarget%5;
                        count+= ones;
                        map.put(cent, ones);
                     }
                  }
                  else
                  {
                     count += fivetarget;
                     map.put(cent, fivetarget);
                     return count;
                  }
               }
            }
            else
            {
               if (remtarget >= 5)
               {
                  if (remtarget % 5 == 0)
                  {
                     count += remtarget/5;
                     map.put(nickel, remtarget/5);
                  }
                  else
                  {
                     count += remtarget/5;
                     map.put(nickel, remtarget/5);
                     int ones = remtarget%5;
                     count+= ones;
                     map.put(cent, ones);
                  }
               }
               else
               {
                  count += remtarget;
                  map.put(cent, remtarget);
                  return count;
               }
            
            }
         }
      }
      else
      {
         if (target == 0)
         {
            return 0;
         }
         if (target >= 10)
         {
            if (target %  10 == 0)
            {
               count += target/10;
               map.put(dime, target/10);
               return count;
            }
            else
            {
               count += target/10;
               map.put(dime, target/10);
               int ftarget = target%10;           
               if (ftarget >= 5)
               {
                  if (ftarget % 5 == 0)
                  {
                     count += ftarget/5;
                     map.put(nickel, ftarget/5);
                  }
                  else
                  {
                     count += ftarget/5;
                     map.put(nickel, ftarget/5);
                     int otarget = ftarget%5;
                     count+= otarget;
                     map.put(cent, otarget);
                  }
               }
               else
               {
                  count += ftarget;
                  map.put(cent, ftarget);
                  return count;
               }
            }
         }
         else
         {  
            if (target > 5)
            {
               if (target % 5 == 0)
               {
                  count += target/5;
                  map.put(nickel, target/5);
               }
               else
               {
                  count += target/5;
                  map.put(nickel, target/5);
                  int o = target%5;
                  count+= o;
                  map.put(cent, o);
               }
            }
            else
            {
               count += target;
               map.put(cent, target);
               return count;
            }
         }
      }
      return count;
   }
}