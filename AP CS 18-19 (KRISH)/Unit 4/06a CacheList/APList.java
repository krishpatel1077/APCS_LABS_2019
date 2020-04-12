public class APList
{
   private ListNode front;
   private int listSize;
   private int remIndex;
   private ListNode remNode;

   public APList()
   {
      front = null;
      remIndex = -1;
      remNode = null;
      listSize = 0;
   }
   public Oject get(int n)
   {
      if (n < 0 || n >= size)
         return null;
      else
      {
         if (n < remIndex){
            for (int i = 0; i < n; i++)
               front = front.getNext();
            remNode = new ListNode(front.getValue(), null);
            remIndex = n;
            return front.getValue();
         }
         else{
            for (int i = remIndex; i < n; i++)
               front = front.getNext();
            remIndex = n;
            remNode = new ListNode(front.getValue(), null);
            return front.getValue();
         }
      }
   }
   public void addFirst(Object obj)
   {
   ListNode temp = new ListNode(obj, front);
   front = temp;
   listSize++;
   }
   public int size()
   {
      return listSize;
   }
}