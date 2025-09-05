package dsa.leetcode.graphs.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC2316 {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> components = new ArrayList<>();
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                List<Integer> comp = new ArrayList<>();
                dfs(i, graph, visited, comp);
                components.add(comp);
            }
        }

        if (components.size() <= 1) return 0;

        long fans = 0;
        for (List<Integer> comp : components) {
            fans += (long) comp.size() * (n - comp.size());
        }

        return fans / 2;  // avoid double counting
    }

    private void dfs(int node, List<List<Integer>> graph, int[] visited, List<Integer> comp) {
        visited[node] = 1;
        comp.add(node);   // FIX: add the current node
        for (int nei : graph.get(node)) {
            if (visited[nei] == 0) {
                dfs(nei, graph, visited, comp);
            }
        }
    }
}
