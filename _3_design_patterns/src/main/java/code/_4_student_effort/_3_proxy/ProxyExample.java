package code._4_student_effort._3_proxy;

public class ProxyExample {
    public static void main(String[] args) {
        Apartment apartment1 = new Apartment("Crangasi1", 300);
        Apartment apartment2 = new Apartment("Crangasi1", 600);
        Apartment apartment3 = new Apartment("Crangasi1", 350);
        Apartment apartment4 = new Apartment("Crangasi1", 400);
        Apartment apartment5 = new Apartment("Crangasi1", 200);

        RealEstateAgentProxy realEstateAgent = new RealEstateAgentProxy();
        realEstateAgent.represent(apartment1);
        realEstateAgent.represent(apartment2);
        realEstateAgent.represent(apartment3);
        realEstateAgent.represent(apartment4);
        realEstateAgent.represent(apartment5);

        Student student1 = new Student("Ionescu", 500);
        Student student2 = new Student("Popescu", 330);

        Apartment apartmentForStudent1 = realEstateAgent.rent(student1);
        System.out.println(student1 + " rented " + apartmentForStudent1);
        Apartment apartmentForStudent2 = realEstateAgent.rent(student2);
        System.out.println(student2 + " rented " + apartmentForStudent2);
    }
}
