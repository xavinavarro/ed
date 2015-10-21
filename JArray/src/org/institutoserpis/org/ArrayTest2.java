package org.institutoserpis.org;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayTest2 {

	@Test
	public void testMenor() {
		//fail("Not yet implemented");
		assertEquals(3, Array.menor(new int[]{5, 9, 3, 14}));
		assertEquals(5, Array.menor(new int[]{5, 9, 10, 14}));
	}

	/*@Test
	public void testIndexOf() {
		fail("Not yet implemented");
	}*/

}
