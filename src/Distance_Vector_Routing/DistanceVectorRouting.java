package Distance_Vector_Routing;

import java.util.Scanner;

public class DistanceVectorRouting {
    static final int INF = 999; // Use a large number to represent "infinity"

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];
        int[][] distance = new int[n][n];
        int[][] nextHop = new int[n][n];

        // Input cost matrix
        System.out.println("Enter cost matrix (999 for no direct path):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
                distance[i][j] = cost[i][j];
                if (i != j && cost[i][j] != INF) {
                    nextHop[i][j] = j;
                } else {
                    nextHop[i][j] = -1;
                }
            }
        }

        // Distance Vector Routing Algorithm
        boolean updated;
        do {
            updated = false;
            for (int i = 0; i < n; i++) { // source
                for (int j = 0; j < n; j++) { // destination
                    for (int k = 0; k < n; k++) { // intermediate
                        if (distance[i][k] + distance[k][j] < distance[i][j]) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                            nextHop[i][j] = nextHop[i][k];
                            updated = true;
                        }
                    }
                }
            }
        } while (updated);

        // Display routing tables
        for (int i = 0; i < n; i++) {
            System.out.println("\nRouting table for Node " + i + ":");
            System.out.println("Destination\tNextHop\t\tDistance");
            for (int j = 0; j < n; j++) {
                System.out.println("     " + j + "\t\t   " + (nextHop[i][j] == -1 ? "-" : nextHop[i][j]) + "\t\t   " + distance[i][j]);
            }
        }
    }
}
