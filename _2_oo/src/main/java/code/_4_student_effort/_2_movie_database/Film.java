package code._4_student_effort._2_movie_database;

public class Film {
    private final String nume;
    private final int anAparitie;
    private final Actor[] actori;

    public Film(String nume, int anAparitie, Actor[] actori) {
        this.nume = nume;
        this.anAparitie = anAparitie;
        this.actori = actori;
    }

    public String getNume() { return nume; }
    public int getAnAparitie() { return anAparitie; }
    public Actor[] getActori() { return actori; }
}
