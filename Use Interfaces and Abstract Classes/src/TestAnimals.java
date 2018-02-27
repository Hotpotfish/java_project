import java.util.Scanner;
public class TestAnimals {
	public static void main(String args[])
	{
		Fish f1 = new Fish();
		Animal f2 = new Fish();
		Pet f3 = new Fish();
		Cat c1 = new Cat("Xiao Bao");
		Animal c2 = new Cat();
		Pet c3 = new Cat("Xiao fei");
		Spider s1 = new Spider();
		Animal s2 = new Spider();
		System.out.println("How about Fish f1?");
		f1.walk();
		System.out.println("How about Fish f2?");
		f2.walk();
		System.out.println("How about Fish f3?");
		f3.play();
		System.out.println("How about Cat c1?");
		c1.play();
		System.out.println("How about Cat c2?");
		c2.walk();
		
		
	}

}
