package code._4_student_effort._1_two_fighters;

public class Fighter {
    private final String name;
    private final int damagePerAttack;
    private int health;

    public Fighter(String name, int damagePerAttack, int health) {
        this.name = name;
        this.damagePerAttack = damagePerAttack;
        this.health = health;
    }

    public String getName() { return name; }
    public int getDamagePerAttack() { return damagePerAttack; }
    public int getHealth() { return health; }

    public void setHealth(int health) { this.health = health; }

    public void attack(Fighter opponent) { opponent.setHealth(opponent.getHealth() - this.getDamagePerAttack()); }
}
