public abstract class AbstractList<E>
       implements IList<E>
{
   public AbstractList()
   // post: does nothing
   {
   }

   /**
    * retorno si la lista esta vacio o no
    */
   public boolean isEmpty()
   // post: returns true iff list has no elements
   {
      return size() == 0;
   }
  
   /**
    * retorna si el valor ingresado esta en la lista
    */
  public boolean contains(E value)
  // pre: value is not null
  // post: returns true iff list contains an object equal to value
  {
	return -1 != indexOf(value);
  }
}