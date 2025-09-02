package dsa.leetcode.graphs.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridegsInAGraphTarjanAlgo {
    private int timer = 1;

    private void dfs(int node, int parent, int[] vis,
                     ArrayList<ArrayList<Integer>>adj, int tin[], int low[], List<List<Integer>>bridges){
        vis[node]=1;
        tin[node] = low[node] = timer;
        timer++;
        for(Integer it : adj.get(node)){
            if(it == parent) continue;
            if(vis[it] == 0){
                dfs(it, node, vis, adj, tin, low, bridges);
                low[node] = Math.min(low[node], low[it]);
                if(low[it] > tin[node]){
                    bridges.add(Arrays.asList(it, node));
                }
            }else{
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }

    // calling dfs -> dfs(0, -1, vis, adj, tin, low, bridges);
}
