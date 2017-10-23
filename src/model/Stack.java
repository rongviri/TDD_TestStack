package model;

public class Stack implements IStack {
	protected Object[] elements; // Stack
	protected int size; // Stack Size
	protected int counter; // Stack Counter

	public Stack(int initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException("initialCapacity must be >= 1");

		elements = new Object[initialCapacity];
		size = initialCapacity;
		counter = 0;
	}

	public Stack() {
		elements = null;
		size = counter = 0;
	}

	public void setCapacity(int initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException("initialCapacity must be >= 1");

		elements = new Object[initialCapacity];
		size = initialCapacity;
		counter = 0;
	}
	
	

	public int getSize() {
		return size;
	}

	public int getCounter() {
		return counter;
	}

	public boolean isfull() {
		return (counter == size);
	}

	public boolean isempty() {
		return (counter == 0);
	}

	public Object[] getElements() {

		return elements;
	}

	public Object top(){
		if(this.isempty())
			return null ;
		else
			return elements[counter-1];
	}
	
	//element will be pushed to the stack from the order 0 to size-1.
	public boolean push(Object element) throws Exception {
		if (counter == size){
			throw new PushToFullStackException("Cannot push any element to a Full Stack.") ;
		}

		elements[counter] = element;
		counter++;

		return true;
	}

	//last in first out, so the popped element will be extracted from the tail of the array.
	public Object pop() {
		if (counter == 0)
			return false;

		counter--;
		return elements[counter];
	}

	public String toString() {
		int i;
		StringBuffer s = new StringBuffer("[");

		for (i = 0; i < counter; i++)
			s.append(elements[i].toString() + ", ");

		for (; i < size; i++)
			s.append("__, ");

		if (size > 0)
			s.delete(s.length() - 2, s.length());

		s.append("]");
		return new String(s);
	}

	public String getStatus() {
		StringBuffer s = new StringBuffer("");
		s.append("SC: " + counter);
		return new String(s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
