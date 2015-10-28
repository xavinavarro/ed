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

	@Test
	public void testIndexOf() {
		assertEquals(3, Array.indexOf(new int[]{5, 9, 3, 14}, 14));
		//fail("Not yet implemented");
	}
	/*@Test
	public void indexOf_empty() {
		assertEquals(-1, Array.indexOf(new int[]{5, 9, 3, 14}, 14));
		//fail("Not yet implemented");
	}*/
}
