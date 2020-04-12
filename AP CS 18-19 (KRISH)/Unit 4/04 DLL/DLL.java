// Name: R2-17
// Date: 11/27/18

//  implements some of the List and LinkedList interfaces: 
//	 	  size(), add(i, o), remove(i);  addFirst(o), addLast(o); 
//  This class also overrides toString().
//  the list is zero-indexed.
//  Uses DLNode.

public class DLL        //DoubleLinkedList
{
   private int size;
   private DLNode head = new DLNode(); //dummy node--very useful--simplifies the code
   
   public int size()
   {
      return size;
   }
   
   /* appends obj to end of list; increases size;
   	  @return true  */
   public boolean add(Object obj)
   {
      addLast(obj);
      return true;   
   }
   
   /* inserts obj at position index.  increments size. 	*/
   public void add(int index, Object obj) throws IndexOutOfBoundsException  //this the way the real LinkedList is coded
   {
      if( index > size || index < 0 )
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      for (int i =0; i < size; i++){
      head = head.getNext();
      }
      size++;
      head.getNext().setValue(obj);
   }
   /* return obj at position index. 	*/
   public Object get(int index)
   { 
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      for (int i = 0; i <= index; i++){
         head = head.getNext();
      }
      Object temp = head.getValue();
      return temp;
   }
   
   /* replaces obj at position index. 
        returns the obj that was replaced*/
   public Object set(int index, Object obj)
   {      
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      for (int i = 0; i < index; i++){
         head = head.getNext();
      }  
      Object temp = head.getValue();
      head.setValue(obj);
      return temp;
   }
   
   /*  removes the node from position index (zero-indexed).  decrements size.
       @return the object of the node that was removed.    */
   public Object remove(int index)
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      for (int i = 0; i <= index; i++){
         head = head.getNext();
      }
      size--;
      Object temp = head.getValue();
      head.getNext().setPrev(head.getPrev());
      return temp;
   }
   
   /* inserts obj at front of list, increases size   */
   public void addFirst(Object obj)
   {
      head.getPrev().setValue(obj);
      size++;
   }
   
   /* appends obj to end of list, increases size    */
   public void addLast(Object obj)
   {
      DLNode first = head;
      for (int i = 0; i < size; i++){
      head = head.getNext();
      }
      size++;
      DLNode last = new DLNode(obj, head, head.getNext());
   }
   
   /* returns the first element in this list  */
   public Object getFirst()
   {
      return head.getValue();  
   }
   
   /* returns the last element in this list  */
   public Object getLast()
   {
      Object temp = head.getValue();
      while(head.getNext() != temp){
         head = head.getNext();
      }
      return head.getValue();
   }
   
   /* returns and removes the first element in this list, or
       returns null if the list is empty  */
   public Object removeFirst()
   {
      head.getNext().setPrev(head.getPrev());
      return head.getValue();
   }
   
   /* returns and removes the last element in this list, or
       returns null if the list is empty  */
   public Object removeLast()
   {
      Object temp = head.getValue();
      while(head.getNext() != temp){
         head = head.getNext();
      }
      head.getNext().setPrev(head.getPrev());
      return head.getValue();
   }
   
   /*  returns a String with the values in the list in a 
       friendly format, for example   [Apple, Banana, Cucumber]
       The values are enclosed in [], separated by one comma and one space.
    */
   public String toString()
   {
      String s = "[";
      Object temp = head.getValue();
      s = s + temp;
      while(head.getNext().getValue() != temp){
         s = s + ", " + head.getNext().getValue();
         head = head.getNext();
      }
      s = s + "]";
      return s;
   }
}