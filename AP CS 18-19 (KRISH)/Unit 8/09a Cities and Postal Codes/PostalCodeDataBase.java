public class PostalCodeDataBase
{
   private Map<String, Set<String>> codeToCityMap;
	// additional instance variables to be declared in part (b)

	// constructs an empty database
   public PostalCodeDataBase()
   {
      codeToCityMap = new HashMap<String, Set<String>>();
     // additional instance variable(s) to be initialized in part (b)
   }

	// returns the set of cities associated with postalCode it that
	// code is in the database, otherwise returns null
   public Set<String> getCitiesForCode( String code )
   {
      return codeToCityMap.get( code );
   }

	// adds a new city, postalCode pair to this database
   public void addCityCodePair( String code, String city )
   {
      Set<String> citySet = getCitiesForCode( code );
      if( citySet == null )
      {
         citySet = new HashSet();
         codeToCityMap.put( code, citySet );
      }
      citySet.add( city );
   }

// prints an alphabetical list of all cities in this database
// postcondition:  the state of the data structure is not changed.
   public void printAllCities()
   {  // to be implemented in part (d) }
   }
}