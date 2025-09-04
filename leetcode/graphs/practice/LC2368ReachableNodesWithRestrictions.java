package dsa.leetcode.graphs.practice;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Input: n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
Output: 4
Explanation: The diagram above shows the tree.
We have that [0,1,2,3] are the only nodes that can be reached from node 0 without visiting a restricted node.
* */
public class LC2368ReachableNodesWithRestrictions {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[n];
        Set<Integer> hs = new HashSet<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for (int i = 0; i < restricted.length; i++) {
            hs.add(restricted[i]);
        }

        dfs(0, graph, hs, visited);

        for(int i = 0; i < visited.length; i++){
            if(visited[i] == 1) count++;
        }

        return count;
    }

    public void dfs(int node, List<List<Integer>> graph, Set<Integer> restricted, int[] visited) {
        if (restricted.contains(node)) {
            return;
        }

        visited[node] = 1;

        for (int i : graph.get(node)) {
            if (visited[i] != 1) {
                dfs(i, graph, restricted, visited);
            }
        }
    }
}



























