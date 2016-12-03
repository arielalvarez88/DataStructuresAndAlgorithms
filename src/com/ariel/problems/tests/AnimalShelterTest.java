package com.ariel.problems.tests;

import com.ariel.problems.AnimalShelter;
import com.ariel.problems.AnimalShelter.Cat;
import com.ariel.problems.AnimalShelter.Dog;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ariel.data_structures.LinkedListNode;

public class AnimalShelterTest {

	AnimalShelter as;

	@Before
	public void init() {
		as = new AnimalShelter();
	}

	@Test
	public void enqueueAnimalTest() {
		Dog a = new AnimalShelter.Dog();
		Cat b = new AnimalShelter.Cat();
		as.enqueueAnimal(a);
		assertTrue(as.getCount() == 1);
		as.enqueueAnimal(b);

		assertTrue(as.getCount() == 2);
		Object oldest = as.dequeueAny();
		assertTrue(oldest instanceof AnimalShelter.Dog);
	}

	@Test
	public void dequeueDogTest() {
		Dog a = new AnimalShelter.Dog();
		Cat b = new AnimalShelter.Cat();
		as.enqueueAnimal(b);
		as.enqueueAnimal(a);
		Cat c = new AnimalShelter.Cat();
		as.enqueueAnimal(c);
		Dog d = as.dequeueDog();
		assertTrue(a == d);
		assertTrue(as.getCount() == 2);
		as.dequeueDog();
		assertTrue(as.getCount() == 2);
	}

	@Test
	public void dequeueAny() {
		Dog a = new Dog();
		Cat b = new Cat();
		Dog c = new Dog();
		as.enqueueAnimal(a);
		Object first = as.dequeueAny();
		assertTrue(as.getCount() == 0);
		assertTrue(first instanceof Dog);
		as.enqueueAnimal(b);
		as.enqueueAnimal(c);
		as.enqueueAnimal(a);
		first = as.dequeueAny();
		assertTrue(first instanceof Cat);
		assertTrue(as.getCount() == 2);
	}

}
