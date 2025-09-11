package dsa.leetcode.graphs.practice;

import java.util.*;

public class LC1042FlowerPlanting {
    public int[] gardenNoAdj(int n, int[][] paths) {
        // adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }

        int[] ans = new int[n]; // flower type for each garden (1-indexed garden → 0-indexed array)

        for (int i = 1; i <= n; i++) {
            boolean[] used = new boolean[5]; // track flowers used by neighbors (1–4)

            // check neighbor flowers
            for (int nei : graph.get(i)) {
                if (ans[nei - 1] != 0) {
                    used[ans[nei - 1]] = true;
                }
            }

            // assign first available flower
            for (int f = 1; f <= 4; f++) {
                if (!used[f]) {
                    ans[i - 1] = f;
                    break;
                }
            }
        }
        return ans;
    }
}
