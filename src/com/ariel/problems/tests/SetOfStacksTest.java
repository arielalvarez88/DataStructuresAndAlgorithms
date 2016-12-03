package com.ariel.problems.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ariel.data_structures.SetOfStacks;

public class SetOfStacksTest {

	SetOfStacks set;

	@Before
	public void init() {
		this.set = new SetOfStacks(2);
	}

	@Test
	public void testSetOfStacks() {
		set = new SetOfStacks(3);
		assertTrue(set.getThreshold() == 3);
	}

	@Test
	public void testSetOfStacksInt() {
		set = new SetOfStacks();
		assertTrue(set.getThreshold() == 2);

	}

	@Test
	public void testPush() {
		set.push(1);
		assertTrue(set.getCount() == 1);
		set.push(2);
		assertTrue(set.getCount() == 2);
		assertTrue(set.getStackCount() == 1);
		set.push(3);
		assertTrue(set.getCount() == 1);
		assertTrue(set.getStackCount() == 2);
		set.push(4);
		set.push(5);
		assertTrue(set.getCount() == 1);
		assertTrue(set.getStackCount() == 3);

	}

	@Test
	public void testPop() {
		set.push(1);
		set.pop();
		assertTrue(set.getCount() == 0);
		assertTrue(set.getStackCount() == 1);

		set.push(1);
		set.push(2);
		set.pop();
		assertTrue(set.getCount() == 1);
		assertTrue(set.getStackCount() == 1);

		set.push(2);
		set.push(3);
		assertTrue(set.getCount() == 1);
		assertTrue(set.getStackCount() == 2);
		set.pop();
		assertTrue(set.getCount() == 2);
		assertTrue(set.getStackCount() == 1);

	}

	@Test
	public void testPeek() {
		set.push(1);
		Integer one = (Integer) set.peek();
		assertTrue(one.equals(1));
		assertTrue(set.getCount() == 1);
	}

	@Test
	public void testPopAt() {
		set.push(1);
		set.popAt(0);
		assertTrue(set.getCount() == 0);
		assertTrue(set.getStackCount() == 1);

		set.push(1);
		set.push(2);
		set.push(3);
		set.push(4);
		set.popAt(1);
		assertTrue(set.getCount() == 1);
		assertTrue(set.getStackCount() == 2);		
		assertTrue(set.pop().equals(4));
		assertTrue(set.pop().equals(3));
		assertTrue(set.pop().equals(1));

		this.init();
		set.push(1);
		set.push(2);
		set.push(3);
		set.push(4);
		set.push(5);
		assertTrue(set.getStackCount() == 3);
		set.popAt(2);
		assertTrue(set.getStackCount() == 2);
		assertTrue(set.getCount() == 2);

		assertTrue(set.pop().equals(5));
		assertTrue(set.pop().equals(4));
		assertTrue(set.pop().equals(2));
		assertTrue(set.pop().equals(1));

	}

}
