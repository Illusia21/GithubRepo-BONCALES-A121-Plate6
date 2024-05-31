package problem3;

import java.util.Scanner;

public class Problem3 {
    static int[][] boncalesGraph;
    static boolean[] boncalesVisited;
    
    public static void main(String[] args) {
        Scanner boncalesScanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int boncalesVertices = boncalesScanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int boncalesEdges = boncalesScanner.nextInt();

        boncalesGraph = new int[boncalesVertices][boncalesVertices];

        System.out.println("Enter the edges: ");
        for (int i = 0; i < boncalesEdges; i++) {
            int u = boncalesScanner.nextInt();
            int v = boncalesScanner.nextInt();
            boncalesGraph[u][v] = 1;
            boncalesGraph[v][u] = 1;
        }

        boncalesVisited = new boolean[boncalesVertices];

        boolean boncalesHasCycle = false;
        for (int i = 0; i < boncalesVertices; i++) {
            if (!boncalesVisited[i]) {
                if (boncalesDFS(i, -1)) {
                    boncalesHasCycle = true;
                    break;
                }
            }
        }

        if (boncalesHasCycle) {
            System.out.println("The graph has a cycle.");
        } else {
            System.out.println("The graph does not have a cycle.");
        }

        boncalesScanner.close();
    }

    private static boolean boncalesDFS(int v, int s) {
        boncalesVisited[v] = true;
        for (int i = 0; i < boncalesGraph.length; i++) {
            if (boncalesGraph[v][i] == 1) {
                if (!boncalesVisited[i]) {
                    if (boncalesDFS(i, v)) {
                        return true;
                    }
                } else if (i != s) {
                    return true;
                }
            }
        }
        return false;
    }
}
