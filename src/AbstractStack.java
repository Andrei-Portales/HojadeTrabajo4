abstract public class AbstractStack<E> 
implements IStack<E>
{
	/**
	 * MEtodo que devuelve si la lista esta vacia 
	 */
      public boolean empty()
   // post: regresa true si el stack esta vacio
   {
      return size() == 0;
   }
}