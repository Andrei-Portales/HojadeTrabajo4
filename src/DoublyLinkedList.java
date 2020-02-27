import java.util.NoSuchElementException;

public class DoublyLinkedList<E> extends AbstractList<E>{

	protected int count;
	protected DoublyLinkedNode<E> head;
	protected DoublyLinkedNode<E> tail;
	
	public DoublyLinkedList() {
		count = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}


	
	public boolean isEmpty() {
		return count ==0;
	}

	@Override
	public void addFirst(E value) {
		// TODO Auto-generated method stub
		DoublyLinkedNode<E> tmp = new DoublyLinkedNode<E>(value,head,null);
		if(head != null ) {head.prev = tmp;}
		head = tmp;
        if(tail == null) { tail = tmp;}
        count++;
	}

	@Override
	public void addLast(E value) {
		// TODO Auto-generated method stub
		DoublyLinkedNode<E> tmp = new DoublyLinkedNode<E>(value,null,tail);
		if(tail != null) {tail.next = tmp;}
        tail = tmp;
        if(head == null) { head = tmp;}
        count++;
	}
	
	public void iterateForward(){
        
        System.out.println("iterating forward..");
        DoublyLinkedNode<E> tmp = head;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }
     
    /**
     * this method walks backward through the linked list
     */
    public void iterateBackward(){
         
        System.out.println("iterating backword..");
        DoublyLinkedNode<E> tmp = tail;
        while(tmp != null){
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }

	

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		 if (count == 0) throw new NoSuchElementException();
		 	DoublyLinkedNode<E> tmp = head;
	        head = head.next;
	        head.prev = null;
	        count--;
	        System.out.println("deleted: "+tmp.element);
	        return tmp.element;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		 if (count == 0) throw new NoSuchElementException();
		 	DoublyLinkedNode<E> tmp = tail;
	        tail = tail.prev;
	        tail.next = null;
	        count--;
	        System.out.println("deleted: "+tmp.element);
	        return tmp.element;
	}

	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getLast() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public E remove(E value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(E value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(E value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int i, E o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int i, E o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
