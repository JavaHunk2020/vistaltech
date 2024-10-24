package com.boot;

import java.util.function.Function;

interface A{
	public void show();
}

interface B extends A{
	public void hide();
}
class Aha {
	public static void main(String[] args) {
		//Function<String,Integer> faa=(String t)->t.length();
		Function<String,Integer> faa=String::length;
		
	}
	
}