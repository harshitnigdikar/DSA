package dsa.leetcode.graphs.practice;

import java.util.ArrayList;


/* Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2

[[0,1],[0,2],[3,5],[5,4],[4,3]]
* */
class LC1971FindIfPathExists {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int j = edge[0];
            int k = edge[1];
            graph.get(j).add(k);
            graph.get(k).add(j);
        }

        boolean[] visited = new boolean[n];

        return dfs(n, graph, source, destination, visited);
    }
    public boolean dfs(int n, ArrayList<ArrayList<Integer>> graph, int source, int destination, boolean[] visited){

        if(source == destination) return true;
        visited[source] = true;

        for(int i : graph.get(source)){
            if(!visited[i]){
                boolean res = dfs(n, graph, i, destination, visited);
                if(res) {
                    return true;
                }
            }
        }
        return false;
    }
}