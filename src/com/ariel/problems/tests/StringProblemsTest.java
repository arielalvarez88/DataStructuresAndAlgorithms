package com.ariel.problems.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

import com.ariel.problems.StringProblems;

public class StringProblemsTest {

	@Test
	public void testHasUniqueChars() {

		boolean result;
		result = StringProblems.hasUniqueChars("ariel");
		assertTrue(result);

		result = StringProblems.hasUniqueChars("coco");
		assertTrue(result);

		result = StringProblems.hasUniqueChars("COco");
		assertTrue(result);

	}

	@Test
	public void testIsPermutation() {

		boolean result;
		result = StringProblems.isPermutation("ariel", "leira");
		assertTrue(result);

		result = StringProblems.isPermutation("coco", "coco");
		assertTrue(result);

		result = StringProblems.isPermutation("COco", "coCo");
		assertTrue(result);

		result = StringProblems.isPermutation("car", "RAC");
		assertTrue(result);

		result = StringProblems.isPermutation("pierre", "erpie");
		assertFalse(result);

		result = StringProblems.isPermutation("apple", "plae");
		assertFalse(result);

		result = StringProblems.isPermutation("apple", "plpae");
		assertTrue(result);

	}

	@Test
	public void compareTest() {
		String c = "caabcc";
		String expected = "c1a2b1c2";
		String result = StringProblems.compress(c);
		assertTrue(expected.equals(result));

		c = "b";
		result = StringProblems.compress(c);
		assertTrue(result.equals(c));
		c = "ba";
		result = StringProblems.compress(c);
		assertTrue(result.equals(c));
	}
	
	


	@Test
	public void isRotationTest() {
		String s1 = "ariel";
		String rotation = "elari";
		assertTrue(StringProblems.isRotation(s1, rotation));
		rotation = "elari";
		assertTrue(StringProblems.isRotation(s1, rotation));
		s1 = "a";
		rotation = "a";
		assertTrue(StringProblems.isRotation(s1, rotation));
	}
	
	
}
