package com.boot;

import java.util.function.BiFunction;
import java.util.function.Supplier;

class Dog {
	String name="tommy";

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}
}

public class MethodReftoCons {
	
	public static void main(String[] args) {
		Supplier<Dog> dogSupplier1= () -> new Dog();
		Supplier<Dog> dogSupplier2= Dog::new;//
		
		//BiFunction<Integer, Integer, Integer> biFunction=(num1,num2)->Integer.sum(num1, num2);
		BiFunction<Integer, Integer, Integer> biFunction=Integer::sum; // reference to static
		int result=biFunction.apply(10,22);
		System.out.println(result);
	}

}
