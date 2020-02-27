
public class ListFactory<E> {
	//selecciona la implementacion a utilizar para un stack
	//se utiliza el patron Factory
	   public IList<E> getList(String entry) {
	    // seleccion de la implementacion de lista  a utilizar:
		if (entry.equals("Circular"))
	    {
			System.out.println("Usara Lista circular");
			return null; //regresa circular
	    }
		else if (entry.equals("Doble"))
		{
			System.out.println("Usara Lista doble");
	      return null; //regresa doble 
		}
		else if (entry.equals("Simple"))
	    {
			System.out.println("Usara Lista simple");
			return new SinglyLinkedList<E>(); //lista simple
	    }
		else
		{
			System.out.println("Usara Default - Lista simple");
		  return new SinglyLinkedList<E>();
		} 
	   }
	}
