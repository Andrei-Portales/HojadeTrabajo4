abstract public class AbstractStack<E> 
implements IStack<E>
{
      public boolean empty()
   // post: regresa true si el stack esta vacio
   {
      return size() == 0;
   }
}