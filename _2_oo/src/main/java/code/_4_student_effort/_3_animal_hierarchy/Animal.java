package code._4_student_effort._3_animal_hierarchy;

public abstract class Animal {
    protected int numberOfLegs;

    protected Animal(int numberOfLegs) { this.numberOfLegs = numberOfLegs; }

    public abstract void eat();

    public void walk() { System.out.println("Animal with " + numberOfLegs + " legs is walking"); }
}
