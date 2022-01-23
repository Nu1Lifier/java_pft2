package ru.stqa.pft.sandbox;

public class JavaFirst {

	public static void main(String[] args){
		hello("GF");
		System.out.println(area(5));

		System.out.println(area2(2,4));




	}

	public static void hello (String somebody){
		System.out.println("Hello " + somebody);
	}

	public static double area (double l){
		return  l * l;
	}

	public static double area2 (double a, double b){
		return  a*b;
	}
}