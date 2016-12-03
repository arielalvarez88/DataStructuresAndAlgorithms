package com.ariel.problems;

import java.util.LinkedList;

public class AnimalShelter {

	private LinkedList<Object> animals = new LinkedList<Object>();

	public void enqueueAnimal(Object animal) {
		animals.add(animal);
	}

	public Dog dequeueDog() {
		return (Dog) (dequeueType(Dog.class));
	}

	public Cat dequeueCat() {
		return (Cat) (dequeueType(Cat.class));
	}

	public Object dequeueAny() {
		return animals.removeFirst();
	}

	private Object dequeueType(Class t) {
		for (Object animal : animals) {
			if (t.isInstance(animal)) {
				animals.remove(animal);
				return animal;
			}
		}
		return null;
	}

	public int getCount() {
		return animals.size();
	}

	public static class Dog {

		

	}

	public static class Cat {

	}
}
