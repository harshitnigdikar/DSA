package dsa.leetcode.graphs.practice;

import java.util.Arrays;
import java.util.List;


// [[1,3],[3,0,1],[2],[0]]
public class LC841KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
         int[] visited = new int[rooms.size()];
         dfs(0, rooms, visited);

        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0){
                return false;
            }
        }
        return true;
    }
    public void dfs(int node, List<List<Integer>>rooms, int[] visited){
        visited[node] = 1;

        for(int i : rooms.get(node)){
            if(visited[i] == 0){
                dfs(i, rooms, visited);
            }
        }
    }
}
