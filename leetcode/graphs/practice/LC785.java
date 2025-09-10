package dsa.leetcode.graphs.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC785 {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!check(i, graph.length, graph, color)) {
                    return true;
                }
            }
        }
        return true;
    }

    private boolean check(int start, int V, int[][] graph, int color[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for (int it : graph[node]) {
                //if the adjacent node is yet not colored
                //you will give the opposite color of the node
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                //if the adjacent guy having the same color
                //someone did color it on some other path
                else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
