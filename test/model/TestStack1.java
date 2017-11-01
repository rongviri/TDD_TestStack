package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStack1 {
	Stack1 s ;
	
	@Before
	public void setUp() throws Exception {
		s = new Stack1();
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	@Test
	public void testEmptyInitialStack(){
		// 1. create new stack
		
		// 2. get element from top of stack
		Object topElm = s.top(); 
		
		// 3. check if top element == null ?
		// yes -> test pass, no-> test fail
		assertNull("New Stack must have no element on top!!",
				topElm);
		
		
		// 4. delete stack
		
	}


	@Test
	public void testLastInFirstOut(){
//		1.Set ��Ҵ�ͧ Stack �� 4 ��ͧ
		s.setCapacity(4);
//		2.Push ��� integer 1, 2, 3, 4 ��� stack ����ҴѺ
		try {
			s.push(new Integer(1));
			s.push(new Integer(2));
			s.push(new Integer(3));
			s.push(new Integer(4));
//			3.get �����Ҫԡ��Ǻ��ش�ͧ Stack �������ʹ top
			Integer elm = (Integer)s.top();
			
//			4.���º��Ҽ��Ѿ����׹�ҡ���ʹ top ��� �繤�� 4 ?
			assertTrue(elm.intValue()==4);
//			���ҡѺ 4 ��� Test Success
//			������ҡѺ 4 ��� Test Fail
			
//			5.Pop ��� 4 �͡�ҡ stack
			s.pop();
//			6.ǹ�Ң�鹷�� 3-5 ����Ѻ��� 3, 2, 1
			elm = (Integer)s.top();
			assertTrue(elm.intValue()==3);
			s.pop();
			elm = (Integer)s.top();
			assertTrue(elm.intValue()==2);
			s.pop();
			elm = (Integer)s.top();
			assertTrue(elm.intValue()==1);
			s.pop();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Push 1,2,3,4 to Stack Size 4,"
					+ "  An Exception must not happen!!");
		}

		
		
	}
	
	
	@Test
	public void testPushElmToTop(){
		// 1. create stack with capacity = 1
			s.setCapacity(1);
		// 2. push 1 to stack
			try {
				s.push(new Integer(1));
		// 3. check if top element must be not null.
		// or check if the number of elements in stack
		// must be greater than 0.
				assertNotNull(s.top());
				
		// 4. check if element on top 
		//    is equal to the pushed element.
				int topElm = ((Integer)s.top()).intValue();
				assertEquals(1, topElm);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("test push element to top of a stack with capacity 1 "
						+ "must not throw exception!!");
			}
		
		
		// 5. delete stack
		
	}


}
