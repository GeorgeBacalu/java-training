package code._4_student_effort._6_builder;

public class BuilderExample {
    public static void main(String[] args) {
        Person person1 = new Person.Builder("Popescu").setJob("java developer").setUniversity("FMI").setMarried(false).build();
        Person person2 = new Person.Builder("Ionescu").setDrivingLicense("B").setMarried(true).build();
    }
}
