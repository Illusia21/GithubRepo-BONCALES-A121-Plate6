import java.util.*;

public class Problem5 {

    public static boolean BoncalesBipartite(int[][] BoncalesEdges, int BoncalesNumVertices) {
        int[] BoncalesArr = new int[BoncalesNumVertices];
        Arrays.fill(BoncalesArr, -1);

        for (int BoncalesI = 0; BoncalesI < BoncalesNumVertices; BoncalesI++) {
            if (BoncalesArr[BoncalesI] == -1) {
                if (!BoncalesBipartiteU(BoncalesEdges, BoncalesI, BoncalesArr))
                    return false;
            }
        }
        return true;
    }

    public static boolean BoncalesBipartiteU(int[][] BoncalesEdges, int BoncalesS, int[] BoncalesColorArr) {
        BoncalesColorArr[BoncalesS] = 1;
        LinkedList<Integer> BoncalesQ = new LinkedList<>();
        BoncalesQ.add(BoncalesS);

        while (!BoncalesQ.isEmpty()) {
            int BoncalesU = BoncalesQ.poll();
            if (BoncalesEdges[BoncalesU][BoncalesU] == 1)
                return false;

            for (int BoncalesV = 0; BoncalesV < BoncalesEdges.length; BoncalesV++) {
                if (BoncalesEdges[BoncalesU][BoncalesV] == 1 && BoncalesColorArr[BoncalesV] == -1) {
                    BoncalesColorArr[BoncalesV] = 1 - BoncalesColorArr[BoncalesU];
                    BoncalesQ.add(BoncalesV);
                } else if (BoncalesEdges[BoncalesU][BoncalesV] == 1 && BoncalesColorArr[BoncalesV] == BoncalesColorArr[BoncalesU]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] BoncalesEdges = { 
            { 0, 1, 0, 0  },
            { 1, 0, 0, 0 },
            { 0, 0, 0, 1 },
            { 0, 0, 1, 0 },
        };
        /**0, 1, 0, 0 
        1, 0, 0, 0
        0, 0, 0, 1 
        0, 0, 1, 0
        0, 0, 0, 1
        0, 0, 1, 0**/
        //Expected Output:
        //This graph is bipartite
        
        int BoncalesNumV = BoncalesEdges.length;

        if (BoncalesBipartite(BoncalesEdges, BoncalesNumV))
            System.out.println("This graph is bipartite");
        else
            System.out.println("This graph is not bipartite");
    }
}


/** TEST CASES:
TEST CASE #1:
0, 1, 0, 0 
1, 0, 0, 0
0, 0, 0, 1 
0, 0, 1, 0

Expected Output:
This graph is bipartite


TEST CASE #2:
0, 1, 0, 1 
1, 0, 1, 0
0, 1, 0, 1 
1, 0, 1, 0

Expected Output:
This graph is bipartite


TEST CASE #3:
0, 1, 1, 1 
1, 0, 1, 1
1, 1, 0, 1 
1, 1, 1, 0

Expected Output:
This graph is not bipartite


TEST CASE #4:
0, 1, 0, 1 
1, 0, 1, 0
0, 1, 0, 1 
1, 0, 1, 1

Expected Output:
This graph is not bipartite


TEST CASE #5:
0, 1, 0, 0 
1, 0, 0, 0
0, 0, 0, 1 
0, 0, 1, 0
0, 0, 0, 1
0, 0, 1, 0

Expected Output:
This graph is bipartite **/