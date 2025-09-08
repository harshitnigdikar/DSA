package dsa.leetcode.graphs.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LC210CourseSchedule2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        Stack<Integer>st = new Stack<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            int y = prerequisite[1];

            graph.get(x).add(y);
        }
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0 && !dfs(i, graph, visited, st)){
                //System.out.println(i);
                return new int[0];
            }
        }
        int[] ans = new int[st.size()];
        int j = st.size();
        j--;
        while (!st.isEmpty()){
            ans[j] = st.pop();
            j--;
        }
        return ans;
    }
    private static boolean dfs(int node, List<List<Integer>>graph, int[] visited, Stack<Integer>st){
        visited[node] = 1;

        for (int nbr : graph.get(node)) {
            if(visited[nbr] == 1) return false;
            if(visited[nbr] == 0){
                if(!dfs(nbr, graph, visited, st)) return false;
            }
        }
        visited[node] = 2;
        st.push(node);
        return true;
    }
    public static void main(String[] args) {
        int[][] prerequisites = {
                {1, 4},
                {2, 4},
                {3, 1},
                {3, 2}
        };

        int numCourses = 5;

        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
}
