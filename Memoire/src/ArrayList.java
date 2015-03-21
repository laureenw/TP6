import java.awt.Window.Type;
import java.util.*;

public class ArrayList<T, E> implements Iterable<T> {
	
	static final int DEFAULT_CAPACITY = 10;
	private T[] data ;
	private int size = 0;
	
	public ArrayList() { 
		data = (T[]) new Object[DEFAULT_CAPACITY]; 
	}
	
	public int size() { 
		return size ; 
	}
	
	public void add(T e) { 
		data[size] = e ;
		++size ;
	}
	
	public T get(int i) {
		if(i < 0 || i >= size) {
			try {
				throw OutOfBoundException ();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return data[i]; 
	}
	
	private Exception OutOfBoundException() {
		return null;
	}

	public int indexOf(Object o) {
		if (o == null) {
			for(int i = 0; i < size; i++) {
				if (data[i] == null) {
					return i;
				}
			}
		} else {
			for(int i = 0; i < size; i++) {
				if (o.equals(data[i])) {
					return i;
				}
			}
		}
		return size;
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("" + index);
		}
		E o = (E) data[index];
		size--;
		return o;	
	}
	
	public boolean remove(Object o) {
		if(o == null){
	        for (int index = 0; index < size; index++)
	           if (data[index] == null) {
	              remove(index);
	              return true;
	           }
	     }else{
	        for (int index = 0; index < size; index++)
	          if (o.equals(data[index])){
	              remove(index);
	              return true;
	          }
	     }
	     return false;
	}
	
	@Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && data[currentIndex] != null;
            }

            @Override
            public T next() {
                return data[currentIndex++];
            }
           
            @Override
            public void remove() {
               if (currentIndex - 1 < size) {
            	   System.arraycopy(data, currentIndex, data, currentIndex-1, size-currentIndex--);
               }
               size--;
            	
            }
        };
        return it;
    }
	
	public static void main(String[] args) {
		ArrayList x = new ArrayList();
		x.add(new String("M. George"));
		x.add(new Integer(0));
		x.add(new String("Laureen"));
		System.out.println("Taille : "+x.size());
		for (int i = 0; i < x.size(); i++) {
			System.out.println(i+" : "+x.get(i));
		}
		System.out.println("Avant remove :");
		for (Iterator i = x.iterator(); i.hasNext();) {
			System.out.println(i.next());
		}
		for (Iterator iterator = x.iterator(); iterator.hasNext();) {
			Object element = iterator.next();
			if (element.equals(0)) {
				System.out.println("Element à supprimer : "+element);
				iterator.remove();
			}
		}
		System.out.println("Après remove :");
		for (Iterator it = x.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
		
	}
}