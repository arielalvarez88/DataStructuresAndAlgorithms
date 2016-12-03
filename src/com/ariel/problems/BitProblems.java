
package com.ariel.problems;

import java.util.HashMap;

public class BitProblems {

	public static int clearBitsMSBThroughI(int num, int i) {

		int mask = (1 << i) - 1;
		return num & mask;
	}

	public static int insert(int m, int n, int i, int j) {
		int onesAfter = ~0 << (j + 1);
		int onesBefore = (1 << i) - 1;
		n = n & (onesAfter | onesBefore);
		m = m << i;
		n = n | m;
		return n;
	}

	public static String toBinary(int a) {
		int count = 0;
		StringBuilder result = new StringBuilder();
		do {
			result.insert(0, a % 2);
			a = a / 2;
			count++;

		} while (a > 0 && count < 30);
		if (count >= 30) {
			return "error";
		}
		return result.toString();
	}

	public static byte[] drawLine(byte[] a, int w, int x1, int x2, int y) {
		int smallestX = x1 < x2 ? x1 : x2, biggestX = x1 < x2 ? x2 : x1;
		for (int i = smallestX; i <= biggestX; i++) {
			int numberOfByte = (int) (((y - 1) & (w / 8)) + Math.ceil(i / 8.0D)) - 1;
			int numberOfBit = 8 - (i % 8);
			int mask = 1 << numberOfBit;
			a[numberOfByte] = (byte) (a[numberOfByte] | mask);
		}
		return a;
	}

	public static String printBinaryDecimal(Double d) {
		int repetitions = 3;
		Long intPart = 0L;
		HashMap<Double, Integer> repited = new HashMap<Double, Integer>();
		Double decimalPart = 0.0;
		StringBuilder result = new StringBuilder();
		int max = 32, charCount;
		result.append(Long.toBinaryString(d.longValue()));
		result.append(".");
		charCount = result.length();

		do {
			intPart = d.longValue();
			decimalPart = intPart == 0 ? d : d % intPart;
			d = new Double(decimalPart * 2);
			result.append(d.intValue());
			if (repited.containsKey(d)) {
				repited.put(d, repited.get(d) + 1);
			} else {
				repited.put(d, 0);
			}
			charCount++;

		} while (!decimalPart.equals(0.0) && repited.get(d) < repetitions && charCount <= max);
		if (charCount > max) {
			System.out.println("ERROR");
			return "ERROR";

		}
		System.out.println(result.toString());
		return result.toString();
	}

	public static class NoBiggerNumberException extends RuntimeException {
		public NoBiggerNumberException(String message) {
			super(message);
		}
	}

	public static int nextWithSameOnes(int n) throws NoBiggerNumberException{		
		
		int i = 0;

		while (BitProblems.getBit(n, i) <= 0 || BitProblems.getBit(n, i + 1) != 0) {
			i++;
			if (i >= 30) {
				throw new BitProblems.NoBiggerNumberException("Integer class doesn't support a bigger number");
			}
		}
		n = BitProblems.setBit(n, i, 0);
		n = BitProblems.setBit(n, i + 1, 1);
		return n;

	}

	public static int getBit(int n, int i) throws IllegalArgumentException {
		if (i > 31) {
			throw new IllegalArgumentException("The max index of integer is 31 and you sent a bigger index.");
		}

		int mask = 1;
		mask = (1 << i);
		return n & mask;
	}

	public static int setBit(int n, int i, int val) throws IllegalArgumentException {
		int mask;

		if (val == 0) {
			mask = -1 << (i + 1);
			mask = mask | ~(-1 << i);
			return n & mask;
		}
		if (val == 1) {
			mask = 1 << i;			
			return n | mask;
		}
		throw new IllegalArgumentException("Only 1 and 0 are valid values for parameter val.");

	}

}
