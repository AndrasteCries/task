package pat;

import java.util.*;

public class Task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();                                 // number of tests
        sc.nextLine();  // Consume the newline after reading the number of tests
        for (int i = 0; i < s; i++) {                          // iteration for every test
            int n = sc.nextInt();                             // number of cities
            sc.nextLine();  // Consume the newline after reading the number of cities
            Map<String, Integer> cityIndex = new HashMap<>(); // map for city like ("cityName", index)
            List<List<int[]>> graph = new ArrayList<>();      // graph for cities like ([[1,1], [2,3]], [[1,2], [2,4]]), for every city [neighbor, weight]

            // Initialize the graph with empty lists for each city
            for (int j = 1; j <= n; j++) {                     // for every city
                String cityName = sc.nextLine();              // input city name
                cityIndex.put(cityName, j);                   // map city name to index
                graph.add(new ArrayList<>());                 // create new city in graph
                int p = sc.nextInt();                         // neighbors count
                sc.nextLine();  // Consume the newline after the number of neighbors input
                for (int neigIndex = 0; neigIndex < p; neigIndex++) { // input data about neighbors
                    int neighbor = sc.nextInt();
                    int weight = sc.nextInt();
                    graph.get(j - 1).add(new int[]{neighbor - 1, weight});  // add edge [neighbor, cost]
                }
                sc.nextLine();  // Consume the newline after neighbors input
            }
            int r = sc.nextInt();                             // number of queries
            sc.nextLine();  // Consume the newline after reading the number of queries
            for (int queryIndex = 0; queryIndex < r; queryIndex++) {
                String sourceCity = sc.next();                // source city
                String destinationCity = sc.next();           // destination city
                int source = cityIndex.get(sourceCity);       // get source index
                int destination = cityIndex.get(destinationCity); // get destination index

                int minCost = dijkstra(graph, source - 1, destination - 1);  // 0-based index for dijkstra
                System.out.println(minCost);
            }
        }
    }

    static int dijkstra(List<List<int[]>> graph, int start, int end) {
        int n = graph.size();
        int[] distances = new int[n];
        Arrays.fill(distances, 200000);  // fill distances with a large number
        distances[start] = 0;  // first city has 0 distance

        // priority queue for min weights
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));
        pq.add(new int[]{start, 0});  // {city, weight}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();  // remove the city with the minimum cost
            int currentCity = current[0];
            int currentCost = current[1];

            if (currentCity == end) { // if reached the destination city return its cost
                return currentCost;
            }

            if (currentCost > distances[currentCity]) { // if the current cost is already worse than the previously found cost skip it
                continue;
            }

            for (int[] neighbor : graph.get(currentCity)) { // process all neighbors of the current city
                int nextCity = neighbor[0];
                int nextCost = currentCost + neighbor[1];

                if (nextCost < distances[nextCity]) { // if a shorter path to the neighbor is found, update its distance
                    distances[nextCity] = nextCost;
                    pq.add(new int[]{nextCity, nextCost});
                }
            }
        }

        return -1;  // if no path is found
    }
}
