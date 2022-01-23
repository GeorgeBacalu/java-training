package code._3_in_class;

public class Student {
    private String nume;
    private String prenume;
    private int varsta;
    private String orasNatal;
    private String cnp;
    private String telefon;
    private String contactUrgenta;
    private String universitate;
    private String email;
    private String adresa;
    private String medieGenerala;

    public Student(String nume, String prenume, String varsta, String orasNatal, String cnp, String telefon, String contactUrgenta, String universitate, String email, String adresa) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = Integer.parseInt(varsta);
        this.orasNatal = orasNatal;
        this.cnp = cnp;
        this.telefon = telefon;
        this.contactUrgenta = contactUrgenta;
        this.universitate = universitate;
        this.email = email;
        this.adresa = adresa;
    }

    private Student() {}

    public String getVarsta() { return String.valueOf(varsta); }

    public void setVarsta(String varsta) {
        int varstaParsata = Integer.parseInt(varsta);
        if (varstaParsata >= 18 && varstaParsata <= 90) this.varsta = varstaParsata;
        else throw new RuntimeException("Valoare varsta invalida: setati o varsta cuprinsa intre 18 si 90 de ani");
    }

    // singleton lazy - creaza instanta doar la cerere
    private static Student instance;
    public static Student createInstance() {
        if (instance == null) {
            instance = new Student();
            return instance;
        } else throw new RuntimeException("Exista deja o instanta creata!");
    }

    // singleton eager - creaza instanta la pornirea aplicatiei
    /*
    private static Student instance = new Student();
    public static Student createInstance() { return instance; }
     */

    public static void main(String[] args) {
        // 1. Builder Design Pattern
        /*
        StudentBuilder sb = new StudentBuilder("Bacalu", "Andrei");
        sb.setVarsta("18").setTelefon("0243657888");
        Student student1 = sb.build();

        Student student2 = new StudentBuilder("Bacalu", "George").setEmail("georgebacalu83@gmail.com").build();
        */

        // 2. Singleton Design Pattern

        Student student3 = Student.createInstance();
        // Student student4 = Student.createInstance(); - returneaza exceptie

        // Pasi pentru a implementa design pattern-ul singleton = limitare creare maxim 1 instanta a unui obiect
        // a) creare constructor privat
        // b) expunerea unui mecanism / metoda prin care utilizatorul poate crea o singura instanta
    }
}
