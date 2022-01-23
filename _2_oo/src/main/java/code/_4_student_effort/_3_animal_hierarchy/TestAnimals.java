package code._4_student_effort._3_animal_hierarchy;

import java.util.Scanner;

public class TestAnimals {
    public static void main(String[] args) {
        Cat cat = new Cat("Leo");
        Fish fish = new Fish("Dorry");
        Spider spider = new Spider();
        Animal animalFish = new Fish();
        Animal animalSpider = new Spider();
        Pet petCat = new Cat("Yoki");

        // EXPERIMENT

        // 1. call methods on objects

        System.out.println(cat.getName());
        System.out.println(cat.numberOfLegs);
        cat.eat();
        cat.setName("Jack");
        cat.play();

        System.out.println(fish.getName());
        System.out.println(fish.numberOfLegs);
        fish.eat();
        fish.walk();
        fish.setName("Goldy");
        fish.play();

        System.out.println(animalFish.numberOfLegs);
        animalFish.eat();
        animalFish.walk();

        System.out.println(animalSpider.numberOfLegs);
        animalSpider.eat();
        animalSpider.walk();

        System.out.println(petCat.getName());
        petCat.setName("Jack");
        petCat.play();

        // 2. casting objects

        Animal animalFish2 = (Animal) fish;
        System.out.println(animalFish2.numberOfLegs);
        animalFish2.eat();
        animalFish2.walk();
        // animalFish2.play(); - gives an error

        // 3. using polymorphism

        Animal[] animals = new Animal[]{cat, fish, spider};
        for(Animal animal : animals) animal.eat();

        Scanner sc = new Scanner(System.in);
        Animal animal;

        System.out.println("What animal do you want?");
        System.out.print("(1 = cat) / (2 = fish) / (3 = spider): ");
        int option = sc.nextInt();

        switch(option) {
            case 1: animal = new Cat(); break;
            case 2: animal = new Fish(); break;
            case 3: animal = new Spider(); break;
            default: {
                animal = new Cat();
                System.out.println("Invalid option!");
            }
        }
        animal.eat();
        sc.close();
    }
}
