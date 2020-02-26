class StackFactory<E> {
	//selecciona la implementacion a utilizar para un stack
	//se utiliza el patron Factory
	   public IStack<E> getStack(String entry) {
	    // seleccion de la implementacion a utilizar:
		if (entry.equals("ArrayList"))
	      return new StackArrayList<E>(); //regresa ArrayList
		else if (entry.equals("Vector"))
	      return new StackVector<E>(); //regresa Vector
		else 
		  return new StackVector<E>(); 
	   }
	}