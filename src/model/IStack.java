package model;

public interface IStack {
	boolean push(Object elm) throws Exception ;
	Object pop() ;
	void setCapacity(int initialCapacity) ; 
	Object top() ;

}
