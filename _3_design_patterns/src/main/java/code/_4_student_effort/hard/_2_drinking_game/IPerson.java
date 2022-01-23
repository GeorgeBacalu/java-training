package code._4_student_effort.hard._2_drinking_game;

public interface IPerson {
    void walk();

    @LogExecutionTime
    void drink();

    String getName();
}
