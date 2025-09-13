package dsa.leetcode.graphs.concepts;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


class DEdge{

    int src;
    int dest;
    int wt;
    public DEdge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}
class DPair{
    int dest;
    String psf;

    public DPair(int dest, String psf, int wsf) {
        this.dest = dest;
        this.psf = psf;
        this.wsf = wsf;
    }

    int wsf;
}
public class Dijkstra {
    /*
    * Finds Shortest Path from one point to another in terms of weight
    * Almost BFS
    * Uses Priority Queue instead of queue
    *  */

    // given a 2-D array where [[src, target, weight]] -> all edges you can say
    //int [][]graph = new int[5][3];


    public void dijkstra(int[][] graph, int src, int target) {

        List<List<DEdge>> adj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            int sc = graph[i][0];
            int dest = graph[i][1];
            int wt = graph[i][2];

            adj.get(sc).add(new DEdge(sc, dest, wt));
            adj.get(dest).add(new DEdge(dest, sc, wt));
        }

        int[] visited = new int[graph.length];


        PriorityQueue<DPair> pq = new PriorityQueue<>();

        pq.add(new DPair(src, src + "", 0));

        while (!pq.isEmpty()) {
            DPair rm = pq.remove();

            if (visited[rm.dest] == 1) {
                continue;
            }

            visited[rm.dest] = 1;

            System.out.println(rm.dest + "via" + rm.psf + " @ " + rm.wsf);

            for (DEdge e : adj.get(rm.dest)) {
                if (visited[e.dest] == 0) {
                    pq.add(new DPair(e.dest, rm.psf + e.dest, rm.wsf + e.wt));
                }
            }
        }
    }

}
