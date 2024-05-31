import java.util.*;

public class Problem7 {

    public static void main(String[] args) {
        Scanner BoncalesScanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int boncalesNumV = BoncalesScanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int boncalesNumE= BoncalesScanner.nextInt();

        int[][] boncalesIncidenceMatrix = new int[boncalesNumV][boncalesNumE];

        for (int i = 0; i < boncalesNumE; i++) {
            System.out.println("Enter vertex pairs for edge " + (i + 1) + ": ");
            int boncalesVertex1 = BoncalesScanner.nextInt();
            int boncalesVertex2 = BoncalesScanner.nextInt();
            System.out.print("Enter the number of times edge " + (i + 1) + " appears: ");
            int boncalesEdge = BoncalesScanner.nextInt();

            boncalesIncidenceMatrix[boncalesVertex1 - 1][i] = boncalesEdge;
            boncalesIncidenceMatrix[boncalesVertex2 - 1][i] = boncalesEdge;
        }

        System.out.println("\nIncidence Matrix:");
        for (int i = 0; i < boncalesNumV; i++) {
            for (int j = 0; j < boncalesNumE; j++) {
                System.out.print(boncalesIncidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/**TEST CASES:
TEST CASE #1:
number of vertices: 3
number of edges: 3
1 2
1
2 3
1
1 3
1

Expected Output:

Incidence Matrix:
1 0 1 
1 1 0 
0 1 1 


TEST CASE #2:
number of vertices: 2
number of edges: 2
1 1
1
1 2
1

Expected Output:

Incidence Matrix:
1 1 
0 1 

TEST CASE #3:
number of vertices: 3
number of edges: 3
1 2
2
2 3
3
1 3
1

Expected Output:

Incidence Matrix:
2 0 1 
2 3 0 
0 3 1 


TEST CASE #4:
number of vertices: 4
number of edges: 4
1 2
1
2 3
1
3 4
1
4 1
1

Expected Output:

Incidence Matrix:
1 0 0 1 
1 1 0 0 
0 1 1 0 
0 0 1 1 


TEST CASE #5:
number of vertices: 5
number of edges: 3
1 2
1
3 4
1
4 5
1


Expected Output:

Incidence Matrix:
1 0 0 
1 0 0 
0 1 0 
0 1 1 
0 0 1  **/