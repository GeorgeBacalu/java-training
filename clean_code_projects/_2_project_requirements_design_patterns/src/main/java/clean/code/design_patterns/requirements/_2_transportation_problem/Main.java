package clean.code.design_patterns.requirements._2_transportation_problem;

import java.util.*;

/**
 * An instance of the Transportation Problem consists of source and destinations.
 * <p>
 * Each source has a given capacity, i.e. how many units of a commodity it is able to supply to the destinations.
 * Each destination demands a certain amount of commodities.
 * The cost of transporting a unit of commodity from each source to each destination is given by a cost matrix (or function).
 * <p>
 * We consider the problem of determining the quantities to be transported from sources to destinations, in order to minimize the total transportation cost. The supply and demand constraints must be satisfied.
 * <p>
 * Consider the following example:
 * D1  D2  D3  Supply
 * S1       2   3   1     10
 * S2       5   4   8     35
 * S3       5   6   8     25
 * Demand   20  25  25
 * <p>
 * A solution may be something like that:
 * <p>
 * S1 -> D3: 10 units * cost 1 = 10
 * S2 -> D2: 25 units * cost 4 = 100
 * S2 -> D3: 10 * 8 = 80
 * S3 -> D1: 20 * 5 = 100
 * S3 -> D3: 5 * 8 = 40
 * Total cost: 330
 */

