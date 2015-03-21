
public class Node<T> {
	T data;
	Node<T> next;
	Node<T> previous;

	   public Node(T data, Node<T> next, Node<T> previous)
	   {
	      this.data = data;
	      this.next = next;
	      this.previous = previous;
	   }
	   
	   public T getData()
       {
           return data;
       }

       public Node<T> getNext()
       {
           return next;
       }

public Node<T> getPrevious()
{
return previous;
}

public void setNext(Node<T> next) {
	this.next = next;
}

public void setPrevious(Node<T> previous) {
	this.previous = previous;
}

       
}
