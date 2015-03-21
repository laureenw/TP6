import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList<T, E> implements Iterable<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	
	public LinkedList() {
		head = null;
		tail = null;
	}
	
	public int size() {
		return size;
	}

	public void addFirst(T e) {
		Node<T> tmp = new Node<T>(e, head, null);
		if (head != null) {
			head.previous = tmp;
		}
		head = tmp;
		if (tail == null) {
			tail = tmp;
		}
		size++;
	} 
	
	public void addLast(T e) {
		Node<T> tmp = new Node(e, null, tail);
		if (tail != null) {
			tail.next = tmp;
		}
		tail = tmp;
		if (head == null) {
			addFirst(e);
		}
		size++;
	}
	
	public T get(int i) {
		if (head == null) throw new IndexOutOfBoundsException();

	    Node<T> tmp = head;
	    for (int k = 0; k < i; k++) {
	    	tmp = tmp.next;
	    }

	    if(tmp == null) throw new IndexOutOfBoundsException();

	    return tmp.data;
	}
	
	public E pop() {
		if (head == null) throw new NoSuchElementException();
		Node<T> tmp = head;
		head = head.next;
		size--;
		return (E) tmp.data;
	}
	
	private E getFirst() {
		if(head == null) throw new NoSuchElementException();
		return (E) head.data;
	}
	
	public E poll() {
		getFirst();
		Node<T> tmp = head;
		head = head.next;
		size--;
		return (E) tmp.data;
	}
	
	public E peekFirst() {
		if (size == 0) throw new NoSuchElementException();
		return getFirst();
	}
	
	public E peekLast() {
		if (size == 0) throw new NoSuchElementException();
		if(head == null) throw new NoSuchElementException();
		Node<T> tmp = head;
		for (int k = 0; k <= size+1; k++) {
			tmp = tmp.next;
			size--;
		}
		return (E) tmp.data;
		
	}
	
	public boolean remove(Object o) {
		Node<T> tmp = head;
		Node<T> prev = null;
		
		if (head.data.equals(o)) {
			head = head.next;
			head.previous = null;
		} else if (tail.data.equals(o)) {
			tail = tail.previous;
			tail.next = null;
		}
		
		while (tmp != null && !tmp.data.equals(o)) {
			prev = tmp;
			tmp = tmp.next;
		}
		
		if (tmp == null) {
			return false;
		}
		
		if (tmp == head) {
			head = tmp.next;
		}
		
		if (prev != null) {
			prev.next = tmp.next;
		}
		
		size--;
		return true;
	}
	
	public E remove(int index) {
		if (head == null) throw new IndexOutOfBoundsException();
		Node <T> tmp = head;
		if (index == 0) {
			head = head.next;
		} else if(index == size) {
			tail = tail.previous;
		} else {
			for (int i = 0; i < index - 1; i++) {
				tmp = tmp.next;
			}
			
			tmp.next = tmp.next.next;
		}
	    size--;
	    return (E) tmp.data;
		
	}
	
	@Override
    public Iterator<T> iterator() {
		 Iterator<T> it = new Iterator<T>() {
			 
			 	Node<T> tmp = head;

	            private int currentIndex = 0;

	            @Override
	            public boolean hasNext() {
	                return tmp != tail;
	            }

	            @Override
	            public T next() {
	               if (hasNext()) {
	            	   T result = tmp.data;
	            	   tmp = tmp.next;
	            	   return result;
	               }
	               throw new NoSuchElementException();
	            }
	           
	            @Override
	            public void remove() {
	            	throw new UnsupportedOperationException
	                  ("Linked list iterator remove not supported");
	            }
	        };
	        return it;
        
    }
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
	    list.addFirst("p");
	    list.addFirst("a");
	    list.addFirst("e");
	    list.addFirst("i");
	    list.addLast("l");
	    list.addLast("m");
	    for (int i = 0; i < list.size; i++) {
	    	System.out.println(list.get(i));
	    }
	}

}
