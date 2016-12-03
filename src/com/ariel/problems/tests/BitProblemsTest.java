package com.ariel.problems.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import com.ariel.problems.BitProblems;

public class BitProblemsTest {

	@Test
	public void testClearBitsMSBThroughI() {

		BitProblems.clearBitsMSBThroughI(0xFFFF, 3);
	}

	@Test
	public void testInsert() {
		int m = Integer.parseInt("10011", 2);
		int n = Integer.parseInt("10000000000", 2);
		int i = 2;
		int j = 6;
		int result = BitProblems.insert(m, n, i, j);
		int expected = Integer.parseInt("10001001100", 2);
		assertTrue(result == expected);

	}

	@Test
	public void testToBinary() {
		int a = 1;
		String expected = "1";
		assertTrue(BitProblems.toBinary(a).equals(expected));
		a = 2;
		expected = "10";
		assertTrue(BitProblems.toBinary(a).equals(expected));
		a = 11;
		expected = "1011";
		assertTrue(BitProblems.toBinary(a).equals(expected));

	}

	@Test
	public void testDrawLine() {
		byte[] arr = new byte[3];
		arr[1] = (byte) 0;
		arr[0] = (byte) 0;
		arr[2] = (byte) 0;
		arr = BitProblems.drawLine(arr, 8, 3, 5, 2);
		assertTrue(arr[1] == 56);
	}

	@Test
	public void testPrintBinaryDecimal() {
		Double a = 1.0;
		String expected = Integer.toBinaryString(a.intValue());
		expected += ".0";
		assertTrue(BitProblems.printBinaryDecimal(a).equals(expected));
		a = 0.1;
		expected = Integer.toBinaryString(a.intValue());
		expected = "ERROR";
		assertTrue(BitProblems.printBinaryDecimal(a).equals(expected));
	}

	@Test
	public void testNextWithSameOnes() {
		int n = 1, expected = 2;
		assertTrue(BitProblems.nextWithSameOnes(n) == expected);
		n = 3;
		expected = 5;
		assertTrue(BitProblems.nextWithSameOnes(n) == expected);
		n = 7;
		expected = 11;
		assertTrue(BitProblems.nextWithSameOnes(n) == expected);
		n = Integer.MAX_VALUE;
		try{
			BitProblems.nextWithSameOnes(n);
			Assert.fail("Exception was not trhwon");
		}catch(BitProblems.NoBiggerNumberException err){
			
		}

	}

}
