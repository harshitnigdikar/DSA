package dsa.leetcode.graphs.practice;

import java.lang.reflect.Array;
import java.util.*;

public class LC210CourseScheduleBFS {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            int y = prerequisite[1];

            graph.get(y).add(x);
        }

        int indegree[] = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int it: graph.get(i)){
                indegree[it]++;
            }
        }
        for(int i = 0; i < numCourses; i++){
            System.out.println(i + " -> " + indegree[i]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        if(q.isEmpty()){
            return new int[0];
        }
        ArrayList<Integer>topo = new ArrayList<>();
        int i = 0;
        while (!q.isEmpty()){
            int node = q.remove();
            topo.add(node);

            for(int it : graph.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(topo.size() != numCourses) return new int[0];

        int[] topoarr = new int[topo.size()];
        for (int j = 0; j < topo.size(); j++) {
            topoarr[j] = topo.get(j);
        }

        return topoarr;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {
                {1, 0},
                {1, 2},
                {0, 1}
        };
        int numCourses = 3;
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
}
