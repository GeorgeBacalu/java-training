package code._1_study._3_type_errasure;

public class Node2 extends Node<Integer> {
    //after type erasure, the method signatures do not match
    void setData(Integer data) {
        super.setData(data);
    }

    // mosteneste setData(java.lang.Object) si dupa, ca sa functioneze specializarea mea se genereaza o metoda sintetica pentru tipul de date setData(java.lang.Integer)
    // -> partea de generice functioneaza fara batai de cap pentru cei ce folosesc limbajul
}
