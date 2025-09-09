package dsa.leetcode.graphs.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/*
* To check if the graph is bipartite
* A bipartite graph can be colored with two colors such that no two adjacent vertices share the same color.
*  This means we can divide the graph's vertices into two distinct sets where:
*  All edges connect vertices from one set to vertices in the other set.
*  No edges exist between vertices within the same set.
* */
public class GraphColuring {
    private boolean check(int start, int V, ArrayList<ArrayList<Integer>>adj, int color[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(int it : adj.get(node)){
                //if the adjacent node is yet not colored
                //you will give the opposite color of the node
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                //if the adjacent guy having the same color
                //someone did color it on some other path
                else if(color[it] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj){
        int[] color = new int[v];
        Arrays.fill(color, -1);

        for (int i = 0; i < v; i++) {
            if(color[i] == -1){
                if(!check(i, v, adj, color)){
                    return true;
                }
            }
        }
        return true;
    }
}
