import java.util.Scanner;

public class Problem1 {

    public static void DFS(int[][] graph, int v, boolean[] boncalesVisited) {
        boncalesVisited[v] = true;
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] == 1 && !boncalesVisited[i]) {
                DFS(graph, i, boncalesVisited);
            }
        }
    }

    public static boolean connected(int[][] graph) {
        boolean[] boncalesVisited = new boolean[graph.length];
        DFS(graph, 0, boncalesVisited);

        for (boolean visit : boncalesVisited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }

    public static int countConnect(int[][] graph) {
        boolean[] boncalesVisited = new boolean[graph.length];
        int boncalesCount = 0;

        for (int i = 0; i < graph.length; i++) {
            if (!boncalesVisited[i]) {
                DFS(graph, i, boncalesVisited);
                boncalesCount++;
            }
        }
        return boncalesCount;
    }

    public static void main(String[] args) {
        Scanner boncalesScanner = new Scanner(System.in);

        System.out.print("Input how many vertices: ");
        int boncalesNumVertex = boncalesScanner.nextInt();

        int[][] graph = new int[boncalesNumVertex][boncalesNumVertex];

        System.out.print("Input how many edges: ");
        int boncalesNumEdge = boncalesScanner.nextInt();

        System.out.println("Enter the edges: ");
        for (int i = 0; i < boncalesNumEdge; i++) {
            int boncalesY = boncalesScanner.nextInt();
            int boncalesZ = boncalesScanner.nextInt();
            graph[boncalesY][boncalesZ] = 1;
            graph[boncalesY][boncalesZ] = 1;
        }

        if (connected(graph)) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + countConnect(graph));
        }
    }
}
