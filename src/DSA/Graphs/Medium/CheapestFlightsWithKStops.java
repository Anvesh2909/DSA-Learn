package DSA.Graphs.Medium;
import java.util.*;

public class CheapestFlightsWithKStops {
    class Flight {
        int city;
        int price;
        int stops;

        Flight(int c, int p, int s) {
            city = c;
            price = p;
            stops = s;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        PriorityQueue<Flight> pq = new PriorityQueue<>((a, b) -> a.price - b.price);
        pq.offer(new Flight(src, 0, 0));
        int[][] minCost = new int[n][k + 2];
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minCost[src][0] = 0;
        while (!pq.isEmpty()) {
            Flight curr = pq.poll();
            int city = curr.city;
            int price = curr.price;
            int stops = curr.stops;
            if (city == dst) {
                return price;
            }
            if (stops > k) {
                continue;
            }
            for (int[] neighbor : graph.get(city)) {
                int nextCity = neighbor[0];
                int nextPrice = price + neighbor[1];
                int nextStops = stops+1;
                if (nextPrice < minCost[nextCity][nextStops]) {
                    minCost[nextCity][nextStops] = nextPrice;
                    pq.offer(new Flight(nextCity, nextPrice, nextStops));
                }
            }
        }
        return -1;
    }
}