public class Main {
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        try {
            System.out.print("Introduce the number of sources: ");
            int numberOfSources = sc.nextInt();
            System.out.print("Introduce the number of destinations: ");
            int numberOfDestinations = sc.nextInt();
            List<Source> sourcesList = new ArrayList<>();
            List<Destination> destinationsList = new ArrayList<>();

            /**
             * Populate the list of sources and get the total number of units of commodity they are able to supply to the destinations
             */

            System.out.println();
            int totalSupply = 0;
            for (int i = 0; i < numberOfSources; i++) {
                System.out.println("Source " + (i + 1) + ": ");
                addSource(sourcesList);
                totalSupply += sourcesList.get(i).getSupply();
            }

            /**
             * Populate the list of destinations and get the total number of units of commodity they are able to handle from the sources
             */

            System.out.println();
            int totalDemand = 0;
            for (int i = 0; i < numberOfDestinations; i++) {
                System.out.println("Destination " + (i + 1) + ": ");
                addDestination(destinationsList);
                totalDemand += destinationsList.get(i).getDemand();
            }

            /**
             * If the total number of units from the sources is greater than the total number of units from the destinations, a new destination
             * with a number of units equal to the difference will be created. The same applies in the opposite case
             */

            if (totalSupply > totalDemand)
                destinationsList.add(new WarehouseDestination("D" + (numberOfDestinations + 1), totalSupply - totalDemand));
            else if (totalSupply < totalDemand)
                sourcesList.add(new WarehouseSource("S" + (numberOfSources + 1), totalDemand - totalSupply));
            displaySourcesList(sourcesList);
            displayDestinationsList(destinationsList);

            /**
             * Create arrays that contain the number of units for every source and destination
             */

            int[] supply = new int[sourcesList.size()];
            for (int i = 0; i < sourcesList.size(); i++) supply[i] = sourcesList.get(i).getSupply();
            int[] demand = new int[destinationsList.size()];
            for (int i = 0; i < destinationsList.size(); i++) demand[i] = destinationsList.get(i).getDemand();

            /**
             * Create and display a matrix of costs of transportation between each source and each destination
             */

            int[][] costs = new int[supply.length][demand.length];
            System.out.println("\nIntroduce the elements of the costs matrix: ");
            for (int i = 0; i < supply.length; i++) {
                for (int j = 0; j < demand.length; j++) {
                    System.out.print("costs[" + i + "][" + j + "]= ");
                    costs[i][j] = sc.nextInt();
                }
            }
            System.out.println("\nDisplay the costs matrix: ");
            displayMatrix(supply, demand, costs);

            /**
             * Create and display a copy of the costs matrix where the values for every row are sorted
             */

            int[][] sortedCosts = new int[supply.length][demand.length];
            for (int i = 0; i < supply.length; i++) {
                System.arraycopy(costs[i], 0, sortedCosts[i], 0, demand.length);
                Arrays.sort(sortedCosts[i]);
            }
            System.out.println("\nDisplay the sorted by row costs matrix: ");
            displayMatrix(supply, demand, sortedCosts);

            /**
             * Create and display a matrix of indexes of the second array based on the original matrix
             */

            int[][] sortedIndexes = new int[supply.length][demand.length];
            for (int i = 0; i < supply.length; i++) {
                for (int j = 0; j < demand.length; j++) {
                    for (int k = 0; k < demand.length; k++) {
                        if (sortedCosts[i][j] == costs[i][k]) sortedIndexes[i][j] = k;
                    }
                }
            }
            System.out.println("\nDisplay the sorted by row costs indexes matrix: ");
            displayMatrix(supply, demand, sortedIndexes);

            System.out.println("\nFinal solution: \n");
            int totalCost = 0;
            for (int i = 0; i < supply.length; i++) {
                for (int j = 0; j < demand.length; j++) {
                    // if a destination is fully supplied go to the next one
                    if (demand[sortedIndexes[i][j]] == 0) continue;
                    int auxSupply = supply[i], auxDemand = demand[sortedIndexes[i][j]], cost;
                    System.out.println("supply[" + i + "]= " + supply[i] + "\tdemand[" + sortedIndexes[i][j] + "]= " + demand[sortedIndexes[i][j]]);
                    if (supply[i] > demand[sortedIndexes[i][j]]) {
                        cost = demand[sortedIndexes[i][j]] * costs[i][sortedIndexes[i][j]];
                        supply[i] -= demand[sortedIndexes[i][j]];
                        demand[sortedIndexes[i][j]] = 0;
                    } else if (supply[i] < demand[sortedIndexes[i][j]]) {
                        cost = supply[i] * costs[i][sortedIndexes[i][j]];
                        demand[sortedIndexes[i][j]] -= supply[i];
                        supply[i] = 0;
                    } else {
                        cost = supply[i] * costs[i][sortedIndexes[i][j]];
                        demand[sortedIndexes[i][j]] = 0;
                        supply[i] = 0;
                    }
                    System.out.println(sourcesList.get(i).getName() + " -> " + destinationsList.get(sortedIndexes[i][j]).getName() + ": " + Math.min(auxSupply, auxDemand) + " * " + costs[i][sortedIndexes[i][j]] + " = " + cost);
                    System.out.println("supply[" + i + "]= " + supply[i] + "\tdemand[" + sortedIndexes[i][j] + "]= " + demand[sortedIndexes[i][j]] + "\n");
                    totalCost += cost;
                    // if the source has no more commodity to transport go to the next one
                    if (supply[i] == 0) break;
                }
            }
            System.out.println("-----------");
            System.out.println("Total cost: " + totalCost);

        } catch (Exception e) {
            System.out.println("There was an error in execution: " + e);
        } finally {
            sc.close();
        }
    }

    private static void displaySourcesList(List<Source> sourcesList) {
        System.out.println("\nDisplay the sourcesList: ");
        for (Source source : sourcesList) System.out.println(source);
    }

    private static void displayDestinationsList(List<Destination> destinationsList) {
        System.out.println("\nDisplay the destinationsList");
        for (Destination destination : destinationsList) System.out.println(destination);
    }

    private static void displayMatrix(int[] supply, int[] demand, int[][] arr) {
        for (int i = 0; i < supply.length; i++) {
            for (int j = 0; j < demand.length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static void addSource(List<Source> sourcesList) {
        try {
            sc.nextLine();
            System.out.print("Name: "); String name = sc.nextLine();
            for (int i = 0; i < sourcesList.size(); i++) {
                if (name.equalsIgnoreCase(sourcesList.get(i).getName())) {
                    System.out.println("This source has already been introduced! Introduce another name for it!");
                    System.out.print("Name: "); name = sc.nextLine();
                    i--;
                }
            }
            System.out.print("Supply: "); int supply = sc.nextInt();
            System.out.print("Introduce the type of source to add to the list (1 - Warehouse , 2 - Factory): "); int type = sc.nextInt();
            do {
                if (type == 1) sourcesList.add(new WarehouseSource(name, supply));
                else if (type == 2) sourcesList.add(new FactorySource(name, supply));
                else {
                    System.out.print("Introduce the type of source to add to the list (1 - Warehouse , 2 - Factory): ");
                    type = sc.nextInt();
                }
            } while (type != 1 && type != 2);
        } catch (Exception e) {
            System.out.println("There was an error at the data introduction: " + e);
        }
    }

    private static void addDestination(List<Destination> destinationsList) {
        try {
            sc.nextLine();
            System.out.print("Name: "); String name = sc.nextLine();
            for (int i = 0; i < destinationsList.size(); i++) {
                if (name.equals(destinationsList.get(i).getName())) {
                    System.out.println("This destination has already been introduced! Introduce another name for it!");
                    System.out.print("Name: "); name = sc.nextLine();
                    i--;
                }
            }
            System.out.print("Demand: "); int demand = sc.nextInt();
            System.out.print("Introduce the type of destination to add to the list (1 - Warehouse , 2 - Factory): "); int type = sc.nextInt();
            do {
                if (type == 1) destinationsList.add(new WarehouseDestination(name, demand));
                else if (type == 2) destinationsList.add(new FactoryDestination(name, demand));
                else {
                    System.out.print("Introduce the type of destination to add to the list (1 - Warehouse , 2 - Factory): ");
                    type = sc.nextInt();
                }

            } while (type != 1 && type != 2);
        } catch (Exception e) {
            System.out.println("There was an error at the data introduction: " + e);
        }
    }
}
