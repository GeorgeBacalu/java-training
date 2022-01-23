package code._1_study._9_buffered_character_streams;

import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class CopyTextFiles {

    public static void main(String[] args) throws IOException {
        FileReader nonBufferedReader = new FileReader("_4_exceptions_io\\_test_files\\in\\a.txt");
        FileWriter nonBufferedWriter = new FileWriter("_4_exceptions_io\\_test_files\\out\\aNonBuffered.txt");
        printCopyDuration("non-buffered", nonBufferedReader, nonBufferedWriter);

        BufferedReader bufferedReader = new BufferedReader(new FileReader("_4_exceptions_io\\_test_files\\in\\a.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("_4_exceptions_io\\_test_files\\out\\aBuffered.txt"));
        printCopyDuration("buffered", bufferedReader, bufferedWriter);
    }

    private static void printCopyDuration(String msg, Reader reader, Writer writer) throws IOException {
        Instant start = Instant.now();
        copy(reader, writer);
        Instant stop = Instant.now();
        Duration duration = Duration.between(start, stop);
        System.out.println(msg + ": " + duration);
    }

    private static void copy(Reader reader, Writer writer) throws IOException {
        try {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
        } finally {
            if (reader != null) reader.close();
            if (writer != null) writer.close();
        }
    }

    // spre deosebire de FileReader si FileWriter, BufferedReader si BufferedWriter lucreaza cu fluxuri de caractere -> prin urmare nu se ia cate un caracter si se introduce in sir, ci un calup de caractere pe care le da mai departe
    // -> faci mai putine drumuri prin canalul de comunicare intre partea de citire si cea de scriere
}
