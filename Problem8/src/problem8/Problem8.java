import org.jgrapht.Graph;
import org.jgrapht.alg.isomorphism.VF2GraphIsomorphismInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import java.util.Iterator;
import org.jgrapht.GraphMapping;

public class Problem8 {
    public static void main(String[] args) {
        Graph<String, DefaultEdge> BoncalesGraph1 = new SimpleGraph<>(DefaultEdge.class);
        Graph<String, DefaultEdge> BoncalesGraph2 = new SimpleGraph<>(DefaultEdge.class);

        BoncalesGraph1.addVertex("A");
        BoncalesGraph1.addVertex("B");
        BoncalesGraph1.addVertex("C");
        BoncalesGraph1.addVertex("D");
        
        BoncalesGraph2.addVertex("1");
        BoncalesGraph2.addVertex("2");
        BoncalesGraph2.addVertex("3");
        BoncalesGraph2.addVertex("4");

        BoncalesGraph1.addEdge("A", "B");
        BoncalesGraph1.addEdge("B", "C");
        BoncalesGraph1.addEdge("C", "D");
        
        BoncalesGraph2.addEdge("1", "2");
        BoncalesGraph2.addEdge("2", "3");
        BoncalesGraph2.addEdge("3", "4");
        BoncalesGraph2.addEdge("4", "1");
       
        
        
        /**TEST CASE #5:
        Graph 1:
        Vertices: A, B, C, D
        Edges: (A-B), (B-C), (C-D)
        Graph 2:
        Vertices: 1, 2, 3, 4
        Edges: (1-2), (2-3), (3-4), (4-1)

        Expected Output:
        The graphs are not isomorphic.**/
        
        

        VF2GraphIsomorphismInspector<String, DefaultEdge> BoncalesIsomorphismInspector =
                new VF2GraphIsomorphismInspector<>(BoncalesGraph1, BoncalesGraph2);

        if (BoncalesIsomorphismInspector.isomorphismExists()) {
            System.out.println("The graphs are isomorphic.");

            Iterator<GraphMapping<String, DefaultEdge>> BoncalesMappings = BoncalesIsomorphismInspector.getMappings();

            while (BoncalesMappings.hasNext()) {
                GraphMapping<String, DefaultEdge> BoncalesMapping = BoncalesMappings.next();
                System.out.println("Mapping: " + BoncalesMapping);
                
                for (String BoncalesVertex : BoncalesGraph1.vertexSet()) {
                    System.out.println(BoncalesVertex + " -> " + BoncalesMapping.getVertexCorrespondence(BoncalesVertex, true));
                }
            }
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    }
}

/**TEST CASES:
TEST CASE #1:
Graph 1:
Vertices: A, B, C
Edges: (A-B), (B-C), (C-A)
Graph 2:
Vertices: 1, 2, 3
Edges: (1-2), (2-3), (3-1)

Expected Output:
The graphs are isomorphic.



TEST CASE #2:
Graph 1:
Vertices: A, B, C
Edges: (A-B), (B-C)
Graph 2:
Vertices: 1, 2, 3
Edges: (1-2), (2-3), (3-1)

Expected Output:
The graphs are not isomorphic.

TEST CASE #3:
Graph 1:
Vertices: A, B, C, D
Edges: (A-B), (B-C), (C-D), (D-A)
Graph 2:
Vertices: 1, 2, 3, 4
Edges: (1-2), (2-3), (3-4), (4-1)

Expected Output:
The graphs are isomorphic.


TEST CASE #4:
Graph 1:
Vertices: X, Y, Z
Edges: (X-Y), (Y-Z), (Z-X)
Graph 2:
Vertices: 4, 5, 6
Edges: (4-5), (5-6), (6-4)

Expected Output:
The graphs are isomorphic.


TEST CASE #5:
Graph 1:
Vertices: A, B, C, D
Edges: (A-B), (B-C), (C-D)
Graph 2:
Vertices: 1, 2, 3, 4
Edges: (1-2), (2-3), (3-4), (4-1)

Expected Output:
The graphs are not isomorphic.  **/
