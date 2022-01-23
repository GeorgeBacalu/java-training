package clean.code.design_patterns.requirements._2_transportation_problem;

public interface Source {
    String getName();
    void setName(String name);
    int getSupply();
    void setSupply(int supply);
    // supply = how many units of commodity it is able to supply to the destinations
}
