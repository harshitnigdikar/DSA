package dsa.leetcode.graphs.practice;

public class LC547NumberOFProvinces {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int components = 0;
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                dfs(i, isConnected, visited);
                components++;
            }
        }
        return components;
    }
    public void dfs(int node, int[][] isConnected, boolean[] visited){
        visited[node] = true;
        for(int i = 0; i < visited.length; i++){
            if(isConnected[node][i] == 1 && !visited[i]){
                dfs(i, isConnected, visited);
            }
        }
    }
}