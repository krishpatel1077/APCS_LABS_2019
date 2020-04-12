import java.text.DecimalFormat;
public class SmartCard_DriverFINAL
{
   public static void main(String[] args) 
   {
      Station downtown = new Station("Downtown", 1);
      Station center = new Station("Center City", 1);
      Station uptown = new Station("Uptown", 2);
      Station suburbia = new Station("Suburb", 4);
      Station sector56 = new Station("Sector 56", 6);//Our ideal area only has 5 zones. We added 6, so our program doesn't know that yet
     
      SmartCard jimmy = new SmartCard(20.00); 
      jimmy.board(center);                    //Boarded at Center City.  SmartCard has $20.00
      jimmy.disembark(suburbia);              //From Center City to Suburb costs $2.75.  SmartCard has $17.25
      jimmy.disembark(uptown);				//Error:  did not board?!
      System.out.println();
   			
      SmartCard susie = new SmartCard(1.00); 
      susie.board(uptown);            		//Boarded at Uptown.  SmartCard has $1.00
      susie.disembark(suburbia);				//Insuffient funds to exit. Please add more money.
      System.out.println();
    
      SmartCard kim = new SmartCard(.25);    
      kim.board(uptown);            		    //Insuffient funds to board. Please add more money.
      System.out.println();
    
      SmartCard b = new SmartCard(10.00);   
      b.board(center);            		    //Boarded at Center City.  SmartCard has $10.00
      b.disembark(downtown);					//From Center City to Downtown costs $0.50.  SmartCard has $9.50
      System.out.println();
          
      SmartCard mc = new SmartCard(10.00);  
      mc.board(suburbia);            		    //Boarded at Suburbia.  SmartCard has $10.00
      mc.disembark(downtown);					//From Suburbia to Downtown costs $2.75.  SmartCard has $7.25
      System.out.println();
      
        //Make more test cases.  What else needs to be tested?
     SmartCard derek = new SmartCard(5.00); // TEST CASE 1
     derek.board(downtown);//Boarded at Downtown. SmartCard has $5.00
     derek.disembark(downtown);// From Downtown to Downtown costs $0.50. SmartCard has $4.50
     System.out.println(); 
     //What? This shouldn't be working. If i go to one station, and leave the same station, why am i being charged?
     //One way to fix this is to comapre by name and zone, to ensure no extra charges have been made
     SmartCard tom = new SmartCard(40.00); // TEST CASE 2
     tom.board(downtown);//Boarded at Downtown. SmartCard has $40.00.
     tom.disembark(sector56);//From Downtown to Sector 56 costs $4.25.
     System.out.println();
     //This actually shouldn't work, because in our ideal reigon/state, there are only 5 zones.
     //If tom wanted to go past 5 zones, he should either pay an interstate fee, or not be allowed
     SmartCard john = new SmartCard(5.00); // TEST CASE 3
     john.addMoney(-3.50); //SmartCard has $1.50.
     //What? How can you add negative money to your SmartCard?
     //This is an easy fix. ALL you need o do is add an if else statement to make sure that d (the arg for addMoney) is above 0;
   }
} 	

//Note SmartCard is not denoted as public.  Why?
class SmartCard 
{
   public final static DecimalFormat df = new DecimalFormat("$0.00");
   public final static double MIN_FARE = 0.5;
    /* enter your code below */
   private double wallet;
   ////////////////////////////
   public SmartCard(double w) {
      wallet = w;
   }
   ////////////////////////////
   private boolean SCpresent;
   private double finalcost;
   private int zone;
   public void addMoney(double d) {
      wallet += d;
   }
   public String getBalance() {
      return df.format(wallet);
   }
   public boolean isBoarded() {
      return SCpresent;
   }
   public void board(Station s) {
      if (isBoarded()) {
      System.out.println("Error: already boarded!");
      }
      else {
      if (wallet < MIN_FARE) {
      System.out.println("Insufficient funds to board. Please add more money.");
      }
      else {
      System.out.println("Boarded at " + s.getStation() + ". SmartCard has " + getBalance());
      SCpresent = true;
      }
      }
   }
   public double cost(Station s) {
   finalcost = 0;
   if (zone == s.getZone()){
   finalcost += .50;
   }
   else{
   finalcost += .75;
   }
   return finalcost;
   }
   
   public void disembark (Station s) {
   if (!SCpresent) {
   System.out.println("Error: Did not board.");
   }
   else {
   wallet = wallet - finalcost;
   if (wallet < MIN_FARE) {
   System.out.println("Insufficient funds to leave. Please add more money.");
   }
   else {
   System.out.println("Your ride to " + s.getStation() + " costs " + df.format(finalcost));
   System.out.println("SmartCard has " + getBalance());
   }
   }
   }
      
}
   
//Note Station is not a public class.  Why?
class Station
{
   private int Stationzone;
   private String Stationname;
   //////////////////////////////////
   public Station(String n, int z) {
      Stationname = n;
      Stationzone = z;
   }
   //////////////////////////////////
   public String getStation() {
      return Stationname;
   }
   public int getZone() {
      return Stationzone;
   }
}

 /*******************  Sample Run ************

 Boarded at Center City.  SmartCard has $20.00
 From Center City to Suburb costs $2.75.  SmartCard has $17.25
 Error: did not board?!
 
 Boarded at Uptown.  SmartCard has $1.00
 Insufficient funds to exit. Please add more money.
 
 Insufficient funds to board. Please add more money.
 
 Boarded at Center City.  SmartCard has $10.00
 From Center City to Downtown costs $0.50.  SmartCard has $9.50
 
 Boarded at Suburb.  SmartCard has $10.00
 From Suburb to Downtown costs $2.75.  SmartCard has $7.25
 
 ************************************************/