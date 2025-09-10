package dsa.leetcode.graphs.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC886PossiblePartion {
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
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n+1];
        Arrays.fill(color, -1);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 1; i <= n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            int x = dislike[0];
            int y = dislike[1];

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 1; i < color.length; i++) {
            if(color[i] == -1){
                if(!check(i, n, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
}
