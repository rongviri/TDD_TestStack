package model;

public interface IStack1 {
	Object pop();
	void push(Object elm) throws Exception ;
	void setCapacity(int initialCapacity) ; 
	Object top() ;
	int getSize();
	int getCounter();
	

}
