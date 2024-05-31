package problem6;

public class Problem6 {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {2, 3}, {3, 4}};
        int vertexIndexBoncales = 0;
        
        /**TEST CASE #5:
        {{0, 1}, {2, 3}, {3, 4}}

        Expected Output:
        0 1 0 0 0 
        1 0 0 0 0 
        0 0 0 1 0 
        0 0 1 0 1 
        0 0 0 1 0   **/

        for (int[] edge : edges) {
            vertexIndexBoncales = Math.max(vertexIndexBoncales, Math.max(edge[0], edge[1]));
        }

        int[][] adjacencyMatrixBoncales = new int[vertexIndexBoncales + 1][vertexIndexBoncales + 1];

        for (int[] edge : edges) {
            int uBoncales = edge[0];
            int vBoncales = edge[1];
            adjacencyMatrixBoncales[uBoncales][vBoncales] += 1; 
        }

        System.out.println("Welcome to Problem 6");
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i <= vertexIndexBoncales; i++) {
            for (int j = 0; j <= vertexIndexBoncales; j++) {
                System.out.print(adjacencyMatrixBoncales[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/**TEST CASES:
TEST CASE #1:
{{0, 1}, {1, 2}, {2, 0}}

Expected Output:
Adjacency Matrix:
0 1 0 
0 0 1 
1 0 0 


TEST CASE #2:
{{0, 1}, {1, 2}, {2, 0}, {1, 1}}

Expected Output:
Adjacency Matrix:
0 1 0 
0 1 1 
1 0 0 


TEST CASE #3:
{{0, 1}, {1, 2}, {2, 0}, {1, 2}, {2, 0}}

Expected Output:
Adjacency Matrix:
0 1 0 
0 0 2 
2 0 0 


TEST CASE #4:
{{0, 1}, {1, 2}, {2, 0}}

Expected Output:
Adjacency Matrix:
0 1 1 
1 0 1 
1 1 0 


TEST CASE #5:
{{0, 1}, {2, 3}, {3, 4}}

Expected Output:
0 1 0 0 0 
1 0 0 0 0 
0 0 0 1 0 
0 0 1 0 1 
0 0 0 1 0 **/