package dsa.leetcode.graphs.practice;

import java.util.Arrays;

public class LC787CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int []dist = new int [n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i=0;i<=k;i++)
        {
            int[] temp = dist.clone();
            for(int j[]:flights)
            {
                int u=j[0],v=j[1],w=j[2];

                if(dist[u] != Integer.MAX_VALUE && dist[u]+w < temp[v])
                    temp[v] = dist[u]+w;
            }
            dist = temp;
        }
        return (dist[dst]==Integer.MAX_VALUE)?-1:dist[dst];
    }
}
