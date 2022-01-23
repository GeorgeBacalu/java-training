package code._4_student_effort._3_animal_hierarchy;

public class Fish extends Animal implements Pet {
    private String name;

    protected Fish(String name) {
        super(0);
        this.name = name;
    }

    public Fish() { this(""); }

    @Override
    public void eat() { System.out.println("Fish " + name + " is eating"); }
    @Override
    public void walk() { System.out.println("Fish " + name + " cannot walk"); }
    @Override
    public void play() { System.out.println("Fish " + name + " is playing"); }
    @Override
    public String getName() { return this.name; }
    @Override
    public void setName(String name) { this.name = name; }
}
