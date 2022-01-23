package code._3_in_class;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        a();

        try {
            System.out.println(7 / 0);
        } catch(ArithmeticException e) {
            System.out.println("Nu poti imparti la 0. " + e);
        }

        try {
            readFile("nicaieri");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(String path) throws FileNotFoundException {
        throw new FileNotFoundException("fisierul cautat la calea " + path + " nu a fost gasit.");
    }

    public static void a() {
        try {
            b();
        } catch (SQLException e) {
            System.out.println("fac altceva... resetez conexiunea la baza de date");
        } catch(IOException e) {
            System.out.println("ignor exceptiile de citire / scriere");
        }
    }

    public static void b() throws IOException, SQLException {
        c();
        throw new SQLException("Eroare la comunicarea cu baza de date");
    }

    public static void c() throws FileNotFoundException {
        throw new FileNotFoundException("nu ti-am gasit fisierul");
    }
}