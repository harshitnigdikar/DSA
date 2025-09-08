package dsa.leetcode.graphs.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//not a correct solution
public class LC685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        Set<int[]> redEdges = new HashSet<>();

        //edges.length = 5
        //visited.length = 6
        int[] visited = new int[edges.length+1];

        for (int i = 1; i <= edges.length+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph.get(x).add(y);
        }

        for (int i = 1; i < edges.length+1; i++) {
            if (visited[i] == 0) {
                dfs(i, graph, visited, redEdges);
            }
        }

        for(int i = edges.length-1; i >= 0; i--){
            if(redEdges.contains(edges[i])){
                return edges[i];
            }
        }
        return new int[0];
    }
    private void dfs(int node, List<List<Integer>> graph, int[] visited, Set<int[]> redEdges) {
        visited[node] = 1;

        for (int nei : graph.get(node)) {
            if (visited[nei] == 0) {
                dfs(nei, graph, visited, redEdges);
            }else{
                int[] temp = new int[2];
                temp[0] = node;
                temp[1] = nei;
                redEdges.add(temp);
            }
        }
    }
}
