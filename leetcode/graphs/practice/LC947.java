package dsa.leetcode.graphs.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC947 {
    class Solution {
        public int removeStones(int[][] stones) {
            int OFFSET = 10001;  // bigger than max row/col
            Map<Integer, Integer> parent = new HashMap<>();

            for (int[] stone : stones) {
                int r = stone[0];
                int c = stone[1] + OFFSET;
                union(r, c, parent);
            }

            // count unique roots
            Set<Integer> roots = new HashSet<>();
            for (int[] stone : stones) {
                roots.add(find(stone[0], parent));
            }
            return stones.length - roots.size();
        }

        private int find(int x, Map<Integer, Integer> parent) {
            parent.putIfAbsent(x, x);
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x), parent));
            }
            return parent.get(x);
        }

        private void union(int a, int b, Map<Integer, Integer> parent) {
            int pa = find(a, parent);
            int pb = find(b, parent);
            if (pa != pb) {
                parent.put(pb, pa);
            }
        }
    }

}
