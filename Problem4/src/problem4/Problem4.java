package problem4;

public class Problem4 {

    static class GraphBoncales {
        int verticesBoncales, edgesBoncales;
        int[][] adjMatrixBoncales;

        GraphBoncales(int v, int e) {
            this.verticesBoncales = v;
            this.edgesBoncales = e;
            adjMatrixBoncales = new int[v][v];
        }
    }

    static GraphBoncales createGraphBoncales(int v, int e) {
        GraphBoncales gBoncales = new GraphBoncales(v, e);

        gBoncales.adjMatrixBoncales[0][1] = 1;
        gBoncales.adjMatrixBoncales[1][0] = 1;
        
        gBoncales.adjMatrixBoncales[1][2] = 1;
        gBoncales.adjMatrixBoncales[2][1] = 1;
        
        gBoncales.adjMatrixBoncales[2][0] = 1;
        gBoncales.adjMatrixBoncales[0][2] = 1;
        
        return gBoncales;
    }

    static int findDegBoncales(GraphBoncales graphBoncales, int vertexBoncales) {
        int degreeBoncales = 0;
        for (int i = 0; i < graphBoncales.verticesBoncales; i++) {
            if (graphBoncales.adjMatrixBoncales[vertexBoncales][i] == 1 || graphBoncales.adjMatrixBoncales[i][vertexBoncales] == 1)
                degreeBoncales++;
        }
        return degreeBoncales;
    }

    public static void main(String[] args) {
        int verticesBoncales = 3;
        int edgesBoncales = 3;

        GraphBoncales gBoncales = createGraphBoncales(verticesBoncales, edgesBoncales);

        for (int i = 0; i < verticesBoncales; i++) {
            int degreeBoncales = findDegBoncales(gBoncales, i);
            System.out.println("Degree of vertex " + i + ": " + degreeBoncales);
        }
    }
}

/** TEST CASES:
TEST CASE #1:
Number of vertices: 4
Number of edges: 4
Edges: (0, 1), (0, 2), (1, 2), (2, 3)

Expected Output:

Degree of vertex 0: 2
Degree of vertex 1: 2
Degree of vertex 2: 3
Degree of vertex 3: 1

TEST CASE #2:
Number of vertices: 5
Number of edges: 3
Edges: (0, 1), (0, 2), (0, 3)

Expected Output:

Degree of vertex 0: 3
Degree of vertex 1: 1
Degree of vertex 2: 1
Degree of vertex 3: 1
Degree of vertex 4: 0

TEST CASE #3:
Number of vertices: 6
Number of edges: 6
Edges: (0, 1), (1, 2), (2, 3), (3, 4), (4, 5), (5, 0)

Expected Output:

Degree of vertex 0: 2
Degree of vertex 1: 2
Degree of vertex 2: 2
Degree of vertex 3: 2
Degree of vertex 4: 2

TEST CASE #4:
Number of vertices: 3
Number of edges: 3
Edges: (0, 1), (1, 2), (2, 0)

Expected Output:

Degree of vertex 0: 2
Degree of vertex 1: 2
Degree of vertex 2: 2

TEST CASE #5:
Number of vertices: 5
Number of edges: 5
Edges: (0, 1), (1, 2), (2, 3), (3, 4), (4, 0)

Expected Output:

Degree of vertex 0: 2
Degree of vertex 1: 2
Degree of vertex 2: 2
Degree of vertex 3: 2
Degree of vertex 4: 2 **/


