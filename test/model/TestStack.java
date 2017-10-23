package model;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStack {
	private Stack aStack ; 

	@Before
	public void setUp() throws Exception {
		aStack = new Stack();
		JOptionPane.showMessageDialog(null, "Creating a new stack before each test case.");
	}

	@After
	public void tearDown() throws Exception {
		aStack = null ;
		JOptionPane.showMessageDialog(null, "Deleting stack after each test case.");
	}

	@Test 
	public void testPushToFullStackException () {
		//���ҧ stack ��Ҵ 3 ��ͧ
		aStack.setCapacity(3);
		//Push ��� integer 1,2,3 ��� stack 
		try {
			aStack.push(new Integer(1));
			aStack.push(new Integer(2));
			aStack.push(new Integer(3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Push ��� integer 4 ŧ Stack
		try {
			aStack.push(new Integer(4));
			fail("Expect PushToFullStackException");
		} catch (Exception e) {
			assertTrue("Push 1,2,3,4 to a Stack with capacity of 3 must throw PushToFullStackException.",
					e instanceof PushToFullStackException);
			//���º��ҷ��׹�ҡ������¡���ʹ pop 3 ������� �繤�� 3,2,1  ? 
			//��ҡѺ 3,2,1 ��� Test Success
			//�����ҡѺ 3,2,1 ��� Test Fail
			//get �����Ҫԡ��Ǻ��ش�ͧ Stack �������ʹ top
			for(int i=3;i>=1 ;i--){
				int elm = ((Integer)aStack.pop()).intValue() ; 
				assertEquals("Push 1,2,3,4 to a Stack with capacity of 3 must have 3,2,1 in Stack.", i, elm);
			}
			
		}

		

		//��ͧ Throw Exception ������ PushToFullStackException �֧�ж����� Test Success �ԩй�鹶����� Test Fail

	}
	
	@Test
	public void testLastInFirstOut () {
		//Set ��Ҵ�ͧ Stack �� 4 ��ͧ
		aStack.setCapacity(4);
		//Push ��� integer 1, 2, 3, 4  ��� stack ����ӴѺ
		try {
			aStack.push(new Integer(1));
			aStack.push(new Integer(2));
			aStack.push(new Integer(3));
			aStack.push(new Integer(4));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//get �����Ҫԡ��Ǻ��ش�ͧ Stack �������ʹ top
		for(int i=4;i>=1 ;i--){
			int elm = ((Integer)aStack.pop()).intValue() ; 
			assertEquals(i, elm);
		}
		//���º��Ҽ��Ѿ����׹�ҡ���ʹ top ��� �繤�� 4 ? 
		//��ҡѺ 4 ��� Test Success
		//�����ҡѺ 4 ��� Test Fail
		//Pop ��� 4 �͡�ҡ stack
		//ǹ�Ӣ�鹷�� 3-5 ����Ѻ��� 3, 2, 1  		
	}

    @Test
	public void testEmptyInitialStack  () {
		fail("Not yet implemented.");
	}
    
    @Test
	public void testPushElmToTop () {
		fail("Not yet implemented.");
	}
    
    @Test
	public void testPushDifferentElmTypeToStack () {
		fail("Not yet implemented.");
	}
}
