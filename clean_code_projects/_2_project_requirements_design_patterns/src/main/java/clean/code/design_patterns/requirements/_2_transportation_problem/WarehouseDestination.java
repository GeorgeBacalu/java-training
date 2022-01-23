package clean.code.design_patterns.requirements._2_transportation_problem;

public class WarehouseDestination implements Destination {
    private String name;
    private int demand;

    public WarehouseDestination(String name, int demand) {
        super();
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
        return "WarehouseDestination [name=" + name + ", demand=" + demand + "]";
    }
}
