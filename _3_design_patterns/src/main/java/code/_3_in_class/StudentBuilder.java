package code._3_in_class;

public class StudentBuilder {
    // required - se seteaza prin intermediul constructorului
    private String nume;
    private String prenume;

    // optional - se seteaza prin intermediul setterilor
    private String varsta;
    private String orasNatal;
    private String cnp;
    private String telefon;
    private String contactUrgenta;
    private String universitate;
    private String email;
    private String adresa;

    public StudentBuilder(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public StudentBuilder setVarsta(String varsta) {
        this.varsta = varsta;
        return this;
    }

    public StudentBuilder setOrasNatal(String orasNatal) {
        this.orasNatal = orasNatal;
        return this;
    }

    public StudentBuilder setCnp(String cnp) {
        this.cnp = cnp;
        return this;
    }

    public StudentBuilder setTelefon(String telefon) {
        this.telefon = telefon;
        return this;
    }

    public StudentBuilder setContactUrgenta(String contactUrgenta) {
        this.contactUrgenta = contactUrgenta;
        return this;
    }

    public StudentBuilder setUniversitate(String universitate) {
        this.universitate = universitate;
        return this;
    }

    public StudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public StudentBuilder setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public Student build() {
        return new Student(nume, prenume, varsta, orasNatal, cnp, telefon, contactUrgenta, universitate, email, adresa);
    }
}