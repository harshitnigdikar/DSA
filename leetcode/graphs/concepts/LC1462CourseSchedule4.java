package dsa.leetcode.graphs.concepts;

import java.util.*;

public class LC1462CourseSchedule4 {
    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
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
        for (int i = 0; i < numCourses; i++) {
            for (int it : graph.get(i)) {
                indegree[it]++;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            System.out.println(i + " -> " + indegree[i]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        if (q.isEmpty()) {
            System.out.println("harshit");
            return new ArrayList<Boolean>(queries.length);
        }
        HashMap<Integer, Integer> topo = new HashMap<>();
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            topo.put(node, i);
            i++;

            for (int it : graph.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if (topo.size() != numCourses) {
            System.out.println("harshit");
            return new ArrayList<Boolean>(queries.length);
        }

        List<Boolean> ans = new ArrayList<>();

        for (int j = 0; j < queries.length; j++) {
            int x = queries[j][0];
            int y = queries[j][1];

            if (topo.get(x) < topo.get(y)) {
                ans.add(false);
            }else{
                ans.add(true);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {
                {1, 2},
                {1, 0},
                {2, 0}
        };
        int[][] queries = {
                {1, 0},
                {1, 2}
        };
        int numCourses = 3;
        System.out.println((checkIfPrerequisite(numCourses, prerequisites, queries)));

    }
}
