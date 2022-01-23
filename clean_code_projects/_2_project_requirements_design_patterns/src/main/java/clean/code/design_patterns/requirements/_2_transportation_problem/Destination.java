package clean.code.design_patterns.requirements._2_transportation_problem;

public interface Destination {
    String getName();
    void setName(String name);
    int getDemand();
    void setDemand(int demand);
    // demand = how many units of commodity it is able to handle from the sources
}
