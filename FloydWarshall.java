import java.util.Scanner;

public class FloydWarshall {
    final static int INF = 99999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input number of stations
        System.out.print("Enter number of stations: ");
        int n = sc.nextInt();
        
        int[][] graph = new int[n][n];
        
        // Input travel times
        System.out.println("Enter travel time matrix (use 99999 for no direct path):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        
        // Run Floyd-Warshall Algorithm
        floydWarshall(graph, n);
    }

    static void floydWarshall(int[][] graph, int n) {
        int[][] dist = new int[n][n];

        // Initialize distance array
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = graph[i][j];

        // Floyd-Warshall logic
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Print the final shortest distance matrix
        System.out.println("Shortest travel times between all stations:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
