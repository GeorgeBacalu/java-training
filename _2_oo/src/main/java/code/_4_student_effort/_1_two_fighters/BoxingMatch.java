package code._4_student_effort._1_two_fighters;

public class BoxingMatch {
    private final Fighter fighter1;
    private final Fighter fighter2;

    public BoxingMatch(Fighter fighter1, Fighter fighter2) {
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
    }

    public static void main(String[] args) {
        Fighter fighter1 = new Fighter("player1", 10, 100);
        Fighter fighter2 = new Fighter("player2", 10, 100);
        BoxingMatch boxingMatch = new BoxingMatch(fighter1, fighter2);
        String winner = boxingMatch.fight();
        System.out.println("The winner is: " + winner);
    }

    private String fight() {
        while(fighter1.getHealth() > 0 && fighter2.getHealth() > 0) {
            fighter1.attack(fighter2);
            fighter2.attack(fighter1);
        }
        return fighter1.getHealth() <= 0 ? fighter1.getName() : fighter2.getName();
    }
}
