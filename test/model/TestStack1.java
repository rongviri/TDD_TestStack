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
//		1.Set ขนาดของ Stack เป็น 4 ช่อง
		s.setCapacity(4);
//		2.Push ค่า integer 1, 2, 3, 4 ใส่ stack ตามลาดับ
		try {
			s.push(new Integer(1));
			s.push(new Integer(2));
			s.push(new Integer(3));
			s.push(new Integer(4));
//			3.get ค่าสมาชิกตัวบนสุดของ Stack ด้วยเมธอด top
			Integer elm = (Integer)s.top();
			
//			4.เปรียบค่าผลลัพธ์ที่คืนจากเมทอด top ว่า เป็นค่า 4 ?
			assertTrue(elm.intValue()==4);
//			–เท่ากับ 4 คือ Test Success
//			–ไม่เท่ากับ 4 คือ Test Fail
			
//			5.Pop ค่า 4 ออกจาก stack
			s.pop();
//			6.วนทาขั้นที่ 3-5 สาหรับค่า 3, 2, 1
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
