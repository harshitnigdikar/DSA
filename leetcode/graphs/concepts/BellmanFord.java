package dsa.leetcode.graphs.concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
* Used for finding the shortest path from src to destination
* Why not Dijkstra? -> because this fails in -ve edges
* If the graph has -ve cycles the dijkstra fails
* Bellmen ford helps to detects -ve cycles also
* works only in Directed Graph
* Bellmen ford doesnt work on Undirected graphs
* Make a directed graph from undir. gra. and then apply bf
*
* algo -> apply formula n-1 times on all edges
* if(dist[u] + wt < dist[v]) dist[v] = dist[u] + wt;
* one more time apply the same formaula, if the distance gets updated, then there is a -ve cycle and min distance could not be found. return whatever you have found until now
*  */
public class BellmanFord {

    public int bellmanFord(int n, int m, int src, int dest, List<List<Integer>>edges){

        List<Integer> dist = IntStream.range(0, 10)   // indices 0 to 9
                .mapToObj(i -> Integer.MAX_VALUE)
                .collect(Collectors.toList());

        dist.set(src, 0);

        for(int i = 1; i <= n; i++){
            for (int j = 0; j <= m; j++){
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int wt = edges.get(j).get(2);

                if(dist.get(u) != 1e9 && (dist.get(u) + wt) < dist.get(v)) {
                    dist.set(v, dist.get(u) + wt);
                }
            }
        }
        return dist.get(dest);
    }

    public String negativeCycleUsingBellmanFord(int n, int m, int src, int dest, List<List<Integer>>edges){

        List<Integer> dist = IntStream.range(0, 10)   // indices 0 to 9
                .mapToObj(i -> Integer.MAX_VALUE)
                .collect(Collectors.toList());

        dist.set(src, 0);

        int flag = 0;

        for(int i = 1; i <= n; i++){
            for (int j = 0; j <= m; j++){
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int wt = edges.get(j).get(2);

                if(dist.get(u) != 1e9 && (dist.get(u) + wt) < dist.get(v)) {
                    flag =1;
                }
            }
            if(flag == 1){
                return "-ve cycle";
            }
        }
        return "No -ve Cycle";
    }
}
