/*
import java decimal text format; <----------------------- Lets you write text like money
public class SmartCard_Driver(LAYMAN'S TERMS) {

public static void main(String[] args) {         <-----   You need to do a main line for the program to work!

- Creates Station Downtown @ Zone 1 <---- ("Downtown", 1)
- Creates Station Center City @ Zone 1 <---- ("Center City", 1)
- Creates Station Uptown @ Zone 2 <---- ("Uptown", 2)
- Creates Station Suburb @ Zone 4 <---- ("Suburb", 4);

- Creates SmartCard "jimmy"
 - jimmy has $20.00
 - jimmy boards at Center City - 1
 - jimmy disembarks at Suburbia - 4
 - jimmy disembarks at Uptown - 2
 
- You get the jist. A few more Smart Cards are made, and then we move on to SmartCard and Station

} - the main ends here
} - so does SmartCard_Driver!

class SmartCard { - Our class for SmartCard is created
 - Creates a decimal format to look like money
 - Creates a minimum fare of 50 cents
 
 ^^What they created^^
 
 - Creates a double (basically an int with decimal points) called WALLET <------  wallet represents the SmarCard money (that comes from your wallet)!
 - Creates an integer called ZONE <----- zone represents the zone the passenger is in currently
 - Creates a double called FINALCOST <----- finalcost represents the cost that will be subtracted from wallet after the train ride
 - Creates a boolean (true or false) called SCpresent <-------- SCpresent is to see if the SmartCard is present or not
 
 ^^Initialization variables^^ <---------- I made them
 
 -Creates a method called addMoney with an argument (a double called d) <---------- This method allows you to add money to wallet
 -Creates a String method called getBalance() <--------- it just gives you wallet in the money format mentioned above.
 -Creates a Boolean method called isBoarded() <--------- Just tells you is SCpresent is true or false
 -Creates a method called board with a Station arguement (Station s) <-------- Will decide if you board or not judging on your wallet
 -Creates a method called cost with a Station arguement (Station s) <-------- Will give you your cost according to where you travelled
     -50 cents if in the same zone, and 75 cents for each different zone.
     -Also uses finalcost (see above) as the go-to variable
     -Compares station zone to passenger current zone
 -Creates a method called disembark with a Station arguement (Station s) <------ Will diesmbark after cost has been subtractred from wallet
     -if you don't have a smartcard, you gotta add more money
     -Also, you can't leave the train/station if you haven't boarded the train in the first place.
     
     ^^All of the methods^^ <--------------- I made them, again
 } ---- End of SmartCard
 
 class Station { <---------- creates the class that represents the train station
 -Creates an integer called Stationzone -------- represents the zone of the Station that the passenger has reached
 -Creates a String called Stationname -------- represents the name of the Station that the passegner has reached
 -Creates a constructor for Station with two arguements (String n, int z) <------- If you guessed right, n represents Stationname, and z represents Stationzone
 -Creates a String method called getStation() ------- retreives the station name from the Station the passenger is at
 -Creates an integer method called getZone() ------- retrieves the zone from the Station that the passenger is at.
 } ------ End of Station, and end of code!
 */