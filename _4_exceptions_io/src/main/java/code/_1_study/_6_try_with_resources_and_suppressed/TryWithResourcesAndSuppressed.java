package code._1_study._6_try_with_resources_and_suppressed;

public class TryWithResourcesAndSuppressed {

    public static void main(String[] args) {
        try (BrokenClosableResource resource = new BrokenClosableResource()) {
            throw new CustomException("Error when doing work");
        } catch (Exception ex) {
            System.err.println("Exception encountered: " + ex.toString());
            printSuppressedExceptions(ex);
        }
    }

    private static void printSuppressedExceptions(Exception ex) {
        Throwable[] suppressedExceptions = ex.getSuppressed();
        int numSuppressed = suppressedExceptions.length;
        if (numSuppressed > 0) {
            System.err.println("Found " + numSuppressed + " suppressed exceptions:");
            for (int i = 0; i < suppressedExceptions.length; i++) {
                System.err.println("Nr " + (i + 1) + " : " + suppressedExceptions[i].toString());
            }
        }
    }

    // un try care primeste ca parametru o resursa, o si inchide automat la finalul executiei -> implementeaza principiul autoclosable
    // incepand cu java8 obiectele apartinand clasei throwable au disponibila metoda getSuppressed() care intercepteaza toate exceptiile amortizate

}
