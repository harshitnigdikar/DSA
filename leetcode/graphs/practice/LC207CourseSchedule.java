package dsa.leetcode.graphs.practice;

import java.util.*;

public class LC207CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 1) return true;
        List<List<Integer>> graph = new ArrayList<>();
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
            if(visited[i] == 0 && !dfs(i, graph, visited)){
                //System.out.println(i);
                return false;
            }
        }
        return true;
    }
    private static boolean dfs(int node, List<List<Integer>>graph, int[] visited){
        visited[node] = 1;

        for (int nbr : graph.get(node)) {
            if(visited[nbr] == 1) return false;
            if(visited[nbr] == 0){
                if(!dfs(nbr, graph, visited)) return false;
            }
        }
        visited[node] = 2;
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

        boolean res = canFinish(numCourses, prerequisites);
        System.out.println(res);
    }
}
