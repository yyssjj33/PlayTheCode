package ood.polymorphism;

public class AnimalTest {
	public static void main(String[] args) {
		Mamal dog = new Dog();
		Mamal cat = new Cat();

		dog.eat();
		cat.eat();
	}
}
