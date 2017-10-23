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
		//สร้าง stack ขนาด 3 ช่อง
		aStack.setCapacity(3);
		//Push ค่า integer 1,2,3 ใส่ stack 
		try {
			aStack.push(new Integer(1));
			aStack.push(new Integer(2));
			aStack.push(new Integer(3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Push ค่า integer 4 ลง Stack
		try {
			aStack.push(new Integer(4));
			fail("Expect PushToFullStackException");
		} catch (Exception e) {
			assertTrue("Push 1,2,3,4 to a Stack with capacity of 3 must throw PushToFullStackException.",
					e instanceof PushToFullStackException);
			//เปรียบค่าที่คืนจากการเรียกเมทอด pop 3 ครั้งว่า เป็นค่า 3,2,1  ? 
			//เท่ากับ 3,2,1 คือ Test Success
			//ไม่เท่ากับ 3,2,1 คือ Test Fail
			//get ค่าสมาชิกตัวบนสุดของ Stack ด้วยเมธอด top
			for(int i=3;i>=1 ;i--){
				int elm = ((Integer)aStack.pop()).intValue() ; 
				assertEquals("Push 1,2,3,4 to a Stack with capacity of 3 must have 3,2,1 in Stack.", i, elm);
			}
			
		}

		

		//ต้อง Throw Exception ประเภท PushToFullStackException จึงจะถือว่า Test Success มิฉะนั้นถือว่า Test Fail

	}
	
	@Test
	public void testLastInFirstOut () {
		//Set ขนาดของ Stack เป็น 4 ช่อง
		aStack.setCapacity(4);
		//Push ค่า integer 1, 2, 3, 4  ใส่ stack ตามลำดับ
		try {
			aStack.push(new Integer(1));
			aStack.push(new Integer(2));
			aStack.push(new Integer(3));
			aStack.push(new Integer(4));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//get ค่าสมาชิกตัวบนสุดของ Stack ด้วยเมธอด top
		for(int i=4;i>=1 ;i--){
			int elm = ((Integer)aStack.pop()).intValue() ; 
			assertEquals(i, elm);
		}
		//เปรียบค่าผลลัพธ์ที่คืนจากเมทอด top ว่า เป็นค่า 4 ? 
		//เท่ากับ 4 คือ Test Success
		//ไม่เท่ากับ 4 คือ Test Fail
		//Pop ค่า 4 ออกจาก stack
		//วนทำขั้นที่ 3-5 สำหรับค่า 3, 2, 1  		
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
