package week9;

public class PolyDriver {
    public static void main(String[] args){
        /* // not polymorphism - reference is same as object
        Animal animal = new Animal();
        animal.makeSound();
        Dog dog = new Dog();
        dog.makeSound();
        dog.chaseTail();
        Cat cat = newCat();
        cat.makeSound();
        */

        Animal animal = new Cat();
        animal.makeSound();
        animal = new Dog();
        animal.makeSound();
        ((Dog)animal).chaseTail();
        System.out.println(Beverage.getStatus());
    }
}
