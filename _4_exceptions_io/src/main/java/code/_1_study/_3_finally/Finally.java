package code._1_study._3_finally;

public class Finally {

    public static void main(String[] args) {
        Finally ex2 = new Finally();
        int result = ex2.test();

        System.out.println("before");
        System.out.println(result);
        System.out.println("after");
    }

    public int test() { //what will this method return ?
        try {
            //throw new RuntimeException("something bad happened");
            // incearca sa citesti fisierul X folosind canalDeComunicarePesteRetea
            return 0;
        } catch (Exception e) {
            // trateaza cazul in care fisierul nu exista - aflu ca nu exista folosind canalDeComunicarePesteRetea
            return 1;
        } finally {
            // dezalocam resursele folosite sau inchidem canalul de comunicare
            return 2;
        }
    }
}
