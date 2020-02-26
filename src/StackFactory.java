class StackFactory<E> {
	//selecciona la implementacion a utilizar para un stack
	//se utiliza el patron Factory
	   public IStack<E> getStack(String entry) {
	    // seleccion de la implementacion a utilizar:
		if (entry.equals("ArrayList"))
	    {
			System.out.println("Usara ArrayList");
			return new StackArrayList<E>(); //regresa ArrayList
	    }
		else if (entry.equals("Vector"))
		{
			System.out.println("Usara Vector");
	      return new StackVector<E>(); //regresa Vector
		}
		else
		{
			System.out.println("Usara Default - vector");
		  return new StackVector<E>();
		} 
	   }
	}