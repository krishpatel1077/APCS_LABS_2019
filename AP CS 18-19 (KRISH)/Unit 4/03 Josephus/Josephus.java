//	Name:R2-17
//	Date:11/21/18
import java.util.*;
import java.io.*;

public class Josephus
{
	private static	String WINNER = "Josephus";
	
	public static void main(String[]	args)	throws FileNotFoundException
	{
		/*	run numberCircle first with J_numbers.txt	 */
		Scanner sc = new Scanner(System.in);
		System.out.print("How many names (2-20)? ");
		int n	= Integer.parseInt(sc.next());
		System.out.print("How many names to count off each time?"  );
		int countOff =	Integer.parseInt(sc.next());
		ListNode	winningPos = numberCircle(n, countOff,	"J_numbers.txt");
		System.out.println(winningPos.getValue() + " wins!");	 
	  
		/*	run josephusCircle next	with J_names.txt	*/
		System.out.println("\n ****  Now start all over. **** \n");
		System.out.print("Where should "+WINNER+" stand?  ");
		int winPos = Integer.parseInt(sc.next());			 
		ListNode	theWinner =	josephusCircle(n,	countOff, "J_names.txt", winPos);
		System.out.println(theWinner.getValue() +	" wins!");	
	}
	
	public static ListNode numberCircle(int n, int countOff,	String filename) throws	FileNotFoundException
	{
		ListNode	p = null;
		p = readNLinesOfFile(n,	new File(filename));
		p = countingOff(p, countOff, n);
		return p;
	}
	
	public static ListNode josephusCircle(int	n,	int countOff, String	filename, int winPos) throws FileNotFoundException
	{
		ListNode	p = null;
		p = readNLinesOfFile(n,	new File(filename));
		replaceAt(p, WINNER,	winPos);
		p = countingOff(p, countOff, n);
		return p;
	}

	/*	reads	the names, calls insert(),	builds the linked	list.
	 */
	public static ListNode readNLinesOfFile(int n, File f) throws FileNotFoundException
	{
		Scanner sc = new Scanner(f);
		ListNode	bob =	new ListNode(sc.nextLine(), null);
		for (int	i = 1; i	< n; i++) {
			bob =	insert(bob,	sc.nextLine());
		}
		return bob;
	}
	
	/*	helper method to build the	list.	 Creates	the node, then
	 *	inserts it in the	circular	linked list.
	 */
	public static ListNode insert(ListNode	p,	Object obj)
	{
		ListNode	temp;
		if	(p.getNext() == null){
			temp = new ListNode(obj, p);
			p.setNext(temp);
		}
		else{
			temp = new ListNode(obj, p.getNext());
			p.setNext(temp);
		}
		return temp;
	}	 
	/*	Runs a Josephus game, counting off and	removing	each name. Prints	after	each removal.
		Ends with one remaining	name,	who is the winner. 
	 */
	public static ListNode countingOff(ListNode p, int	count, int n)
	{
      for (int i = 1; i < count; i++){
      print(p);
      p = remove(p, count);
      }
      return p;
	}
	
	/*	removes the	node after counting off	count-1 nodes.
	 */
	public static ListNode remove(ListNode	p,	int count)
   {
		for (int i = 1; i < count; i++)
      p = p.getNext();
		p.setNext(p.getNext().getNext());
		return p;
	}
	/*	prints the circular linked	list.
	 */
	public static void print(ListNode p)
	{
      p = p.getNext();
		Object temp	= p.getValue();
		System.out.print(temp);
		while	(p.getNext().getValue()	!=	temp){
			System.out.print(" "	+ p.getNext().getValue());
			p = p.getNext();
		}
      System.out.println();
	}
	/*	replaces	the value (the	string) at the	winning node.
	 */
	public static void replaceAt(ListNode p, Object	obj, int	pos)
	{
   p = p.getNext();
	for (int i = 1; i < pos; i++){
   p = p.getNext();
   }
   p.setValue(obj);
	}
}

