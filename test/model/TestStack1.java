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
	

}
