//********************************************************************
//  DoublyLinkedList.java       
//
//  Clase para el uso de una lista doblemente enlazada, basada en 
//  el ejemplo publicado en canvas
//********************************************************************
public class DoublyLinkedNode<E> {

	 E element;
	 DoublyLinkedNode<E> next;
	 DoublyLinkedNode<E> prev;

     public DoublyLinkedNode(E element, DoublyLinkedNode<E> head, DoublyLinkedNode<E> prev) {
         this.element = element;
         this.next = head;
         this.prev = prev;
     }
}
