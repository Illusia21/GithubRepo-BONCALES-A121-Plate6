package problem2;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner boncalesScanner = new Scanner(System.in);
        boolean boncalesGraphChecker = true;
       
        System.out.print("Number of vertex: ");
        int boncalesNumVertex = boncalesScanner.nextInt();
        boncalesScanner.nextLine(); 

        String[] boncalesVertexName = new String[boncalesNumVertex];

        System.out.println("Name of vertex:");
        for (int i = 0; i < boncalesNumVertex; i++) {
            System.out.print("Node " + (i + 1) + ": ");
            boncalesVertexName[i] = boncalesScanner.nextLine();
        }

        int[][] boncalesAdjacencyMatrix = new int[boncalesNumVertex][boncalesNumVertex];
        
        System.out.println("Enter edges between nodes:");
        System.out.println();
        for (int i = 0; i < boncalesNumVertex; i++) {
            for (int j = 0; j < boncalesNumVertex; j++) {
                System.out.print("Enter number of edge/s between node " + boncalesVertexName[i] + " and " + boncalesVertexName[j] + ": ");
                
                if (!boncalesScanner.hasNextInt()) {  
                    System.out.println("Invalid input. Only digits only");
                    return;
                }
                boncalesAdjacencyMatrix[i][j] = boncalesScanner.nextInt();
                if (boncalesAdjacencyMatrix[i][j] < 0) { 
                    System.out.println("Invalid input. Only digits only");
                    return;
                }
            }
        }

        System.out.println("\nAdjacency Matrix:");
        System.out.print("  ");
        for (String boncalesNodeName : boncalesVertexName) {
            System.out.print(boncalesNodeName + " ");
        }
        System.out.println();
        
        for (int i = 0; i < boncalesNumVertex; i++) {
            System.out.print(boncalesVertexName[i] + " ");
            for (int j = 0; j < boncalesNumVertex; j++) {
                System.out.print(boncalesAdjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nEdges and the number of times each edge appears:");
        
        for (int i = 0; i < boncalesNumVertex; i++) {
            for (int j = 0; j < boncalesNumVertex; j++) {
                if (boncalesAdjacencyMatrix[i][j] > 0) {
                    System.out.println(boncalesVertexName[i] + "-" + boncalesVertexName[j] + ": " + boncalesAdjacencyMatrix[i][j]);
                }
                if (boncalesAdjacencyMatrix[i][j] != 0 && boncalesAdjacencyMatrix[i][j] != 1) {
                    boncalesGraphChecker = false;
                }
            }
        }
    }
}
