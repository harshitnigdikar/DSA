package dsa.leetcode.graphs.concepts;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    /*
    * Finds Shortest Path from one point to another in terms of weight
    * Almost BFS
    * Uses Priority Queue instead of queue
    *  */

    // given a 2-D array where [[src, target, weight]] -> all edges you can say
    //int [][]graph = new int[5][3];

    public void dijkstra(int[][] graph, int src, int target){

        PriorityQueue<int[]>pq = new PriorityQueue<>();

        //pq.stream().sorted((a,b) -> (a[2] - b[2]));

        pq.add(graph[0]);
        int[] visited = new int[graph.length];

        while (!pq.isEmpty()){
            int[] edge = pq.remove();

            visited[edge[0]] = 1;

            System.out.println("next node ->" + edge[0]);

            // Add edges in PQ

        }
    }

}
