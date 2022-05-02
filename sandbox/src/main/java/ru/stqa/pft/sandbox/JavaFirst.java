package ru.stqa.pft.sandbox;

public class JavaFirst {

	public static void main(String[] args){
		hello("GF");

		Square s = new Square(5);
		System.out.println(s.area());

		Rectangle r = new Rectangle(4,6);
		System.out.println(r.area());


		Point p1 = new Point(20,10);
		Point p2 = new Point(30,12);
		System.out.println(p1.distance(p2));
	}

	public static void hello (String somebody){
		System.out.println("Hello " + somebody);
	}
}