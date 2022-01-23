package code._4_student_effort._2_movie_database;

public class Actor {
    private final String nume;
    private final int varsta;
    private final Premiu[] premii;

    public Actor(String nume, int varsta, Premiu[] premii) {
        this.nume = nume;
        this.varsta = varsta;
        this.premii = premii;
    }

    public String getNume() { return nume; }
    public int getVarsta() { return varsta; }
    public Premiu[] getPremii() { return premii; }
}
