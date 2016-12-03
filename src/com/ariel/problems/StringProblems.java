package com.ariel.problems;

import java.util.ArrayList;
import java.util.Hashtable;

public class StringProblems {

	public static boolean hasUniqueChars(String str) {
		str = str.toLowerCase();
		char c;
		Hashtable<Character, Integer> counts = new Hashtable<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (counts.containsKey(c)) {
				return false;
			}
		}

		return true;
	}

	public static boolean isPermutation(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		if (str1.length() != str2.length()) {
			return false;
		}
		int counts;
		Hashtable<Character, Integer> str1Counts = new Hashtable<Character, Integer>();
		Hashtable<Character, Integer> str2Counts = new Hashtable<Character, Integer>();
		for (int i = 0; i < str1.length(); i++) {
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			counts = 0;
			if (str1Counts.containsKey(c1)) {
				counts = str1Counts.get(c1);
			}
			str1Counts.put(c1, counts++);

			counts = 0;
			if (str2Counts.containsKey(c2)) {
				counts = str2Counts.get(c2);
			}

			str2Counts.put(c2, counts++);
		}
		return str1Counts.equals(str2Counts);

	}

	public static String compress(String toCompress) {
		boolean first = true, lastIteration = false, moreThanOne = false;
		Character c, before = null;
		int count = 1;
		ArrayList<Integer> counts = new ArrayList<Integer>();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < toCompress.length(); i++) {
			c = toCompress.charAt(i);
			lastIteration = i == toCompress.length() - 1;
			if (c.equals(before)) {
				count++;
				moreThanOne = true;

			} else if (!first) {
				result.append(before);
				result.append("%d");
				counts.add(count);
				count = 1;
			}

			if (lastIteration) {
				result.append(c);
				result.append("%d");
				counts.add(count);
			}
			before = c;
			first = false;

		}
		String f = result.toString();
		if (moreThanOne) {
			f = String.format(f, counts.toArray());
		} else {
			f = f.replace("%d", "");
		}

		return f;

	}

	public static boolean isRotation(String s1, String s2) {
		Character c;
		int pos, posCurr = 0, init;
		StringBuilder sb = new StringBuilder();
		if (s1 != s2 && s1.contains(s2) && s1.length() == s2.length()) {
			return true;
		}
		for (int i = 0; i < s1.length(); i++) {
			pos = i + 1 < s1.length() ? i+1 : 0;
			init = pos;
			sb.setLength(0);
			while (true) {
				sb.append(s1.charAt(pos));												
				if(pos == i){
					break;
				}
				pos++;
				if(pos >= s1.length()){
					pos = 0;
				}		
				
			}
			if(sb.toString().equals(s2)){
				return true;
			}
		}
		return false;

	}

}
