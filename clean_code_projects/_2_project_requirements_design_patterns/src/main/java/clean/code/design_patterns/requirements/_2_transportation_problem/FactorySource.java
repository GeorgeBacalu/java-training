package clean.code.design_patterns.requirements._2_transportation_problem;

public class FactorySource implements Source {
    private String name;
    private int supply;

    public FactorySource(String name, int supply) {
        super();
        this.name = name;
        this.supply = supply;
    }

    @Override
    public String getName() { return name; }

    @Override
    public void setName(String name) { this.name = name; }

    @Override
    public int getSupply() { return supply; }

    @Override
    public void setSupply(int supply) { this.supply = supply; }

    @Override
    public String toString() {
        return "FactorySource [name=" + name + ", supply=" + supply + "]";
    }
}
