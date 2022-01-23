package clean.code.design_patterns.requirements._2_transportation_problem;

public class FactoryDestination implements Destination {
    private String name;
    private int demand;

    public FactoryDestination(String name, int demand) {
        this.name = name;
        this.demand = demand;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public int getDemand() { return demand; }

    @Override
    public void setDemand(int demand) { this.demand = demand; }

    @Override
    public String toString() {
        return "FactoryDestination [name=" + name + ", demand=" + demand + "]";
    }
}
